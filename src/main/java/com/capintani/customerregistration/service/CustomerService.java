package com.capintani.customerregistration.service;

import com.capintani.customerregistration.model.Customer;
import com.capintani.customerregistration.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerRegistrationService<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
}
