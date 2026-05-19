package com.example.project3.cafe.controller;

import com.example.project3.cafe.dto.*;
import com.example.project3.cafe.service.CafeServiceImpl;
import com.example.project3.comment.domain.Comment;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cafes")
public class CafeController {
    CafeServiceImpl cafeService;

    CafeController(CafeServiceImpl cafeService){
        this.cafeService = cafeService;
    }

    // 카페 생성 - 테스트 API
//    @PostMapping
//    ResponseEntity<CafeResponse> createCafe(@RequestBody CafeRequest cafeRequest) {
//        CafeResponse cafeResponse = cafeService.createCafe(cafeRequest);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(cafeResponse);
//    }

    // 카페 리스트 조회 (필터링 무관!)
//    @Operation(summary = "카페 리스트 조회 (필터링x)", description = "[메인 페이지] 당일 추가된 모든 카드 리스트를 반환합니다. (필터링 없음)")
//    @GetMapping("/noFilter")
//    ResponseEntity<List<CafeResponse>> getCafeList(){
//        List<CafeResponse> cafeResponseList = cafeService.getCafeList();
//
//        return ResponseEntity.ok(cafeResponseList);
//    }

    // 카페 리스트 조회 (필터링 존재)
    @Operation(summary = "카페 리스트 조회 (필터링O)", description = "[메인 페이지] 당일 추가된 모든 카드 리스트를 반환합니다. (필터링 가능)")
    @GetMapping
    ResponseEntity<List<CafeResponse>> getCafeListWithFiltering(
            @RequestParam(required = false, defaultValue = "0") Integer categoryId,
            @RequestParam(required = false, defaultValue = "서울시") String addressCity,
            @RequestParam(required = false, defaultValue = "전체") String addressDistrict,
            @RequestParam(required = false, defaultValue = "recentlyUpdated") String listingType
    ){
        List<CafeResponse> cafeResponseList = cafeService.getCafeListWithFiltering(categoryId, addressCity, addressDistrict, listingType);

        return ResponseEntity.ok(cafeResponseList);
    }

    // 오늘의 카페 메뉴 - 생성
    /*@Operation(summary = "카드 생성", description = "[카드 생성 페이지] 카페 정보, 메뉴 폼 내용을 요청하면 저장합니다. 추 후 삭제")
    @PostMapping("/menus")
    ResponseEntity<CafeMenuResponse> createDailyMenu(@RequestBody CafeMenuRequest menuRequest){
        CafeMenuResponse response = cafeService.createDailyMenu(menuRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }*/

    // 오늘의 카페 메뉴 - 폼 데이터 삽입용 조회
    @Operation(summary = "이전 카페 폼 데이터 조회", description = "[카드 생성 페이지] 카페 정보, 메뉴 폼 내용을 요청합니다.")
    @GetMapping("/info/{userId}") // userId : user 의 PK
    ResponseEntity<CafeInfoResponse> getCafeInfo(@PathVariable Long userId) {
        CafeInfoResponse response = cafeService.getCafeInfo(userId);

        return ResponseEntity.ok(response);
    }

    // 오늘의 카페 메뉴 - 폼 데이터 작성하고 제출
    @Operation(summary = "카페 폼 데이터 제출", description = "[카드 생성 페이지] 카페 정보, 메뉴 폼 내용을 요청하면 저장합니다.")
    @PutMapping("/update/{userId}") // userId : user 의 PK
    ResponseEntity<CafeMenuResponse> createDailyMenu(@RequestBody CafeMenuRequest menuRequest, @PathVariable Long userId) {
        CafeMenuResponse response = cafeService.createDailyMenu(menuRequest, userId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }


    // 오늘의 카페 메뉴 - 조회
    @Operation(summary = "메인페이지에서 카드 조회", description = "[상세 페이지] 카페 아이디를 요청하면 카드의 상세 내용을 반환합니다. (메인 페이지에서 라우팅 되는 페이지)")
    @GetMapping("{id}/menus") // id : cafe 의 pk
    ResponseEntity<CafeMenuResponse> getDailyMenu(@PathVariable Long id){
        CafeMenuResponse response = cafeService.getDailyMenu(id);

        return ResponseEntity.ok(response);
    }

    // 리뷰 작성 (리뷰 화면에서 “작성” 버튼 눌렀을때)
    @Operation(summary = "리뷰 작성", description = "[상세 화면-리뷰 화면] 리뷰 화면에서 “작성” 버튼을 누르면 리뷰 코멘트를 저장합니다.")
    @PostMapping("{id}/review")
    ResponseEntity<Void> createComment(@PathVariable Long id, @RequestBody CafeCommentRequest commentRequest){
        cafeService.createComment(id, commentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 리뷰 리스트 조회 (리뷰 버튼 눌렀을 때)
    @Operation(summary = "리뷰 리스트 조회", description = "[상세 화면] 상세 화면에서 리뷰 버튼을 눌렀을 때 리뷰 리스트를 응답받습니다.")
    @GetMapping("{id}/review")
    ResponseEntity<List<CafeCommentResponse>> getCommentList(@PathVariable Long id){
        List<CafeCommentResponse> responseList = cafeService.getCommentList(id);
        return ResponseEntity.ok(responseList);
    }

    // 리뷰 삭제 (리뷰 화면에서 본인 리뷰 글 삭제)
    @Operation(summary = "리뷰 삭제", description = "[상세 화면-리뷰 화면] 리뷰 화면에서 본일 리뷰 글을 삭제합니다.")
    @DeleteMapping("{id}/review/{reviewId}/{userId}")
    ResponseEntity<Void> deleteComment(@PathVariable Long id, @PathVariable Long reviewId, @PathVariable Long userId){
        cafeService.deleteComment(id, reviewId, userId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
