package com.example.testlibrary.cucumber;

import com.example.testlibrary.annotations.CucumberTest;
import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;

@Suite
@CucumberTest
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@Regression")
@SelectDirectories("src/test/java/com/example/testlibrary/cucumber/features")
public class CucumberSuiteRun {
}
