package com.example.testlibrary.utils.browser;

import com.example.testlibrary.context.ScenarioRunContext;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class CapabilityUtils {

    @Value("${browser}")
    private String browserName;

    @Autowired
    private LoggingUtils loggingUtils;

    @Autowired
    private ScenarioRunContext scenarioRunContext;

    @Autowired
    private EmulationUtils emulationUtils;

    private DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        return capabilities;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*")
                .addArguments("--no-sandbox")
                .addArguments("disable-infobars")
                .addArguments("--disable-extensions")
                .addArguments("--disable-gpu")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("disable-popup-blocking");

        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));

        options.setCapability("acceptInsecureCerts", true);
        emulationUtils.setMobileEmulation(options);
        loggingUtils.setLoggingPrefs(options);

        return options.merge(getDesiredCapabilities());
    }

}
