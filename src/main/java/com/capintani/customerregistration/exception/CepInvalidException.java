package com.capintani.customerregistration.exception;

public class CepInvalidException extends RuntimeException {

    private static final String CEP_INVALID = "The CEP entered is invalid.";

    public CepInvalidException() {
        super(CEP_INVALID);
    }

}
