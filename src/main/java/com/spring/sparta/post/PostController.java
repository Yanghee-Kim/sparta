package com.spring.sparta.post;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @GetMapping
    @Operation(
            summary = "게시글 목록 조회",
            description = "게시글 목록 반환 <br>"
    )
    public String list() {
        return "게시글 목록 조회 로직 작성 예정";
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "게시글 상세 조회",
            description = "게시글 ID를 받아 해당 게시글의 상세 내용 반환 <br>" +
                    "ErrorCase : 존재하지 않는 게시글 조회(id 파라미터 누락 or 잘못된 id 전달)"
    )
    public String detail() {
        return "게시글 상세 조회 로직 작성 예정";
    }

    @PostMapping
    @Operation(
            summary = "게시글 작성",
            description = "게시글 작성 후 저장 <br>" +
                    "ErrorCase : 필수값 누락(title, content), 인증 안된 사용자(비회원)"
    )
    public String create() {
        return "게시글 작성 로직 작성 예정";
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "게시글 수정",
            description = "게시글 수정 <br>" +
                    "ErrorCase : id 파라미터 누락, 필수값 누락(title, content), 인증 안된 사용자(비회원), 권한 없는 사용자(내 게시글이 아닐 경우)"
    )
    public String update() {
        return "게시글 수정 로직 작성 예정";
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "게시글 삭제",
            description = "게시글 삭제 <br>" +
                    "ErrorCase : id 파라미터 누락, 인증 안된 사용자(비회원), 권한 없는 사용자(내 게시글이 아닐 경우)"
    )
    public String delete() {
        return "게시글 삭제 로직 작성 예정";
    }
}
