package com.example.jumia_Ecommerce.productSuppllier.service.interfaces;

import com.example.jumia_Ecommerce.model.data.Address;
import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.generalEnums.Product_Categories;
import com.example.jumia_Ecommerce.product.DTO.request.ProductRequest;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.UpdateProductSupplierRequest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
class ProductSupplierServiceTest {
    @Autowired
    private  ProductSupplierService productSupplierServiceService;


    private Address address1;
    private Address address2;
    private Address address3;
    private JumiaUser jumiaUser1;
    private JumiaUser jumiaUser2;
    private JumiaUser jumiaUser3;
    private UpdateProductSupplierRequest supplierUpdateRequest;
    private Address updateAddress;

    private ProductSupplierRequest productSupplierRequest1;
    private ProductSupplierRequest productSupplierRequest2;
    private ProductSupplierRequest productSupplierRequest3;

    private ProductRequest productRequest1;
    private ProductRequest productRequest2;
    private ProductRequest productRequest3;
    private ProductRequest productRequest4;


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
        jumiaUser1.setPassword("SAMUELSHOLA14@GMAIL.COM0");
        jumiaUser1.setEmailAddress("samuelshola14@gmail.com");
        jumiaUser1.setPhoneNumber("09099332737");
        productSupplierRequest1 = new ProductSupplierRequest();
        productSupplierRequest1.setJumiaUser(jumiaUser1);


        address2 = new Address();
        address2.setLocationGovernmentName("ikeja");
        address2.setStreetName("airport road");
        address2.setState("lagos");
        address2.setBuildingNumber("56");
        jumiaUser2 = new JumiaUser();
        jumiaUser2.setPhoneNumber("09062666877");
        jumiaUser2.setAddress(address2);
        jumiaUser2.setUserName("boneshaker");
        jumiaUser2.setPassword("BONESHAKER986@GMAIL.COM");
        jumiaUser2.setEmailAddress("boneshaker896@gmail.com");
        productSupplierRequest2 = new ProductSupplierRequest();
        productSupplierRequest2.setJumiaUser(jumiaUser2);

        address3 = new Address();
        address3.setBuildingNumber("100");
        address3.setState("lagos");
        address3.setStreetName("makoko");
        address3.setLocationGovernmentName("ebute meta");
        jumiaUser3 = new JumiaUser();
        jumiaUser3.setEmailAddress("sholaibrahimoh@gmail.com");
        jumiaUser3.setPassword("blueboat123");
        jumiaUser3.setAddress(address3);
        jumiaUser3.setUserName("sambone");
        jumiaUser3.setPhoneNumber("09062066877");
        jumiaUser3.setPassword("1SHOLAIBRAHIMOH2@GMAIL.COM3");
        productSupplierRequest3 = new ProductSupplierRequest();
        productSupplierRequest3.setJumiaUser(jumiaUser3);

        supplierUpdateRequest = new UpdateProductSupplierRequest();
        updateAddress = new Address();
        updateAddress.setLocationGovernmentName("iwaya");
        updateAddress.setStreetName("more road");
        supplierUpdateRequest.setProductSupplierUserName("sambone");
        supplierUpdateRequest.setUserName("isreal");
        supplierUpdateRequest.setAddress(updateAddress);

        productRequest1 = new ProductRequest();
        productRequest1.setProductSupplierName("rephah");
        productRequest1.setProductName("oraimo power bank");
        productRequest1.setProductPrice(BigDecimal.valueOf(2000));
        productRequest1.setCategory(Product_Categories.COMPUTER);
        productRequest1.setQuantity(50);
        productRequest1.setWareHouseName("oshodi");


        productRequest2 = new ProductRequest();
        productRequest2.setProductSupplierName("isreal");
        productRequest2.setProductName("nike cap");
        productRequest2.setProductPrice(BigDecimal.valueOf(3000));
        productRequest2.setQuantity(1600);
        productRequest2.setProductName("oyingbo");
        productRequest2.setCategory(Product_Categories.FASHION);


        productRequest3 = new ProductRequest();
        productRequest3.setCategory(Product_Categories.SPORT);
        productRequest3.setProductSupplierName("sport bycikle");
        productRequest3.setProductPrice(BigDecimal.valueOf(93000));
        productRequest3.setQuantity(70);
        productRequest3.setProductSupplierName("sambone");
        productRequest3.setWareHouseName("oyingbo");

    }

    @Test
    void registerNewProductSupplier(){
        try{
            assertNotNull(productSupplierServiceService.registerNewProductSupplier(productSupplierRequest1));
           assertNotNull(productSupplierServiceService.registerNewProductSupplier(productSupplierRequest2));
            assertNotNull(productSupplierServiceService.registerNewProductSupplier(productSupplierRequest3));

        }catch(Exception e){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>  "+e.getMessage());
        }
    }

    @Test
    void updateProductSupplier(){
        try{
            assertNotEquals("isreal", productSupplierServiceService.updateProductSupplierDetails(supplierUpdateRequest).getToken());

        }catch (Exception a){
            System.out.println(a.getMessage()+"   <<<<<<<");
        }
    }

    @Test
    void deleteProductSupplier(){
        assertEquals("deleted successfully \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49", productSupplierServiceService.deleteProductSupplierByName("sambone"));
        assertEquals("deleted successfully \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49", productSupplierServiceService.deleteProductSupplierByName("boneshaker"));
        assertEquals("deleted successfully \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49", productSupplierServiceService.deleteProductSupplierByName("samuel shola"));
        assertNull(productSupplierServiceService.findProductSupplierByUserName("samuel shola"));
        assertNull(productSupplierServiceService.findProductSupplierByEmailAddress("samuelshola14@gmail.com"));
        assertNull(productSupplierServiceService.findProductSupplierByUserName("boneshaker"));
        assertNull(productSupplierServiceService.findProductSupplierByEmailAddress("sholaibrahimoh@gmail.com"));
        assertNull(productSupplierServiceService.findProductSupplierByUserName("sambone"));
        assertNull(productSupplierServiceService.findProductSupplierByEmailAddress("boneshaker896@gmail.com"));
    }
    @Test
    void reRegisterDeletedProductSupplier(){
        assertNotNull(productSupplierServiceService.registerNewProductSupplier(productSupplierRequest3));

    }
    @Test
    void deleteAllProductSupplier(){
        productSupplierServiceService.deleteAllProductSupplier();
    }

    @Test
    void loginAsProductSupplier(){
        assertNotEquals("bqeeubequbddubdubbueu", productSupplierServiceService.loginAsProductSupplier("boneshaker896@gmail.com","BONESHAKER986@GMAIL.COM"));
    }

    @Test
    void testThatProductSupplierCanSupplyProductsToWareHouse(){

        assertDoesNotThrow(()-> {
            productSupplierServiceService.supplyNewProduct(productRequest3);
            productSupplierServiceService.supplyNewProduct(productRequest2);
            productSupplierServiceService.supplyNewProduct(productRequest1);
        });


    }


}