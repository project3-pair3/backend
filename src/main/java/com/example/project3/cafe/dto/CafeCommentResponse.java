package com.example.project3.cafe.dto;

import com.example.project3.comment.domain.Comment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CafeCommentResponse {
    String nickname;
    String comment;
    LocalDateTime createdAt;

    public static CafeCommentResponse from(Comment comment){
        return CafeCommentResponse.builder()
                .nickname(comment.getUser().getNickname())
                .comment(comment.getComment())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
