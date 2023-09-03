package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.UpdateWareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.WareHouseRequest;
import com.example.jumia_Ecommerce.model.data.Address;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class WareHouseServiceTest {
    @Autowired
    private WareHouseService wareHouseService;
   private Address address1;
   private Address address2;
   private Address address3;
   private Address address4;
    private WareHouseRequest wareHouseRequest1;
    private WareHouseRequest wareHouseRequest2;
    private WareHouseRequest wareHouseRequest3;
    private WareHouseRequest wareHouseRequest4;
    private UpdateWareHouseRequest updateWareHouseRequest;

    @BeforeEach
    void setUp() {
        wareHouseRequest1 = new WareHouseRequest();
        wareHouseRequest1.setPassword("blueSEa");
        address1 = new Address();
        address1.setBuildingNumber("3");
        address1.setState("lagos");
        address1.setStreetName("yaba");
        address1.setLocationGovernmentName("yaba");
       wareHouseRequest1.setWareHouesAddress(address1);

       wareHouseRequest2 = new WareHouseRequest();
        wareHouseRequest2.setPassword("blueBoat");
       address2 = new Address();
       address2.setBuildingNumber("67");
       address2.setState("lagos");
       address2.setStreetName("sango");
       address2.setLocationGovernmentName("sango");
       wareHouseRequest2.setWareHouesAddress(address2);

       wareHouseRequest3 = new WareHouseRequest();
        wareHouseRequest3.setPassword("blueShip");
       address3 = new Address();
       address3.setBuildingNumber("34");
       address3.setState("lagos");
       address3.setStreetName("mongoMarry");
       address3.setLocationGovernmentName("yaba");
       wareHouseRequest3.setWareHouesAddress(address3);

       wareHouseRequest4 = new WareHouseRequest();
        wareHouseRequest4.setPassword("blueboat");
       address4 = new Address();
       address4.setBuildingNumber("70");
       address4.setState("lagos");
       address4.setStreetName("oshodi");
       address4.setLocationGovernmentName("oshodi");
       wareHouseRequest4.setWareHouesAddress(address4);

       updateWareHouseRequest = new  UpdateWareHouseRequest();
       updateWareHouseRequest.setOldWareHouseName("yaba");
       updateWareHouseRequest.setNewWareHouseName("oyinbgo");

    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void createWareTes(){
        assertNotNull(wareHouseService.registerNewWareHouse(wareHouseRequest1));
        assertNotNull(wareHouseService.registerNewWareHouse(wareHouseRequest2));
        assertNotNull(wareHouseService.registerNewWareHouse(wareHouseRequest3));
        assertNotNull(wareHouseService.registerNewWareHouse(wareHouseRequest4));
    }
    @Test
    void updateWareHouse(){
        assertEquals("oyinbgo",wareHouseService.updateWareHouse( updateWareHouseRequest).getWarehouseName());
    }
    @Test
    void deleteWareHouse(){
        assertDoesNotThrow(()->{
            wareHouseService.deleteWareHouseByName("oyinbgo");
        });
    }
    @Test
    void deleteAllWareHouse(){
        wareHouseService.deleteAllWareHouse();
        assertEquals(0, wareHouseService.countWareHouse());
    }
    @Test
    void loginToWareHouseDashBoard(){
    assertEquals(true,wareHouseService.loginToWareHouseDashBoard("mongoMarry","blueship").isLoggedIn());
    }
}