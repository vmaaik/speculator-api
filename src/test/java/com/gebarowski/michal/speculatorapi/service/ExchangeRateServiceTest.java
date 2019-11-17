package com.gebarowski.michal.speculatorapi.service;

import com.gebarowski.michal.speculatorapi.gateway.ExchangeRateServiceGateway;
import com.gebarowski.michal.speculatorapi.model.ExchangeRateModel;
import com.gebarowski.michal.speculatorapi.response.ExchangeRateResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ExchangeRateServiceTest {

    private static final String EUR = "EUR";
    private static final String PLN = "PLN";

    private static final Currency CODE_EURO = Currency.getInstance(EUR);
    private static final Currency CODE_PLN = Currency.getInstance(PLN);

    @Mock
    private ExchangeRateServiceGateway exchangeRateServiceGateway;

    @InjectMocks
    private ExchangeRateService exchangeRateService;

    @Test
    public void test() {
        when(this.exchangeRateServiceGateway.getCurrencyExchangeRate(CODE_EURO, CODE_PLN))
                .thenReturn(buildExchangeRateResponse());

        final ExchangeRateModel response = this.exchangeRateService.getExchangeRate(EUR, PLN);

        assertEquals(response, buildExchangeRateModel());
    }


    private static ExchangeRateResponse buildExchangeRateResponse() {
        return ExchangeRateResponse.builder()
                .exchangeRateModel(buildExchangeRateModel())
                .build();
    }

    private static ExchangeRateModel buildExchangeRateModel() {
        return ExchangeRateModel.builder()
                .askPrice(BigDecimal.valueOf(4.2789))
                .bidPrice(BigDecimal.valueOf(4.2715))
                .currencyCodeFrom(CODE_EURO)
                .currencyCodeTo(CODE_PLN)
                .lastRefreshed(new Date())
                .exchangeRate(BigDecimal.valueOf(4.2752))
                .build();
    }
}