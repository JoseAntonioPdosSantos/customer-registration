package com.capintani.customerregistration.service;

import com.capintani.customerregistration.wrapper.AddressWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private final ExternalApiAddressService<String, AddressWrapper> externalApiAddressService;

    @Autowired
    public AddressService(@Qualifier("viaCepApiService") ExternalApiAddressService<String, AddressWrapper> externalApiAddressService) {
        this.externalApiAddressService = externalApiAddressService;
    }

    public Optional<AddressWrapper> findByCep(String cep){
        return externalApiAddressService.find(cep);
    }


}
