@smokeYLC @login
Feature: Login and User account functions

  Background:
    When the user changes language "TR"
    Given the user is on the login dropdown

    #WEB-003
  Scenario: User can register
    When click the register
    And enter the personal information
    And click Membership agreement
    And click registerButton
    Then the user should be able to register

   #WEB-003.1    #üyelik sözleşmesi imzalanmalı texti kontrol edilecek
  Scenario: User can not register without membership agreement
    When click the register
    And enter the personal information
    And click registerButton
    Then the user should not able to register

   #WEB-003.2       #geçersiz eposta texti kontrol edilecek
  Scenario Outline: User can not register via invalid information
    When click the register
    And enter the invalid "<e-mail>" and "<password>" information
    And click Membership agreement
    And click registerButton
    Then the user should not able to register
    Examples:
      |e-mail          |password   |
      |edasd@asdcom    |Aasdf1234  |

    #WEB-004
  Scenario:  Registered user should be able to login and logout
    When the user enter valid credentials
    Then the user should be able to login
    And user click logout
    Then the user should be able to logout

   #WEB-005
  Scenario: Registered user should be able to use forgot password function
    When the registered user click forgot password button
    And send e-mail
    And click forgot password button
    Then the user should be able to receive forgot password mail

     #WEB-006
  Scenario: Registered user should be able to update his account information
    When the user enter valid credentials
    Then the user should be able to login
    When click account button
    Then user should see account page
    And verify open "Sürücü Bilgileri" page
    And the user should be able to update account information
    And the user should save address information
    And the user should click permission information
    And the user should save permission save
    When user click logout
    Then the user should be able to logout

    #WEB-007.1
  Scenario: Registered user should be able to see past reservations
    When the user enter valid credentials
    Then the user should be able to login
    When click account button
    And click past reservations
    Then verify open "Geçmiş Rezervasyonlarım" page
    And past reservations should be shown

    #WEB-007.2
  Scenario: Registered user should be able to see empty past reservations
    When user enters valid credentials with non-reservation
    Then the user should be able to login
    When click account button
    And click past reservations
    Then verify open "Geçmiş Rezervasyonlarım" page
    And past reservations should be shown but result should be empty

    #WEB-008
  Scenario: Registered user can change account password
    When the user enter valid credentials
    Then the user should be able to login
    When click account button
    And click change password button
    Then verify open "Şifre Değiştirme" page
    When the user should be able to change password
    Then verify update message

 #WEB-031.1
  Scenario Outline: Registered user should not be able to login
    When Enters "<username>" and enters invalid "<Password>"
    Then Users should see "Bilinmeyen kullanıcı veya eşleşmeyen şifre." message
    Examples:
      |username         |Password        |
      |qa2@yolcu360.com |asd             |
      |qa2@yolcu360.com |UserUser123     |

     #WEB-031.2
  Scenario Outline: Empty user credential for negative Scenario
    When Enters "<username>" and enters invalid "<Password>"
    Then Users should see "Bu alanın doldurulması zorunludur." message
    Examples:
      |username                 |Password        |
      |qa2@yolcu360.com         |                |
      |                         |Qa12345678      |

     #WEB-031.3
  Scenario Outline: Valid EMail must contains "@" and "." and char
    When Enters "<username>" and enters invalid "<Password>"
    Then Users should see "Lütfen geçerli bir e-posta adresi giriniz." message
    Examples:
      |username         |Password      |
      |qa2yolcu360.com  |Qa12345678    |
      |qa2@yolcu360com  |Qa12345678    |
      |qa2@yolcu360.    |Qa12345678    |

    #WEB-032
  Scenario Outline: Registered user can not change account password
    When the user enter valid credentials
    Then the user should be able to login
    When click account button
    And click change password button
    Then verify open "Şifre Değiştirme" page
    And Enter invalid "<password>"  and "<confirmation password>"
    Then Users should see "<error message>"
    Examples:
      |password      |confirmation password |error message                                                                           |
      |Yol           |Yol                   |Şifreniz 8-15 karakter arasında olmalıdır, 1 büyük , 1 küçük harf ve rakam içermelidir. |
      |Yolcu360      |Yolcu36               |Girilen şifreler uyuşmuyor.                                                             |

    #WEB-067  #YLC-1372
  Scenario Outline: Register emailBox can fix Turkish character and accept email address consist (-)
    When click the register
    And enter the "<e-mail>" and "<password>" information
    Then Register emailBox should be able to fix Turkish character
    And emailBox should be accept email address consist (-)
    Examples:
      |e-mail           |password   |
      |çğüı@as-d.com    |Aasdf1234  |

    #WEB-068  #YLC-1372
  Scenario Outline: Login emailBox can fix Turkish character and accept email address consist (-)
    When click the signin
    And enter the "<e-mail>" and "<password>" information on Login Page
    Then Login emailBox should be able to fix Turkish character on Login Page
    And emailBox should be accept email address consist (-)
    Examples:
      |e-mail           |password   |
      |çğüı@as-d.com    |Aasdf1234  |

    #WEB-070  #YLC-1372
  Scenario Outline: Reservation Search emailBox can fix Turkish character and accept email address consist (-)
    Given the user is on the find reservation box
    When the user enters "<reservation no>" and "<email>" on Reservation Search
     Then Reservation emailBox should be able to fix Turkish character
    And emailBox should be accept email address consist (-)
    Examples:
      | reservation no | email              |
      | R_A1ZV         | çğüı@as-d.com      |


