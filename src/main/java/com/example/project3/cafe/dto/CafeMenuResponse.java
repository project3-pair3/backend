package com.example.project3.cafe.dto;

import com.example.project3.cafe.domain.Cafe;
import com.example.project3.menu.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class CafeMenuResponse {
    Long cafeId;
    String cafeName;
    String addressCity;
    String addressDistrict;
    String addressDetail;
    String description;
    LocalDateTime open;
    LocalDateTime close;
    String imageUrl;
    List<ItemDto> menu;

    public static CafeMenuResponse from(Cafe cafe, List<ItemDto> menuList) {
        return CafeMenuResponse.builder()
                .cafeId(cafe.getId())
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