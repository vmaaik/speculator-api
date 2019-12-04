package com.gebarowski.michal.speculatorapi.data;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Data
public class ExchangeRateEntity {

    Long id;

    LocalDateTime createdAt;

    Currency currencyCodeFrom;

    Currency currencyCodeTo;

    BigDecimal exchangeRate;

    LocalDateTime lastRefreshed;

    BigDecimal bidPrice;

    BigDecimal askPrice;
}
