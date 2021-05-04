package com.capintani.customerregistration.service.address;

import com.capintani.customerregistration.service.ConsumeWhitRestTemplate;
import com.capintani.customerregistration.service.ViaCepApiService;
import com.capintani.customerregistration.wrapper.AddressWrapper;
import com.capintani.customerregistration.wrapper.RestTemplateParams;
import com.capintani.customerregistration.wrapper.ViaCepApiParams;
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
        AddressWrapper addressTest01 = new AddressWrapper();
        addressTest01.setCep("79000001");
        addressTest01.setStreetAddress("Street Test 01");
        addressTest01.setComplement("");
        addressTest01.setNeighborhood("District Test 01");
        addressTest01.setLocality("Locality Test 01");
        addressTest01.setUf("MS");

        final String cep = "79000001";
        BDDMockito.when(consumeWhitRestTemplate.execute(ArgumentMatchers.any()))
                .thenReturn(Optional.of(ResponseEntity.of(Optional.of(addressTest01))));
    }

    @Test
    @DisplayName("Find address by CEP")
    public void find_addressByCEP_WhenSuccessful(){
        String cep = "79115090";
        Optional<AddressWrapper> address = externalApiAddressService.find(cep);

        Assertions.assertThat(address.get().getCep()).isNotNull();
    }





}

