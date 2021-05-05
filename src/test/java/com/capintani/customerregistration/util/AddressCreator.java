package com.capintani.customerregistration.util;

import com.capintani.customerregistration.model.Address;

public class AddressCreator {

    public static Address createAddressToBeSaved(){
        return new Address.Builder()
                .cep("79000001")
                .streetAddress("Street Test 01")
                .complement("")
                .neighborhood("District Test 01")
                .locality("Locality Test 01")
                .uf("MS").build();
    }

    public static Address createAddressToBeFinded(){
        return new Address.Builder()
                .id(1L)
                .cep("79000001")
                .streetAddress("Street Test 01")
                .complement("")
                .neighborhood("District Test 01")
                .locality("Locality Test 01")
                .uf("MS").build();
    }
}
