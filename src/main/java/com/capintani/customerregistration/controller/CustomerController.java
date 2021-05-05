package com.capintani.customerregistration.controller;

import com.capintani.customerregistration.model.Address;
import com.capintani.customerregistration.model.Customer;
import com.capintani.customerregistration.service.CustomerRegistrationService;
import com.capintani.customerregistration.wrapper.AddressWrapper;
import com.capintani.customerregistration.wrapper.CustomerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cr0001/customer-registration/v1/customers")
public class CustomerController {

    private final CustomerRegistrationService<Customer> customerCustomerRegistrationService;

    @Autowired
    public CustomerController(@Qualifier("customerService") CustomerRegistrationService<Customer> customerCustomerRegistrationService) {
        this.customerCustomerRegistrationService = customerCustomerRegistrationService;
    }

    @PostMapping("/")
    public ResponseEntity<CustomerWrapper> save(@RequestBody CustomerWrapper customerWrapper){
        Address address = new Address.Builder()
                .id(customerWrapper.getAddress().getId())
                .cep(customerWrapper.getAddress().getCep())
                .neighborhood(customerWrapper.getAddress().getNeighborhood())
                .streetAddress(customerWrapper.getAddress().getStreetAddress())
                .complement(customerWrapper.getAddress().getComplement())
                .locality(customerWrapper.getAddress().getLocality())
                .uf(customerWrapper.getAddress().getUf()).build();
        Customer customer = new Customer.Builder()
                .name(customerWrapper.getName())
                .email(customerWrapper.getEmail())
                .cpf(customerWrapper.getCpf())
                .address(address).build();

        customer = customerCustomerRegistrationService.save(customer);

        AddressWrapper addressWrapper = new AddressWrapper.Builder()
                .id(customer.getAddress().getId())
                .cep(customer.getAddress().getCep())
                .neighborhood(customer.getAddress().getNeighborhood())
                .streetAddress(customer.getAddress().getStreetAddress())
                .locality(customer.getAddress().getLocality())
                .uf(customer.getAddress().getUf()).build();
        customerWrapper = new CustomerWrapper.Builder()
                .id(customer.getId())
                .name(customer.getName())
                .cpf(customer.getCpf())
                .email(customer.getEmail())
                .address(addressWrapper)
                .build();
        return new ResponseEntity<>(customerWrapper, HttpStatus.CREATED);
    }
}
