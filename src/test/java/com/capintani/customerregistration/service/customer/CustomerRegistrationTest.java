package com.capintani.customerregistration.service.customer;

import com.capintani.customerregistration.model.Address;
import com.capintani.customerregistration.model.Customer;
import com.capintani.customerregistration.repository.CustomerRepository;
import com.capintani.customerregistration.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DisplayName("Tests for Customer")
public class CustomerRegistrationTest {

    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp(){
        Address address = createAddress();
        Customer customer = new Customer.Builder()
                .id(1L)
                .name("Customer Name")
                .cpf("79000000")
                .address(address)
                .email("email@gmail.com").build();

        BDDMockito.when(customerRepository.save(ArgumentMatchers.any()))
                .thenReturn(customer);
    }

    @Test
    @DisplayName("Tests for save Customer")
    public void save_Customer_WhenSuccessful(){
        Customer customer = new Customer.Builder()
                .name("Customer Name")
                .cpf("79000000")
                .address(new Address())
                .email("email@gmail.com").build();
        customer = customerService.save(customer);

        Assertions.assertThat(customer).isNotNull();
        Assertions.assertThat(customer.getId()).isNotNull();
        Assertions.assertThat(customer.getName()).isNotNull();
        Assertions.assertThat(customer.getEmail()).isNotNull();
        Assertions.assertThat(customer.getCpf()).isNotNull();
        Assertions.assertThat(customer.getAddress()).isNotNull();
        Assertions.assertThat(customer.getAddress().getId()).isNotNull();
        Assertions.assertThat(customer.getAddress().getCep()).isNotNull();
        Assertions.assertThat(customer.getAddress().getNeighborhood()).isNotNull();
        Assertions.assertThat(customer.getAddress().getStreetAddress()).isNotNull();
        Assertions.assertThat(customer.getAddress().getLocality()).isNotNull();
        Assertions.assertThat(customer.getAddress().getUf()).isNotNull();
    }


    private Address createAddress() {
        return new Address.Builder()
                .id(1L)
                .cep("79000001")
                .streetAddress("Street Test 01")
                .complement("")
                .neighborhood("District Test 01")
                .locality("Locality Test 01")
                .uf("MS").build();
    }
}
