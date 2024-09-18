package com.example.testlibrary.utils.browser;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Value;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BrowserImpl implements Browser{

    private WebDriver driver;

    private Wait<WebDriver> wait;

    private final JavascriptExecutor javascriptExecutor;

    @Value("${web.wait.timeout}")
    private int waitTimeOut;

    public BrowserImpl(WebDriver driver) {
        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }

    @PostConstruct
    private void init() {
        setDefaultWait();
    }

    private void setDefaultWait() {
        this.wait = new FluentWait<>(driver).withTimeout(Duration.ofMillis(waitTimeOut))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchFieldException.class, StaleElementReferenceException.class);
    }


    @Override
    public boolean browserHasQuit() {
        return Objects.isNull(((RemoteWebDriver) driver).getSessionId());
    }

    @Override
    public <T> void click(T elementAttr) {
        WebElement element;
        if(elementAttr instanceof By) {
            element = driver.findElement((By) elementAttr);
        }else {
            element = (WebElement) elementAttr;
        }
        element.click();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @Override
    public void quit() {
        try {
            driver.quit();
        }catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }

    @Override
    public void get(String url) {
        driver.get(url);
        waitUrlToBe(url);
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    public void waitUrlToBe(String urlToBe) {
        waitUntil(ExpectedConditions.urlToBe(urlToBe));
    }

    @Override
    public <T> T waitUntil(ExpectedCondition<T> expectedCondition) {
        return wait.until(expectedCondition);
    }

    @Override
    public <T> T waitUntilFast(ExpectedCondition<T> expectedCondition) {
        var savedWait = wait;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(waitTimeOut))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchFieldException.class);
        T returnValue = wait.until(expectedCondition);
        wait = savedWait;
        return returnValue;
    }

    @Override
    public byte[] takeScreenShot() {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Number ratio = (Number) jsExecutor.executeScript("return window.devicePixelRatio;");
        log.info("Device Pixel Ratio: " + ratio);

        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(1000,0,0, ratio.floatValue())).takeScreenshot(driver);
        ByteArrayOutputStream byt = new ByteArrayOutputStream();

        try {
            ImageIO.write(screenshot.getImage(), "png", byt);
        }catch (IOException exception) {
            log.info(exception.getMessage());
        }
        return byt.toByteArray();
    }

    @Override
    public WebElement findElement(SearchContext context, By by) {
        return context.findElement(by);
    }

    @Override
    public List<WebElement> findElements(SearchContext context, By by) {
        return context.findElements(by);
    }

    @Override
    public Object executeScript(String script, Object... args) {
        Object obj = null;

        try {
            obj = javascriptExecutor.executeScript(script, args);
        }catch (Exception e) {
            log.error(e.getMessage());
        }

        return obj;
    }

    @Override
    public <T> boolean isDisplayed(T elementAttr) {
        WebElement element;
        if(elementAttr instanceof By) {
            element = driver.findElement((By) elementAttr);
        } else {
            element = (WebElement) elementAttr;
        }
        return element.isDisplayed();
    }

    @Override
    public <T> String readText(T elementAttr) {
        if(elementAttr.getClass()
                .getName()
                .contains("By")) {
            return driver.findElement((By) elementAttr)
                    .getText();
        }else {
            return ((WebElement) elementAttr).getText();
        }
    }

    @Override
    public <T> void sendKeys(T elementAttr, String text) {
        if(elementAttr instanceof By) {
            driver.findElement((By) elementAttr)
                    .sendKeys(text);
        }else {
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    @Override
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void sleep() {
        sleep(TimeUnit.SECONDS.toMillis(1));
    }

}
