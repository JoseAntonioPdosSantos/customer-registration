package com.capintani.customerregistration.model;

import com.capintani.customerregistration.wrapper.AddressWrapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Address implements Serializable {

    @Id
    @GeneratedValue(generator = "address_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="address_sequence", initialValue = 1)
    private Long id;
    private String cep;
    private Long number;
    private String streetAddress;
    private String complement;
    private String neighborhood;
    private String locality;
    private String uf;

    public Address() {
    }

    public Address(Builder builder) {
        setId(builder.id);
        setNumber(builder.number);
        setCep(builder.cep);
        setStreetAddress(builder.streetAddress);
        setComplement(builder.complement);
        setNeighborhood(builder.neighborhood);
        setLocality(builder.locality);
        setUf(builder.uf);
    }

    public Address(AddressWrapper addressWrapper) {
        setId(addressWrapper.getId());
        setNumber(addressWrapper.getNumber());
        setCep(addressWrapper.getCep());
        setStreetAddress(addressWrapper.getStreetAddress());
        setComplement(addressWrapper.getComplement());
        setNeighborhood(addressWrapper.getNeighborhood());
        setLocality(addressWrapper.getLocality());
        setUf(addressWrapper.getUf());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setCep(String cep) {
        this.cep = cep != null ? cep.trim().replaceAll("[^0-9]{8}", "") : cep;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String publicPlace) {
        this.streetAddress = publicPlace;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String district) {
        this.neighborhood = district;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class Builder {
        private Long id;
        private Long number;
        private String cep;
        private String streetAddress;
        private String complement;
        private String neighborhood;
        private String locality;
        private String uf;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder number(Long number) {
            this.number = number;
            return this;
        }

        public Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder streetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder complement(String complement) {
            this.complement = complement;
            return this;
        }

        public Builder neighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
            return this;
        }

        public Builder locality(String locality) {
            this.locality = locality;
            return this;
        }

        public Builder uf(String uf) {
            this.uf = uf;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}
