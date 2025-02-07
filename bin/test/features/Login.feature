Feature: Login Sauce Demo

  Scenario: Login scenario infokes demo
    Given User is on login page
    And User fill username with credential "admin"
    And User click button continue
    And User fill password with credential "Admin123"
    And User click login
    Then User is on home page

  Scenario: Login with incorrect credentials infokes demo
    Given User is on login page
    And User fill username with credential "admin"
    And User click button continue
    And User fill password with credential "Ad1111"
    And User click login
    And User see restriction invalid credential
