package com.capintani.customerregistration.service;

public interface CustomerRegistrationService<T> {

    T save(T t);

    T findByEmail(String email);

}
