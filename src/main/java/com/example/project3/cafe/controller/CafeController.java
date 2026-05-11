package com.example.project3.cafe.controller;

import com.example.project3.cafe.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cafes")
public class CafeController {
    // 카페 생성 - 테스트 API
    @PostMapping
    ResponseEntity<CafeResponse> createCafe(@RequestBody CafeRequest cafeRequest) {
        CafeResponse cafeResponse = new CafeResponse(1L, cafeRequest.getCafeName(), cafeRequest.getAddressCity(), cafeRequest.getAddressDistrict(), cafeRequest.getAddressDetail(), LocalDateTime.now(), LocalDateTime.now(), cafeRequest.getImageUrl(), 10, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cafeResponse);
    }

    // 카페 리스트 조회 (필터링 추가)
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
        CafeMenuResponse response = new CafeMenuResponse(1L, menuRequest.getCafeName(), menuRequest.getAddressCity(), menuRequest.getAddressDistrict(), menuRequest.getAddressDetail(), menuRequest.getDescription(), LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300", menuRequest.getMenu());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    // 오늘의 카페 메뉴 - 조회
    @GetMapping("{id}/menus")
    ResponseEntity<CafeMenuResponse> getDailyMenu(@PathVariable Long id){
        List<ItemDto> menu = new ArrayList<>();
        ItemDto item1 = new ItemDto("오레오", 1L, 3000, 20);
        ItemDto item2 = new ItemDto("군옥수수", 1L, 3500, 25);
        ItemDto item3 = new ItemDto("솔티카라멜", 2L, 2500, 10);
        ItemDto item4 = new ItemDto("무화과", 2L, 3000, 15);
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);

        CafeMenuResponse response = new CafeMenuResponse(id, "cafe", "서울시", "강남구", "강남대로 889", "오랜만에 앵그리 군옥수수가 나왔어요~", LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300", menu);

        return ResponseEntity.ok(response);
    }
}
