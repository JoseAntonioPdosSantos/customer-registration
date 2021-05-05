package com.capintani.customerregistration.exception;

public class CpfInvalidException extends RuntimeException {

    private static final String CPF_INVALID = "The CPF informed is invalid.";

    public CpfInvalidException() {
        super(CPF_INVALID);
    }
}
