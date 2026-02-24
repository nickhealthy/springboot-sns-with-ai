package com.nickhealthy.springboot_sns_sample.domain.user;

import lombok.Getter;

@Getter
public enum UserRole {

    USER("ROLE_USER");

    private final String authority;

    UserRole(String authority) {
        this.authority = authority;
    }
}
