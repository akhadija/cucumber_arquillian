Feature: search "arquillian" on google

  @SearchArquillian
  Scenario: search "arquillian" on google
    Given the user on google page
    When the user inputs "arquillian" int the search box
    And the user clicks on search button
    Then the results page should be displayed
