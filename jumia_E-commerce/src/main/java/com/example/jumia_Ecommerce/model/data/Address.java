package com.example.jumia_Ecommerce.model.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String buildingNumber;
    @Column(nullable = false)
    private String streetName;
    private String locationGovernmentName;
    private String state;


    public static boolean containsAlphabet(String phoneNumber) {
        // Use a regular expression to check if the phone number contains any alphabet characters
        return phoneNumber.matches(".*[a-zA-Z].*");
    }
    public static void main(String[] args) {

        System.out.println(containsAlphabet("090992237272-"));
    }


}
