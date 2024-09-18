package com.example.testlibrary.pages;


import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.utils.browser.Browser;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class BasePage {

    @Value("${web.implicitlyWait.timeout}")
    private long implicitlyWaitTimeout;

    @LazyAutowired
    protected Browser browser;

    @Autowired
    protected ScenarioRunContext scenarioRunContext;

    @PostConstruct
    private void init() {
        PageFactory.initElements(browser.getWebDriver(), this);
    }

    public abstract boolean isAt();

    public void switchNextPage() {
        Set<String> allWindows = browser.getWebDriver().getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(allWindows);

        String currentWindow = browser.getWebDriver().getWindowHandle();
        int currentWindowIndex = windowHandlesList.indexOf(currentWindow);

        browser.getWebDriver().switchTo().window(windowHandlesList.get(currentWindowIndex+1));

    }
}
