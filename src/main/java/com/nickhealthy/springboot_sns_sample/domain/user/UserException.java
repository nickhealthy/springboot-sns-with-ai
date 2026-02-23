package com.nickhealthy.springboot_sns_sample.domain.user;

import lombok.Getter;

public class UserException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;

    public UserException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    @Getter
    public enum ErrorCode {
        USER_NOT_FOUND("사용자를 찾을 수 없습니다."),
        DUPLICATE_USERNAME("이미 사용 중인 사용자명입니다.");

        private final String message;

        ErrorCode(String message) {
            this.message = message;
        }
    }
}
