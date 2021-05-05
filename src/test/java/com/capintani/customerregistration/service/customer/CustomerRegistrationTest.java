package com.capintani.customerregistration.service.customer;

import com.capintani.customerregistration.model.Address;
import com.capintani.customerregistration.model.Customer;
import com.capintani.customerregistration.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DisplayName("Tests for Customer")
public class CustomerRegistrationTest {

    @InjectMocks
    private CustomerService customerService;

    @Test
    @DisplayName("Tests for save Customer")
    public void save_Customer_WhenSuccessful(){

        Customer customer = new Customer.Builder()
                .name("Customer Name")
                .cpf("00000000000")
                .address(new Address())
                .email("email@gmail.com").build();
        customer = customerService.save(customer);

        Assertions.assertThat(customer).isNotNull();
        Assertions.assertThat(customer.getId()).isNotNull();
    }
}
