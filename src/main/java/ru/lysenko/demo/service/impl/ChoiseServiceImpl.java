package ru.lysenko.demo.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.lysenko.demo.service.ChoiseService;
import ru.lysenko.demo.service.ExchangeRatesService;
import ru.lysenko.demo.service.GifService;

@Service
public class ChoiseServiceImpl implements ChoiseService {

    ExchangeRatesService ratesService;
    GifService gifService;

    @Value("${gif.rich}")
    String rich;
    @Value("${gif.broke}")
    String broke;
    @Value("${gif.zero}")
    String zero;

    //переменная для присвоения результата поиска гиф
    String tag;

    public ChoiseServiceImpl(ExchangeRatesService ratesService, GifService gifService) {
        this.ratesService = ratesService;
        this.gifService = gifService;
    }

    /*
     метод выбора параметра tag, значение rich or broke
     в зависимости от значения ratesService.getDifference

      return url gif
     */

    @Override
    public String choiseResult() {
        tag = ratesService.getDifference() > 0 ? rich : broke;
        if (ratesService.getDifference() == 0) {
            tag = zero;
        }

        String response = gifService.getGif(tag);

        return response;
    }
}
