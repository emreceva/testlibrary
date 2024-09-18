package com.example.testlibrary.utils.browser;


import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public interface Browser {

    boolean browserHasQuit();

    <T> void click(T elementAttr);

    WebDriver getWebDriver();

    void get(String baseUrl);

    String getTitle();

    <T> boolean isDisplayed(T element);

    <T> String readText(T elementAttr);

    <T> void sendKeys(T elementAttr, String text);

    void sleep(long millis);

    void sleep();

    void quit();

    void waitUrlToBe(String urlToBe);

    <T> T waitUntil(ExpectedCondition<T> expectedCondition);

    <T> T waitUntilFast(ExpectedCondition<T> expectedCondition);

    byte[] takeScreenShot();

    WebElement findElement(SearchContext context, By by);

    List<WebElement> findElements(SearchContext context, By by);

    Object executeScript(String script, Object... args);

}
