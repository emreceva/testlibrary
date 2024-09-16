package com.example.testlibrary.pages.accuweather;

import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.interfaces.accuweather.AccuweatherHome;
import com.example.testlibrary.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@LazyComponent
public class AccuweatherHomePage extends BasePage implements AccuweatherHome {

    @Value("${web.accuweather.base.url}")
    private String baseUrl;

    @FindBy(xpath = "//a[@class='header-logo']")
    private WebElement headerLogo;

    @FindBy(className = "search-input")
    private WebElement inputSearchBox;

    @FindBy(xpath = "//*[@class = 'results-container']//*[@class = 'search-bar-result__name']")
    private List<WebElement> cityListedSearchBar;

    public AccuweatherHomePage goToHomePage() {
        browser.get(baseUrl);
        return this;
    }

    @Override
    public boolean isAt() {
        return browser.getWebDriver().getTitle().contains("Weather") && browser.isDisplayed(headerLogo);
    }


    @Override
    public AccuweatherHome searchCity(String city) {
        enterCityName(city);
        selectCityOnResultBar(city);
        return this;
    }

    private void enterCityName(String city) {
        browser.sendKeys(inputSearchBox, city);
    }

    private void selectCityOnResultBar(String city) {
        browser.waitUntil(ExpectedConditions.visibilityOfAllElements(cityListedSearchBar));
        for(WebElement element : cityListedSearchBar) {
            if(browser.readText(element).equals(city)){
                browser.click(element);
                break;
            }
        }
    }




}
