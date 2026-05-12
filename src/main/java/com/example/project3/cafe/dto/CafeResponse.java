package com.example.project3.cafe.dto;

import com.example.project3.cafe.domain.Cafe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter
@AllArgsConstructor
@Builder
public class CafeResponse {
    Long id;
    String cafeName;
    String addressCity;
    String addressDistrict;
    String addressDetail;
    LocalTime open;
    LocalTime close;
    String imageUrl;
    Integer totalCount;
    LocalDateTime createdAt;

    // Entity -> Dto 변환
    // TODO: totalCount 추가하기
    public static CafeResponse from(Cafe cafe){
        return CafeResponse.builder()
                .id(cafe.getId())
                .cafeName(cafe.getCafeName())
                .addressCity(cafe.getAddressCity())
                .addressDistrict(cafe.getAddressDistrict())
                .addressDetail(cafe.getAddressDetail())
                .open(cafe.getOpen())
                .close(cafe.getClose())
                .imageUrl(cafe.getImageUrl())
                .createdAt(cafe.getCreatedAt())
                .build();
    }
}
