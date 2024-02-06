package com.example.testlibrary.cucumber;

import com.example.testlibrary.annotations.CucumberTest;
import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
@CucumberTest
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Smoke")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")
@SelectDirectories("/src/test/java/com/example/testlibrary/cucumber/features")
public class CucumberSuiteRun {
}
