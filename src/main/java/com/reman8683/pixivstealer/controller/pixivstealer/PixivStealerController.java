package com.reman8683.pixivstealer.controller.pixivstealer;

import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PixivStealerController {
    @SneakyThrows
    @PostMapping(value = "/pixivstealer", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] pixivstealer(@RequestBody ImageSearchVo imageSearchVo) {
        return imageSearchVo.image();
    }
}
