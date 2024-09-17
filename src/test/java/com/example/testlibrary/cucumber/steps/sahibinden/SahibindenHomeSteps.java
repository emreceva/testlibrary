package com.example.testlibrary.cucumber.steps.sahibinden;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.enums.CategoryMenuItem;
import com.example.testlibrary.interfaces.sahibinden.SahibindenCategoryMenu;
import com.example.testlibrary.interfaces.sahibinden.SahibindenHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SahibindenHomeSteps {

    @LazyAutowired
    private SahibindenHome sahibindenHome;

    @LazyAutowired
    private SahibindenCategoryMenu sahibindenCategoryMenu;

    @Given("I go to Sahibinden Home Page")
    public void iGoToSahibindenHomePage() {
        sahibindenHome.goToHomePage();
        Assertions.assertTrue(sahibindenHome.isAt(), "Sahibinden home page could not be opened successfully.");
    }

    @Given("I click sign in button on the Sahibinden Home Page")
    public void iClickSignInButtonOnTheSahibindenHomePage() {
        sahibindenHome.clickSignInButton();
    }

    @Then("Verify the user login successfully on the Sahibinden Home Page")
    public void verifyTheUserLoginSuccessfully() {
        Assertions.assertTrue(sahibindenHome.verifyUserLogin(), "Sahibinden user could not be login successfully.");
    }

    @When("I click {categoryMenuItem} menu item on the Sahibinden Home Page")
    public void iClickMenuItemOnTheSahibindenHomePage(CategoryMenuItem categoryMenuItem) {
        sahibindenCategoryMenu.clickItemOnCategoryMenu(categoryMenuItem);
    }
}
