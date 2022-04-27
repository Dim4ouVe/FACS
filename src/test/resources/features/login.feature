Feature: Logging into the portal

  As a user
  I want to sign in to application with valid email and password
  So that I can navigate to Home Page

 @smoke
  Scenario: Login with valid credentials
    Given user is on the home page
    When user enter valid portal, username and password
    Then user should see be directed to main page and see the projects

  Scenario: Login with invalid credentials
    Given user is on the home page
    When user enter invalid portal, username and password
    Then user should see error message

