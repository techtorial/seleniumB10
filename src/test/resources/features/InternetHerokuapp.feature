Feature: Herokuapp tests

  @outline
  Scenario Outline: Test 5 links of herokuapp
    Given user navigated to HerokuApp home page
    When user clicks on "<link>"
    Then user should see "<page header>"

    Examples:
      | link            | page header     |
      | File Download   | File Downloader |
      | Hovers          | Hovers          |
      | Redirect Link   | Redirection     |
      | Frames          | Frames          |
      | Forgot Password | Forgot Password |


    @datatable
  Scenario: Validate checkbox text and checkbox statuses
    When user navigates to Checkboxes page
    Then user should see checkboxes as follows:
      | checkbox1Text   | checkbox 1 |
      | checkbox2Text   | checkbox 2 |
      | checkBox1Status | unchecked  |
      | checkBox2Status | checked    |

