@reservation  @smokeYLC
Feature: Vehicle Listing & Reservation
  Background:
    When the user changes language "TR"
#    When the user changes currency "try"

   @res @test  #Postman properties
  Scenario: Postman key
    Given Postman get payment type

  @page @res   #WEB-037
  Scenario: Yolcu test vendor should be active
    Given The user goes to Atlantis and log in
    When click "Vendor configurations"
    Then Vendor Configurations page should be open
    When click page 2
    And The user click "Yolcutest"
    Then Check the vendor status active or not active

      #WEB-009
  Scenario: User should be able to make daily rental search
    Given the user is on the daily rental
    When search "saw"
    And select date and time from calendar
    And click find button
    Then the user should be able to see vehicle listing

   @res @test #WEB-013.3
  Scenario: Registered user should be able to make daily rental reservation and check reservation no
    Given the user is on the login dropdown
    When the user enter valid credentials
    And search "saw"
    And select date and time from calendar
    And click find button
    And select vendor and car
    And click continuous button
    And enter driver information
    And click continuous button
    And enter payment method
    And click pay button
    And send sms key
    Then the user should be able to make reservation
    When save reservation no on reservation detail page
    When click yolcu360 logo
    Then verify find button seen main page
    And verify "Lütfen bir alış yeri seçin" message
    And verify open main page
    When click account button
    And click past reservations
    Then verify past reservations number in my account page

  @page #WEB-010
  Scenario: User should be able to make monthly rental search
    Given the user is on the monthly rental
    When search "saw"
    And select month date and time from calendar
    And click find button
    Then the user should be able to see vehicle listing

  @page  #WEB-011
  Scenario: User should be able to make default daily rental search
    Given the user is on the daily rental
    When search "saw"
    And click find button
    Then the user should be able to see default daily search

  @page  #WEB-012
  Scenario: User should be able to make default monthly rental search
    Given the user is on the monthly rental
    When search "saw"
    And click find button
    Then the user should be able to see default monthly search

  @res @test #WEB-013.1
  Scenario: User should be able to make daily rental reservation
   Given the user is on the daily rental
    When search "saw"
    And select date and time from calendar
    And click find button
    And select vendor and car
    And click continuous button
    And enter driver information
    And click continuous button
    And enter payment method
    And click pay button
    And send sms key
    Then the user should be able to make reservation

  @res @test #WEB-013.2
  Scenario: Registered user should be able to make monthly rental reservation
    Given registered user is on the monthly rental
    When search "saw"
    And select month date and time from calendar
    And click find button
    And select vendor and car
    And click continuous button
    And enter driver information
    And click continuous button
    And enter payment method
    And click pay button
    And send sms key
    Then the user should be able to make reservation

  @page  #WEB-014.1
  Scenario Outline: User should be able to search his reservation
    Given the user is on the find reservation box
    When the user enters "<reservation no>" and "<email>"
    Then the user should be able to match "<reservation no>" and "<email>" on reservation detail page
    Examples:
      | reservation no | email              |
      | R_A1ZV         | caner@yolcu360.com |
      | R_BQJI         | busra@yolcu360.com |

  @page   #WEB-014.2
  Scenario Outline: User should not able to search his reservation
    Given the user is on the find reservation box
    When the user enters "<reservation no>" and "<email>"
    Then verify user can not past reservation
    Examples:
      | reservation no | email              |
      |                | caner@yolcu360.com |
      | R_BQAA         | busra@yolcu360.com |

  @page  #WEB-026
  Scenario Outline: Vehicle listing page functions should be seen and enabled
    Given search "<first place>"
    When click find button
    And enter different drop location "<second place>"
    And select date and time from calendar
    And click find button inside reservation page
    Then verify promo code is working
    When click cancel campaign code Window
    Then Reservation time should be seen
    Then the functions should be enabled and information should be matched with search details
    And verify "<first place>" and "<second place>" search location
    Examples:
      | first place | second place |
      | sabiha      | esenboga     |

  @page #WEB-027
  Scenario: Vehicle detail page functions should be seen and enabled
    Given search "ayt"
    When select forward date and time from calendar
    And click find button
    And the user uses sorting criteria then vehicle listing can sorted
    When select "724" and car for review
    Then the user verify price and office type
    And the user verify car model and price
    And  the user verify rental conditions
    And the user verify driver requirements
    And the user verify reviews
    And the user checks and uses the functions of the detail page

  @page #WEB-028
  Scenario: Driver information page functions should be seen and enabled
    Given search "saw"
    When select date and time from calendar
    And click find button
    And select vendor and car
    And the user is on the driver information page
    And the user checks the functions and enters driver information
    Then the functions should be enabled and information should be entered to input boxes

  #WEB-029
  Scenario: Payment information page functions should be seen and enabled
    Given search "saw"
    When select date and time from calendar
    And click find button
    And select vendor and car
    And click continuous button
    And enter driver information
    And click continuous button
    And enter payment method
    Then input boxes should be enabled and driver&invoice information should be matched

  @page  #WEB-030
  Scenario: Vehicle search should be done from rent a car URL
    Given the user is on the rent a car url
    When search "saw"
    And click find button
    Then the user should be able to see default daily search

  @res #WEB-033.1
  Scenario: Extra Products & Assurances must be added to the office amount for daily reservation
    Given search "saw"
    When select date and time from calendar
    And click find button
    And select vendor and car
    And add extra Products & Assurances
    Then verify price on driver information page &Vehicle Selection
    When click continuous button
    And enter driver information
    Then verify price on driver information page &Vehicle Selection
    When click continuous button
    Then verify price on driver information page &Vehicle Selection
    And enter payment method
    Then input boxes should be enabled and driver&invoice information should be matched
    When click pay button
    And send sms key
    Then verify price on reservation summary page

  @res  #WEB-033.2
  Scenario: Extra Products & Assurances must be added to the office amount for monthly reservation
    Given the user is on the monthly rental
    When search "saw"
    And select month date and time from calendar
    And click find button
    And select vendor and car
    And add extra Products & Assurances
    Then verify price on driver information page &Vehicle Selection
    When click continuous button
    And enter driver information
    Then verify price on driver information page &Vehicle Selection
    When click continuous button
    Then verify price on driver information page &Vehicle Selection
    And enter payment method
    Then input boxes should be enabled and driver&invoice information should be matched
    When click pay button
    And send sms key
    Then verify price on reservation summary page

  @res  #WEB-034 #YLC-2889
  Scenario:From checkout page Come back and choose more expensive vehicle total price should change
    Given search "saw"
    When select date and time from calendar
    And click find button
    And sort by "En Düşük Fiyat"
    And select vendor and car
    Then verify price on driver information page &Vehicle Selection
    When click continuous button
    And enter driver information
    Then verify price on driver information page &Vehicle Selection
    When click continuous button
    Then verify price on driver information page &Vehicle Selection
    And enter payment method
    Then input boxes should be enabled and driver&invoice information should be matched
    And click back to previous page
    And click back to previous page
    And click back to previous page
    And sort by "En Yüksek Fiyat"
    And Select vehicle in row "1"
    Then verify price on driver information page &Vehicle Selection
    When click continuous button
    Then verify price on driver information page &Vehicle Selection
    When click continuous button
    Then verify price on driver information page &Vehicle Selection
    And enter payment method
    Then input boxes should be enabled and driver&invoice information should be matched
    When click pay button
    And send sms key
    Then verify price on reservation summary page

 #WEB-035
  Scenario: The user should not make a daily rental reservation without accepting the membership agreement.
    Given the user is on the daily rental
    When search "saw"
    And select date and time from calendar
    And click find button
    And select vendor and car
    And click continuous button
    And click continuous button
    Then Users should see "Lütfen kutuyu işaretleyiniz."
    When enter "valid" driver information without check box
    And click continuous button
    Then Users should see "Lütfen kutuyu işaretleyiniz."
    When click KVKK check box on driver information
    And click continuous button


  @page   #WEB-036
  Scenario: The invalid user should not make a daily rental reservation
    Given the user is on the daily rental
    When search "saw"
    And select date and time from calendar
    And click find button
    And select vendor and car
    And click continuous button
    When enter "invalid" driver information
    And click continuous button
    Then Users should see error exclamation mark

  @page  #WEB-042
  Scenario Outline: The user should select different drop location and check different location price on car details
    Given search "<first place>"
    When click find button
    And enter different drop location "<second place>"
    And select date and time from calendar
    When click find button inside reservation page
    Then verify "<first place>" and "<second place>" search location
    When select "Yolcutest" vendor
    Then check different price on first car detail
    And click rentNowButton
    Then check different price list page and car details page
    Examples:
      | first place | second place |
      | sabiha      | esenboga     |

  @page  #WEB-045  #YLC-1584
  Scenario Outline: User should be able to view vehicle listing from landing pages with different date
    Given the user is on the landing pages
    When the user goes the "<location1>" landing page
    Then verify "<location1>" search page open
    When click find button
    And click start date
    And select forward date and time from calendar
    Then click find button inside reservation page
    Given the user is on the landing pages
    When the user goes the "<location2>" landing page
    Then verify "<Verify location>" search page open
    When click find button
    And click start date
    And select forward date and time from calendar
    Then click find button inside reservation page
    And Select vehicle in row "1"
    Examples:
      | location1                                | location2              | Verify location               |
      | Ankara Esenboğa Havalimanı Araç Kiralama | İstanbul Araç Kiralama | İstanbul Araç Kiralama        |

  @page  #WEB-046  #YLC-1512
  Scenario: User should be able to see selected filter in URL after back from detail page to listing page
    Given the user is on the daily rental
    When search "saw"
    And click find button
    When select "Yolcutest" vendor
    And select transmission filter
    And saved current URL
    And Select vehicle in row "1"
    And click back to previous page
    Then URL should be contains selected filter options

  @page  #WEB-047
  Scenario Outline: When user cancel the different location after searching in a different location, you should search again and the url should change.
    Given search "<first place>"
    When click find button
    And enter different drop location "<second place>"
    And select date and time from calendar
    And click find button inside reservation page
    Then verify "<first place>" and "<second place>" search location
    When save first url
    And cancel different location click X button
    And wait until car image animation on vehicle page
    And save second url
    Then url should "not be equal"
    And enter different drop location "<third place>"
    And click find button inside reservation page
    Then verify "<first place>" and "<third place>" search location
    Examples:
      | first place | second place | third place |
      | sabiha      | esenboga     |  izmir      |

  @page  #WEB-048
  Scenario: The user must give up Drop-Off Information by clicking the X button.
    Given search "sabiha"
    When click the different drop off location checkbox
    And enter different drop location "esenboga" on main page
    And cancel different location click X button
    When click find button
    Then url contains "sabiha"
    Then url must not contain "esenboga"

  @page  #WEB-049  #YLC-1515
  Scenario: The user should receive a warning text in cases Where the vehicle is not found
    When search "Aü Sivil Havacılık"
    And click only find button
    Then Users should see warning text when the vehicle is not be found

  @page   #WEB-050 #YLC-1423
  Scenario: The user should be search only put start date
    Given the user is on the daily rental
    When search "saw"
    And select start date
    And click empty 930 X and 330 Y coordinate
  #  And click empty field
    When click find button
    Then the user should be able to see default daily search

  @page  #WEB-051  #YLC-1451
  Scenario: The user should be able to search after click pick-up box button(firstly pick-up box is must be entered location) on LandingPage
    Given the user is on the landing pages
    When the user goes the "Bursa Araç Kiralama" landing page
    And click pick-up box
    And click the different drop off location checkbox
    And enter different drop location "saw" on main page
    And click different drop off location box
    And select forward date and time from calendar
    Then click find button

  @page  #WEB-052  #YLC-1451
  Scenario: The user should be able to search after click pick-up box button(firstly pick-up box is must be entered location) on homepage
    Given the user is on the daily rental
    When search "esenboga"
    And click pick-up box
    And click the different drop off location checkbox
    And enter different drop location "sabiha" on main page
    And click different drop off location box
    Then click find button

  @res #WEB-053  #YLC-3669
  Scenario: User can be change language on main page, car detail page, reservation summary page
    Given user select language and verify on main page
      |TR|
      |EN|
      |DE|
      |TR|
    When search "saw"
    And select date and time from calendar
    And click find button
    And select vendor and car
    And user select language and verify on car detail page
      |TR|
      |EN|
      |DE|
      |TR|
    And click continuous button
    And enter driver information
    And click continuous button
    And enter payment method
    And click pay button
    And send sms key
    Then the user should be able to make reservation
    And user select language and verify on reservation summary page
      |TR|
      |EN|
      |DE|

  @page    #WEB-055  #YLC-1436
  Scenario: The user who wants to leave the vehicle in a different place should go to the Vehicle detail page and see the drop location on the listing page when returns
    Given search "saw"
    When click find button
    And enter different drop location "esenboga"
    And select date and time from calendar
    And click find button inside reservation page
    And save first url
    And Select vehicle in row "1"
    And click back to previous page
    And save second url
    Then url should "equal"
    And verify drop off box "Esenboğa" location

  @page   #WEB-061   #YLC-1421
  Scenario: User should be able to see sorted parameter on url
    Given search "saw"
    When click find button
    And the user uses sorting criteria then url should change

  @page    #WEB-062 YLC-1358
  Scenario: The user can search vehicle by selecting a different drop off location in the Landing Page
    Given the user is on the landing pages
    When the user goes the "İstanbul Sabiha Gökçen Havalimanı Araç Kiralama" landing page
    Then verify "İstanbul Sabiha Gökçen Havalimanı Araç Kiralama" search page open
    And click the different drop off location checkbox
    And enter different drop location "izmir"
    When click find button
    Then verify "sabiha" and "izmir" search location
    And click pickUp icon
    Then the user should be able to see default daily search

  @page   #WEB-063 #YLC-1443
  Scenario: User should be able to back from vehicle driver information page
    Given search "saw"
    When click find button
    Then the user should be able to see vehicle listing
    And Select vehicle in row "1"
    Then verify user on detail page
    And click continuous button
    Then Verify driver information page open
    And click back button
    Then verify user on detail page
    And click back button
    Then the user should be able to see vehicle listing

   @res   #WEB-074 #YLC-91
  Scenario: User should be able to see delivery type detail when hover delivery type on list, vehicle detail and reservation confirm page
    Given the user is on the daily rental
    When search "saw"
    And select date and time from calendar
    And click find button
    When User hover "Aracı nasıl teslim alacağım?" on vehicle detail
    Then User should see detail delivery type
    And select vendor and car
    When User hover "Aracı nasıl teslim alacağım?" on vehicle detail
    Then User should see detail delivery type
    And click continuous button
    And enter driver information
    And click continuous button
    And enter payment method
    And click pay button
    And send sms key
    Then the user should be able to make reservation
    When User hover "Aracı nasıl teslim alacağım?" on vehicle detail
    Then User should see detail delivery type

  @res #WEB-077  #YLC-1710
  Scenario Outline: User should be able to make daily rental reservation with Different Location
    Given search "<first place>"
    When click the different drop off location checkbox
    And enter different drop location "<second place>" on main page
    And select date and time from calendar
    And click find button
    #Then the user should be able to see vehicle listing
    Then verify "<first place>" and "<second place>" search location
    And select vendor and car
    And click continuous button
    And enter driver information
    And click continuous button
    And enter payment method
    Then User should be see green check icon for card number and Card owner name
    And select 3 installments
    And click pay button
    And send sms key
    Then the user should be able to make reservation
    Then the user should be able to see Rezervasyon No and Rezervasyon Numarası
    Examples:
      | first place | second place |
      | sabiha      | esenboga     |

     #WEB-079 #YLC-1335
  Scenario: If user enter invalid card number
    Given the user is on the daily rental
    When search "saw"
    And click find button
    And select vendor and car
    And click continuous button
    And enter driver information
    And click continuous button
    And enter invalid card number
    Then verify error message "Geçersiz kredi kartı numarası."
    And click pay button
    Then verify open payment page

  @page  #WEB-081    #YLC-1705
  Scenario Outline: User should be able to see pickUp and drop location on vehicle detail page
    Given search "<first place>"
    When click the different drop off location checkbox
    And enter different drop location "<second place>" on main page
    And select date and time from calendar
    And click find button
    Then verify "<first place>" and "<second place>" search location
    When select "Greenmotion" vendor
    And Select vehicle in row "1"
    Then verify "<first place>" and "<second place>" is seen on the page
    Then second verify "<first place>" and "<second place>" is seen on the page
    Examples:
      | first place | second place |
      | sabiha      | esenboga     |

    #WEB-082 #YLC-1376
  Scenario: If user enter invalid card date
    Given the user is on the daily rental
    When search "saw"
    And click find button
    And select vendor and car
    And click continuous button
    And enter driver information
    And click continuous button
    And enter invalid card date
    And click pay button
    Then verify pop up contains error message "Belirtilen kredi kartı geçerlilik tarihi geçersizdir"




