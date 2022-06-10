package ru.lysenko.demo.service;

import java.util.List;

public interface ExchangeRatesService {

    List<String> getSymbols();

    double getDifference();
}
