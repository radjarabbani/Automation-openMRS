Feature: Homepage

  Scenario: User will see the patient list and detail
    Given User is on login page
    And User fill username with credential "admin"
    And User click button continue
    And User fill password with credential "Admin123"
    And User click login
    Then User is on home page
    And User click the detail of patient
    And User see the detail information of patient

  Scenario: User will see the patient list and detail
    Given User is on login page
    And User fill username with credential "admin"
    And User click button continue
    And User fill password with credential "Admin123"
    And User click login
    Then User is on home page
    And User click dropdown of patient
    And User see data dropdown of patient