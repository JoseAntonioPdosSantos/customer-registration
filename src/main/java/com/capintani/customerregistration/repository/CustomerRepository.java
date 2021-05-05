package com.capintani.customerregistration.repository;

import com.capintani.customerregistration.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCpfOrEmail(String cpf, String email);
    Optional<Customer> findByEmail(String email);
}
