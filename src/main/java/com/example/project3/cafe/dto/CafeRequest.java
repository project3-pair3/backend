package com.example.project3.cafe.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class CafeRequest {
    String cafeName;
    String addressCity;
    String addressDistrict;
    String addressDetail;
    @Schema(type = "string", example = "09:00", description = "오픈 시간")
    @JsonFormat(pattern = "HH:mm")
    LocalTime open;
    @Schema(type = "string", example = "18:00", description = "마감 시간")
    @JsonFormat(pattern = "HH:mm")
    LocalTime close;
    String imageUrl;
}
