package com.example.testlibrary.utils.browser;

import com.example.testlibrary.context.ScenarioRunContext;
import io.cucumber.java.bs.A;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class CapabilityUtils {

    @Value("${browser}")
    private String browserName;

    @Autowired
    private LoggingUtils loggingUtils;

    @Autowired
    private ScenarioRunContext scenarioRunContext;

    private DesiredCapabilities getDesiredCapabilities() {
       /*
        String scenarioName = scenarioRunContext.getProperty(ScenarioRunContext.ContextProperties.Common.SCENARIO_NAME);

        HashMap<String, Object> scenarioOptions = new HashMap<String, Object>();
        scenarioOptions.put("name", scenarioName);

        capabilities.setCapability("scenarioOptions", scenarioOptions);

        */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        return capabilities;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        // Create ChromeOptions
        options.addArguments("--remote-allow-origins=*")
                .addArguments("--no-sandbox")
                .addArguments("disable-infobars")
                .addArguments("--disable-extensions")
                .addArguments("--disable-gpu")
                .addArguments("--disable-dev-shm-usage");

        options.setCapability("acceptInsecureCerts", true);
        loggingUtils.setLoggingPrefs(options);

        return options.merge(getDesiredCapabilities());
    }

}
