package com.example.testlibrary.utils.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;


@Component
public class BrowserUtils {

    @Value ("${browser}")
    private String  browser;

    @Value("${web.implicitlyWait.timeout}")
    private long implicitlyWaitTimeout;

    @Value("${web.pageLoad.Timeout}")
    private long pageLoadTimeout;

    @Value("${web.script.timeout}")
    private long scriptTimeout;

    @Autowired
    private CapabilityUtils capabilityUtils;

    public synchronized Browser doCreateBrowser() {
        WebDriver driver = createWebDriver();
        setups(driver);
        return new BrowserImpl(driver);
    }

    private void setups(WebDriver driver) {
        setTimeOuts(driver);
        setMaximizedWindow(driver);
    }

    protected void setMaximizedWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    protected void setTimeOuts(WebDriver driver) {
        setImplicitlyWaitTimeout(driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeout));
    }

    private void setImplicitlyWaitTimeout(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(implicitlyWaitTimeout));
    }

    private WebDriver createWebDriver() {
        return createLocalDriver();
    }

    private WebDriver createLocalDriver() {
        return new ChromeDriver(capabilityUtils.getChromeOptions());
    }


}
