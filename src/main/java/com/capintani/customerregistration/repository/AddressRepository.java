package com.capintani.customerregistration.repository;

import com.capintani.customerregistration.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {

}
