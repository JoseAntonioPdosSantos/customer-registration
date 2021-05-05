package com.capintani.customerregistration.service;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@FunctionalInterface
public interface ConsumeExternalApi<P,R> {

    Optional<R> execute(P p);

}
