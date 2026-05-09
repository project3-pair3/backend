package com.example.project3.cafe.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CafeMenuRequest {
    String imageUrl;
    String description;
    List<CategoryDto> menu;
}

