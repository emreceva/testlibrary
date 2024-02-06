package com.example.testlibrary.pages;

import com.example.testlibrary.annotations.LazyComponent;
import com.example.testlibrary.interfaces.Home;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
       return browser.isDisplayed(result) && browser.readText(result).contains("The factorial of");
    }

    public String getResultNumbers (int i) {
        browser.waitUntil(ExpectedConditions.visibilityOf(result));
        List<Integer> numbers = Arrays.stream(browser.readText(result).split(" ")).
                map(String::trim).
                filter(d-> d.matches("\\d+")).
                map(Integer::parseInt)
                .collect(Collectors.toList());

        return numbers.get(i).toString();
    }
}
