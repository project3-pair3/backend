package com.example.project3.cafe.repository;

import com.example.project3.cafe.domain.Cafe;
import com.example.project3.menu.domain.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    List<Cafe> findAllByUpdatedAtBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT DISTINCT c FROM Cafe c " +
            "JOIN FETCH c.menuList m " +
            "WHERE c.addressCity = :city " +
            "AND (:district IS NULL OR c.addressDistrict = :district) " +
            "AND (:category IS NULL OR m.type = :category) " +
            "AND c.updatedAt BETWEEN :start AND :end") // 쿼리의 이름과
    List<Cafe> findCafesWithFilters(
            @Param("city") String city,
            @Param("district") String district,
            @Param("category") MenuCategory category,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
}
