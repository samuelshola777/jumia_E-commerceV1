package com.example.jumia_Ecommerce.service.implementation;

import com.example.jumia_Ecommerce.exception.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class Tools {
    public  String passwordValidate(String password) {
        int number = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                number++;}
        }
        if (number < 3)
            throw new ValidationException("password should contain at least 3 number");
        return password;
    }


}
