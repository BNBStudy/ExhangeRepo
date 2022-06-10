package ru.lysenko.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.lysenko.demo.client.GifClient;
import ru.lysenko.demo.service.GifService;

import java.util.Map;

@Service
public class GifServiceImpl implements GifService {

    private GifClient gifClient;

    @Value("${giphy.api.key}")
    private String api_key;

    @Autowired
    public GifServiceImpl(GifClient gifClient) {
        this.gifClient = gifClient;
    }

    /*
     Получения нужной ГИФ c giphy.com

     return url нужной gif
     */
    @Override
    public String getGif(String tag) {

        ResponseEntity<Map> response = gifClient.getRandomGif(api_key, tag);

        Map data = (Map) response.getBody().get("data");
        Map images = (Map) data.get("images");
        Map fixed_height_downsampled = (Map) images.get("fixed_height_downsampled");
        String url = (String) fixed_height_downsampled.get("url");
        return url;
    }
}
