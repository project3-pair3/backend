package com.example.project3.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class CafeResponse {
    Long id;
    String cafeName;
    String addressCity;
    String addressDistrict;
    String addressDetail;
    LocalDateTime open;
    LocalDateTime close;
    String imageUrl;
    Integer totalCount;
    LocalDateTime createdAt;
}
