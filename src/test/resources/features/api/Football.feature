Feature: Testing football api

  @football
  Scenario: Find competition id
    Given I have football competition endpoint
    When I send GET request to retrieve list of competitions
    Then status code should be 200
    And competitions list must more than 0