package com.example.testlibrary.utils.browser;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;


@Component
@Slf4j
public class BrowserUtils {

    @Value ("${browser}")
    private String  browser;

    @Value("${web.implicitlyWait.timeout}")
    private long implicitlyWaitTimeout;

    @Value("${web.pageLoad.Timeout}")
    private long pageLoadTimeout;

    @Value("${web.script.timeout}")
    private long scriptTimeout;

    @Value("${remote.mode}")
    private boolean isRemoteMode;

    @Value("${remote.driver}")
    private String remoteDriver;

    @Autowired
    private CapabilityUtils capabilityUtils;

    public synchronized Browser doCreateBrowser() {
        WebDriver driver = createDriver();
        setups(driver);
        return new BrowserImpl(driver);
    }

    private WebDriver createDriver() {
        return isRemoteMode ? createRemoteDriver() : createLocalDriver();
    }

    private WebDriver createRemoteDriver() {
        try {
            Assertions.assertTrue(StringUtils.isNoneBlank(remoteDriver));
            URL remoteUrl = URI.create(remoteDriver).toURL();

            return new RemoteWebDriver(remoteUrl, capabilityUtils.getChromeOptions(), false);
        }catch (MalformedURLException e) {
            log.error(e.getMessage());
        }
        throw new RuntimeException("Remote WebDriver Instance could not be created!");

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

    protected void setImplicitlyWaitTimeout(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(implicitlyWaitTimeout));
    }

    private WebDriver createLocalDriver() {
        return new ChromeDriver(capabilityUtils.getChromeOptions());
    }


}
