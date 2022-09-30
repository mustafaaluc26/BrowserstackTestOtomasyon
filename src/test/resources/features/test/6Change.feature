Feature: Change reservation scenarios
  Background:
    When the user changes language "TR"

  @smokeYLC  @change
  Scenario: User should be able to get refund after reservation change
    Given User goes to non-canceled order on atlantis page
    When User changes the reservation detail and selects less price vehicle
    Then reservation details should be changed and payment should be revised

    #needs to try automating console in payment page
  Scenario: User should be able to pay price difference after reservation change
    Given User goes to non-canceled order on atlantis page
    When User changes the reservation detail and selects higher price vehicle
    Then reservation details should be changed and payment should be revised