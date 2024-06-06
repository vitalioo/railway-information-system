package com.example.railwayinformationsystem.exception;

public class CashierNotFoundException extends RuntimeException {
    public CashierNotFoundException(String message) {
        super(message);
    }
}
