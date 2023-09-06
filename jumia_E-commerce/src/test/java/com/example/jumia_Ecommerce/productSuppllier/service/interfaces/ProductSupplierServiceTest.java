package com.example.jumia_Ecommerce.productSuppllier.service.interfaces;

import com.example.jumia_Ecommerce.model.data.Address;
import com.example.jumia_Ecommerce.model.data.JumiaUser;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce.productSuppllier.data.model.ProductSupplier;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
class ProductSupplierServiceTest {

    private final ProductSupplierService productSupplierService;

    private Address address1;
    private Address address2;
    private Address address3;
    private JumiaUser jumiaUser1;
    private JumiaUser jumiaUser2;
    private JumiaUser jumiaUser3;

    private ProductSupplierRequest productSupplierRequest1;
    private ProductSupplierRequest productSupplierRequest2;
    private ProductSupplierRequest productSupplierRequest3;



    @BeforeEach
    void setUp() {
        address1 = new Address();
        address1.setState("lagos");
        address1.setStreetName("88");
        address1.setStreetName("awoyejo");
        address1.setLocationGovernmentName("mushin");
        jumiaUser1 = new JumiaUser();
        jumiaUser1.setAddress(address1);
        jumiaUser1.setUserName("samuel shola");
        jumiaUser1.setPassword("SAMUELSHOLA14@GMAIL.COM");
        jumiaUser1.setEmailAddress("samuelshola14@gmail.com");
        jumiaUser1.setMobileNetwork("09099332737");
        productSupplierRequest1.setJumiaUser(jumiaUser1);


        address2 = new Address();
        address2.setLocationGovernmentName("ikeja");
        address2.setStreetName("airport road");
        address2.setState("lagos");
        address2.setBuildingNumber("56");
        jumiaUser2 = new JumiaUser();
        jumiaUser2.setMobileNetwork("09062666877");
        jumiaUser2.setAddress(address2);
        jumiaUser2.setUserName("boneshaker");
        jumiaUser2.setPassword("BONESHAKER986@GMAIL.COM");
        jumiaUser2.setEmailAddress("boneshaker896@gmail.com");
        productSupplierRequest2.setJumiaUser(jumiaUser2);

        address3 = new Address();
        address3.setBuildingNumber("100");
        address3.setState("lagos");
        address3.setStreetName("makoko");
        address3.setLocationGovernmentName("ebute meta");
        jumiaUser3 = new JumiaUser();
        jumiaUser3.setEmailAddress("sholaibrahimoh@gmail.com");
        jumiaUser3.setPassword("blueboat");
        jumiaUser3.setAddress(address3);
        jumiaUser3.setUserName("sambone");
        jumiaUser3.setPassword("SHOLAIBRAHIMOH@GMAIL.COM");
        productSupplierRequest3.setJumiaUser(jumiaUser3);

    }


    @Test
    void registerNewProductSupplier(){

        assertNotNull(        productSupplierService.registerNewProductSupplier(productSupplierRequest3));
        assertNotNull(        productSupplierService.registerNewProductSupplier(productSupplierRequest2));
        assertNotNull(        productSupplierService.registerNewProductSupplier(productSupplierRequest1));

    }



}