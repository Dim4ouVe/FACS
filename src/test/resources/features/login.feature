@FACS6-2528 @Regression
Feature: (Automation) Login to the portal
  As a user
  I want to login to the portal
  So that I can access the portal

	#User should be able to log in successfully to the portal using right credential
  @TEST_FACS6-2529 @Smoke
  Scenario: (Automation) Login to the portal with valid credentials
    Given user is on the home page
    When user enter valid portal, username and password
    #Then user should see be directed to main page and see the projects


		#user should be able to login to the portal right credentials
  @TEST_FACS6-2530
  Scenario: (Automation) Login to the portal with invalid credentials
    Given user is on the home page
    When user enter invalid portal, username and password
    Then user should see error message



    #this is an example of a data driven test, the table in the example is the data source, another way is to user excel table
  @test
  Scenario Outline: (Automation) Login to the portal with multiple valid credentials
    Given user is on the home page
    When user login with "<portal>" "<email>" and "<password>"
    Then assert dashboard "Projects" header is displayed
    And assert select project dropdown is displayed
    And assert search box is displayed
    And assert company name is "<portal>"

    Examples:
      | portal | email                | password |
      | QAQC   | support@facsware.com | gogiants |
      | HDOT   | support@facsware.com | gogiants |