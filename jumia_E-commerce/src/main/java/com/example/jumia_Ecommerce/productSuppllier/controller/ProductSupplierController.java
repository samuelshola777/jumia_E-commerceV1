package com.example.jumia_Ecommerce.productSuppllier.controller;

import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce.productSuppllier.exception.ProductSupplierException;
import com.example.jumia_Ecommerce.productSuppllier.service.interfaces.ProductSupplierService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productSupplier/")
public class ProductSupplierController {
    private final ProductSupplierService productSupplierService;

    @PostMapping("register")
    public ResponseEntity<?> registerProductSupplier(@RequestBody ProductSupplierRequest productSupplierRequest){
       try{
           return new ResponseEntity<>(productSupplierService.registerNewProductSupplier(productSupplierRequest), HttpStatus.OK);
       }catch (Exception e){
           System.out.println(e.getMessage());
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

       }
    }

    @GetMapping("login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
        try{
            return new ResponseEntity<>(productSupplierService.loginAsProductSupplier(email, password), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new ProductSupplierException("login Detail Error");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }












}
