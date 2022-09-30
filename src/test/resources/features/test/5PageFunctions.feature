  @smokeYLC @reservation
Feature: Main page Functions
  Background:
   When the user changes language "TR"

    # WEB-001
  Scenario: Main functions should be available/usable
    When click the monthly rental
    Then monthly rental function should be available
    When click the daily rental
    Then daily rental function should be available
    When enter word to pick-up information box
    Then location list should be available
    When select location from location list
    Then calender should be opened
    When select date and time from calendar
    Then dates should be selected
    When click the different drop off location checkbox
    Then drop-off information box should be available
    When enter word to drop-off information box
    Then drop-off location list should be available
    When select location from drop-off location list
    Then location should be selected

     #WEB-002
  Scenario: Header functions should be available/usable
    When click the currency selector
    Then currency selector dropdown should be opened
    When click the language
    Then language dropdown should be opened
    When check the call center
    Then call center number and text should be correct
    When click the popular locations
    Then popular locations dropdown should be opened
    When click the find reservation
    Then find reservation page should be opened
    When click the campaigns on header bar
    Then campaigns page should be opened

      #WEB-066  #YLC-1672
    Scenario: Yolcu360 Partner tab which on header should be not seen when page language change to EN
      Given "Yolcu360 Partner" tab should be seen on header
       When the user changes language "EN"
       Then "Yolcu360 Partner" tab should be not seen on header
       When the user changes language "DE"
       Then "Yolcu360 Partner" tab should be not seen on header
       When the user changes language "TR"
       Then "Yolcu360 Partner" tab should be seen on header

       #WEB-080  #YLC-386
    Scenario: User should be see social media links on footer web page
      Given the user is on the landing pages
      Then the user should be able to see social media links








