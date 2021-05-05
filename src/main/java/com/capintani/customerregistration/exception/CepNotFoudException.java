package com.capintani.customerregistration.exception;

public class CepNotFoudException extends RuntimeException {

    private static final String CEP_NOT_FOUND = "The informed CEP was not found.";

    public CepNotFoudException() {
        super(CEP_NOT_FOUND);
    }
}
