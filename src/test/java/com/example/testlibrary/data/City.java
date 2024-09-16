package com.example.testlibrary.data;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum City {

    ISTANBUL("Istanbul"),ANKARA("Ankara");

    private String city;
}
