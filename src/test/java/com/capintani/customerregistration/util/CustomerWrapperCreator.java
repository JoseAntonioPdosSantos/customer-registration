package com.capintani.customerregistration.util;

import com.capintani.customerregistration.wrapper.CustomerWrapper;

public class CustomerWrapperCreator {

    public static CustomerWrapper createCustomerToBeSaved(){
        return new CustomerWrapper.Builder()
                .name("Customer Name")
                .cpf("07359375088")
                .address(AddressWrapperCreator.createWithInvalidCep())
                .email("email@gmail.com").build();
    }

    public static CustomerWrapper createCustomerToBeSavedWithInvalidCep(){
        return new CustomerWrapper.Builder()
                .name("Customer Name")
                .cpf("07359375088")
                .address(AddressWrapperCreator.create())
                .email("email@gmail.com").build();
    }

    public static CustomerWrapper createCustomerToBeFinded(){
        return new CustomerWrapper.Builder()
                .id(1L)
                .name("Customer Name")
                .cpf("07359375088")
                .address(AddressWrapperCreator.create())
                .email("email@gmail.com").build();
    }
}
