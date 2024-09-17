package com.example.testlibrary.pages.sahibinden;


import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.interfaces.sahibinden.SahibindenSecurity;
import com.example.testlibrary.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@LazyComponent
public class SahibindenSecurityPage extends BasePage implements SahibindenSecurity {

    @FindBy(css = "input[type='checkbox']")
    private WebElement acceptSecurityCheckbox;

    @FindBy(xpath = "//iframe[starts-with(@id, 'cf-chl-widget')]")
    private WebElement iframe;

    @Override
    public boolean isAt() {
        return false;
    }

    @Override
    public SahibindenSecurityPage acceptSecurityCheckbox() {
        browser.getWebDriver().switchTo().alert();
        browser.getWebDriver().switchTo().alert().accept();
        getInIFrame();
        browser.click(acceptSecurityCheckbox);
        return this;
    }

    public SahibindenSecurityPage getInIFrame() {
        browser.waitUntil(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@id, 'cf-chl-widget')]")));
        return this;
    }
}
