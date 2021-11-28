package step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OpenMRSHomePage;
import utils.Driver;

import java.util.Map;

public class OpenMRSStepDefs {

    WebDriver driver;
    OpenMRSHomePage openMRSHomePage;

    @Given("I'm logged in to OpenMRS with following credentials:")
    public void i_m_logged_in_to_open_mrs_with_following_credentials(DataTable dataTable) {
        Map<String, String> userNamePasswordMap = dataTable.asMap();
        String username = userNamePasswordMap.get("username");
        String password = userNamePasswordMap.get("password");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        driver = Driver.getDriver();
        driver.get("https://demo.openmrs.org/openmrs/referenceapplication/login.page");

        openMRSHomePage = new OpenMRSHomePage();
        openMRSHomePage.signIn(username, password);

    }

    @When("I register a new patient with following info:")
    public void registerNewPatient(DataTable dataTable) {
        Map<String, String> patientInfoMap = dataTable.asMap();
        String givenName = patientInfoMap.get("GivenName");
        String familyName = patientInfoMap.get("FamilyName");

        System.out.println("Given name: " + givenName);
        System.out.println("Family name: " + familyName);

    }

    @Given("I'm logged in to OpenMRS with admin and Admin123")
    public void i_m_logged_in_to_open_mrs_with_admin_and_admin123() {

    }

    @When("I register a new patient with {string}, {string}, {string}, {int}, {string}, {int}, {string} and {int}")
    public void i_register_a_new_patient_with_jerry_white_male_chicago_and(String firstName, String lastName,
                                                                           String gender, Integer day, String month,
                                                                           Integer year, String city, Integer phone) {

        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Phone number: " + phone);

    }


}
