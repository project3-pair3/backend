package com.example.project3.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CategoryDto {
    String type;
    List<ItemDto> items;
}
