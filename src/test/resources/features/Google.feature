Feature: Testing google functionalities

  Background:
    Given I navigated to google.com

  Scenario: Happy path Google search functionality
    When I search for Techtorial Academy
    Then I get more than 1000 results

  Scenario: Google search negative scenario
    When I search for "kladjfladdlkfjdklajf"
    Then I should get 0 results








