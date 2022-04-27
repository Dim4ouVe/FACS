Feature: Selecting a project



  Scenario: Using the project selector at the top of the page (once logged in).
    Given user is login with valid credentials
    When user select project from the dropdown menu
    Then user should be able to see reports


    Scenario: Unselecting a project (returning to the portal homepage once a project has been selected).
      Given user is login with valid credentials
      When user click on QAQC
      Then user should see projects