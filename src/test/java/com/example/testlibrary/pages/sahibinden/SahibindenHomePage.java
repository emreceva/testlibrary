package com.example.testlibrary.pages.sahibinden;

import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.interfaces.sahibinden.SahibindenHome;
import com.example.testlibrary.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;


@LazyComponent
public class SahibindenHomePage extends BasePage implements SahibindenHome {

    @Value("${web.sahibinden.base.url}")
    private String baseUrl;

    @FindBy(xpath = "//a[@class = 'logo']")
    private WebElement headerLogo;

    @FindBy(id = "secure-login")
    private WebElement signInButton;

    public SahibindenHome goToHomePage() {
        browser.get(baseUrl);
        return this;
    }

    @Override
    public SahibindenHome clickSignInButton() {
        browser.click(signInButton);
        return this;
    }


    @Override
    public boolean isAt() {
        return browser.getWebDriver().getTitle().contains("Türkiye'nin Online İlan ve Alışveriş Sitesi") && browser.isDisplayed(headerLogo);
    }


}
