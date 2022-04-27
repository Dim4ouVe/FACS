Feature: Creating/editing an Entry.



  Scenario: Select a project, select a service, create a new entry ("New" button).
    Given user is login with valid credentials
    When user select project from the dropdown menu
    And user select BMP Inspection from Service
    And user select New
    Then entry ID will appear in the URL
    And page should load without errors
    And entry should exist in the selected project's Service listing


  Scenario: Delete the entry you created.
    Given user is login with valid credentials
    When user select project from the dropdown menu
    And user select BMP Inspection from Service
    And user select New
    And user go back to the list and delete his entry
    Then entry user create should be deleted

