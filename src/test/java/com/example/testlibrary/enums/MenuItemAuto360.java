package com.example.testlibrary.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MenuItemAuto360 {

    ARAC_DEGERLEME("Araç Değerleme"), OTO_EKSPERTIZ("Oto Expertiz");

    private String text;
}
