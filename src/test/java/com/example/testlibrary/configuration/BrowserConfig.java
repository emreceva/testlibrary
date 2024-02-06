package com.example.testlibrary.configuration;

import com.example.testlibrary.annotations.BrowserBean;
import com.example.testlibrary.annotations.LazyConfiguration;
import com.example.testlibrary.utils.browser.Browser;
import com.example.testlibrary.utils.browser.BrowserUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Primary;

@LazyConfiguration
public class BrowserConfig {

    @BrowserBean
    @ConditionalOnMissingBean
    @Primary
    public Browser browser(BrowserUtils browserUtils) {
        return browserUtils.doCreateBrowser();
    }

}
