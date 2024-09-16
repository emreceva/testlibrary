package com.example.testlibrary.cucumber.steps.sahibinden;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.interfaces.sahibinden.SahibindenHome;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

public class SahibindenHomeSteps {

    @LazyAutowired
    private SahibindenHome sahibindenHome;

    @Given("I go to Sahibinden Home Page")
    public void iGoToSahibindenHomePage() {
        sahibindenHome.goToHomePage();
        Assertions.assertTrue(sahibindenHome.isAt(), "Sahibinden home page could not be opened successfully.");
    }

    @Given("I click sign in button on the Sahibinden Home Page")
    public void iClickSignInButtonOnTheSahibindenHomePage() {
        sahibindenHome.clickSignInButton();
    }
}
