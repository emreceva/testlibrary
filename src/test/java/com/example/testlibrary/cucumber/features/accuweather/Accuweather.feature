Feature: Accuweather

  Scenario: Comparison Current Temperature Ui And Api
    Given I get city location key from Accuweather Location Api Request
    And I get city current temperature from Accuweather Current Conditions Api Request
    Given I go to Accuweather Home Page
    And I search a city on the Accuweather Home Page
    Then Verify the UI and API temperature info should be matched

