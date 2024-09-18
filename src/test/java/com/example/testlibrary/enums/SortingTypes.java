package com.example.testlibrary.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SortingTypes {
    EN_DUSUK_FIYAT("Fiyata göre (Önce en düşük)"), EN_YUKSEK_FIYAT("Fiyata göre (Önce en yüksek)");

    private String text;
}
