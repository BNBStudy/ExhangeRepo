package ru.lysenko.demo.service;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.lysenko.demo.client.impl.FeginExchangeClient;
import ru.lysenko.demo.model.CurrencyExchange;
import ru.lysenko.demo.service.impl.ExchangeRatesServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("ru.lysenko")
public class ExchangeRatesServiceImplTest {

    @MockBean
    FeginExchangeClient feginExchangeClient;

    private CurrencyExchange currentRates;
    private CurrencyExchange prevRates;

    @BeforeEach
    public void init() {
        this.currentRates = new CurrencyExchange();
        Map<String, Double> currentRatesMap = new HashMap<>();
        currentRatesMap.put("Test1", 0.1);
        currentRatesMap.put("Test2", 0.5);
        currentRatesMap.put("Test3", 1.0);
        this.currentRates.setRates(currentRatesMap);

        this.prevRates = new CurrencyExchange();
        Map<String, Double> prevRatesMap = new HashMap<>();
        prevRatesMap.put("Test1", 0.1);
        prevRatesMap.put("Test2", 1.0);
        prevRatesMap.put("Test3", 0.5);
        this.prevRates.setRates(prevRatesMap);
    }

    @Test
    public void whenPositiveChanges() {
        Mockito.when(feginExchangeClient.getCurrentExchange(anyString()))
                .thenReturn(this.currentRates);
        Mockito.when(feginExchangeClient.getYesturdayExchange(anyString(), anyString()))
                .thenReturn(this.prevRates);
        double result = currentRates.getRates().get("Test3") - prevRates.getRates().get("Test3");
        assertEquals(0.5, result);
    }

    @Test
    public void whenNegativeChanges() {
        Mockito.when(feginExchangeClient.getCurrentExchange(anyString()))
                .thenReturn(this.currentRates);
        Mockito.when(feginExchangeClient.getYesturdayExchange(anyString(), anyString()))
                .thenReturn(this.prevRates);
        double result = currentRates.getRates().get("Test2") - prevRates.getRates().get("Test2");
        assertEquals(-0.5, result);
    }

    @Test
    public void whenZero() {
        Mockito.when(feginExchangeClient.getCurrentExchange(anyString()))
                .thenReturn(this.currentRates);
        Mockito.when(feginExchangeClient.getYesturdayExchange(anyString(), anyString()))
                .thenReturn(this.prevRates);
        double result = currentRates.getRates().get("Test1") - prevRates.getRates().get("Test1");
        assertEquals(0, result);
    }
}
