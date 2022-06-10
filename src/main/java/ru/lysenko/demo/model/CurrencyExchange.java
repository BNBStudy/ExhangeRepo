package ru.lysenko.demo.model;

import java.util.Map;

/*
Модель для получения данный с openexchage
 */

public class CurrencyExchange {

    private String disclaimer;
    private String license;
    private int timestamp;
    private String base;
    private Map<String, Double> rates;

    public CurrencyExchange() {
    }

    public CurrencyExchange(String disclaimer, String license, int timestamp, String base, Map<String, Double> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.base = base;
        this.rates = rates;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

}
