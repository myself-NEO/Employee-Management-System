package com.example.demo.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String houseNo;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String pinCode;

    public static Address fromString(String address) {
        // ..
        return new Address();
    }
}
