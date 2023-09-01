package com.example.jumia_Ecommerce.service.interfaces;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.model.data.Address;

public interface AddressService {
    Address savedAddress(Address address);
   Address findAddressByStreetName(String streetName);

}
