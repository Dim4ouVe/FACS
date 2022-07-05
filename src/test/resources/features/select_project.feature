@FACS6-2522 @Regression
Feature: (Automation) Selecting Project

	#User should be able to select project from the *Project* dropdown
  @TEST_FACS6-2531 @Smoke
  Scenario: (Automation) Selecting Project
    Given user is login with valid credentials
    When user select "Test Project" from the dropdown menu
    Then user should be able to see 90 in the url




    Scenario: Unselecting a project (returning to the portal homepage once a project has been selected).
      Given user is login with valid credentials
      When user click on company name logo
      Then user should see "Projects" header is displayed