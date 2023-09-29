package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.controller;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.UpdateWareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.WareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseLoginResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces.WareHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wareHouse")

public class WareHouseController {
    private final WareHouseService wareHouseService;

    @PostMapping("/register")
    public ResponseEntity<WareHouseResponse> registerWareHouse(@RequestBody WareHouseRequest wareHouseRequest){
        return new ResponseEntity<>(wareHouseService.registerNewWareHouse(wareHouseRequest), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<WareHouseResponse> updateWareHouseDetails( @RequestBody UpdateWareHouseRequest updateWareHouseRequest){
        return new ResponseEntity<>(wareHouseService.updateWareHouse(updateWareHouseRequest), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteByName")
    public ResponseEntity<String> deleteWareHouseByWareHouseName(@RequestParam String wareHouseName) {
        boolean deleted = wareHouseService.deleteWareHouseByName(wareHouseName);

        if (deleted) {
            return ResponseEntity.ok("Warehouse with the name " + wareHouseName + " has been deleted \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Warehouse with the name \uD83E\uDD37\u200D♂\uD83E\uDD37\u200D♂\uD83E\uDD37\u200D♂" +
                    "\uD83E\uDD37\u200D♂\uD83E\uDD37\u200D♂\uD83E\uDD37\u200D♂\uD83E\uDD37\u200D♂\uD83E\uDD37\u200D♂\uD83E\uDD37\u200D♂  " + wareHouseName + " not found.");
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllWareHouse(){
        boolean deleted = wareHouseService.deleteAllWareHouse();
        if (deleted){
            return new ResponseEntity<>(" all ware house has been deleted  \uD83D\uDC35\uD83D\uDE48\uD83D\uDE49",HttpStatus.OK);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("\uD83D\uDE48\uD83D\uDE49\uD83D\uDE4A couldn't complete this action");

        }
    }
@GetMapping("/getAllCategories")
    private ResponseEntity<?> getAllCategoriesByWareHouseManagerDetails(@RequestParam String wareHouseManagerEmail, @RequestParam String warehouseName){
        return new ResponseEntity<>(wareHouseService.getAllCategory(wareHouseManagerEmail, warehouseName), HttpStatus.ACCEPTED);

}


}
