package com.example.project3.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDto {
    String itemName;
    Long typeId;
    Integer cost;
    Integer stock;
}
