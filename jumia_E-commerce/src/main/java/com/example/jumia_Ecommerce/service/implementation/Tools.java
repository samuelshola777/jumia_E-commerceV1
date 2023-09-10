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
    public String networkProvider(String phoneNumber){

            if (gloCheck(phoneNumber)) return "glo";
            if (mtnCheck(phoneNumber)) return "mtn";
            if(airtelCheck(phoneNumber)) return "airtel";
            if (visaCheck(phoneNumber)) return "visafone";
            if (etisalatCheck(phoneNumber)) return "etisalat";


        return  null;

    }
    //todo  09099332737
    public String cutFirstFourNumber(String phoneNumber) {
     return phoneNumber.substring(0,4);
    }
    public  boolean mtnCheck(String number) {
        String[] mtnNumber = {"0803", "0816", "0903", "0810", "0806", "0703", "0706", "0813", "0814", "0906"};
        String[] mtnNigeria = {"+234803", "+234816", "+234903", "+234810", "+234806", "+234703", "+234706", "+234813", "+234814", "+234906"};

        if (cutFirstFourNumber(number).equals("+234")){
            String cutNigerNumber = number.substring(0,7);
            for (String s : mtnNigeria){
            if (s.equals(cutNigerNumber)) return true;
            }
        }
        for (String mtn : mtnNumber) {
            if (mtn.equals(cutFirstFourNumber(number))) {
                return true;
            }
        }
        return false;
    }
    public boolean etisalatCheck(String number){
        String [] etisalatNumber = {"0909"	,"0908"	,"0818","0809","0817"};
        String [] etisalatNigeria = {"+234909"	,"+234908"	,"+234818","+234809","+234817"};
        if (cutFirstFourNumber(number).equals("+234")){
            String cutNigerNumber = number.substring(0,7);
            for (String s : etisalatNigeria){
                if (s.equals(cutNigerNumber)) return true;
            }
        }
        for (String mtn : etisalatNumber) {
            if (mtn.equals(cutFirstFourNumber(number))) {
                return true;
            }
        }
        return false;
    }
    public boolean airtelCheck(String number){
        String [] airtelNumber = {"0907","0708","0802","0902","0812","0808","0701"};
        String [] airtelNigeria = {"+234907","+234708","+234802","+234902","+234812","+234808","+234701"};
        if (cutFirstFourNumber(number).equals("+234")){
            String cutNigerNumber = number.substring(0,7);
            for (String s : airtelNigeria){
                if (s.equals(cutNigerNumber)) return true;
            }
        }
        String cutNumber = cutFirstFourNumber(number);
        for (String mtn : airtelNumber) {
            if (mtn.equals(cutNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean gloCheck(String number){
        String [] gloNumber = {"0805","0905","0807","0811","0705","0815"};
        String [] gloNigeria = {"+234805","+234905","+234807","+234811","+234705","+234815"};
        if (cutFirstFourNumber(number).equals("+234")){
            String cutNigerNumber = number.substring(0,7);
            for (String s : gloNigeria){
                if (s.equals(cutNigerNumber)) return true;
            }
        }
        String cutNumber = number.substring(0, 4);
        for (String mtn : gloNumber) {
            if (mtn.equals(cutNumber)) {
                return true;
            }
        }
        return false;
    }
    public boolean visaCheck(String number){
        String [] visafoneNumber = {"0704","07026","07025"};
        String [] visafoneNigeria = {"+234704","+2347026","+2347025"};
        if (cutFirstFourNumber(number).equals("+234")){
            String cutNigerNumber = number.substring(0,7);
            for (String s : visafoneNigeria){
                if (s.equals(cutNigerNumber)) return true;
            }
        }
        String cutNumber = number.substring(0, 4);
        for (String mtn : visafoneNumber) {
            if (mtn.equals(cutNumber)) {
                return true;
            }
        }
        return false;
    }




}
