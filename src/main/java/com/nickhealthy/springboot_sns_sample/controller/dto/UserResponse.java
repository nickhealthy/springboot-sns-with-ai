package com.nickhealthy.springboot_sns_sample.controller.dto;

import com.nickhealthy.springboot_sns_sample.domain.user.User;


public record UserResponse(
        Long id,
        String username
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername()
        );
    }
}
