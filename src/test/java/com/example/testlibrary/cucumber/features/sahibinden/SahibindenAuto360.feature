Feature: Oto360

  @Test
  Scenario: Sahibinden Auto 360 With Selling
    Given I go to Sahibinden Home Page
    And I click "OTO360" menu item on the Sahibinden Home Page
    When I click "SATARKEN" menu item from "ARAC_DEGERLEME" on the Sahibinden Auto360 Page
    And Verify that the Vehicle Evaluation Page is opened successfully
    And I click the vehicle evaluation button on the Sahibinden Vehicle Evaluation Page
    And I select "CITROEN_C3" for the vehicle type selection container on the Sahibinden Vehicle Evaluation Page
    And I click evaluate another vehicle button on the Sahibinden Vehicle Evaluation Page
    Then Verify that the another vehicles are listed on the Sahibinden List Page
    And Verify that the "EN_DUSUK_FIYAT" filter function is working successfully on the Sahibinden List Page