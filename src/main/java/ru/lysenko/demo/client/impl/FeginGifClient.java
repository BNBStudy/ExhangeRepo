package ru.lysenko.demo.client.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lysenko.demo.client.GifClient;

import java.util.Map;

/*
Клиент для получения ГИФ в зависимости от параметра tag
 */
@FeignClient(value = "gif", url = "${gif.url}")
public interface FeginGifClient extends GifClient {

    @Override
    @GetMapping("/random")
    ResponseEntity<Map> getRandomGif(@RequestParam("api_key") String api_key, @RequestParam("tag") String tag);
}
