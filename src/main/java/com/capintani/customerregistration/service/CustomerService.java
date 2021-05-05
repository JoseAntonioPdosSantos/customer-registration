package com.capintani.customerregistration.service;

import com.capintani.customerregistration.model.Customer;
import com.capintani.customerregistration.repository.CustomerRepository;
import com.capintani.customerregistration.wrapper.AddressWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements CustomerRegistrationService<Customer> {

    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AddressService addressService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
    }

    public Customer save(Customer customer){
        Optional<AddressWrapper> addressWrapperOptional = addressService.findByCep(customer.getAddress().getCep());
        if(addressWrapperOptional.isPresent()){
            AddressWrapper addressWrapper = addressWrapperOptional.get();
            addressWrapper.setComplement(customer.getAddress().getComplement());
            addressWrapper.setNumber(customer.getAddress().getNumber());
            customer.setAddress(addressWrapper);
        } else {
            throw new RuntimeException("The informed CEP is invalid.");
        }
        Optional<Customer> optionalCustomer = customerRepository.findByCpfOrEmail(customer.getCpf(), customer.getEmail());
        if(optionalCustomer.isPresent()){
            throw new RuntimeException("There is already a registration with this CPF or e-mail. This operation failed.");
        }
        return customerRepository.save(customer);
    }

    public Customer findByEmail(String email){
        Optional<Customer> customerOptional = customerRepository.findByEmail(email);
        if(customerOptional.isPresent()){
            return customerOptional .get();
        }
        throw new RuntimeException("Customer not found with this e-mail.");
    }
}
