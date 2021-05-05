package com.capintani.customerregistration.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Customer implements Serializable {

    @Id
    @GeneratedValue(generator = "customer_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="customer_sequence", initialValue = 1)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Customer() {
    }

    public Customer(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setCpf(builder.cpf);
        setEmail(builder.email);
        setAddress(builder.address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class Builder {
        private Long id;
        private String name;
        private String cpf;
        private String email;
        private Address address;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }

}
