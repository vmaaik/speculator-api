package com.gebarowski.michal.speculatorapi.service;

import com.gebarowski.michal.speculatorapi.gateway.ExchangeRateServiceGateway;
import com.gebarowski.michal.speculatorapi.model.ExchangeRateModel;
import com.gebarowski.michal.speculatorapi.response.ExchangeRateResponse;
import com.gebarowski.michal.speculatorapi.service.exception.CurrencyExchangeException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExchangeRateServiceTest {

    private static final String EUR = "EUR";
    private static final String PLN = "PLN";
    private static final String UNSUPPORTED_CURRENCY = "ISK";

    private static final Currency CODE_EURO = Currency.getInstance(EUR);
    private static final Currency CODE_PLN = Currency.getInstance(PLN);

    @Mock
    private ExchangeRateServiceGateway exchangeRateServiceGateway;

    @InjectMocks
    private ExchangeRateService exchangeRateService;

    @Test
    @Disabled
    void returnsSuccessfulResponse() {
        when(this.exchangeRateServiceGateway.getCurrencyExchangeRate(CODE_EURO, CODE_PLN))
                .thenReturn(buildExchangeRateResponse());

        final ExchangeRateModel response = this.exchangeRateService.getCurrentExchangeRate(EUR, PLN);

        assertEquals(response, buildExchangeRateModel());
    }

    @Test
    void throwsExceptionWhenCurrencyUnsupported() {

        assertThrows(CurrencyExchangeException.class, () ->
                this.exchangeRateService.getCurrentExchangeRate(UNSUPPORTED_CURRENCY, PLN)
        );
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
                .lastRefreshed(LocalDateTime.of(2015, 2, 20, 20, 20, 20))
                .exchangeRate(BigDecimal.valueOf(4.2752))
                .build();
    }
}