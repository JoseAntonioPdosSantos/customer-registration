package com.capintani.customerregistration.controller;

import com.capintani.customerregistration.service.CustomerRegistrationService;
import com.capintani.customerregistration.util.CustomerCreator;
import com.capintani.customerregistration.util.CustomerWrapperCreator;
import com.capintani.customerregistration.wrapper.CustomerWrapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    @Qualifier("customerService")
    private CustomerRegistrationService customerRegistrationService;

    @BeforeEach
    public void setUp(){
        BDDMockito
                .when(customerRegistrationService.save(ArgumentMatchers.any()))
                .thenReturn(CustomerCreator.createCustomerToBeFinded());
    }

    @Test
    public void save_Customer_WhenSuccessful(){
        ResponseEntity<CustomerWrapper> responseEntity = customerController.save(CustomerWrapperCreator.createCustomerToBeSaved());
        Assertions.assertThat(responseEntity).isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode().value()).isEqualTo(201);
        Assertions.assertThat(responseEntity.getBody().getId()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getName()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getCpf()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getAddress()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getAddress().getId()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getAddress().getCep()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getAddress().getLocality()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getAddress().getNeighborhood()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getAddress().getStreetAddress()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getAddress().getUf()).isNotNull();

    }

}