package com.example.project3.cafe.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class CafeRequest {
    // TODO:
    //    String address;
    //    LocalDateTime open;
    //    LocalDateTime close;
    String name;
    String addressDetail;
    String imageUrl;
}
