
Feature: feature to test Tamamanager is able to Initiate RA Process
@smoke
  Scenario: Login as TamaManager
    Given User is in login page
    And User Gives valid username and password
    And User click on Initiate Tab
    And User clicks on GLDT_Module
    When User Enters product
    And User Enters reason
    And User Enters region
    And User Enters ropu
    And User Enters country
    And User Clicks on Initiate RA Process
    And User Clicks on Continue
    Then Initialisation need to be completed and logout
 
    