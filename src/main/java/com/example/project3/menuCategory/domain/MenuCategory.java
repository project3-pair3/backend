package com.example.project3.menuCategory.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class MenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String name;
}
