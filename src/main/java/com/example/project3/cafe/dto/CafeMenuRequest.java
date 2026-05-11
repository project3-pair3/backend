package com.example.project3.cafe.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class CafeMenuRequest {
    String cafeName;
    String addressCity;
    String addressDistrict;
    String addressDetail;
    String description;
    LocalDateTime open;
    LocalDateTime close;
    String imageUrl;
    List<ItemDto> menu;
}

