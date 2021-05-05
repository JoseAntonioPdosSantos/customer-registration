package com.capintani.customerregistration.controller;

import com.capintani.customerregistration.model.Customer;
import com.capintani.customerregistration.service.CustomerRegistrationService;
import com.capintani.customerregistration.wrapper.CustomerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cr0001/customer-registration/v1/customers")
public class CustomerController {

    private final CustomerRegistrationService<Customer> customerCustomerRegistrationService;

    @Autowired
    public CustomerController(@Qualifier("customerService") CustomerRegistrationService<Customer> customerCustomerRegistrationService) {
        this.customerCustomerRegistrationService = customerCustomerRegistrationService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<CustomerWrapper> findByEmail(@RequestAttribute String email){
        Customer customer = customerCustomerRegistrationService.findByEmail(email);
        return new ResponseEntity<>(new CustomerWrapper(customer), HttpStatus.CREATED);
    }

    @PostMapping("/")
    public ResponseEntity<CustomerWrapper> save(@RequestBody CustomerWrapper customerWrapper){
        Customer customer = new Customer(customerWrapper);
        customer = customerCustomerRegistrationService.save(customer);
        return new ResponseEntity<>(new CustomerWrapper(customer), HttpStatus.CREATED);
    }
}
