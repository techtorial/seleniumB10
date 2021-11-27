Feature: Testing google functionalities

  Scenario: Happy path Google search functionality
    Given I navigated to google.com
    When I search for Techtorial Academy
    Then I get more than 1000 results