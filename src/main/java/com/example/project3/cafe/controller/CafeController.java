package com.example.project3.cafe.controller;

import com.example.project3.cafe.dto.*;
import com.example.project3.cafe.service.CafeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    @PostMapping
    ResponseEntity<CafeResponse> createCafe(@RequestBody CafeRequest cafeRequest) {
        CafeResponse cafeResponse = cafeService.createCafe(cafeRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cafeResponse);
    }

    // 카페 리스트 조회 (필터링 추가)
    // TODO: service, repository 레이어
    @GetMapping
    ResponseEntity<List<CafeResponse>> getCafeList(@RequestParam Long categoryId, @RequestParam String addressCity, @RequestParam String addressDistrict, @RequestParam String listingType){
        List<CafeResponse> cafeResponseList = new ArrayList<>();
        CafeResponse cafe1 = new CafeResponse(1L, "first", "서울시", "강남구", "강남대로 889", LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300", 15, LocalDateTime.now());
        CafeResponse cafe2 = new CafeResponse(2L, "second","서울시", "강남구", "강남대로 889", LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300", 16, LocalDateTime.now());
        CafeResponse cafe3 = new CafeResponse(3L, "third","서울시", "강남구", "강남대로 889", LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300", 17, LocalDateTime.now());
        cafeResponseList.add(cafe1);
        cafeResponseList.add(cafe2);
        cafeResponseList.add(cafe3);

        return ResponseEntity.ok(cafeResponseList);
    }

    // 오늘의 카페 메뉴 - 생성
    @PostMapping("/menus")
    ResponseEntity<CafeMenuResponse> createDailyMenu(@RequestBody CafeMenuRequest menuRequest){
        CafeMenuResponse response = cafeService.createDailyMenu(menuRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    // 오늘의 카페 메뉴 - 조회
    // TODO: service, repository 레이어
    @GetMapping("{id}/menus")
    ResponseEntity<CafeMenuResponse> getDailyMenu(@PathVariable Long id){
        CafeMenuResponse response = cafeService.getDailyMenu(id);

        return ResponseEntity.ok(response);

//        List<ItemDto> menu = new ArrayList<>();
//        ItemDto item1 = new ItemDto("오레오", 1L, 3000L, 20);
//        ItemDto item2 = new ItemDto("군옥수수", 1L, 3500L, 25);
//        ItemDto item3 = new ItemDto("솔티카라멜", 2L, 2500L, 10);
//        ItemDto item4 = new ItemDto("무화과", 2L, 3000L, 15);
//        menu.add(item1);
//        menu.add(item2);
//        menu.add(item3);
//        menu.add(item4);
//
//        CafeMenuResponse response = new CafeMenuResponse(id, "cafe", "서울시", "강남구", "강남대로 889", "오랜만에 앵그리 군옥수수가 나왔어요~", LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300", menu);
//
//        return ResponseEntity.ok(response);
    }
}
