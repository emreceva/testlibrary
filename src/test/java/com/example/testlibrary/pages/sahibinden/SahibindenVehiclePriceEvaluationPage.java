package com.example.testlibrary.pages.sahibinden;

import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.data.Car;
import com.example.testlibrary.data.CarType;
import com.example.testlibrary.interfaces.sahibinden.SahibindenVehiclePriceEvaluation;
import com.example.testlibrary.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@LazyComponent
public class SahibindenVehiclePriceEvaluationPage extends BasePage implements SahibindenVehiclePriceEvaluation {

    @FindBy(id = "evaluateVehiclePrice")
    private WebElement vehicleEvaluationButton;

    @FindBy(className = "jspContainer")
    private WebElement vehicleTypeSelection;

    @FindBy(id = "calculate-vehicle-price")
    private WebElement showValueButton;

    @FindBy(xpath = "//*[@class ='jspContainer']")
    private List<SahibindenVehicleEvaluationContainerComponent> vehicleEvaluationContainerComponents;

    @FindBy(id = "mileage-value")
    private WebElement mileageValue;

    @FindBy(css = ".evaluate-another-vehicle")
    private WebElement evaluateAnotherVehicleButton;


    @Override
    public boolean isAt() {
        String currentUrl = browser.getWebDriver().getCurrentUrl();
        return currentUrl.contains("auto360/vehicle-price-evaluation/seller") || currentUrl.contains("oto360/arac-degerleme/satarken");
    }

    @Override
    public SahibindenVehiclePriceEvaluationPage clickVehickeEvaluationButton() {
        browser.click(vehicleEvaluationButton);
        return this;
    }

    @Override
    public SahibindenVehiclePriceEvaluationPage clickVehicleTypeSelectionContainer() {
        browser.click(vehicleTypeSelection);
        return this;
    }

    @Override
    public SahibindenVehiclePriceEvaluationPage clickEvaluateAnotherVehicleButton() {
        browser.click(evaluateAnotherVehicleButton);
        return this;
    }

    @Override
    public SahibindenVehiclePriceEvaluationPage selectCarOnContainer(CarType carType) {
        Car car = carType.getInfo();
        vehicleEvaluationContainerComponents.get(0).clickContainerItem(car.getVehicleType());
        vehicleEvaluationContainerComponents.get(1).clickContainerItem(car.getYear());
        vehicleEvaluationContainerComponents.get(2).clickContainerItem(car.getBrand());
        vehicleEvaluationContainerComponents.get(3).clickContainerItem(car.getModel());
        vehicleEvaluationContainerComponents.get(4).clickContainerItem(car.getFuel());
        vehicleEvaluationContainerComponents.get(5).clickContainerItem(car.getSubModel());
        vehicleEvaluationContainerComponents.get(6).clickContainerItem(car.getSubCategory());
        vehicleEvaluationContainerComponents.get(7).clickContainerItem(car.getFullModelName());
        vehicleEvaluationContainerComponents.get(8).clickSubModelFulName(car.getFullModelName());
        enterMileageValue(car.getKm());
        clickShowValueButton();
        return this;
    }

    private SahibindenVehiclePriceEvaluationPage clickShowValueButton() {
         browser.click(showValueButton);
         return this;
    }

    private SahibindenVehiclePriceEvaluationPage enterMileageValue(String km) {
        browser.sendKeys(mileageValue, km);
        return this;
    }


}
