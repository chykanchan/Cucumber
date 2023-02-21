Feature: To test Login functionality

  Scenario: Login as ROPU user
    Given User is in login page   
    When User gives username and password
    And User clicks on login
    Then Login is succesfull
    
   