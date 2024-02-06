Feature: Home Page Component

  @TestCase-1
  Scenario: Calculate Factorial
    Given Go to Factorial Website
    When Verify the factorial website is opened successfully
    And I enter "5" as an input to textbox on the Home Page
    And I click calculate button on the Home Page
    Then Verify the factorial result should be shown on the Home Page

  @TestCase-2
  Scenario: Calculate Factorial Zero
    Given Go to Factorial Website
    When Verify the factorial website is opened successfully
    And I enter "0" as an input to textbox on the Home Page
    And I click calculate button on the Home Page
    Then Verify the factorial result should be shown on the Home Page


  @TestCase-3
  Scenario: Calculate Factorial Negative
    Given Go to Factorial Website
    When Verify the factorial website is opened successfully
    And I enter "-1" as an input to textbox on the Home Page
    And I click calculate button on the Home Page
    Then Verify the factorial result should be shown on the Home Page