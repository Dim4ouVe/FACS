@Regression @smoke
Feature: Select a service and confirm the page loads.


  Scenario: Select Service out of the project
    Given user is login with valid credentials
    When user select "Test Project" from the dropdown menu
    And user select "RFI" from Service dropdown menu
    Then user should see "RFI" service page page



  Scenario Outline: Select Service out of the project
    Given user login with "qaqc" "support@facsware.com" and "gogiants"
    When user select "<project>" from the dropdown menu
    #this an example of a data table, those values bellow can be used in a test step
    Then assert services dropdown contains services from the datatable
      | BMP Inspection             |
      | Archive                    |
      | BMP Monthly Compliance |
      | Change Order               |
      | FileCabinet                |
      | Liquidated Damages         |
      | Materials On Hand          |
      | Material Tracking          |
      | Pay Estimate               |
      | RFI                        |
      | Sample Card Concrete Grout |
      | Sample Card Field Test     |
      | Submittal                  |
      | Work Report                |
      | WSWD                       |
      | Material Acceptance        |
      | Test Browser               |
      | Widget Test                |




    Examples:
      | project               |
      | Test Project          |
      | Plangrid Test Project |


