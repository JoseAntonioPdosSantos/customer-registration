package com.capintani.customerregistration.repository;

import com.capintani.customerregistration.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
