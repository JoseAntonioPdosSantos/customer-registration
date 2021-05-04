package com.capintani.customerregistration.service;

import com.capintani.customerregistration.wrapper.AddressWrapper;
import com.capintani.customerregistration.wrapper.ViaCepApiParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViaCepApi implements ExternalApiAddressService<String, ResponseEntity<AddressWrapper>> {

    private final ConsumeWhitRestTemplate consumeWhitRestTemplate;

    @Autowired
    public ViaCepApi(ConsumeWhitRestTemplate consumeWhitRestTemplat){
        this.consumeWhitRestTemplate = consumeWhitRestTemplat;
    }

    @Override
    public Optional<ResponseEntity<AddressWrapper>> find(String cep) {
        return consumeWhitRestTemplate.execute(new ViaCepApiParams(cep));
    }

}
