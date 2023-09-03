package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response;

import com.example.jumia_Ecommerce.model.data.Categories;
import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce.product.data.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WareHouseLoginResponse {
    private boolean isLoggedIn;
    private Categories[] categories = Categories.values();
    private final List<ProductResponse> listOfElectronicProducts = new ArrayList<>();
    private final List<ProductResponse> listOfFashionProducts = new ArrayList<>();
    private final List<ProductResponse> listOfHomeProducts = new ArrayList<>();
    private final List<ProductResponse> listOfFoodProducts = new ArrayList<>();
    private final List<ProductResponse> listOfSportProducts = new ArrayList<>();
    private final List<ProductResponse> listOfBookProducts = new ArrayList<>();
    private final List<ProductResponse> listOfPetProducts = new ArrayList<>();
    private final List<ProductResponse> listOfBabyProducts = new ArrayList<>();
    private final List<ProductResponse> listOfHealthProducts = new ArrayList<>();
    private final List<ProductResponse> listOfHospitalProducts = new ArrayList<>();
    private final List<ProductResponse> listOfTravelProducts = new ArrayList<>();


}