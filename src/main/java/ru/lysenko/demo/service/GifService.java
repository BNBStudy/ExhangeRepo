package ru.lysenko.demo.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GifService {

    String getGif(String tag);
}
