package com.example.testlibrary.cucumber.steps.sahibinden;

import com.example.testlibrary.interfaces.sahibinden.SahibindenSecurity;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class SahibindenSecuritySteps {
    @Autowired
    private SahibindenSecurity sahibindenSecurity;

    @And("I accept you are a human on the Security Page")
    public void verifyYouAreAHumanOnTheSecurityPage() {
        sahibindenSecurity.acceptSecurityCheckbox();
    }
}
