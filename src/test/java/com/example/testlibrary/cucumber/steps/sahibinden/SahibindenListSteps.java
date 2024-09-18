package com.example.testlibrary.cucumber.steps.sahibinden;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.enums.SortingTypes;
import com.example.testlibrary.interfaces.sahibinden.SahibindenList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SahibindenListSteps {

    @LazyAutowired
    SahibindenList sahibindenList;

    @Then("Verify that the another vehicles are listed on the Sahibinden List Page")
    public void verifyThatAnotherVehiclesAreListed() {
        sahibindenList.switchNextPage();
        sahibindenList.verifySearchResultItem();
    }

    @And("Verify that the {string} filter function is working successfully on the Sahibinden List Page")
    public void verifyThatTheFilterFunctionIsWorkingSuccessfully(String sorting) {
        SortingTypes sortingType = SortingTypes.valueOf(sorting);
        sahibindenList.verifyFilterFunction(sortingType.getText());
    }
}
