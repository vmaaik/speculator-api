package com.gebarowski.michal.speculatorapi.controller;

import com.gebarowski.michal.speculatorapi.model.ExchangeRateModel;
import com.gebarowski.michal.speculatorapi.service.ExchangeRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/exchange")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(
            final ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping(value = "/{currencyFrom}/{currencyTo}")
    public ResponseEntity<ExchangeRateModel> getExchangeRate(
            @PathVariable final String currencyFrom,
            @PathVariable final String currencyTo) {

        final ExchangeRateModel response = this.exchangeRateService.getExchangeRate(currencyFrom, currencyTo);

        return ResponseEntity.ok(response);
    }
}
