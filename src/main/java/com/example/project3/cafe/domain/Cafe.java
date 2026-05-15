package com.example.project3.cafe.domain;

import com.example.project3.user.domain.User;
import com.example.project3.menu.domain.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Column(nullable = false)
    private String cafeName;

    @Column(nullable = false)
    private String addressCity;

    @Column(nullable = false)
    private String addressDistrict;

    @Column(nullable = false)
    private String addressDetail;

    private String description;

    private String mention;

    @Column(name = "opening_time")
    private LocalTime open;

    @Column(name = "closing_time")
    private LocalTime close;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cafe")
    @Builder.Default
    List<Menu> menuList = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public void updateInfo(String cafeName, String addressCity, String addressDistrict,
                           String addressDetail, String description, String mention,
                           LocalTime open, LocalTime close, String imageUrl) {
        this.cafeName = cafeName;
        this.addressCity = addressCity;
        this.addressDistrict = addressDistrict;
        this.addressDetail = addressDetail;
        this.description = description;
        this.mention = mention;
        this.open = open;
        this.close = close;
        this.imageUrl = imageUrl;
    }
}
