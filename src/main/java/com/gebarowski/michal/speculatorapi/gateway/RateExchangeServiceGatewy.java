package com.gebarowski.michal.speculatorapi.gateway;

import com.gebarowski.michal.speculatorapi.model.CurrencyExchangeRateResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Currency;

@Service
public class RateExchangeServiceGatewy {

    private final RestTemplate template = new RestTemplate();

    @Value("${alphavantage.apiKey}")
    private String apiKey;

    @Value("${alphavantage.url}")
    private String url;


    public CurrencyExchangeRateResponse getCurrencyExchangeRate(final Currency currencyFrom, final Currency currencyTo) {
        return this.template.getForObject(
                UriComponentsBuilder.fromHttpUrl(url)
                        .queryParam("from_currency", currencyFrom)
                        .queryParam("to_currency", currencyTo)
                        .queryParam("apikey", apiKey)
                        .build()
                        .toUri(),
                CurrencyExchangeRateResponse.class);
    }
}
