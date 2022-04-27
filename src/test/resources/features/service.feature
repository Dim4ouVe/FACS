Feature: Select a service and confirm the page loads.




  Scenario: Select Service out of the project
  Given user is login with valid credentials
  When user select Service out of the project
  Then user should see services for all projects



  Scenario: Selecting project and viewing Service
    Given user is login with valid credentials
    When user select Service
    Then user should see all services for the current project

