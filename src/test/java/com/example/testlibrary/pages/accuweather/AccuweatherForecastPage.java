package com.example.testlibrary.pages.accuweather;

import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.interfaces.accuweather.AccuweatherForecast;
import com.example.testlibrary.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@LazyComponent
public class AccuweatherForecastPage extends BasePage implements AccuweatherForecast {

    @FindBy(xpath = "//*[@class = 'cur-con-weather-card__body']//*[@class='temp']")
    private WebElement currentTempInf;

    @Override
    public boolean isAt() {
        return browser.getWebDriver().getTitle().contains("Weather Forecast");
    }

    @Override
    public String getCurrentTemp() {
       return browser.readText(currentTempInf);
    }
}
