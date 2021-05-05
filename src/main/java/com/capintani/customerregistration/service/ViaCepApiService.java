package com.capintani.customerregistration.service;

import com.capintani.customerregistration.validate.CepValidate;
import com.capintani.customerregistration.wrapper.AddressWrapper;
import com.capintani.customerregistration.wrapper.RestTemplateParams;
import com.capintani.customerregistration.wrapper.ViaCepApiParams;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("viaCepApiService")
public class ViaCepApiService implements ExternalApiAddressService<String, AddressWrapper> {

    private final ConsumeExternalApi consumeExternalApi;

    @Autowired
    public ViaCepApiService(@Qualifier("consumeWhitRestTemplate") ConsumeExternalApi consumeExternalApi){
        this.consumeExternalApi = consumeExternalApi;
    }

    @Override
    public Optional<AddressWrapper> find(String cep) {
        if(!new CepValidate().test(cep)){
            throw new RuntimeException("The CEP entered is invalid.");
        }
        Optional<ResponseEntity<AddressWrapper>> wrapperResponseEntity = consumeExternalApi.execute(new ViaCepApiParams(cep));
        return wrapperResponseEntity.isPresent() ? Optional.of(wrapperResponseEntity.get().getBody()) : Optional.empty();
    }

}
