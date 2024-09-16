package com.example.testlibrary.pages.sahibinden;

import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.data.UserType;
import com.example.testlibrary.interfaces.sahibinden.SahibindenLogin;
import com.example.testlibrary.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@LazyComponent
public class SahibindenLoginPage extends BasePage implements SahibindenLogin {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "userLoginSubmitButton")
    private WebElement submitButton;


    @Override
    public boolean isAt() {
        return false;
    }

    @Override
    public SahibindenLogin signIn(String username, String password) {
        browser.sendKeys(this.username, username);
        browser.sendKeys(this.password, password);
        browser.click(submitButton);
        return this;
    }
}
