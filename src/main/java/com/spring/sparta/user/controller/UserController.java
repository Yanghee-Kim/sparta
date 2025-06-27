package com.spring.sparta.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/join")
    @Operation(
            summary = "회원가입",
            description = "사용자 회원가입 처리 <br> " +
                    "ErrorCase : username 중복, 형식 오류, 필수값 누락"
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "회원가입 성공"),
//                    @ApiResponse(responseCode = "400", description = "중복된 ID <br> 형식 오류 (username: 4~10자 영문소문자+숫자, password: 8~15자 대소문자+숫자) <br> 필수값 누락 <br> 잘못된 JSON 형식"),
//                    @ApiResponse(responseCode = "500", description = "서버 내부 오류 (DB 저장 실패 등)")
//            }
    )
    public String join() {
        return "회원가입 로직 작성 예정";
    }

    @PostMapping("/login")
    @Operation(
            summary = "로그인",
            description = "username과 password를 통해 로그인 처리 후 JWT 토큰을 반환 <br> " +
                    "ErrorCase :  존재하지 않는 username, password 불일치, 계정 잠금 상태(로그인 실패 횟수 초과), 필수값 누락, 토큰 발급 실패"
    )
    public String login() {
        return "로그인 로직 작성 예정";
    }
}
