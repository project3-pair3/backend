package com.example.project3.cafe.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CafeRequest {
    String cafeName;
    String addressCity;
    String addressDistrict;
    String addressDetail;
    LocalDateTime open;
    LocalDateTime close;
    String imageUrl;
}
