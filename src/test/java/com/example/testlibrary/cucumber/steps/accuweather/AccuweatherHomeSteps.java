package com.example.testlibrary.cucumber.steps.accuweather;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.data.City;
import com.example.testlibrary.pages.accuweather.AccuweatherHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;


public class AccuweatherHomeSteps {

    @LazyAutowired
    private AccuweatherHomePage homePage;

    @Autowired
    protected ScenarioRunContext scenarioRunContext;

    @Given("I go to Accuweather Home Page")
    public void iGoToAccuweatherHomePage() {
        homePage.goToHomePage();
        Assertions.assertTrue(homePage.isAt(), "Accuweather home page could be opened successfully");
    }


    @When("I search a city on the Accuweather Home Page")
    public void iSearchACity() {
        homePage.searchCity(City.ISTANBUL.getCity());
    }

}
