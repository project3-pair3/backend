package com.example.project3.cafe.controller;

import com.example.project3.cafe.dto.CafeRequest;
import com.example.project3.cafe.dto.CafeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CafeController {
    // 카페 생성
    @PostMapping("/cafes")
    ResponseEntity<CafeResponse> createCafe(@RequestBody CafeRequest cafeRequest) {
        CafeResponse cafeResponse = new CafeResponse(1L, cafeRequest.getName(), cafeRequest.getAddressDetail(), cafeRequest.getImageUrl());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cafeResponse);
    }

    // 카페 전체 조회
    @GetMapping("/cafes")
    ResponseEntity<List<CafeResponse>> getCafeList(){
        List<CafeResponse> cafeResponseList = new ArrayList<>();
        CafeResponse cafe1 = new CafeResponse(1L, "first", "서울시 강남구", "https://picsum.photos/200/300");
        CafeResponse cafe2 = new CafeResponse(2L, "second", "서울시 강남구", "https://picsum.photos/200/300");
        CafeResponse cafe3 = new CafeResponse(3L, "third", "서울시 강남구", "https://picsum.photos/200/300");
        cafeResponseList.add(cafe1);
        cafeResponseList.add(cafe2);
        cafeResponseList.add(cafe3);

        return ResponseEntity.ok(cafeResponseList);
    }

}
