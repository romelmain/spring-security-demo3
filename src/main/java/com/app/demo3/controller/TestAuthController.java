package com.app.demo3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public String helloGet() {
        return "Hello World - GET";
    }

    @PostMapping("/post")
    @PreAuthorize("hasAuthority('READ') or hasAuthority('CREATED')")
    public String helloPost() {
        return "Hello World - POST";
    }

    @PatchMapping("/patch")
    @PreAuthorize("hasAuthority('REFACTOR')")
    public String helloPatch() {
        return "Hello World - PATCH";
    }

}
