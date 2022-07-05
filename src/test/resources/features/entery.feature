@Regression
Feature: CRUD an Entry.


  #create an entry
@wip
  Scenario: Select a project, select a service, create a new entry ("New" button).
    Given user is login with valid credentials
    When user select "Test Project" from the dropdown menu
    And user select "RFI" from Service dropdown menu
    And user press "New" button
    Then assert "RFI No" is empty
    And assert "Description" field is empty

   #edit an entry
  @wip
  Scenario: Select a project, select a service, edit entry ("Edit" button).
    Given user is login with valid credentials
    When user select "Test Project" and select "RFI" from Service dropdown menu
    And user select last created entry
    And user press "Open" button
    And enter information on the fields below
      | RFI No                  |
      | Date Received           |
      | Description             |
      | Action                  |
      | Date of Response        |
      | Date to Contractor      |
      | Description of Response |
    And click on "From" dropdown menu and select "Facs rep"
    And add comments
    And attach a file to a reference from the file cabinet
    Then assert save-status is "All changes saved"


    #delete an entry
  @wip
  Scenario: Select a project, select a service, delete an existing entry ("Delete" button).
    Given user is login with valid credentials
    When user select "Test Project" from the dropdown menu
    And user select "RFI" from Service dropdown menu
    And user select entry from the listing
    And user press "Delete" button
    Then assert entry is deleted







