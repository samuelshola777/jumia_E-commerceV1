package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response;

import com.example.jumia_Ecommerce.generalEnums.Product_Categories;
import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WareHouseLoginResponse {
    private boolean isLoggedIn;
    private Product_Categories[] categories = Product_Categories.values();
    private List<ProductResponse> listOfProducts = new ArrayList<ProductResponse>();


    public void addProductsToList(List<ProductResponse> products) {
       listOfProducts.addAll(products);
    }
}
