package com.gebarowski.michal.speculatorapi.database.spring_data_jdbc;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeRateEntity {

    public Long id;

    public String dbTest;

}
