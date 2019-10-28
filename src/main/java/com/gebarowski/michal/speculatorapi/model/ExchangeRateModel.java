package com.gebarowski.michal.speculatorapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

// TODO write a big decimal serializer

@Builder
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateModel {

    @JsonAlias("1. From_Currency Code")
    Currency currencyCodeFrom;

    @JsonAlias("3. To_Currency Code")
    Currency currencyCodeTo;

    @JsonAlias("5. Exchange Rate")
    BigDecimal exchangeRate;

    @JsonAlias("6. Last Refreshed")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date lastRefreshed;

    @JsonAlias("8. Bid Price")
    BigDecimal bidPrice;

    @JsonAlias("9. Ask Price")
    BigDecimal askPrice;
}
