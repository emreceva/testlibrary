package com.example.testlibrary.cucumber;

import com.example.testlibrary.annotations.CucumberTest;
import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

@Suite
@CucumberTest
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
@SelectDirectories("/src/test/java/com/example/testlibrary/cucumber/features")
public class CucumberSuiteRun {
}
