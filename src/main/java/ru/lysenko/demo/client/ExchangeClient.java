package ru.lysenko.demo.client;

import ru.lysenko.demo.model.CurrencyExchange;

public interface ExchangeClient {

    CurrencyExchange getCurrentExchange(String app_id);

    CurrencyExchange getYesturdayExchange(String date, String app_id);
}
