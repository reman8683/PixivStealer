package com.reman8683.pixivstealer.controller.pixivstealer;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PixivStealerController {
    @SneakyThrows
    @PostMapping("/pixivstealer")
    public String  pixivstealer(@RequestBody ImageSearchVo imageSearchVo) {
        return imageSearchVo.toString();
    }
}
