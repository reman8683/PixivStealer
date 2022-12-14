package com.reman8683.pixivstealer.controller.pixivstealer;

import lombok.SneakyThrows;

public class ImageSearchVo {
    private String tag;
    private int count;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @SneakyThrows
    @Override
    public String toString() {
        return getImage.getImage(tag, count).toString();
    }
}
