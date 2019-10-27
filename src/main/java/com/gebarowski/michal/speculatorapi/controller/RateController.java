package com.gebarowski.michal.speculatorapi.controller;

import com.gebarowski.michal.speculatorapi.model.CurrencyExchangeRateModel;
import com.gebarowski.michal.speculatorapi.service.RateExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
public class RateController {

    private final RateExchangeService rateExchangeService;

    public RateController(RateExchangeService rateExchangeService) {
        this.rateExchangeService = rateExchangeService;
    }

//    @GetMapping("/exchange/{currencyFrom}/{currencyTo}")
//    public CurrencyExchangeRateModel getRate(@PathVariable(name = "currencyFrom") String currencyFrom, @PathVariable(name ="currencyTo") String currencyTo) {
//        System.out.println("lllll");
//        return this.alphavantageService.getExchangeRate(Currency.getInstance(currencyFrom), Currency.getInstance(currencyTo));
//    }

    @GetMapping
    public String getTest() {
        return "Hello";
    }

    @RequestMapping("/test")
    CurrencyExchangeRateModel home() {
        return this.rateExchangeService.getExchangeRate(Currency.getInstance("GBP"), Currency.getInstance("PLN"));
    }
}
