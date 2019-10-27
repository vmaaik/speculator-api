package com.gebarowski.michal.speculatorapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class CurrencyExchangeRateModel  {
    //    String currencyCodeFrom;
//    String currencyCodeTo;

    @JsonAlias("5. Exchange Rate")
    String exchangeRate;
//    String lastRefreshed;
//    String bidPrice;
//    String askPrice;
//    String utc;
}
