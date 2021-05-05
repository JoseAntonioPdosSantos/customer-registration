package com.capintani.customerregistration.wrapper;

import java.io.Serializable;

public class CustomerWrapper implements Serializable {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private AddressWrapper address;

    public CustomerWrapper() {

    }

    public CustomerWrapper(Builder builder) {
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

    public AddressWrapper getAddress() {
        return address;
    }

    public void setAddress(AddressWrapper address) {
        this.address = address;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String cpf;
        private String email;
        private AddressWrapper address;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }

        public Builder email(String email){
            this.name = email;
            return this;
        }

        public Builder address(AddressWrapper address){
            this.address = address;
            return this;
        }

        public CustomerWrapper build(){
            return new CustomerWrapper(this);
        }

    }
}
