package com.example.project3.cafe.controller;

import com.example.project3.cafe.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cafes")
public class CafeController {
    // 카페 생성
    @PostMapping
    ResponseEntity<CafeResponse> createCafe(@RequestBody CafeRequest cafeRequest) {
        CafeResponse cafeResponse = new CafeResponse(1L, cafeRequest.getName(), cafeRequest.getAddress(), cafeRequest.getAddressDetail(), LocalDateTime.now(), LocalDateTime.now(), cafeRequest.getImageUrl());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cafeResponse);
    }

    // 카페 리스트 조회
    @GetMapping
    ResponseEntity<List<CafeResponse>> getCafeList(){
        List<CafeResponse> cafeResponseList = new ArrayList<>();
        CafeResponse cafe1 = new CafeResponse(1L, "first", "서울시 강남구 강남대로 889", "서울시 강남구", LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300");
        CafeResponse cafe2 = new CafeResponse(2L, "second", "서울시 강남구 강남대로 889", "서울시 강남구", LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300");
        CafeResponse cafe3 = new CafeResponse(3L, "third", "서울시 강남구 강남대로 889", "서울시 강남구", LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300");
        cafeResponseList.add(cafe1);
        cafeResponseList.add(cafe2);
        cafeResponseList.add(cafe3);

        return ResponseEntity.ok(cafeResponseList);
    }

    // 오늘의 카페 메뉴 - 생성
    @PostMapping("{id}/menus")
    ResponseEntity<CafeMenuResponse> createDailyMenu(@PathVariable Long id, @RequestBody CafeMenuRequest menuRequest){
        CafeMenuResponse response = new CafeMenuResponse(id, "cafe", "서울시 강남구 강남대로 889", "서울시 강남구", LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300", menuRequest.getDescription(), menuRequest.getMenu());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    // 오늘의 카페 메뉴 - 조회
    @GetMapping("{id}/menus")
    ResponseEntity<CafeMenuResponse> getDailyMenu(@PathVariable Long id){
        List<CategoryDto> menu = new ArrayList<>();
        List<ItemDto> items1 = new ArrayList<>();
        ItemDto item1 = new ItemDto("오레오", 3000, 20);
        ItemDto item2 = new ItemDto("군옥수수", 3500, 25);
        items1.add(item1);
        items1.add(item2);
        CategoryDto category1 = new CategoryDto("마카롱", items1);

        List<ItemDto> items2 = new ArrayList<>();
        ItemDto item3 = new ItemDto("솔티카라멜", 2500, 10);
        ItemDto item4 = new ItemDto("무화과", 3000, 15);
        items1.add(item3);
        items1.add(item4);
        CategoryDto category2 = new CategoryDto("휘낭시에", items1);

        menu.add(category1);
        menu.add(category2);

        CafeMenuResponse response = new CafeMenuResponse(id, "cafe", "서울시 강남구 강남대로 889", "서울시 강남구", LocalDateTime.now(), LocalDateTime.now(), "https://picsum.photos/200/300", "오랜만에 앵그리 군옥수수가 나왔어요~", menu);

        return ResponseEntity.ok(response);
    }
}
