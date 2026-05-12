package com.example.project3.cafe.controller;

import com.example.project3.cafe.dto.*;
import com.example.project3.cafe.service.CafeServiceImpl;
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
    @PostMapping("/menus")
    ResponseEntity<CafeMenuResponse> createDailyMenu(@RequestBody CafeMenuRequest menuRequest){
        CafeMenuResponse response = cafeService.createDailyMenu(menuRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    // 오늘의 카페 메뉴 - 조회
    @GetMapping("{id}/menus")
    ResponseEntity<CafeMenuResponse> getDailyMenu(@PathVariable Long id){
        CafeMenuResponse response = cafeService.getDailyMenu(id);

        return ResponseEntity.ok(response);
    }
}
