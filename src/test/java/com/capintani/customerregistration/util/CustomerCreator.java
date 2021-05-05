package com.capintani.customerregistration.util;

import com.capintani.customerregistration.model.Customer;

public class CustomerCreator {

    public static Customer createCustomerToBeSaved(){
        return new Customer.Builder()
                .name("Customer Name")
                .cpf("79000000")
                .address(AddressCreator.createAddressToBeSaved())
                .email("email@gmail.com").build();
    }

    public static Customer createCustomerToBeFinded(){
        return new Customer.Builder()
                .id(1L)
                .name("Customer Name")
                .cpf("79000000")
                .address(AddressCreator.createAddressToBeFinded())
                .email("email@gmail.com").build();
    }
}
