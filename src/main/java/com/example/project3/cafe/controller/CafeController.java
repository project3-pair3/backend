package com.example.project3.cafe.controller;

import com.example.project3.cafe.dto.*;
import com.example.project3.cafe.service.CafeServiceImpl;
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

    @Operation(summary = "카페 리스트 조회 (필터링x)", description = "[메인 페이지] 당일 추가된 모든 카드 리스트를 반환합니다. (필터링 없음)")
    // 카페 리스트 조회 (필터링 무관!)
    @GetMapping
    ResponseEntity<List<CafeResponse>> getCafeList(){
        List<CafeResponse> cafeResponseList = cafeService.getCafeList();

        return ResponseEntity.ok(cafeResponseList);
    }

    // 카페 리스트 조회 (필터링 존재)
//    @GetMapping
//    ResponseEntity<List<CafeResponse>> getCafeList(@RequestParam Long categoryId, @RequestParam String addressCity, @RequestParam String addressDistrict, @RequestParam String listingType){
//        List<CafeResponse> cafeResponseList = new ArrayList<>();
//        CafeResponse cafe1 = new CafeResponse(1L, "first", "서울시", "강남구", "강남대로 889", LocalTime.of(9, 0), LocalTime.of(13, 0), "https://picsum.photos/200/300", 15, LocalDateTime.now());
//        CafeResponse cafe2 = new CafeResponse(2L, "second","서울시", "강남구", "강남대로 889", LocalTime.of(11, 0), LocalTime.of(15, 0), "https://picsum.photos/200/300", 16, LocalDateTime.now());
//        CafeResponse cafe3 = new CafeResponse(3L, "third","서울시", "강남구", "강남대로 889", LocalTime.of(8, 0), LocalTime.of(16, 0), "https://picsum.photos/200/300", 17, LocalDateTime.now());
//        cafeResponseList.add(cafe1);
//        cafeResponseList.add(cafe2);
//        cafeResponseList.add(cafe3);
//
//        return ResponseEntity.ok(cafeResponseList);
//    }

    // 오늘의 카페 메뉴 - 생성
    @Operation(summary = "카드 생성", description = "[카드 생성 페이지] 카페 정보, 메뉴 폼 내용을 요청하면 저장합니다. 추 후 삭제")
    @PostMapping("/menus")
    ResponseEntity<CafeMenuResponse> createDailyMenu(@RequestBody CafeMenuRequest menuRequest){
        CafeMenuResponse response = cafeService.createDailyMenu(menuRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(summary = "이전 카페 폼 데이터 조회", description = "[카드 생성 페이지] 카페 정보, 메뉴 폼 내용을 요청합니다.")
    @GetMapping("/info/{usersId}") // userId : user 의 PK
    ResponseEntity<CafeInfoResponse> getCafeInfo(@PathVariable Long userId) {
        CafeInfoResponse response = cafeService.getCafeInfo(userId);

        return ResponseEntity.ok(response);
    }

    // 오늘의 카페 메뉴 - 조회
    @Operation(summary = "메인페이지에서 카드 조회", description = "[상세 페이지] 카페 아이디를 요청하면 카드의 상세 내용을 반환합니다. (메인 페이지에서 라우팅 되는 페이지)")
    @GetMapping("{id}/menus")
    ResponseEntity<CafeMenuResponse> getDailyMenu(@PathVariable Long id){
        CafeMenuResponse response = cafeService.getDailyMenu(id);

        return ResponseEntity.ok(response);
    }
}
