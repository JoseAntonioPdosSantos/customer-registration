package com.capintani.customerregistration.wrapper;

import com.capintani.customerregistration.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AddressWrapper implements Serializable {

    private Long id;
    private Long number;
    private String cep;
    @JsonProperty("logradouro")
    private String streetAddress;
    @JsonProperty("complemento")
    private String complement;
    @JsonProperty("bairro")
    private String neighborhood;
    @JsonProperty("localidade")
    private String locality;
    private String uf;

    public AddressWrapper() {
    }

    public AddressWrapper(Builder builder) {
        setId(builder.id);
        setCep(builder.cep);
        setStreetAddress(builder.streetAddress);
        setComplement(builder.complement);
        setNeighborhood(builder.neighborhood);
        setLocality(builder.locality);
        setUf(builder.uf);
    }

    public AddressWrapper(Address address) {
        setId(address.getId());
        setCep(address.getCep());
        setStreetAddress(address.getStreetAddress());
        setComplement(address.getComplement());
        setNeighborhood(address.getNeighborhood());
        setLocality(address.getLocality());
        setUf(address.getUf());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep != null ? cep.trim().replaceAll("[^0-9]{8}", "") : cep;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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

    public static class Builder {
        private Long id;
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

        public AddressWrapper build(){
            return new AddressWrapper(this);
        }
    }
}
