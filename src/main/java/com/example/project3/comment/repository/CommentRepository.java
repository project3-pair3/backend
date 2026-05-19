package com.example.project3.comment.repository;

import com.example.project3.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByCafeIdOrderByCreatedAtDesc(Long cafeId);
}
