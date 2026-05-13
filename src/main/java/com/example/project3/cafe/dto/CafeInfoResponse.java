package com.example.project3.cafe.dto;

import com.example.project3.cafe.domain.Cafe;
import com.example.project3.menu.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class CafeInfoResponse {
    int statusCode; // 1, 2, 3
    String cafeName;
    String addressCity;
    String addressDistrict;
    String addressDetail;
    String description;
    LocalTime open;
    LocalTime close;
    String imageUrl;
    List<ItemDto> menu;

    public static CafeInfoResponse from(Cafe cafe, List<ItemDto> menuList, int statusCode) {
        return CafeInfoResponse.builder()
                .statusCode(statusCode)
                .cafeName(cafe.getCafeName())
                .addressCity(cafe.getAddressCity())
                .addressDistrict(cafe.getAddressDistrict())
                .addressDetail(cafe.getAddressDetail())
                .description(cafe.getDescription())
                .open(cafe.getOpen())
                .close(cafe.getClose())
                .imageUrl(cafe.getImageUrl())
                .menu(menuList)
                .build();
    }
}