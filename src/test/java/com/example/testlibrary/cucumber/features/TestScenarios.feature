Feature: Home Page Component

  @Regression
  Scenario: Calculate Factorial Positive Number 1
    Given Go to Factorial Website
    And I enter "5" as an input to textbox on the Home Page
    And I click calculate button on the Home Page
    Then Verify the factorial result should be shown on the Home Page

  @Regression
  Scenario: Calculate Factorial Positive Number 2
    Given Go to Factorial Website
    And I enter "11" as an input to textbox on the Home Page
    And I click calculate button on the Home Page
    Then Verify the factorial result should be shown on the Home Page

  @Regression
  Scenario: Calculate Factorial Positive Number - Big Number
    Given Go to Factorial Website
    And I enter "100" as an input to textbox on the Home Page
    And I click calculate button on the Home Page
    Then Verify the factorial result should be shown on the Home Page

  @Regression
  Scenario: Calculate Factorial Zero
    Given Go to Factorial Website
    And I enter "0" as an input to textbox on the Home Page
    And I click calculate button on the Home Page
    Then Verify the factorial result should be shown on the Home Page


  @Regression
  Scenario: Calculate Factorial Negative
    Given Go to Factorial Website
    And I enter "-1" as an input to textbox on the Home Page
    And I click calculate button on the Home Page
    Then Verify the factorial result should not be shown on the Home Page

  @Regression
  Scenario: Calculate Factorial Non Digit
    Given Go to Factorial Website
    And I enter "Aaa" as an input to textbox on the Home Page
    And I click calculate button on the Home Page
    Then Verify the warning message in result on the Home Page

  @Regression
  Scenario: Calculate Factorial Infinite Number
    Given Go to Factorial Website
    And I enter "171" as an input to textbox on the Home Page
    And I click calculate button on the Home Page
    Then Verify the factorial result should be shown on the Home Page
