package com.capintani.customerregistration.service.address;

import com.capintani.customerregistration.service.ConsumeWhitRestTemplate;
import com.capintani.customerregistration.service.ViaCepApiService;
import com.capintani.customerregistration.wrapper.AddressWrapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


@ExtendWith(SpringExtension.class)
@DisplayName("Tests for External API Address Service")
public class ExternalApiAddressWrapperServiceTest {

    @Mock
    private ConsumeWhitRestTemplate consumeWhitRestTemplate;

    @InjectMocks
    private ViaCepApiService externalApiAddressService;

    @BeforeEach
    public void setUp(){
        AddressWrapper addressTest01 = new AddressWrapper.Builder()
                .cep("79000001")
                .streetAddress("Street Test 01")
                .complement("")
                .neighborhood("District Test 01")
                .locality("Locality Test 01")
                .uf("MS").build();

        BDDMockito.when(consumeWhitRestTemplate.execute(ArgumentMatchers.any()))
                .thenReturn(Optional.of(ResponseEntity.of(Optional.of(addressTest01))));
    }

    @Test
    @DisplayName("Find address by CEP")
    public void find_addressByCEP_WhenSuccessful(){
        String cep = "79000001";
        Optional<AddressWrapper> address = externalApiAddressService.find(cep);

        Assertions.assertThat(address.get().getCep()).isNotNull();
        Assertions.assertThat(address.get().getStreetAddress()).isNotNull();
        Assertions.assertThat(address.get().getNeighborhood()).isNotNull();
        Assertions.assertThat(address.get().getLocality()).isNotNull();
        Assertions.assertThat(address.get().getUf()).isNotNull();
    }

    @Test
    @DisplayName("Throws invalid CEP")
    public void find_ThrowsInvalidCEP_WhenSuccessful(){
        String cep = "79000-0001";

        Assertions.assertThatThrownBy(() ->
            externalApiAddressService.find(cep))
                .isInstanceOf(RuntimeException.class);
    }




}

