package com.example.testlibrary.cucumber.steps;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.pages.HomePage;
import com.google.common.math.BigIntegerMath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

public class HomePageSteps {

    @LazyAutowired
    private HomePage homePage;

    @Autowired
    ScenarioRunContext scenarioRunContext;

    @Given("Go to Factorial Website")
    public void goToWebsite() {
        homePage.goToHomePage();
    }

    @When("Verify the factorial website is opened successfully")
    public void verifyTheFactorialWebsiteIsOpenedSuccessfully() {
        Assertions.assertTrue(homePage.isAt());
    }

    @And("I enter {string} as an input to textbox on the Home Page")
    public void iEnterAsAnInputToTextboxOnTheHomePage(String number) {
        scenarioRunContext.setProperty(ScenarioRunContext.ContextProperties.Result.FACTORIAL_NUMBER, number);
        homePage.enterNumber(number);
    }

    @And("I click calculate button on the Home Page")
    public void iClickCalculateButtonOnTheHomePage() {
        homePage.clickCalculateButton();
    }

    @Then("Verify the factorial result should be shown on the Home Page")
    public void verifyTheFactorialResultShouldBeShownOnTheHomePAge() {
        Assertions.assertTrue(homePage.resultIsShown());

        String number = scenarioRunContext.getProperty(ScenarioRunContext.ContextProperties.Result.FACTORIAL_NUMBER);
        String expectedResult = BigIntegerMath.factorial(Integer.parseInt(number)).toString();

        String actualNumber = homePage.getResultNumbers(0);
        String actualResult = homePage.getResultNumbers(1);

        Assertions.assertEquals(number,actualNumber);
        Assertions.assertEquals(expectedResult,actualResult);

    }
}
