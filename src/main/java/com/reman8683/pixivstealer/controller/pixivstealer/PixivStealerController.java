package com.reman8683.pixivstealer.controller.pixivstealer;

import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PixivStealerController {
    @SneakyThrows
    @GetMapping(value = "/pixivstealer/getimage", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@RequestParam String tag) {
        return Jsoup.connect(getImage.getImage(tag, 1).get(0).getAsJsonObject().get("url").getAsString())
                .timeout(500)
                .ignoreContentType(true)
                .header("Referer","https://pixiv.net/")
                .execute().bodyAsBytes();
    }

    @SneakyThrows
    @GetMapping(value = "/pixivstealer/geturl")
    public String getUrl(@RequestParam String tag, @RequestParam(required = false, defaultValue = "1") int count) {
        JsonObject post = new JsonObject();
        post.addProperty("Referer","https://pixiv.net/");
        post.add("image", getImage.getImage(tag, count));
        return post.toString();
    }
}
