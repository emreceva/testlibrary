package com.example.testlibrary.cucumber.steps.accuweather;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.interfaces.accuweather.AccuweatherForecast;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class AccuweatherForecastSteps {

    @LazyAutowired
    private AccuweatherForecast accuweatherForecast;

    @Autowired
    protected ScenarioRunContext runContext;

    @Then("Verify the UI and API temperature info should be matched")
    public void verifyTheUIAndAPITemperatureInfoShouldBeMatched() {
        Assertions.assertTrue(accuweatherForecast.isAt(), "Accuweather forecast page could not be opened successfully.");
        String uiCurrentTemp = accuweatherForecast.getCurrentTemp();
        String apiCurrentTemp = runContext.getProperty(ScenarioRunContext.ContextProperties.API.CURRENT_TEMPERATURE);
        Assertions.assertEquals(uiCurrentTemp, apiCurrentTemp, "Ui current temperature and api current temperature is not match.");
    }
}
