package com.app.demo3.controller.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "username", "message", "jwt", "status", })
public record AuthResponse(String username, String message, String jwt, boolean status) {

}
