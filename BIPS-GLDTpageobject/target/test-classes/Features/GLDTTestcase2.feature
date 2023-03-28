
Feature: RA user is able to initiate ROPU process
@smoke
  Scenario: Login as RegulatoryAffairs user
  Given User login as RA user
    And User clicks on GLDT parentcase id
    And User selects  best Submission date
    And User selects  base Submission date
    And User selects  Achieved Submission date
    And User clicks on Not Applicable check box in Approval Date column.
    When User clicks on Initiate ROPU Process button.
    And User clicks on Ok in the pop up dialog.
    And User clicks on complete button
    And User clicks on close button
    Then ROPU process intiated and loggedout
   
    

  
