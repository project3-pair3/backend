package com.example.project3.cafe.dto;

import com.example.project3.cafe.domain.Cafe;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    String mention;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "Asia/Seoul")
    LocalTime open;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "Asia/Seoul")
    LocalTime close;
    String imageUrl;
    Integer totalCount;
    LocalDateTime updatedAt;

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
                .updatedAt(cafe.getUpdatedAt())
                .build();
    }
}
