package com.capintani.customerregistration.repository;

import com.capintani.customerregistration.model.Address;
import com.capintani.customerregistration.model.Customer;
import com.capintani.customerregistration.util.CustomerCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
@DisplayName("Tests for Customer Repository")
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Save customer when successful")
    public void save_PersistCustomer_WhenSuccessful(){
        Customer customer = customerRepository.save(CustomerCreator.createCustomerToBeSaved());
        Assertions.assertThat(customer).isNotNull();
        Assertions.assertThat(customer.getId()).isNotNull();
    }

}