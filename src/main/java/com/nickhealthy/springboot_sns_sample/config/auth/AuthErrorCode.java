package com.nickhealthy.springboot_sns_sample.config.auth;

import lombok.Getter;

@Getter
public enum AuthErrorCode {

    LOGIN_FAILED("아이디 또는 비밀번호가 올바르지 않습니다."),
    LOGOUT_SUCCESS("로그아웃 되었습니다."),
    UNAUTHORIZED("인증이 필요합니다."),
    ACCESS_DENIED("접근 권한이 없습니다.");

    private final String message;

    AuthErrorCode(String message) {
        this.message = message;
    }
}
