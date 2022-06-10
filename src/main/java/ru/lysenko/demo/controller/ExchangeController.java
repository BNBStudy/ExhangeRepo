package ru.lysenko.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lysenko.demo.service.ChoiseService;
import ru.lysenko.demo.service.ExchangeRatesService;
import java.util.List;


@RestController
public class ExchangeController {

    private ExchangeRatesService exchangeRatesService;
    private ChoiseService choiseService;

    public ExchangeController(ExchangeRatesService exchangeRatesService, ChoiseService choiseService) {
        this.exchangeRatesService = exchangeRatesService;
        this.choiseService = choiseService;
    }

    @GetMapping("/sym")
    public List<String> getSymbols() {
        return exchangeRatesService.getSymbols();
    }

    @GetMapping("/gif")
    public String getGif() {
        return choiseService.choiseResult();
    }
}
