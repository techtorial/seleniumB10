Feature: Open MRS tests

  @ignore @badScenario @notRun @forgetAboutMe
  Scenario: Register a patient
    Given I'm logged in to OpenMRS with following credentials:
      | username | admin    |
      | password | Admin123 |
    When I register a new patient with following info:
      | GivenName  | John             |
      | FamilyName | Smith            |
      | Gender     | Male             |
      | Day        | 1                |
      | Month      | January          |
      | Year       | 1999             |
      | Address    | 2200 E Devon ave |
      | Phone      | 3123123123       |

  @smoketest
  Scenario Outline:
    Given I'm logged in to OpenMRS with "<username>" and "<password>"
    When I register a new patient with "<GivenName>", "<FamilyName>", "<Gender>", <Day>, "<Month>", <Year>, "<Address>" and <Phone>

    Examples:
      | GivenName | FamilyName | Gender | Day | Month   | Year | Address | Phone   | username | password |
      | Jerry     | White      | Male   | 11  | January | 1963 | Chicago | 1234533 | admin    | Admin123 |
      | Sarah     | Green      | Female | 31  | March   | 1969 | Chicago | 1234531 | admin    | Admin123 |



    @test
    Scenario:  Test scenario
      When I test OpenMRS
      Then test passes







