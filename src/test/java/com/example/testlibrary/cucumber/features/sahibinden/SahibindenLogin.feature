Feature: Sahibinden Login

  Scenario: Login Test Username And Password Valid
    Given I go to Sahibinden Home Page
    And I click sign in button on the Sahibinden Home Page
    When I sign in with VALID_USER on the Sahibinden Login Page

  Scenario: Login Test Valid Username and Invalid Password
    Given I go to Sahibinden Home Page
    And I click sign in button on the Sahibinden Home Page
    When I sign in with USER1 on the Sahibinden Login Page

  Scenario: Login Test Invalid Username and Valid Password
    Given I go to Sahibinden Home Page
    And I click sign in button on the Sahibinden Home Page
    When I sign in with USER1 on the Sahibinden Login Page

  Scenario: Login Test Invalid Username and Invalid Password
    Given I go to Sahibinden Home Page
    And I click sign in button on the Sahibinden Home Page
    When I sign in with USER on the Sahibinden Login Page

