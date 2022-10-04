 @mobilWeb @smokeYLC
Feature: Mobile view scenarios

  #IphoneX configuration Dimension(width:375, height:812)
  Background:
    Given the page is on the mobile view
     And click mobil dropdown
    And the mobil user changes language "TR"


    # WEB-MOBIL 001
  Scenario: Main functions should be available/usable in mobile view
    When click the monthly rental in mobile view
    Then monthly rental function should be available in mobile view
    When click the daily rental in mobile view
    Then daily rental function should be available in mobile view
    When enter word to pick-up information box in mobile view
    Then location list should be available in mobile view
    When select location from location list in mobile view
    Then calender should be opened in mobile view
    When select date and time from calendar in mobile view
    Then dates should be selected in mobile view
    When click the different drop off location checkbox in mobile view
    Then drop-off information box should be available in mobile view
    When enter word to drop-off information box in mobile view
    Then drop-off location list should be available in mobile view
    When select location from drop-off location list in mobile view
    Then location should be selected in mobile view

    #WEB-MOBIL 002
  Scenario: Mobile Header functions should be available/usable
    Given click mobil dropdown
    When click the currency selector in mobile view
    Then  currency selector dropdown should be opened in mobile view
    Given click mobil dropdown
    When click the language in mobile view
    Then language dropdown should be opened in mobile view
    When check the call center in mobile view
    Then call center number and text should be correct in mobile view
    When click the popular locations in mobile view
    Then popular locations dropdown should be opened in mobile view
    When click the find reservation in mobile view
    Then find reservation page should be opened in mobile view
    When click the campaigns on header bar in mobile view
    Then campaigns page should be opened in mobile view

      #WEB-MOBIL 003
  Scenario: User can register in mobil view
    Given click mobil dropdown
    When the mobil user click the register
    And the mobil user enter the personal information
    And the mobil user click Membership agreement
    And the mobil user click registerButton
    Then the mobil user should be able to register

     #WEB-MOBIL 003.1    #üyelik sözleşmesi imzalanmalı texti kontrol edilecek
  Scenario: User can not register without membership agreement in mobil view
    Given click mobil dropdown
    When the mobil user click the register
    And the mobil user enter the personal information
    And the mobil user click registerButton
    And the mobil user should not able to register without membership agreement

  @xx  #WEB-MOBIL 003.2       #geçersiz eposta texti kontrol edilecek
  Scenario Outline: User can not register via invalid information in mobil view
     Given click mobil dropdown
     When the mobil user click the register
    And enter the invalid "<e-mail>" and "<password>" information
     And the mobil user click Membership agreement
     And the mobil user click registerButton
    And the mobil user should not able to register with wrong email
    Examples:
      |e-mail          |password   |
      |edasd@asdcom    |Aasdf1234  |

     #WEB-MOBIL 004
  Scenario:  Registered user should be able to login and logout in mobil view
    Given click mobil dropdown
    When mobil login
    Then the mobil user should be able to login
    Given click mobil dropdown
    When mobil logOut
    Then the user should be able to logout

    #WEB-MOBIL 005
  Scenario: Registered user should be able to use forgot password function in mobil view
    Given click mobil dropdown
    And click sing in button
    And the mobil registered user click forgot password button
    And send e-mail
    And click forgot password button
    Then the user should be able to receive forgot password mail

      #WEB MOBIL-006
  Scenario: Registered user should be able to update his account information  in mobile view
    Given click mobil dropdown
    When mobil login
    Then the mobil user should be able to login
    When click mobil account button
    Then verify mobil account page
    And the user should be able to update account information
    When mobil logOut
    Then the user should be able to logout

    #WEB MOBIL -007
  Scenario: Registered user should be able to see past reservations in mobile view
    Given click mobil dropdown
    When mobil login
    Then the mobil user should be able to login
    When click mobil account button
    Then verify mobil account page
    And verify mobil past reservations view

    #WEB MOBIL-008
  Scenario: Registered user can change account password in mobile view
    Given click mobil dropdown
    When mobil login
    Then the mobil user should be able to login
    When click mobil account button
    Then verify mobil account page
    When the user should be able to change password
    Then verify update message

       #WEB MOBIL-009
  Scenario: User should be able to make daily rental search in mobile view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page

   #WEB MOBIL-010
  Scenario: User should be able to make monthly rental search in mobile view
    And click the monthly rental in mobile view
    And click mobil search box
    And search mobil "saw"
    And select monthly date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page

  #WEB MOBIL-011
  Scenario: User should be able to make default daily rental search in mobile view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And click mobil find button
    Then the user should be able to see default daily search

   #WEB MOBIL-012 // Sprint 37 de YLC-4094 işinden sonra yorum kaldırılacak ve son step subsitring tekrar check edilebilir
  Scenario: User should be able to make default monthly rental search in mobile view
    And click the monthly rental in mobile view
    And click mobil search box
    And search mobil "saw"
    And click mobil find button
    Then verify mobil open vehicle page
    Then verify the search is default monthly

  @res #WEB MOBIL-013.1
  Scenario: User should be able to make daily rental reservation in mobile view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    When select first car for mobil without check price
    And click mobil forward arrow
    And enter driver information
    And click mobil forward arrow
    And enter mobil payment method
    And click mobil forward arrow
    And mobil send sms key
    Then the user should be able to make reservation in mobile view

  @res  #WEB MOBIL-013.2
  Scenario: Registered user should be able to make monthly rental reservation in mobile view
    Given click mobil dropdown
    When mobil login
    And click the monthly rental in mobile view
    And click mobil search box
    And search mobil "ayt"
    And select monthly date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    Then verify the search is monthly
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    When select first car for mobil without check price
    And click mobil forward arrow
    And enter driver information
    And click mobil forward arrow
    And enter mobil payment method
    And click mobil forward arrow
    And mobil send sms key
    Then the user should be able to make reservation in mobile view

  @res #WEB-013.3
  Scenario: Registered user should be able to make daily rental reservation and check reservation no in mobil view
    Given click mobil dropdown
    When mobil login
    And click the daily rental in mobile view
    And click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    When select first car for mobil without check price
    And click mobil forward arrow
    And enter driver information
    And click mobil forward arrow
    And enter mobil payment method
    And click mobil forward arrow
    And mobil send sms key
    Then the user should be able to make reservation in mobile view
    When save reservation no on reservation detail page
    And click mobil dropdown
    And click mobil account button
    Then verify past reservations number in my account page


    #WEB MOBIL-014
  Scenario Outline: User should be able to search his reservation in mobile view
    Given click mobil dropdown
    When click mobil reservation search
    When the user enters "<reservation no>" and "<email>"
    Then the user should be able to match "<reservation no>" and "<email>" on reservation detail page
    Examples:
      | reservation no | email              |
      | R_A1ZV         | caner@yolcu360.com |
      | R_BQJI         | busra@yolcu360.com |

  #WEB MOBIL-015
  Scenario Outline: User should be able to join campaigns in mobile view
    Given the user is on the rent a car campaigns page in mobile view
    When the user goes the "<campaign>" and enter "<code>" in mobile view
    Then the user can join the "<campaign>" in mobile view
    Examples:
      | campaign                 | code              |
      | kuveyt-turk-miles-smiles | KUVEYTTURK50      |
      | multinet                 | JS5WP8ZK         |

     #WEB MOBIL-016
  Scenario Outline: User should be able to view vehicle listing from popular locations in mobile view
    Given the user is on the popular locations
    When the user goes the "<location>"
    And click mobil forward arrow
    Then the mobil user can view vehicle listing page of "<location>"
    Examples:
      | location                          |
      | istanbul-istanbul-havalimani      |
      | ankara-esenboga-havalimani        |

  #WEB-017
  Scenario Outline: User should be able to view vehicle listing from landing pages in mobile view
    Given the user is on the landing pages
    When the user goes the "<location>" landing page
    Then verify mobil "<Verify location>" search page open
    And click mobil forward arrow
    Then the mobil user can view vehicle listing page of "<location>"
    And the user should be able to see default daily search
    Examples:
      | location                                       | Verify location                               |
      | Ankara Esenboğa Havalimanı Araç Kiralama       |Ankara Esenboğa Havalimanı Araç Kiralama       |
      | Samsun Araç Kiralama                           |Samsun Araç Kiralama                    |

  #WEB MOBIL-018.1
  Scenario: User should be able to use checked filters on the vehicle listing page in mobile view
    Given click mobil search box
    And search mobil "saw"
    And select monthly date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    When the user selects following filters then listing page should be filtered in mobile view
      | vendor        |
      | transmission  |
      | fuel          |
      | brand         |
      | model         |
      | class_type    |
      | delivery_type |

  #WEB MOBIL-018.2
  Scenario: User should be able to use ranged filters on the vehicle listing page in mobile view
    Given click mobil search box
    And search mobil "saw"
    And select monthly date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    When the user selects ranged filters then listing page should be filtered in mobile view
      | price            |
      | distance_limit   |
      | provision        |

  #WEB MOBIL-019
  Scenario: User should be able to use sorting on the vehicle listing page in mobile view
    Given click mobil search box
    And search mobil "saw"
    And select monthly date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    When the user uses sorting criteria then vehicle listing can sorted in mobile view

      #WEB MOBIL-020
  Scenario: User should be able to change language and currency from listing page in mobile view
    Given click mobil search box
    And search mobil "saw"
    And select monthly date and time from calendar in mobile view
    And click mobil find button
    And click mobil dropdown
    And the mobil user changes language "EN"
    Then mobil page language should be "EN"
    And click mobil dropdown
    And the mobil user changes language "TR"
    Then mobil page language should be "TR"
    And click mobil dropdown
    And the mobil user changes language "DE"
    Then mobil page language should be "DE"
    And the mobil user changes currency then page currency should be changed
      | euro    |
      | try     |
      | dollar  |
      | pound   |

   #WEB MOBIL-021
  Scenario: User should be able to use promotion code in mobile view
    Given click mobil search box
    And search mobil "AYT"
    And click the monthly rental in mobile view
    And select monthly date and time from calendar in mobile view
    And click mobil find button
    And click mobil dropdown
    And the mobil user enters "JS5WP8ZK" promotion code
    Then the mobil promotion code can be applied
    When click mobil dropdown
    And the mobil user enters "YOLCU360" promotion code
    Then the mobil promotion code can not be applied

   #WEB MOBIL-022
  Scenario: User should be able to read comments in mobile view
    Given click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    And the user goes to comments
    Then user comments should be opened

   # WEB MOBIL-023.1
  Scenario: Url should be updated with filtering options in mobile view
    Given click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    When the mobil user select filter option then URL contains selected option
      | vendor        |v  |
      | transmission  |t  |
      | fuel          |f  |
      | brand         |b  |
      | model         |m  |
      | class_type    |c  |
      | delivery_type |dt |
    Then the mobil user selects more filter option then URL should be updated

   # WEB MOBIL-023.2
   Scenario: Url should be updated according to ranged filtering options in mobile view
    Given click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    And click mobil filter button
    Then the mobil user selects ranged filters then URL contains selected option
      | price      |
      | distance   |
      | provision  |

 #WEB MOBIL-024
  Scenario: User should be able to see other main page items in mobile view
    When the mobil user scroll down
    Then the user should see our partners banner
    And the user should see Why rent with Yolcu360
    And the user should see Yolcu360 in press
    And the user should see Blog
    And the user should see Car Rental Service

      #WEB MOBIL-025
  Scenario: User should be able to open flat pages in mobile view
    Given the user is on the bottom of the main page
    When the user clicks flat page on the footer then flat page should be opened
      | hakkimizda         |
      | gizlilik           |
      | kvkk               |
      | kullanim-kosullari |
      | tvreklamlari       |
      | yatirim-haberleri  |
    Then the user clicks iletisim, blog and kariyer then pages should be opened

    #WEB MOBIL-026
 Scenario Outline: Vehicle listing page functions should be seen and enabled in mobil view
    Given click mobil search box
    When search mobil "<first place>"
    And click mobil find button
    And click selected location in mobil
    And click the different drop off location checkbox in mobile view
    And enter different drop location "<second place>" in mobil view
    And select date and time from calendar in mobile view
    And click mobil find button
    And click mobil dropdown
    When the mobil user click promotion code button
    Then verify promo code is working  in mobil view
    When click cancel campaign code Window
    Then Reservation time should be seen
    And the functions should be enabled and information should be matched with search details
    And verify "<first place>" and "<second place>" search location
    Examples:
      | first place | second place |
      | sabiha      | esenboga     |


       #WEB MOBIL-027
  Scenario: Vehicle detail page functions should be seen and enabled in mobil view
    Given click mobil search box
    When search mobil "saw"
    When select date and time from calendar in mobile view
    And click mobil find button
    And the user uses sorting criteria then vehicle listing can sorted in mobile view
    When click mobil filter button
    And select mobil vendor filter "724Rent"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "724Rent" vendor
    When select car and check delivery type
    Then the user verify price and office type in mobil view
    And the user verify car model and price in mobil view
    And  the user verify rental conditions
    And the user verify driver requirements
    And the user verify reviews

     #WEB MOBIL-028
  Scenario: Driver information page functions should be seen and enabled in mobil view
      Given click mobil search box
      When search mobil "saw"
      And select date and time from calendar in mobile view
      And click mobil find button
      Then verify mobil open vehicle page
      When click mobil filter button
    And select mobil vendor filter "Yolcutest"
      And click mobil forward arrow
      And click mobil forward arrow
      Then verify mobil filter "Yolcutest" vendor
    When select first car for mobil without check price
      And click mobil forward arrow
      And the user checks the functions and enters driver information
      Then the functions should be enabled and information should be entered to input boxes

    #WEB MOBIL-029
  Scenario: Payment information page functions should be seen and enabled in mobil view
    Given click mobil search box
    When search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    When select first car for mobil without check price
    And click mobil forward arrow
    And enter driver information
    And click mobil forward arrow
    And enter payment method
    Then input boxes should be enabled and driver&invoice information should be matched in mobil view

     #WEB MOBIL-030 #YLC-1734
  Scenario: users press the 'X' button on the Mobile Web filtering page, the filtering page will be closed and the filters will not be deleted
    Given click mobil search box
    When search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    When click mobil filter button
    And click mobil X button on filter page
    Then verify mobil filter "Yolcutest" vendor

    #WEB MOBIL-031  #YLC-1661
  Scenario: User should be see car sort information via orange color
    Given click mobil search box
    When search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    And User click sort button and able to see orange sort dot in mobil view
    And User able to see selected sort criteria with orange text in mobil view

       #WEB MOBIL-031
  Scenario Outline: Registered user should not be able to login in mobil
    Given click mobil dropdown
    When Enters "<username>" and enters invalid "<Password>" in mobil view
    Then Users should see "<Message>" message
    Examples:
      |username         |Password        |Message                                    |
      |qa2@yolcu360.com |asd             |Bilinmeyen kullanıcı veya eşleşmeyen şifre.|
      |qa2@yolcu360.com |UserUser123     |Bilinmeyen kullanıcı veya eşleşmeyen şifre.|
      |qa2@yolcu360.com |                |Bu alanın doldurulması zorunludur.         |
      |                 |Qa12345678      |Bu alanın doldurulması zorunludur.         |
      |qa2yolcu360.com  |Qa12345678      |Lütfen geçerli bir e-posta adresi giriniz. |
      |qa2@yolcu360com  |Qa12345678      |Lütfen geçerli bir e-posta adresi giriniz. |
      |qa2@yolcu360.    |Qa12345678      |Lütfen geçerli bir e-posta adresi giriniz. |

      #WEB MOBIL-032
  Scenario Outline: Registered user can not change account password in mobil view
    Given click mobil dropdown
    When mobil login
    Then the mobil user should be able to login
    When click mobil account button
    Then verify mobil account page
    And Enter invalid "<password>"  and "<confirmation password>" in mobil view
    Then Users should see "<error message>"
    Examples:
      |password      |confirmation password |error message                                                                           |
      |Yol           |Yol                   |Şifreniz 8-15 karakter arasında olmalıdır, 1 büyük , 1 küçük harf ve rakam içermelidir. |
      |Yolcu360      |Yolcu36               |Girilen şifreler uyuşmuyor.                                                             |

  @res #WEB MOBIL-033.1
  Scenario: Extra Products & Assurances must be added to the office amount for daily reservation in mobil view
    Given click mobil search box
    When search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    When select mobil first car
    And add extra Products & Assurances in mobil view
    Then verify price on driver information page &Vehicle Selection in mobil view
    And click mobil forward arrow
    And enter driver information
    Then verify price on driver information page &Vehicle Selection in mobil view
    And click mobil forward arrow
    And enter mobil payment method
    Then verify price on driver information page &Vehicle Selection in mobil view
    Then input boxes should be enabled and driver&invoice information should be matched
    And mobil send sms key
    Then verify price on reservation summary page in mobil view

  @res #WEB MOBIL-033.2
  Scenario: Extra Products & Assurances must be added to the office amount for monthly reservation in mobil view
    Given click the monthly rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And select monthly date and time from calendar in mobile view
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    When select mobil first car
    And add extra Products & Assurances in mobil view
    Then verify price on driver information page &Vehicle Selection in mobil view
    And click mobil forward arrow
    And enter driver information
    Then verify price on driver information page &Vehicle Selection in mobil view
    And click mobil forward arrow
    And enter mobil payment method
    Then verify price on driver information page &Vehicle Selection in mobil view
    Then input boxes should be enabled and driver&invoice information should be matched
    And mobil send sms key
    Then verify price on reservation summary page in mobil view

  @res # WEB MOBIL-034 #YLC-2889
  Scenario:From checkout page Come back and choose more expensive vehicle total price should change in mobil view
    Given click mobil search box
    When search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    And click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    And sort by "En Düşük Fiyat"
    When select mobil first car
    Then verify price on driver information page &Vehicle Selection in mobil view
    And click mobil forward arrow
    And enter driver information
    Then verify price on driver information page &Vehicle Selection in mobil view
    And click mobil forward arrow
    And enter mobil payment method
    Then verify price on driver information page &Vehicle Selection in mobil view
    And click back to previous page
    And click back to previous page
    And click back to previous page
    And sort by "En Yüksek Fiyat"
    And Select vehicle in row "1"
    Then verify price on driver information page &Vehicle Selection in mobil view
    And click mobil forward arrow
    Then verify price on driver information page &Vehicle Selection in mobil view
    And click mobil forward arrow
    Then verify price on driver information page &Vehicle Selection in mobil view
    And enter mobil payment method
    And click mobil forward arrow
    And mobil send sms key
    Then verify price on reservation summary page in mobil view

        #WEB MOBIL-035
  Scenario: The user should not make a daily rental reservation without accepting the membership agreement in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    When select first car for mobil without check price
    And click mobil forward arrow
    And click mobil forward arrow
    Then Users should see "Lütfen kutuyu işaretleyiniz."
    When enter "valid" driver information without check box
    And click mobil forward arrow
    Then Users should see "Lütfen kutuyu işaretleyiniz."
    When click KVKK check box on driver information
    And click mobil forward arrow

    #WEB MOBIL -036
  Scenario: The invalid user should not make a daily rental reservation in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    When select first car for mobil without check price
    And click mobil forward arrow
    When enter "invalid" driver information
    And click mobil forward arrow
    Then Users should see error exclamation mark

    #WEB MOBIL -038
  Scenario: If the user changes the currency, they should return to the vehicle listing page in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    When select first car for mobil without check price
    And the mobil user changes currency "euro" then page currency should be changed
     When select first car for mobil without check price
     And click mobil forward arrow
     And the mobil user changes currency "try" then page currency should be changed
     Then the mobil user should be able to see vehicle listing

     #WEB MOBIL -039
  Scenario: user should be able to click on home page breadcrumb in popular locations in mobil view
    Given the user is on the popular locations
    When the user goes the "istanbul-istanbul-havalimani"
      Then verify mobil "İstanbul Havalimanı Araç Kiralama" search page open
    And select popular locations breadcrumb 1
    Then verify find button seen main page
    And verify "Lütfen bir alış yeri seçin" message
    And verify open main page


    #WEB MOBIL -040
  Scenario: user should be able to click on home page breadcrumb in vehicle list page in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And click mobil find button
    And select breadcrumb 1
    Then verify open main page

    #WEB MOBIL -041
  Scenario: user should be able to click location breadcrumb in vehicle list page in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    When select first car for mobil without check price
    And select breadcrumb 3
    Then verify mobil "İstanbul Sabiha Gökçen Havalimanı Araç Kiralama" search page open

    #WEB MOBIL -042
  Scenario Outline: The user should select different drop location and check different location price on car details in mobil view
     Given click mobil search box
     When search mobil "<first place>"
     And click mobil find button
     And click selected location in mobil
     And click the different drop off location checkbox in mobile view
     And enter different drop location "<second place>" in mobil view
     And select date and time from calendar in mobile view
     And click mobil find button
     When click mobil filter button
    And select mobil vendor filter "Yolcutest"
     And click mobil forward arrow
     And click mobil forward arrow
     Then verify mobil filter "Yolcutest" vendor
     Then check different price on first car detail
     When select first car for mobil without check price
     And click Detaylar için tıklayınız
     Then check different price list page and car details page
     Examples:
      | first place | second place |
      | sabiha      | esenboga     |

      #WEB MOBIL -043
  Scenario: user should be able to change currency after filtering in vehicle list in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    And the mobil user changes currency "euro" then page currency should be changed
    Then verify mobil filter "Yolcutest" vendor
    Then verify filter button orange dot available
    And the mobil user changes currency "try" then page currency should be changed
    Then verify mobil filter "Yolcutest" vendor
    Then verify filter button orange dot available

     #WEB MOBIL-044
  Scenario: filtering and date should go back when user clicks back button in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    When click mobil filter button
    Then mobil verify the number of filters selected must be 1
    And select mobil filter "Dizel"
    And click mobil forward arrow
    And click mobil forward arrow
    When click mobil filter button
    Then mobil verify the number of filters selected must be 2
    And select mobil filter "Otomatik"
    And click mobil forward arrow
    And click mobil forward arrow
    When click mobil filter button
    Then mobil verify the number of filters selected must be 3
    And click mobil forward arrow
    When click back to previous page
    When click mobil filter button
    Then mobil verify the number of filters selected must be 2
    And click mobil forward arrow
    And sort by "En Düşük Fiyat"

     #WEB MOBIL-045  #YLC-1584
  Scenario Outline: User should be able to view vehicle listing from landing pages with different date in mobil view
    Given the user is on the landing pages
    When the user goes the "<location1>" landing page
    Then verify mobil "<location1>" search page open
    When click mobil find button inside landing page
    And click start date
    And select forward date and time from calendar
    And click mobil find button
    Given the user is on the landing pages
    When the user goes the "<location2>" landing page
    Then verify mobil "<Verify location>" search page open
    When click mobil find button inside landing page
    And click start date
    And select forward date and time from calendar
    And click mobil find button
    And Select vehicle in row "1"
    Examples:
      | location1                                | location2              | Verify location            |
      | Ankara Esenboğa Havalimanı Araç Kiralama | İstanbul Araç Kiralama | İstanbul Araç Kiralama     |

     #WEB MOBIL-046  #YLC-1512
  Scenario: User should be able to see selected filter in URL after back from detail page to listing page in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And select mobil filter "Dizel"
    And click mobil forward arrow
    And click mobil forward arrow
    And saved current URL
    And Select vehicle in row "1"
    And click back to previous page
    Then URL should be contains selected filter options

     #WEB MOBIL-047
  Scenario Outline: When user cancel the different location after searching in a different location, you should search again and the url should change in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "<first place>"
    And click mobil find button
    And click start date
    And click the different drop off location checkbox in mobile view
    And enter different drop location "<second place>" in mobil view
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify "<first place>" and "<second place>" search location
    When save first url
    And click start date
    And mobil cancel different location click X button in listing page
    And wait until car image animation on vehicle page
    And save second url
    Then url should "not be equal"
    And click start date
    And click the different drop off location checkbox in mobile view
    And enter different drop location "<third place>" in mobil view
    And click mobil find button
    Then verify "<first place>" and "<third place>" search location
    Examples:
      | first place | second place | third place |
      | sabiha      | esenboga     |  izmir      |

     #WEB MOBIL-048
  Scenario: The user must give up Drop-Off Information by clicking the X button in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "sabiha"
    And click the different drop off location checkbox in mobile view
    And enter different drop location "esenboga" in mobil view
    And cancel different location click X button
    And click mobil find button
    Then url contains "sabiha"
    Then url must not contain "esenboga"

        #WEB MOBIL-049  #YLC-1515
  Scenario: The user should receive a warning text in cases Where the vehicle is not found in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "Aü Sivil Havacılık"
    And click only mobil find button
    Then Users should see warning text when the vehicle is not be found

       #WEB MOBIL-050 #YLC-1423
  Scenario: The user should be search only put start date in mobil view
    When click mobil search box
    And search mobil "saw"
    When click "Tarih Seçimi" with text locator
    And click find button
    Then the user should be able to see default daily search

   #WEB MOBIL-051  #YLC-1451
  Scenario: The user should be able to search after click pick-up box button(firstly pick-up box is must be entered location) on LandingPage in mobil view
    Given the user is on the landing pages
    When the user goes the "Bursa Araç Kiralama" landing page
    And click start date
    And click the different drop off location checkbox in mobile view
    And enter different drop location "saw" in mobil view
    And select forward date and time from calendar
    And click mobil find button
    Then verify "sabiha" and "bursa" search location

    #WEB MOBIL-052  #YLC-1451
  Scenario: The user should be able to search after click pick-up box button(firstly pick-up box is must be entered location) on homepage in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "esenboga"
    And click the different drop off location checkbox in mobile view
    And enter different drop location "sabiha" in mobil view
    And mobil click different drop off location box
    And mobil cancel different location click X button in main page
    And click mobil forward arrow
    Then url contains "sabiha"
    Then url contains "esenboga"

  @res  #WEB MOBIL-053  #YLC-3669
  Scenario: User can be change language on main page, car detail page, reservation summary page in mobil view
    Given user select language and verify on main page in mobil
       |EN|
       |DE|
       |TR|
     When click mobil search box
     And search mobil "saw"
     And select date and time from calendar in mobile view
     And click mobil find button
     Then verify mobil open vehicle page
     When click mobil filter button
     And select mobil vendor filter "Yolcutest"
     And click mobil forward arrow
     And click mobil forward arrow
     Then verify mobil filter "Yolcutest" vendor
    When select first car for mobil without check price
     And user select language and verify on car detail page in mobil
       |EN|
       |DE|
       |TR|
     And click mobil forward arrow
     And enter driver information
     And click mobil forward arrow
     And enter mobil payment method
     And click mobil forward arrow
     And mobil send sms key
     Then the user should be able to make reservation in mobile view
     And user select language and verify on reservation summary page in mobil
       |TR|
       |EN|
       |DE|

    #WEB MOBIL-054 #YLC-1357
  Scenario: User should be able to change pick up locate on landing page in mobil view
    Given the user is on the landing pages
    When the user goes the "Bursa Araç Kiralama" landing page
     Then verify mobil "Bursa Araç Kiralama" search page open
     When click mobil search box in landing page
     And search mobil "saw"
     And click mobil find button
     Then verify mobil open vehicle page
    Then url contains "sabiha"

    #WEB MOBIL-055  #YLC-1436
  Scenario: The user who wants to leave the vehicle in a different place should go to the Vehicle detail page and see the drop location on the listing page when returns in mobil view
    When click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify mobil open vehicle page
    And click selected location in mobil
    And click the different drop off location checkbox in mobile view
    And enter different drop location "esb" in mobil view
    And select date and time from calendar in mobile view
    And click mobil find button
    And save first url
    When select first car for mobil without check price
    And click back to previous page
    And save second url
    Then url should "equal"
    And verify drop off box "Esenboğa" location in mobil view

    #WEB MOBIL-056  #YLC-3052  #YLC-3751
  Scenario: the user should be able to change the language within the campaigns in mobil view
    Given click all campaigns button
    Then verify open campaign page
    When user select language and verify on campaign page in mobil
      |EN|
      |TR|
      |DE|
    And select 3 campaign on all campaign page
    When user select language and verify on campaign detail page in mobil
      |EN|
      |TR|
      |DE|

    #WEB-057 #YLC-1388
  Scenario: User should be able to search (monthly search) with change pick up locate on landing page in mobil view
    Given the user is on the landing pages
    When the user goes the "Bursa Araç Kiralama" landing page
    Then verify mobil "Bursa Araç Kiralama" search page open
    And click monthly date in landing page
    When click mobil search box in landing page
    And search mobil "ayt"
    And click mobil find button
    Then verify mobil open vehicle page
    Then url contains "month"

  #WEB MOBIL-061   #YLC-1421
  Scenario: User should be able to see sorted parameter on url in mobil view
    When click mobil search box
    And search mobil "saw"
    And click mobil find button
    And the user uses sorting criteria then url should change

    #WEB MOBIL-062 YLC-1358
  Scenario: The user can search vehicle by selecting a different drop off location in the Landing Page in mobil view
    Given the user is on the landing pages
    When the user goes the "İstanbul Sabiha Gökçen Havalimanı Araç Kiralama" landing page
    Then verify mobil "İstanbul Sabiha Gökçen Havalimanı Araç Kiralama" search page open
    And click the different drop off location checkbox
     And click Nerede Bırakacaksınız? box in mobil landing page
    And enter different drop location "izmir" in mobil view
    When click mobil find button
    Then verify "sabiha" and "izmir" search location
    And click pickUp icon
    Then the user should be able to see default daily search

    #WEB MOBIL-063 #YLC-1443
  Scenario: User should be able to back from vehicle driver information page in mobil view
    When click mobil search box
    And search mobil "saw"
    And click mobil find button
    Then verify mobil open vehicle page
    When select first car for mobil without check price
    Then verify user on detail page
    And click mobil forward arrow
    Then Verify driver information page open
    And click back to previous page
    Then verify user on detail page
    And click back to previous page
    Then verify mobil open vehicle page

    #WEB MOBIL-064 YLC-298
  Scenario: Generating title & description for vehicle listing pages in mobil view
    When click mobil search box
    And search mobil "saw"
    And click mobil find button
    When the user select filter option then title & description contains selected option in mobil view
      | vendor        |
      | transmission  |
      | fuel          |
    And click mobil dropdown
    And the mobil user changes language "EN"
    Then mobil page language should be "EN"
    When the user select filter option then title & description contains selected option in mobil view
      | vendor        |
      | transmission  |
      | fuel          |
    And click mobil dropdown
    And the mobil user changes language "DE"
    Then mobil page language should be "DE"
    When the user select filter option then title & description contains selected option in mobil view
      | vendor        |
      | transmission  |
      | fuel          |

    #WEB MOBIL-065 #YLC-3068
  Scenario: User should be able search with changing date and location on listing page
     And click the monthly rental in mobile view
     And click mobil search box
     And search mobil "saw"
     And select monthly date and time from calendar in mobile view
     And click mobil find button
     Then verify mobil open vehicle page
    Then verify the search is monthly
     And select forward date for monthly date on listingpage in mobil
     And click mobil find button
     Then verify mobil open vehicle page
     Then verify the search is monthly
     When user click pickUp button
     And search mobil "esb" in listingPage
     And click mobil find button
     Then verify mobil open vehicle page
     Then verify the search is monthly

    #WEB MOBIL-066  #YLC-1672
  Scenario: Yolcu360 Partner tab which on header should be not seen when page language change to EN in mobil view
    Given click mobil dropdown
    And "Yolcu360 Partner" tab should be seen on header
    And the mobil user changes language "EN"
    And click mobil dropdown
    Then "Yolcu360 Partner" tab should be not seen on header
    And the mobil user changes language "DE"
    And click mobil dropdown
    Then "Yolcu360 Partner" tab should be not seen on header
    And the mobil user changes language "TR"
    And click mobil dropdown
    Then "Yolcu360 Partner" tab should be seen on header

    #WEB MOBIL-067  #YLC-1372
  Scenario Outline: Register emailBox can fix Turkish character and accept email address consist (-) in mobil view
    Given click mobil dropdown
    When the mobil user click the register
    And enter the "<e-mail>" and "<password>" information
    Then Register emailBox should be able to fix Turkish character
    And emailBox should be accept email address consist (-)
    Examples:
      |e-mail           |password   |
      |çğüı@as-d.com    |Aasdf1234  |

    #WEB MOBIL-068  #YLC-1372
  Scenario Outline: Login emailBox can fix Turkish character and accept email address consist (-) in mobil view
    Given click mobil dropdown
    And user click login button
    And enter the "<e-mail>" and "<password>" information on Login Page
    Then Login emailBox should be able to fix Turkish character on Login Page
    And emailBox should be accept email address consist (-)
    Examples:
      |e-mail           |password   |
      |çğüı@as-d.com    |Aasdf1234  |

    #WEB MOBIL-070  #YLC-1372
  Scenario Outline: Reservation Search emailBox can fix Turkish character and accept email address consist (-) in mobil view
    Given click mobil dropdown
    When click the find reservation in mobile view
    When the user enters "<reservation no>" and "<email>" on Reservation Search
    Then Reservation emailBox should be able to fix Turkish character
    And emailBox should be accept email address consist (-)
    Examples:
      | reservation no | email              |
      | R_A1ZV         | çğüı@as-d.com      |

    #WEB MOBIL-072 YLC-1708
  Scenario: KM bounder text check inside car rental contract in mobil view
    When click mobil search box
    And search mobil "saw"
    And select forward date and time from calendar
    And click mobil find button
    When User hover "Toplam Km sınırı" on vehicle detail
    Then User should see detail delivery type
    When click mobil filter button
    And select mobil vendor filter "Greenmotion"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Greenmotion" vendor
    And Select vehicle in row "1"
    And click car rental contract
    Then verify "KİLOMETRE SINIRI" inside car rental contract

   #WEB MOBIL-073 YLC-1391
  Scenario: user can search reservation by click empty area after select day then can change date in mobil view
    When click mobil search box
    And search mobil "saw"
    And select date 2 without time in mobil
    When click "Tarih Seçimi" with text locator
    And select date 3 without time in mobil
    When click "Tarih Seçimi" with text locator
    And click find button
    When save first url
    And click start date
    And select date 6 without time in mobil
    When click "Tarih Seçimi" with text locator
    And select date 9 without time in mobil
    When click "Tarih Seçimi" with text locator
    And click mobil find button
    And save second url
    Then url should "not be equal"

   @res   #WEB MOBIL-074 #YLC-91
  Scenario: User should be able to see delivery type detail when hover delivery type on list, vehicle detail and reservation confirm page in mobil view
    Given click mobil search box
    When search mobil "saw"
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    Then verify mobil filter "Yolcutest" vendor
    When User hover "Aracı nasıl teslim alacağım?" on vehicle detail
    Then User should see detail delivery type
    When select first car for mobil without check price
    When user scroll to "Aracı nasıl teslim alacağım?"
    When User hover "Aracı nasıl teslim alacağım?" on vehicle detail
    Then User should see detail delivery type
    And click mobil forward arrow
    And enter driver information
    And click mobil forward arrow
    And enter mobil payment method
    And click mobil forward arrow
    And mobil send sms key
    Then the user should be able to make reservation in mobile view
    When user scroll to "Aracı nasıl teslim alacağım?"
    When User hover "Aracı nasıl teslim alacağım?" on vehicle detail
    Then User should see detail delivery type

         #WEB MOBIL-075 YLC-1530
  Scenario: The user who cleans the filter should see the result within 5 seconds at the most, should not send a request to BE in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And select mobil filter "Dizel"
    And click mobil forward arrow
    And select mobil filter "Otomatik"
    And click mobil forward arrow
    And click mobil forward arrow
    When click mobil filter button
    And click mobil clear filter button
    Then User should be able to see results in less than 4 seconds without requesting BE

  @res  #WEB MOBIL-077  #YLC-1710
  Scenario Outline: User should be able to make daily rental reservation with Different Location in mobil view
    Given click mobil search box
    And search mobil "<first place>"
    And click the different drop off location checkbox in mobile view
    And enter different drop location "<second place>" in mobil view
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify "<first place>" and "<second place>" search location
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    When select first car for mobil without check price
    And click mobil forward arrow
    And enter driver information
    And click mobil forward arrow
    And enter mobil payment method
    Then User should be see green check icon for card number and Card owner name
    And select 3 installments
    And click mobil forward arrow
    And mobil send sms key
    Then the user should be able to make reservation in mobile view
    Then the user should be able to see Rezervasyon No and Rezervasyon Numarası
    Examples:
      | first place | second place |
      | sabiha      | esenboga     |

    #WEB MOBIL-078 YLC-1223
  Scenario: Search Araç Kiralama Kampanyaları on google and verify text in mobil view
    Given click the daily rental in mobile view
    When go to url "https://www.google.com/search?q=Ara%C3%A7+Kiralama+Kampanyalar%C4%B1&rlz=1C5GCEM_enTR1012&ei=tIXCYtifA4erxc8Ps-aYeA&ved=0ahUKEwjYyZrlyt74AhWHVfEDHTMzBg8Q4dUDCA4&uact=5&oq=Ara%C3%A7+Kiralama&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBggAEB4QFjIGCAAQHhAWMgYIABAeEBYyBggAEB4QFjIGCAAQHhAWMgYIABAeEBYyBggAEB4QFkoECEEYAEoECEYYAFAAWABg0K2WAmgFcAB4AYABmQKIAasEkgEDMi0ymAEAwAEB&sclient=gws-wiz"
    And select google language "tr"
    Then verify campaign text on google

    #WEB MOBIL-079 #YLC-1335
  Scenario: If user enter invalid card number in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    When select first car for mobil without check price
    And click mobil forward arrow
    And enter driver information
    And click mobil forward arrow
    And enter invalid card number
    Then verify error message "Geçersiz kredi kartı numarası."
    And click mobil forward arrow
    Then verify open payment page

    #WEB MOBIL-080  #YLC-386
  Scenario: User should be see social media links on footer web page in mobil view
    Given the user is on the landing pages
    Then the user should be able to see social media links

    #WEB MOBIL-081   #YLC-1705
  Scenario Outline: User should be able to see pickUp and drop location on vehicle detail page in mobil view
    Given click mobil search box
    And search mobil "<first place>"
    And click the different drop off location checkbox in mobile view
    And enter different drop location "<second place>" in mobil view
    And select date and time from calendar in mobile view
    And click mobil find button
    Then verify "<first place>" and "<second place>" search location
    When click mobil filter button
    And select mobil vendor filter "Greenmotion"
    And click mobil forward arrow
    And click mobil forward arrow
    When select first car for mobil without check price
    Then verify mobil "<first place>" and "<second place>" is seen on the page
    Then second verify "<first place>" and "<second place>" is seen on the page
    Examples:
      | first place | second place |
      | sabiha      | esenboga     |

        #WEB MOBIL-082 #YLC-1376
  Scenario: If user enter invalid card date in mobil view
    Given click the daily rental in mobile view
    When click mobil search box
    And search mobil "saw"
    And select date and time from calendar in mobile view
    And click mobil find button
    When click mobil filter button
    And select mobil vendor filter "Yolcutest"
    And click mobil forward arrow
    And click mobil forward arrow
    When select first car for mobil without check price
    And click mobil forward arrow
    And enter driver information
    And click mobil forward arrow
    And enter invalid card date
    And click mobil forward arrow
    Then verify pop up contains error message "Belirtilen kredi kartı geçerlilik tarihi geçersizdir"

         #WEB MOBIL-083 YLC-3670
  Scenario: Even if the user enters wrong url, it should be redirected to the correct url
    When go to extensions and add environment type "/tr/rent-a-car/orly-paris-orly-havaliman-arac-kiralama/"
    Then Verify that URL is not returning 404
    When go to extensions and add environment type "/tr/rent-a-car/madrid-barajas-uluslararas-havalimani-arac-kiralama/"
    Then Verify that URL is not returning 404
    When go to extensions and add environment type "/tr/rent-a-car/nice-nice-havaliman-arac-kiralama/"
    Then Verify that URL is not returning 404
