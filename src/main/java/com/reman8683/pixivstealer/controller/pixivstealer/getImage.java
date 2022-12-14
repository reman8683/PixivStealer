package com.reman8683.pixivstealer.controller.pixivstealer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;

public class getImage {
    public static JsonObject getImage(String tag, int imageCount) throws Exception {
        byte[] tagBytes = tag.getBytes("utf-8");
        String tagUTF8 = "";
        for (byte tagByte : tagBytes) {
            tagUTF8 += "%".concat(Integer.toHexString(tagByte).replace("ffffff", ""));
        }
        String baseURI = "https://www.pixiv.net/ajax/search/illustrations/" + tagUTF8 + "?word=" + tagUTF8 + "&order=date_d&mode=all&p=1&s_mode=s_tag_full&type=illust_and_ugoira&lang=ko";

        String str = Jsoup.connect(baseURI)
                .timeout(1000)
                .ignoreContentType(true)
                .execute().body();
        JsonParser jsonParser = new JsonParser();
        JsonArray jo = jsonParser.parse(str)
                .getAsJsonObject().get("body")
                .getAsJsonObject().get("illust")
                .getAsJsonObject().get("data").getAsJsonArray();
        JsonArray Images = new JsonArray();
        int count = 0;
        for (JsonElement p : jo) {
            if (count >= imageCount) {
                break;
            }
            JsonObject Image = new JsonObject();
            Image.add("id", p.getAsJsonObject().get("id"));
            Image.add("title", p.getAsJsonObject().get("title"));
            Image.addProperty("url", p.getAsJsonObject().get("url").getAsString()
                    .replace("/c/250x250_80_a2", "")
                    .replace("square", "master")
                    .replace("/custom-thumb", "/img-master")
                    .replace("custom", "master"));
            Images.add(Image);
            count++;
        }
        JsonObject output = new JsonObject();
        output.addProperty("tag", tag);
        output.addProperty("count", imageCount);
        output.addProperty("Referer", "https://www.pixiv.net/");
        output.add("images", Images);
        return output;
    }
}
