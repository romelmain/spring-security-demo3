package com.app.demo3.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String username, @NotBlank String password) {

}
