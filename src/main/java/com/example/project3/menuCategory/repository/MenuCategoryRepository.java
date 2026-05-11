package com.example.project3.menuCategory.repository;

import com.example.project3.menuCategory.domain.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
}
