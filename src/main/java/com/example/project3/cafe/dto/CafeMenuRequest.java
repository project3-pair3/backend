package com.example.project3.cafe.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
public class CafeMenuRequest {
    String cafeName;
    String addressCity;
    String addressDistrict;
    String addressDetail;
    String description;
    @Schema(type = "string", example = "09:00:00", description = "오픈 시간")
    @JsonFormat(pattern = "HH:mm:ss")
    LocalTime open;
    @Schema(type = "string", example = "18:00:00", description = "마감 시간")
    @JsonFormat(pattern = "HH:mm:ss")
    LocalTime close;
    String imageUrl;
    List<ItemDto> menu;
}

