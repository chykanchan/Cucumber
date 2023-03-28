Feature: feature to test Ropu User is able to complete Ropu Process.
@smoke
Scenario: Ropu User should be able to complete the ROLD Process.
    Given User is logged in as Ropu User
    When User Opens Existing ROLD Case
    And selects Best date in ePAF Submission Date  Column.
    And selects Base date in ePAF Submission Date Column.
    And selects Acheived date in ePAF Submission Date Column.
    And clicks on Not Applicable checkbox of P&R Dossier Submission Date Column.
    And clicks on Not Applicable checkbox of Cut Off Date for IPR Column.
    And clicks on Not Applicable checkbox of Official Price Publication for unreimbursed launch Date Column.
    And clicks on Not Applicable checkbox of Official Price Publication for reimbursed launch Column.
    And clicks on Not Applicable checkbox of Unreimbursed Launch Date Column.
    And clicks on Not Applicable checkbox of Reimbursed Launch Date Column.
    And Ropu User clicks on Complete button.