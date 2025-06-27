package com.spring.sparta.post.dto;

import com.spring.sparta.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDto {
    private final Long id;
    private final String title;
    private final String content;
    private final Long writerId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.writerId = post.getWriterId();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
    }
}
