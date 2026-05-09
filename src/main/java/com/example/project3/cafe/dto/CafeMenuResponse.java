package com.example.project3.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class CafeMenuResponse {
    Long cafeId;
    String cafeName;
    String address;
    String addressDetail;
    LocalDateTime open;
    LocalDateTime close;
    String imageUrl;
    String description;
    List<CategoryDto> menu;
}