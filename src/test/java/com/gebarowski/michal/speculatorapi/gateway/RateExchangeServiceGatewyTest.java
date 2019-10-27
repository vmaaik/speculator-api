package com.gebarowski.michal.speculatorapi.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gebarowski.michal.speculatorapi.model.CurrencyExchangeRateModel;
import com.gebarowski.michal.speculatorapi.model.CurrencyExchangeRateResponse;
import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

import static org.junit.Assert.*;

public class RateExchangeServiceGatewyTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getCurrencyExchangeRate() throws IOException {



        System.out.println(s.toUri());

    }


}


