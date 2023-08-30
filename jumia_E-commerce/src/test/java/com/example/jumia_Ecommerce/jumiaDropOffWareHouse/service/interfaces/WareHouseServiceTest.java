package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.WareHouseRequest;
import com.example.jumia_Ecommerce.model.data.Address;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
class WareHouseServiceTest {
    private final WareHouseService wareHouseService;
   private Address address1;
   private Address address2;
   private Address address3;
   private Address address4;
    private WareHouseRequest wareHouseRequest1;
    private WareHouseRequest wareHouseRequest2;
    private WareHouseRequest wareHouseRequest3;
    private WareHouseRequest wareHouseRequest4;

    @BeforeEach
    void setUp() {
        wareHouseRequest1 = new WareHouseRequest();
        address1 = new Address();
        address1.setBuildingNumber("3");
        address1.setState("lagos");
        address1.setStreetName("yaba");
        address1.setLocationGovernmentName("yaba");
       wareHouseRequest1.setWareHouesAddress(address1);

       wareHouseRequest2 = new WareHouseRequest();
       address2.setBuildingNumber("67");
       address2.setState("lagos");
       address2.setStreetName("sango");
       address2.setLocationGovernmentName("sango");
       wareHouseRequest2.setWareHouesAddress(address2);

       wareHouseRequest3 = new WareHouseRequest();
       address3.setBuildingNumber("34");
       address3.setState("lagos");
       address3.setStreetName("mongoMarry");
       address3.setLocationGovernmentName("yaba");

       wareHouseRequest4 = new WareHouseRequest();
       address4.setBuildingNumber("70");
       address4.setState("lagos");
       address4.setStreetName("oshodi");
       address4.setLocationGovernmentName("oshodi");
       wareHouseRequest4.setWareHouesAddress(address4);

    }

    @AfterEach
    void tearDown() {
    }
}