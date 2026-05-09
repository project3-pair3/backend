package com.example.project3.cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CafeResponse {
    // TODO:
    //    String address;
    //    LocalDateTime open;
    //    LocalDateTime close;
    Long id;
    String name;
    String addressDetail;
    String imageUrl;
}
