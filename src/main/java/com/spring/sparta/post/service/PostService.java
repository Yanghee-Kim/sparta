package com.spring.sparta.post.service;

import com.spring.sparta.post.dto.PostDto;
import com.spring.sparta.post.dto.PostSaveRequestDto;
import com.spring.sparta.post.dto.PostUpdateRequestDto;
import com.spring.sparta.post.entity.Post;
import com.spring.sparta.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostDto> findAll() {
        return postRepository.findAll().stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

    public PostDto findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글이 존재하지 않습니다."));
        return new PostDto(post);
    }

    public Long save(PostSaveRequestDto dto) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writerId(dto.getWriterId())
                .build();
        return postRepository.save(post).getId();
    }

    @Transactional
    public void update(Long id, PostUpdateRequestDto dto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글이 존재하지 않습니다."));
        post.update(dto.getTitle(), dto.getContent());
    }

    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글이 존재하지 않습니다."));
        postRepository.delete(post);
    }
}
