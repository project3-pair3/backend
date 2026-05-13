package com.example.project3.menu.repository;

import com.example.project3.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByCafeIdAndUpdatedAtBetween(Long cafeId, LocalDateTime start, LocalDateTime end);
    List<Menu> findByCafeIdAndCreatedAtBetween(Long cafeId, LocalDateTime start, LocalDateTime end);

    List<Menu> findByCafeId(Long cafeId);
}
