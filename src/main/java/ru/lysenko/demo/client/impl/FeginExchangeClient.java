package ru.lysenko.demo.client.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lysenko.demo.client.ExchangeClient;
import ru.lysenko.demo.model.CurrencyExchange;
/*
 Клиент для получения курса на сегодняшний и вчерашний день
 */
@FeignClient(value = "fegin", url = "${openexchangerates.url}")
public interface FeginExchangeClient extends ExchangeClient {

    @Override
    @GetMapping("/latest.json")
    CurrencyExchange getCurrentExchange(@RequestParam("app_id") String app_id);

    @Override
    @GetMapping("/historical/{date}.json")
    CurrencyExchange getYesturdayExchange(@PathVariable("date") String date, @RequestParam("app_id") String app_id);
}
