package com.example.project3.cafe.repository;

import com.example.project3.cafe.domain.Cafe;
import com.example.project3.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    List<Cafe> findAllByUpdatedAtBetween(LocalDateTime start, LocalDateTime end);

    Optional<Cafe> findByUserId(Long userId);


}
