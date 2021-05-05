package com.capintani.customerregistration.service;

import com.capintani.customerregistration.exception.CepNotFoudException;
import com.capintani.customerregistration.exception.CpfInvalidException;
import com.capintani.customerregistration.exception.CpfOREmailDuplicateException;
import com.capintani.customerregistration.exception.EmailNotRegisteredException;
import com.capintani.customerregistration.model.Customer;
import com.capintani.customerregistration.repository.CustomerRepository;
import com.capintani.customerregistration.validate.CpfValidate;
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
        findAddress(customer);
        validate(customer);
        return customerRepository.save(customer);
    }

    private void validate(Customer customer) {
        validateData(customer);
        validateCustomerDuplicate(customer);
    }

    private void validateData(Customer customer) {
        if(!new CpfValidate().test(customer.getCpf())){
            throw new CpfInvalidException();
        }
    }

    private void validateCustomerDuplicate(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findByCpfOrEmail(customer.getCpf(), customer.getEmail());
        if(!optionalCustomer.isPresent()){
            throw new CpfOREmailDuplicateException();
        }
    }

    private void findAddress(Customer customer) {
        Optional<AddressWrapper> addressWrapperOptional = addressService.findByCep(customer.getAddress().getCep());
        if(addressWrapperOptional.isPresent() || thowCepInvalidException()){
            AddressWrapper addressWrapper = addressWrapperOptional.get();
            addressWrapper.setComplement(customer.getAddress().getComplement());
            addressWrapper.setNumber(customer.getAddress().getNumber());
            customer.setAddress(addressWrapper);
        }
    }

    private boolean thowCepInvalidException() {
        throw new CepNotFoudException();
    }

    public Customer findByEmail(String email){
        Optional<Customer> customerOptional = customerRepository.findByEmail(email);
        if(customerOptional.isPresent()){
            return customerOptional .get();
        }
        throw new EmailNotRegisteredException();
    }
}
