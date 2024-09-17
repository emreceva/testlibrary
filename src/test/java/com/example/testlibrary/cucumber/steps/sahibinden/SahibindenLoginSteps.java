package com.example.testlibrary.cucumber.steps.sahibinden;

import com.example.testlibrary.annotations.LazyAutowired;
import com.example.testlibrary.data.User;
import com.example.testlibrary.data.UserType;
import com.example.testlibrary.interfaces.sahibinden.SahibindenLogin;
import io.cucumber.java.en.When;

public class SahibindenLoginSteps {

    @LazyAutowired
    private SahibindenLogin sahibindenLogin;

    @When("I sign in with {userType} on the Sahibinden Login Page")
    public void iSignIn(UserType userType) {
        User user = userType.getInfo();
        String username = user.getUsername();
        String password = user.getPassword();
        sahibindenLogin.signIn(username, password);
    }

    @When("I sign in with {string} and {string} on the Sahibinden Login Page")
    public void iSignInWithParameters(String username, String password) {
        sahibindenLogin.signIn(username, password);
    }
}
