package com.example.testlibrary.utils.browser;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Component
public class LoggingUtils {

    public ChromeOptions setLoggingPrefs(ChromeOptions options) {
        options.setCapability("goog:loggingPrefs", getLoggingPreferences());
        return options;
    }

    private LoggingPreferences getLoggingPreferences() {
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        loggingPreferences.enable(LogType.DRIVER, Level.ALL);

        return loggingPreferences;
    }
}
