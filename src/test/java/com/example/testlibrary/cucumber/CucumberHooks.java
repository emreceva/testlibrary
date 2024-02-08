package com.example.testlibrary.cucumber;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.utils.browser.Browser;
import com.example.testlibrary.utils.browser.BrowserUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.logging.LogEntries;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CucumberHooks {
    @LazyAutowired
    private Browser browser;

    @Autowired
    private BrowserUtils browserUtils;

    @Autowired
    private ScenarioRunContext scenarioRunContext;


    @Before
    public void beforeScenario(Scenario scenario) {
        scenarioRunContext.setProperty(ScenarioRunContext.ContextProperties.Common.SCENARIO_NAME, scenario.getName());
        log.info(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        statusLog(scenario);
        browserScreenShot(scenario);
        browserConsoleLog(scenario);
        browser.quit();
    }

    private void browserScreenShot (Scenario scenario) {
        try {
            String screenShotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = browser.takeScreenShot();
            scenario.attach(sourcePath, "image/png", screenShotName);
        }catch (Exception e){
            log.error("Could not capture screenshot");
        }
    }

    private void browserConsoleLog(Scenario scenario) {
        try {
            LogEntries log = browser.getWebDriver().manage().logs().get("browser");
            log.iterator().forEachRemaining(it -> scenario.log(it.getMessage()));
        }catch (Exception exception) {
            log.error("Could not get browser console logs.");
        }
    }

    private void statusLog(Scenario scenario) {
        switch (scenario.getStatus()) {
            case PASSED -> log.info("SUCCESS [" + scenario.getName() + "]");
            case FAILED ->  log.info("FAILED [" + scenario.getName() + "]");
            case SKIPPED -> log.info("ABORTED [" + scenario.getName() + "]");
            case UNUSED -> log.info("DISABLED [" + scenario.getName() + "]");
        }
    }

}
