package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces;

import com.example.jumia_Ecommerce.jumiaUser.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.model.data.Address;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class WareHouseManagerServiceTest {
    @Autowired
    private  WareHouseManagerService wareHouseManagerService;


    private Address address1;
    private Address address2;
    private Address address3;

    private JumiaUserRequest wareHouseManager1;
    private JumiaUserRequest wareHouseManager2;
    private JumiaUserRequest wareHouseManager3;


    @BeforeEach
    void setUp() {
        address1 = new Address();
        address1.setState("lagos");
        address1.setStreetName("38");
        address1.setStreetName("obalende");
        address1.setLocationGovernmentName("islAND");

        address2 = new Address();
        address2.setLocationGovernmentName("ikeja");
        address2.setStreetName("airport road");
        address2.setState("lagos");
        address2.setBuildingNumber("56");


        address3 = new Address();
        address3.setBuildingNumber("100");
        address3.setState("lagos");
        address3.setStreetName("makoko");
        address3.setLocationGovernmentName("ebute meta");

        wareHouseManager1 = new JumiaUserRequest();
        wareHouseManager1.setPassword("goat123");
        wareHouseManager1.setAddress(address1);
        wareHouseManager1.setPhoneNumber("09019332737");
        wareHouseManager1.setUserName("flyAway1");
        wareHouseManager1.setEmailAddress("flyaway1@gmail.com");

        wareHouseManager2 = new JumiaUserRequest();
        wareHouseManager2.setEmailAddress("flyaway2@gmail.com");
        wareHouseManager2.setPhoneNumber("09029332737");
        wareHouseManager2.setAddress(address2);
        wareHouseManager2.setPassword("goat1234");
        wareHouseManager2.setUserName("flyaway2");

        wareHouseManager3 = new JumiaUserRequest();
        wareHouseManager3.setUserName("flyaway3");
        wareHouseManager3.setPassword("goat1235");
        wareHouseManager3.setAddress(address3);
        wareHouseManager3.setPhoneNumber("09039332737");
        wareHouseManager3.setEmailAddress("flyaway3@gmail.com");

    }

    @Test
    void registerNewWareHouse() {
        assertDoesNotThrow(()->{

          wareHouseManagerService.registerNewWareHouse(wareHouseManager1, "yaba");
           wareHouseManagerService.registerNewWareHouse(wareHouseManager2,"sango");
            wareHouseManagerService.registerNewWareHouse(wareHouseManager3, "mongoMarry");
        });

    }

    @Test
    void loginAsWareHouseManager() {

        assertEquals("ihwdjfiujeeijeff", wareHouseManagerService.loginAsWareHouseManager("flyaway3@gmail.com","goat1235"));
    }

    @Test
    void deleteAllWareHouseManager(){
        wareHouseManagerService.deleteAllWareHouseManager();
    }
}