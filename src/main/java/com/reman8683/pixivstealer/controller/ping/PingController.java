package com.reman8683.pixivstealer.controller.ping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    @GetMapping("/ping")
    public String Ping() {
        return "pong";
    }
}
