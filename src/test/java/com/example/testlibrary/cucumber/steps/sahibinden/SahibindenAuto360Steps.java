package com.example.testlibrary.cucumber.steps.sahibinden;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.data.Car;
import com.example.testlibrary.data.CarType;
import com.example.testlibrary.enums.HeaderItemAuto360;
import com.example.testlibrary.enums.MenuItemAuto360;
import com.example.testlibrary.interfaces.sahibinden.SahibindenHeaderAuto360;
import com.example.testlibrary.interfaces.sahibinden.SahibindenVehiclePriceEvaluation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SahibindenAuto360Steps {

    @LazyAutowired
    private SahibindenHeaderAuto360 sahibindenHeaderAuto360;

    @LazyAutowired
    private SahibindenVehiclePriceEvaluation vehiclePriceEvaluation;

    @When("I click {string} menu item from {string} on the Sahibinden Auto360 Page")
    public void iClickItemFromHeaderMenu(String headerItem, String menuItem) {
        HeaderItemAuto360 headerItemAuto360 = HeaderItemAuto360.valueOf(headerItem.toUpperCase());
        MenuItemAuto360 menuItemAuto360 = MenuItemAuto360.valueOf(menuItem.toUpperCase());

        sahibindenHeaderAuto360.clickItemOnHeader(headerItemAuto360).clickItemOnMenu(menuItemAuto360);

    }

    @And("Verify that the Vehicle Evaluation Page is opened successfully")
    public void verifyThatTheVehicleEvaluationPageIsOpenedSuccessfully() {
        Assertions.assertTrue(vehiclePriceEvaluation.isAt(), "Sahibinden Vehicle Evaluation Page could not be opened successfully.");
    }

    @And("I click the vehicle evaluation button on the Sahibinden Vehicle Evaluation Page")
    public void iClickTheVehicleEvaluationButton() {
        vehiclePriceEvaluation.clickVehicleTypeSelectionContainer();
    }

    @And("I click the vehicle type selection container on the Sahibinden Vehicle Evaluation Page")
    public void iClickTheVehicleTypeSelectionContainer() {
        vehiclePriceEvaluation.clickVehicleTypeSelectionContainer();
    }

    @And("I select {string} for the vehicle type selection container on the Sahibinden Vehicle Evaluation Page")
    public void iSelectForTheVehicleTypeSelectionContainer(String carType) {
        CarType car = CarType.valueOf(carType.toUpperCase());
        vehiclePriceEvaluation.selectCarOnContainer(car);
    }

    @And("I click evaluate another vehicle button on the Sahibinden Vehicle Evaluation Page")
    public void iClickEvaluateAnotherVehicleButton() {
        vehiclePriceEvaluation.clickEvaluateAnotherVehicleButton();
    }

    @Given("I go to the Sahibinden Auto360 Page")
    public void iGoToTheSahibindenAutoPage() {
        vehiclePriceEvaluation.goToVehicleEvaluationPage();
    }
}
