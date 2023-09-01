package com.example.jumia_Ecommerce.service.implementation;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.exception.AddressException;
import com.example.jumia_Ecommerce.model.data.Address;
import com.example.jumia_Ecommerce.model.repository.AddressRepository;
import com.example.jumia_Ecommerce.service.interfaces.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressServiceIMPL implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public Address savedAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findAddressByStreetName(String streetName) {
        Address foundAddress = addressRepository.findAddressByStreetName(streetName);
        if (foundAddress == null) throw new AddressException(">> Could not find address with street name " + streetName);
        return foundAddress;
    }


}
