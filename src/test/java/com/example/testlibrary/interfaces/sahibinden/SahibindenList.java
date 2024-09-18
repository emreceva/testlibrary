package com.example.testlibrary.interfaces.sahibinden;

public interface SahibindenList {

    void switchNextPage();

    SahibindenList clickSortingType(String sortingType);

    SahibindenList verifySearchResultItem();

    SahibindenList verifyFilterFunction(String sortingType);
}
