package com.example.testlibrary.utils.browser;


import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmulationUtils {

    @Value("${emulator.mode}")
    private boolean isEmulatorMode;

    public ChromeOptions setMobileEmulation(ChromeOptions options) {
        if(isEmulatorMode) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceNAme", "iPhone SE");
            options.setExperimentalOption("mobileEmulation", mobileEmulation);
        }else {
            options.addArguments("window-size=1920,1080")
                    .addArguments("start-maximized");
        }
        return options;
    }
}
