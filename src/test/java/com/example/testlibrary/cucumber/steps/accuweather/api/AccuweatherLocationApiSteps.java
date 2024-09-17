package com.example.testlibrary.cucumber.steps.accuweather.api;

import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.data.City;
import com.example.testlibrary.helper.LocationHelper;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.testlibrary.context.ScenarioRunContext.ContextProperties.City.CITY_KEY;

public class AccuweatherLocationApiSteps {

    @Autowired
    private LocationHelper locationHelper;

    @Autowired
    protected ScenarioRunContext runContext;


    @When("I get city location key from Accuweather Location Api Request")
    public void iGetCityLocationKeyRequest() {
        String cityKey = locationHelper.getLocationKey(City.ISTANBUL.getCity());
        runContext.setProperty(CITY_KEY, cityKey);
    }
}
