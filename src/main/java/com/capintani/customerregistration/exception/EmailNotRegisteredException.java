package com.capintani.customerregistration.exception;

public class EmailNotRegisteredException extends RuntimeException {

    private static final String EMAIL_NOT_REGISTERED = "Customer not found with this e-mail.";

    public EmailNotRegisteredException() {
        super(EMAIL_NOT_REGISTERED);
    }

}
