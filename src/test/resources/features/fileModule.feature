Feature: As a user, I should be able to access to Files module.

  Scenario: verify users can access to Files module
    Given user on the dashboard page
    When the user clicks the "Files" module
    Then verify the page title is "Files - Trycloud QA."

  Scenario: verify users can select all the uploaded files from the page
    Given user on the dashboard page
    When the user clicks the "Files" module
    And user click the top-left checkbox of the table
    Then verify all the files are selected


  Scenario: Verify users to add files to Favorites
    Given user on the dashboard page
    When the user clicks the "Files" module
    When the user clicks action-icon from any file on the page
    And user choose the "Add to favorites" option
    And user click the "Favorites" sub-module on the left side
    Then Verify the chosen file is listed on the table