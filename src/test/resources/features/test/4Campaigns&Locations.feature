@smokeYLC @campaign
Feature: Campaign and locations pages
  Background:
  When the user changes language "TR"


   #WEB-015
  Scenario Outline: User should be able to join campaigns
    Given click left and right arrow on campaign banner
    And click all campaigns button
    Then verify open campaign page
    When the user goes the "<campaign>" and enter "<code>"
    Then the user can join the "<campaign>"
    Examples:
      | campaign                 | code         |
      | kuveyt-turk-miles-smiles | KUVEYTTURK50 |
      | multinet                 | JS5WP8ZK    |

  #WEB-016
  Scenario Outline: User should be able to view vehicle listing from popular locations
    Given the user is on the popular locations
    When the user goes the "<location>"
    #And click pickUp icon
    #And select date and time from calendar
    And click find button
    Then the user can view vehicle listing page of "<location>"
    Examples:
      | location                          |
      | istanbul-istanbul-havalimani      |
      | ankara-esenboga-havalimani        |

  #WEB-017
  Scenario Outline: User should be able to view vehicle listing from landing pages
    Given the user is on the landing pages
    When the user goes the "<location>" landing page
    Then verify "<Verify location>" search page open
    When click find button
    And the user can view vehicle listing page of "<location>"
    Then the user should be able to see default daily search
    Examples:
      | location                                       | Verify location                               |
      | Ankara Esenboğa Havalimanı Araç Kiralama       |Ankara Esenboğa Havalimanı Araç Kiralama       |
      | Muğla Bodrum Havalimanı Araç Kiralama          |Milas Bodrum Havalimanı Araç Kiralama    |
      | İzmir Adnan Menderes Havalimanı Araç Kiralama  |İzmir Adnan Menderes Havalimanı Araç Kiralama  |


  #WEB-018.1
  Scenario: User should be able to use checked filters on the vehicle listing page
    Given search "saw"
    When select date and time from calendar
    And click find button
    Then the user selects following filters then listing page should be filtered
      | vendor        |
      | transmission  |
      | fuel          |
      | brand         |
      | model         |
      | class_type    |
      | delivery_type |

    #WEB-018.2
  Scenario: User should be able to use ranged filters on the vehicle listing page
    Given search "saw"
    And click find button
    Then the user selects ranged filters then listing page should be filtered
      | price      |
      | distance   |
      | provision  |

    #WEB-018.3
  Scenario: User should be able to use checked filters and check details car information
    Given search "saw"
    When select date and time from calendar
    And click find button
    Then the user selects following filters and check all cars details information
      | transmission  |
      | fuel          |


  #WEB-019
  Scenario: User should be able to use sorting on the vehicle listing page
    Given search "saw"
    When select date and time from calendar
      #When select forward date and time from calendar
    And click find button
    Then the user uses sorting criteria then vehicle listing can sorted

  #WEB-020
  Scenario: User should be able to change language and currency from listing page
    Given search "saw"
    When select date and time from calendar
    And click find button
    And the user changes language "EN"
    Then page language should be "EN"
    When the user changes language "TR"
    Then page language should be "TR"
    And the user changes currency then page currency should be changed
      | euro    |
      | try     |
      | dollar  |
      | pound   |

  #WEB-021
  Scenario: User should be able to use promotion code
    Given search "saw"
    And select date and time from calendar
    And click find button
    When the user enters "JS5WP8ZK" promotion code
    Then the promotion code can be applied
    And the user enters "YOLCU360" promotion code
    Then the promotion code can not be applied

  #WEB-022
  Scenario: User should be able to read comments
    Given search "saw"
    When select date and time from calendar
    And click find button
    And the user goes to comments
    Then user comments should be opened

   #WEB-023.1
  Scenario: Url should be updated with filtering options
    Given search "saw"
    When select date and time from calendar
    And click find button
    When the user select filter option then URL contains selected option
      | vendor        |v  |
      | transmission  |t  |
      | fuel          |f  |
      | brand         |b  |
      | model         |m  |
      | class_type    |c  |
      | delivery_type |dt |
    Then the user selects more filter option then URL should be updated

    #WEB-023.2
  Scenario: Url should be updated according to ranged filtering options
    Given search "saw"
    And click find button
    Then the user selects ranged filters then URL contains selected option
      | price      |
      | distance   |
      | provision  |

   #WEB-024 #YLC-1439(second step)
  Scenario: User should be able to see other main page items
    When the user scroll down
    Then the user should see our partners banner
    Then User see partners
    And the user should see Why rent with Yolcu360
    And the user should see Yolcu360 in press
    And the user should see Blog
    And the user should see Car Rental Service


  #WEB-025
  Scenario: User should be able to open flat pages
    Given the user is on the bottom of the main page
    When the user clicks flat page on the footer then flat page should be opened
      | hakkimizda         |
      | gizlilik           |
      | kvkk               |
      | kullanim-kosullari |
      | tvreklamlari       |
      | yatirim-haberleri  |
    Then the user clicks iletisim, blog and kariyer then pages should be opened

    #WEB-038
  Scenario: If the user changes the currency, they should return to the vehicle listing page.
    Given the user is on the daily rental
    When search "saw"
    And select date and time from calendar
    And click find button
    And select vendor and car
    And the user changes currency then page currency should be changed
      | euro    |
    And select vendor and car
    And click continuous button
    And the user changes currency then page currency should be changed
      | try    |
    Then the user should be able to see vehicle listing

    #WEB-039
  Scenario: user should be able to click on home page breadcrumb in popular locations
    Given the user is on the popular locations
    When the user goes the "istanbul-istanbul-havalimani"
    Then verify "İstanbul Havalimanı Araç Kiralama" search page open
    And select popular locations breadcrumb 1
    Then verify find button seen main page
    And verify "Lütfen bir alış yeri seçin" message
    And verify open main page


 #WEB-040
  Scenario: user should be able to click on home page breadcrumb in vehicle list page
    Given the user is on the daily rental
    When search "saw"
    And click find button
    And select breadcrumb 1
    Then verify open main page

 #WEB-041
  Scenario: user should be able to click location breadcrumb in vehicle list page
    Given the user is on the daily rental
    When search "saw"
    And click find button
    And select vendor and car
    And select breadcrumb 3
    Then verify "İstanbul Sabiha Gökçen Havalimanı Araç Kiralama" search page open

     #WEB-043
  Scenario: user should be able to change currency after filtering in vehicle list
    Given the user is on the daily rental
    When search "saw"
    And click find button
    When select "Yolcutest" vendor
    And the user changes currency then page currency should be changed
      | euro    |
    Then verify head filter is keeping
    When the user changes currency then page currency should be changed
      | try    |
    Then verify head filter is keeping

    #WEB-044
  Scenario Outline: filtering and date should go back when user clicks back button
    Given the user is on the daily rental
    When search "saw"
    And click find button
    And select random filter
    Then verify the number of filters selected must be 1
    And select random filter
    Then verify the number of filters selected must be 2
    And select random filter
    Then verify the number of filters selected must be 3
    When click back to previous page
    Then verify the number of filters selected must be 2
    And sort by "<price>"
 Examples:
      | price           |
      | En Düşük Fiyat  |



  #WEB-056  #YLC-3052  #YLC-3751
  Scenario: the user should be able to change the language within the campaigns
    Given click all campaigns button
    Then verify open campaign page
    When user select language and verify on campaign page
      |EN|
      |TR|
      |DE|
    And select 3 campaign on all campaign page
    When user select language and verify on campaign detail page
      |EN|
      |TR|
      |DE|

    #WEB-064 YLC-298
  Scenario: Generating title & description for vehicle listing pages
    Given search "saw"
    And click find button
    When the user select filter option then title & description contains selected option
      | vendor        |
      | transmission  |
      | fuel          |
    And the user changes language "EN"
    Then page language should be "EN"
    When the user select filter option then title & description contains selected option
      | vendor        |
      | transmission  |
      | fuel          |
    When the user changes language "DE"
    Then page language should be "DE"
    When the user select filter option then title & description contains selected option
      | vendor        |
      | transmission  |
      | fuel          |

     #WEB-071 YLC-1426 YLC-1482
  Scenario: User can use drop off autocomplete by url
    Given the user is on the daily rental
    Then The Campaigns Page link must also appear in the source code on the home page
    When go to extensions and add environment type "/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/?dropoff=ankara-esenboga-havalimani&from=2022-06-21&pickup_time=10.00&to=2022-06-24&dropoff_time=10.00&pickupTime=10.00"
    Then verify drop off box "Esenboğa" location
    And click pickUp icon
    Then the user should be able to see default daily search

      #WEB-072 YLC-1708
  Scenario: KM bounder text check inside car rental contract
    Given search "saw"
    And select forward date and time from calendar
    And click find button
    When User hover "Toplam Km sınırı" on vehicle detail
    Then User should see detail delivery type
    And select "Greenmotion" vendor
    And Select vehicle in row "1"
    And click car rental contract
    Then verify "KİLOMETRE SINIRI" inside car rental contract

   #WEB-073 YLC-1391
  Scenario: user can search reservation by click empty area after select day then can change date
    Given the user is on the daily rental
    When search "saw"
    When click the language
    And select pick up default date +2 without time
    When click the language
    And select drop up default date +3 without time
    When click the language
    And click find button
    When save first url
    And select pick up default date +4 without time
    When click the language
    And select drop up default date +7 without time
    And the user is on the login dropdown
    And click find button inside reservation page
    And save second url
    Then url should "not be equal"

     #WEB-075 YLC-1530
  Scenario: The user who cleans the filter should see the result within 5 seconds at the most, should not send a request to BE
    Given the user is on the daily rental
    When search "saw"
    And click find button
    And select random filter
    And select random filter
    And select random filter
    And click clear filter button
    Then User should be able to see results in less than 4 seconds without requesting BE

       #WEB-078 YLC-1223
  Scenario: Search Araç Kiralama Kampanyaları on google and verify text
    Given the user is on the daily rental
    When go to url "https://www.google.com/search?q=Ara%C3%A7+Kiralama+Kampanyalar%C4%B1&rlz=1C5GCEM_enTR1012&ei=tIXCYtifA4erxc8Ps-aYeA&ved=0ahUKEwjYyZrlyt74AhWHVfEDHTMzBg8Q4dUDCA4&uact=5&oq=Ara%C3%A7+Kiralama&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBggAEB4QFjIGCAAQHhAWMgYIABAeEBYyBggAEB4QFjIGCAAQHhAWMgYIABAeEBYyBggAEB4QFkoECEEYAEoECEYYAFAAWABg0K2WAmgFcAB4AYABmQKIAasEkgEDMi0ymAEAwAEB&sclient=gws-wiz"
    And select google language "tr"
    Then verify campaign text on google

     #WEB-083 YLC-3670
  Scenario: Even if the user enters wrong url, it should be redirected to the correct url
    When go to extensions and add environment type "/tr/rent-a-car/orly-paris-orly-havaliman-arac-kiralama/"
    Then Verify that URL is not returning 404
    When go to extensions and add environment type "/tr/rent-a-car/madrid-barajas-uluslararas-havalimani-arac-kiralama/"
    Then Verify that URL is not returning 404
    When go to extensions and add environment type "/tr/rent-a-car/nice-nice-havaliman-arac-kiralama/"
    Then Verify that URL is not returning 404
