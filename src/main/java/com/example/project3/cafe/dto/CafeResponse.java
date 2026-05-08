package com.example.project3.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CafeResponse {
    Long id;
    String name;
    String addressDetail;
    String imageUrl;
}
