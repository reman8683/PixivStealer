package com.reman8683.pixivstealer.controller.pixivstealer;

import lombok.SneakyThrows;

import java.awt.*;

public class ImageSearchVo {
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @SneakyThrows
    public byte[] image() throws Exception {
        return getImage.getImage(tag);
    }
}
