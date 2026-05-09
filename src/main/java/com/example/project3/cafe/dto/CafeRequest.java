package com.example.project3.cafe.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CafeRequest {
    String name;
    String address;
    String addressDetail;
    LocalDateTime open;
    LocalDateTime close;
    String imageUrl;
}
