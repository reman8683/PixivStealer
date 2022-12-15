package com.reman8683.pixivstealer.controller.pixivstealer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;

import java.net.SocketTimeoutException;

public class getImage {
    public static byte[] getImage(String tag) throws Exception {
        byte[] tagBytes = tag.getBytes("utf-8");
        String tagUTF8 = "";
        for (byte tagByte : tagBytes) {
            tagUTF8 += "%".concat(Integer.toHexString(tagByte).replace("ffffff", ""));
        }
        String baseURI = "https://www.pixiv.net/ajax/search/illustrations/" + tagUTF8 + "?word=" + tagUTF8 + "&order=date_d&mode=all&p=1&s_mode=s_tag_full&type=illust_and_ugoira&lang=ko";

        byte[] byteImage = null;
        for (int i = 0; i < 3; i++) {
            try {
                String js = Jsoup.connect(baseURI)
                        .timeout(1000)
                        .ignoreContentType(true)
                        .execute().body();
                JsonParser jsonParser = new JsonParser();
                JsonArray jsDataArray = jsonParser.parse(js)
                        .getAsJsonObject().get("body")
                        .getAsJsonObject().get("illust")
                        .getAsJsonObject().get("data").getAsJsonArray();

                JsonObject jsData = jsDataArray.get((int) (Math.random() * jsDataArray.size())).getAsJsonObject();
                String Image = jsData.get("url").getAsString()
                        .replace("/c/250x250_80_a2", "")
                        .replace("square", "master")
                        .replace("/custom-thumb", "/img-master")
                        .replace("custom", "master");

                byteImage = Jsoup.connect(Image)
                        .timeout(2000)
                        .ignoreContentType(true)
                        .header("Referer", "https://www.pixiv.net/")
                        .execute().bodyAsBytes();
                break;
            } catch (HttpStatusException e) {
            } catch (SocketTimeoutException e) {
            }
        }
        return byteImage;
    }
}
