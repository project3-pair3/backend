package com.example.project3.cafe.dto;

import com.example.project3.menu.domain.Menu;
import com.example.project3.menu.domain.MenuCategory;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ItemDto {
    String itemName;
    @JsonProperty("typeId")
    MenuCategory type;
    Long cost;
    Integer stock;

    public static ItemDto from(Menu menu) {
        return ItemDto.builder()
                .itemName(menu.getName())
                .type(menu.getType())
                .cost(menu.getCost())
                .stock(menu.getStock())
                .build();
    }
}
