Feature: Amazon most important features testing

  Scenario: Positive scenario for amazon search
    When I navigate to Amazon home page
    And I search for iphone 13 case
    Then I should get more than 20 results
    And I validate the search result number