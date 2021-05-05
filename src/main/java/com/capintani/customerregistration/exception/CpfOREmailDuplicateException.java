package com.capintani.customerregistration.exception;

public class CpfOREmailDuplicateException extends RuntimeException {

    private static final String CPF_OR_EMAIL_DUPLICATE = "There is already a registration with this CPF or e-mail. This operation failed.";

    public CpfOREmailDuplicateException() {
        super(CPF_OR_EMAIL_DUPLICATE);
    }
}
