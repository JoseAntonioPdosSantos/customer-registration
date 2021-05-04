package com.capintani.customerregistration.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FunctionalInterface
public interface ExternalApiAddressService<P,R> {

    Optional<R> find(P p);

}
