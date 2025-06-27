package com.spring.sparta.post.controller;

import com.spring.sparta.post.dto.PostDto;
import com.spring.sparta.post.dto.PostSaveRequestDto;
import com.spring.sparta.post.dto.PostUpdateRequestDto;
import com.spring.sparta.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    @Operation(
            summary = "게시글 목록 조회",
            description = "게시글 목록 반환 <br>"
    )
    public ResponseEntity<List<PostDto>> list() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "게시글 상세 조회",
            description = "게시글 ID를 받아 해당 게시글의 상세 내용 반환 <br>" +
                    "ErrorCase : 존재하지 않는 게시글 조회(id 파라미터 누락 or 잘못된 id 전달)"
    )
    public ResponseEntity<PostDto> detail(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping
    @Operation(
            summary = "게시글 작성",
            description = "게시글 작성 후 저장 <br>" +
                    "ErrorCase : 필수값 누락(title, content), 인증 안된 사용자(비회원)"
    )
    public ResponseEntity<Long> create(@RequestBody @Valid PostSaveRequestDto dto) {
        return ResponseEntity.ok(postService.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "게시글 수정",
            description = "게시글 수정 <br>" +
                    "ErrorCase : id 파라미터 누락, 필수값 누락(title, content), 인증 안된 사용자(비회원), 권한 없는 사용자(내 게시글이 아닐 경우)"
    )
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid PostUpdateRequestDto dto) {
        postService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "게시글 삭제",
            description = "게시글 삭제 <br>" +
                    "ErrorCase : id 파라미터 누락, 인증 안된 사용자(비회원), 권한 없는 사용자(내 게시글이 아닐 경우)"
    )
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
