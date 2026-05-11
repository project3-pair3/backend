package com.example.project3.menu.domain;

import com.example.project3.cafe.domain.Cafe;
import com.example.project3.menuCategory.domain.MenuCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Long cost;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "cafe_id", nullable = false)
    Cafe cafe;

    @ManyToOne
    @JoinColumn(name = "menu_category_id", nullable = false)
    MenuCategory menuCategory;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
