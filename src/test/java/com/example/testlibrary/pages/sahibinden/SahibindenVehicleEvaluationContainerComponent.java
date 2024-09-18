package com.example.testlibrary.pages.sahibinden;

import com.example.testlibrary.pages.NestedComponent;
import org.openqa.selenium.By;

public class SahibindenVehicleEvaluationContainerComponent extends NestedComponent {

    private String containerItem = "//*[@class ='jspContainer']//li/span[text() = '%s']";

    private String subModelFullName = "//*[@class ='jspContainer']//td[text()='%s']";

    public SahibindenVehicleEvaluationContainerComponent clickContainerItem(String item) {
        getBrowser().click(By.xpath(String.format(containerItem, item)));
        return this;
    }

    public SahibindenVehicleEvaluationContainerComponent clickSubModelFulName(String subModel) {
        getBrowser().click(By.xpath(String.format(subModelFullName, subModel)));
        return this;
    }
}
