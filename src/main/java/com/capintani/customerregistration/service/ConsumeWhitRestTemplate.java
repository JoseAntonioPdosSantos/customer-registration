package com.capintani.customerregistration.service;

import com.capintani.customerregistration.wrapper.AddressWrapper;
import com.capintani.customerregistration.wrapper.RestTemplateParams;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Component
public class ConsumeWhitRestTemplate implements ConsumeExternalApi<RestTemplateParams, ResponseEntity<AddressWrapper>> {


    @Override
    public Optional<ResponseEntity<AddressWrapper>> execute(RestTemplateParams restTemplateParams) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(restTemplateParams.getScheme())
                .host(restTemplateParams.getHost())
                .path(restTemplateParams.getPath()).build();
        return  Optional.ofNullable(restTemplate.getForEntity(uriComponents.toUriString(), AddressWrapper.class));
    }
}
