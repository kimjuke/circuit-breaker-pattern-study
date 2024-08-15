package com.example.circuitbreakerpatternstudy.controller;

import com.example.circuitbreakerpatternstudy.service.CustomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomController {

    private final CustomService customService;

    @GetMapping("/fail")
    public String fail() {
        return customService.fail();
    }

    @GetMapping("/slow-call")
    public String slowCall() throws InterruptedException {
        return customService.slowCall();
    }

    @GetMapping("/success")
    public String success() {
        return customService.success();
    }
}
