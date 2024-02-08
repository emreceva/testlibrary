package com.example.testlibrary.cucumber.steps;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.context.ScenarioRunContext;
import com.example.testlibrary.errors.ResultWarning;
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

        int factorialInt = Integer.parseInt(number);
        String expectedFactorialResult = factorialInt > 170 ?  "Infinite" : BigIntegerMath.factorial(Integer.parseInt(number)).toString();

        String actualNumber = homePage.getResultNumbers(3);
        String actualFactorialResult = homePage.getResultNumbers(5);

        if(actualFactorialResult.contains("e+")) {
            actualFactorialResult.replace(".", "").substring(16);
            expectedFactorialResult.substring(16);
        }

        Assertions.assertEquals(number,actualNumber);
        Assertions.assertEquals(expectedFactorialResult,actualFactorialResult);

    }

    @Then("Verify the factorial result should not be shown on the Home Page")
    public void verifyTheFactorialResultShouldNotBeShownOnTheHomePage() {
        Assertions.assertFalse(homePage.resultIsShown());
    }

    @Then("Verify the warning message in result on the Home Page")
    public void verifyTheWarningMessageInResultOnTheHomePage() {
        Assertions.assertEquals(ResultWarning.NON_DIGIT_ERROR.getError(), homePage.getWarningMessageForInput());
    }
}
