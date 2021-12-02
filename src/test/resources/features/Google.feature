@regression
Feature: Testing google functionalities

  Background:
    Given I navigated to google.com
  @smoketest @random @newScenario
  Scenario: Happy path Google search functionality
    When I search for Techtorial Academy
    Then I get more than 10 results

  Scenario: Google search negative scenario
    When I search for "kladjfladdlkfjdklajf"
    Then I should get 0 results








