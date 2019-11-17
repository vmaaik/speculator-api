package com.gebarowski.michal.speculatorapi.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.gebarowski.michal.speculatorapi.model.ExchangeRateModel;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ExchangeRateResponse {

    @JsonAlias("Realtime Currency Exchange Rate")
    private ExchangeRateModel exchangeRateModel;
}
