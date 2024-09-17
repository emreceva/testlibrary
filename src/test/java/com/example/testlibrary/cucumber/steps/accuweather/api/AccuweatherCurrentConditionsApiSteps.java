package com.example.testlibrary.cucumber.steps.accuweather.api;

import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.helper.CurrentConditionsHelper;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.testlibrary.context.ScenarioRunContext.ContextProperties.Accuweather.CURRENT_TEMPERATURE;
import static com.example.testlibrary.context.ScenarioRunContext.ContextProperties.City.CITY_KEY;

public class AccuweatherCurrentConditionsApiSteps {

    @Autowired
    private CurrentConditionsHelper currentConditionsHelper;

    @Autowired
    protected ScenarioRunContext runContext;


    @When("I get city current temperature from Accuweather Current Conditions Api Request")
    public void iGetCityCurrentTemperature() {
        String cityKey = runContext.getProperty(CITY_KEY);
        String currentTemperature = currentConditionsHelper.getCurrentWeather(cityKey);
        currentTemperature = String.valueOf(Math.ceil(Double.parseDouble(currentTemperature)));
        currentTemperature = currentTemperature.split("\\.")[0];
        runContext.setProperty(CURRENT_TEMPERATURE, currentTemperature);
    }

}
