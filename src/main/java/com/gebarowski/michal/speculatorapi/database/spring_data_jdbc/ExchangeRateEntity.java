package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Table;

@Data
@Builder
@Table(name = "EXCHANGE_RATE_HISTORY")
public class ExchangeRateEntity {

    private Long id;

    private String currencyCodeFrom;

    private String currencyCodeTo;

    private String exchangeRate;

    private String lastRefreshed;

    private String bidPrice;

    private String askPrice;
}
