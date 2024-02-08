package com.example.testlibrary.pages;

import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.interfaces.Home;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;
import java.util.Arrays;
import java.util.List;

@LazyComponent
public class HomePage extends BasePage implements Home {

    @Value("${application.url}")
    private String baseUrl;

    @FindBy(css = "h1.margin-base-vertical.text-center")
    private WebElement title;

    @FindBy(id = "number")
    private WebElement inputTextbox;

    @FindBy(id = "getFactorial")
    private WebElement calculateButton;

    @FindBy(id = "resultDiv")
    private WebElement result;

    public HomePage goToHomePage() {
        browser.get(baseUrl);
        return this;
    }

    @Override
    public boolean isAt() {
        return browser.getTitle().equals("Factoriall") && browser.readText(title).equals("Factorial Calculator Extreme!");
    }

    @Override
    public HomePage enterNumber(String number) {
        browser.sendKeys(inputTextbox, number);
        return this;
    }

    @Override
    public HomePage clickCalculateButton() {
        browser.click(calculateButton);
        return this;
    }

    @Override
    public boolean resultIsShown() {
       browser.waitUntil(ExpectedConditions.visibilityOf(result));
       browser.sleep();
       return browser.isDisplayed(result) && browser.readText(result).contains("The factorial of");
    }

    @Override
    public String getWarningMessageForInput() {
        browser.waitUntil(ExpectedConditions.visibilityOf(result));
        return browser.readText(result);
    }

    public String getResultNumbers (int i) {
        browser.waitUntil(ExpectedConditions.visibilityOf(result));

        List<String> numbers = Arrays.stream(browser.readText(result).split(" ")).
                map(String::trim).toList();
        return numbers.get(i);
    }
}
