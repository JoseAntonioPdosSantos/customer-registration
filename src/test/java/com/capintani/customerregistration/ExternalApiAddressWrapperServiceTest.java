package com.capintani.customerregistration;

import com.capintani.customerregistration.service.ConsumeWhitRestTemplate;
import com.capintani.customerregistration.service.ExternalApiAddressService;
import com.capintani.customerregistration.wrapper.AddressWrapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@DisplayName("Tests for External API Address Service")
public class ExternalApiAddressWrapperServiceTest {

    @Mock
    private ExternalApiAddressService<String, ResponseEntity<AddressWrapper>> externalApiAddressService;

    @BeforeEach
    public void setUp(){
        AddressWrapper addressTest01 = new AddressWrapper();
        addressTest01.setCep("79000001");
        addressTest01.setPublicPlace("Street Test 01");
        addressTest01.setComplement("");
        addressTest01.setDistrict("District Test 01");
        addressTest01.setLocality("Locality Test 01");
        addressTest01.setUf("MS");

        AddressWrapper addressTest02 = new AddressWrapper();
        addressTest02.setCep("79000002");
        addressTest02.setPublicPlace("Street Test 02");
        addressTest02.setComplement("");
        addressTest02.setDistrict("District Test 02");
        addressTest02.setLocality("Locality Test 02");
        addressTest02.setUf("MS");

        AddressWrapper addressTest03 = new AddressWrapper();
        addressTest03.setCep("79000003");
        addressTest03.setPublicPlace("Street Test 03");
        addressTest03.setComplement("");
        addressTest03.setDistrict("District Test 03");
        addressTest03.setLocality("Locality Test 03");
        addressTest03.setUf("MS");

        List<Optional<ResponseEntity<AddressWrapper>>> addressList = Arrays.asList(
                Optional.of(ResponseEntity.of(Optional.of(addressTest01))),
                Optional.of(ResponseEntity.of(Optional.of(addressTest02))),
                Optional.of(ResponseEntity.of(Optional.of(addressTest03))));

        final String cep = "79000001";
        BDDMockito.when(externalApiAddressService.find(cep))
                .thenReturn(addressList.stream().filter(address -> address.get().getBody().getCep().equals(cep)).findFirst().get());
    }

    @Test
    public void find_addressByCEP_WhenSuccessful(){
        String cep = "79000001";
        Optional<ResponseEntity<AddressWrapper>> address = externalApiAddressService.find(cep);

        Assertions.assertThat(address.isPresent()).isTrue();

        System.out.println(address.get().getBody());

    }
}
