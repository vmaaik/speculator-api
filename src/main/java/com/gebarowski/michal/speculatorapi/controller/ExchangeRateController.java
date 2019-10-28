package com.gebarowski.michal.speculatorapi.controller;

import com.gebarowski.michal.speculatorapi.model.ExchangeRateModel;
import com.gebarowski.michal.speculatorapi.service.ExchangeRateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @RequestMapping("/test")
    ExchangeRateModel home() {
        return this.exchangeRateService.getExchangeRate(Currency.getInstance("GBP"), Currency.getInstance("PLN"));
    }
}
