package com.gebarowski.michal.speculatorapi.service.exception;

import java.util.function.Supplier;

public class CurrencyExchangeException extends RuntimeException {
    public CurrencyExchangeException(String message) {
        super(message);
    }
}
