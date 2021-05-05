package com.capintani.customerregistration.respository;

import com.capintani.customerregistration.model.Address;
import com.capintani.customerregistration.model.Customer;
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
        Customer customer = customerRepository.save(createCustomer());
        Assertions.assertThat(customer).isNotNull();
        Assertions.assertThat(customer.getId()).isNotNull();
    }

    private Address createAddress() {
        return new Address.Builder()
                .cep("79000001")
                .streetAddress("Street Test 01")
                .complement("")
                .neighborhood("District Test 01")
                .locality("Locality Test 01")
                .uf("MS").build();
    }

    private Customer createCustomer(){
        return new Customer.Builder()
                .name("Fulando de Tal")
                .cpf("00000000000")
                .address(createAddress())
                .build();
    }
}