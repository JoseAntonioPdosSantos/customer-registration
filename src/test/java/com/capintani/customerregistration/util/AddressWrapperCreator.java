package com.capintani.customerregistration.util;

import com.capintani.customerregistration.wrapper.AddressWrapper;

public class AddressWrapperCreator {

    public static AddressWrapper create(){
        return new AddressWrapper.Builder()
                .cep("79000001")
                .streetAddress("Street Test 01")
                .complement("")
                .neighborhood("District Test 01")
                .locality("Locality Test 01")
                .uf("MS").build();
    }

    public static AddressWrapper createWithInvalidCep(){
        return new AddressWrapper.Builder()
                .cep("7900000100")
                .streetAddress("Street Test 01")
                .complement("")
                .neighborhood("District Test 01")
                .locality("Locality Test 01")
                .uf("MS").build();
    }
}
