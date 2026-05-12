package com.example.project3.cafe.repository;

import com.example.project3.cafe.domain.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    List<Cafe> findAllByUpdatedAtBetween(LocalDateTime start, LocalDateTime end);
}
