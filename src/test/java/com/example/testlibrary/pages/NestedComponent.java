package com.example.testlibrary.pages;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.utils.browser.Browser;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.manager.util.SessionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

public abstract class NestedComponent {

    @LazyAutowired
    protected Browser browser;
    private SearchContext searchContext;
    @Getter
    @Setter
    private boolean isContextADriver;
    protected static boolean isEmulatorMode;
    protected static ApplicationContext applicationContext;
    protected static ScenarioRunContext scenarioRunContext;
    public void setSearchContext(SearchContext searchContext) {
        this.searchContext = searchContext;
    }
    public SearchContext getSearchContext() {
        return searchContext;
    }
    protected Browser getBrowser() {
        return applicationContext.getBean(Browser.class);
    }
    protected SessionUtils getSessionUtils() {
        return applicationContext.getBean(SessionUtils.class);
    }
    public WebElement findElement(By by) {
        return getBrowser().findElement(getSearchContext(), by);
    }
    public List<WebElement> findElements(By by) {
        return getBrowser().findElements(getSearchContext(), by);
    }
    public boolean isAt() {
        return getBrowser().isDisplayed(getSearchContext());
    }
    @Component
    private static class ApplicationContextInject {
        @Autowired
        private ApplicationContext applicationContext;
        @Autowired
        private ScenarioRunContext scenarioRunContext;
        @Value("${emulator.mode}")
        private boolean isEmulatorMode;
        @PostConstruct
        private void init() {
            NestedComponent.isEmulatorMode = this.isEmulatorMode;
            NestedComponent.applicationContext = this.applicationContext;
            NestedComponent.scenarioRunContext = this.scenarioRunContext;
        }
    }
}
