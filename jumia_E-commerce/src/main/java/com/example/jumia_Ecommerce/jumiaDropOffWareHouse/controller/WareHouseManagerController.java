package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.controller;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces.WareHouseManagerService;
import com.example.jumia_Ecommerce.jumiaUser.DTO.request.JumiaUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wareHouseManager/")
public class WareHouseManagerController {
    private final WareHouseManagerService wareHouseManagerService;

    @PostMapping("register")
    public ResponseEntity<String> registerWareHouseManager(@RequestBody JumiaUserRequest jumiaUserRequest, @RequestParam String warehouseName){
        return new ResponseEntity<>(wareHouseManagerService.registerNewWareHouse(jumiaUserRequest, warehouseName), HttpStatus.ACCEPTED);
    }
    @GetMapping("login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password){
        return new ResponseEntity<>(wareHouseManagerService.loginAsWareHouseManager(email, password), HttpStatus.OK);
    }

}
