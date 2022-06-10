package ru.lysenko.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.lysenko.demo.client.ExchangeClient;
import ru.lysenko.demo.model.CurrencyExchange;
import ru.lysenko.demo.service.ExchangeRatesService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

    CurrencyExchange todayExchange;
    CurrencyExchange yesturdayExchange;

    private ExchangeClient client;


    @Value("${openexchangerates.app.id}")
    private String appId;
    @Value("${openexchangerates.base}")
    private String base;

    @Autowired
    public ExchangeRatesServiceImpl(ExchangeClient client) {
        this.client = client;
    }

    /*
    Получения всех доступных валют
    для сравнения с базовой парой USD openexchangerates

    return Список все доступных пар
     */
    @Override
    public List<String> getSymbols() {
        todayExchange = client.getCurrentExchange(appId);
        return new ArrayList<>(todayExchange.getRates().keySet());
    }

    /*
    Получени вчерашнего и текущего курса от openexchangerates
     и сравнение его с базовым

    return результат сравнения курсов
     */
    @Override
    public double getDifference() {
        double result = 0;
        todayExchange = client.getCurrentExchange(appId);
        yesturdayExchange = client.getYesturdayExchange(getYesturdaySimpleDate(), appId);
        if (!todayExchange.getRates().isEmpty()) {
            Double todayValue = todayExchange.getRates().get(base);
            Double yesturdayValue = yesturdayExchange.getRates().get(base);

            result = todayValue - yesturdayValue;
        }
        return result;
    }

    /*
     получения вчерашней даты для getYesturdayExchange

     return Дату в формате yyyy-MM-dd для api openexchangerates
     */
    public String getYesturdaySimpleDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(calendar.getTime());
    }
}
