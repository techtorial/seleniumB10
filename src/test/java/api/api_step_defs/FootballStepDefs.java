package api.api_step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.Constants;

import java.util.List;
import java.util.Map;

public class FootballStepDefs {
    Response response;

    @Given("I have football competition endpoint")
    public void i_have_football_competition_endpoint() {
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "v2/competitions/";
    }

    @When("I send GET request to retrieve list of competitions")
    public void i_send_get_request_to_retrieve_list_of_competitions() {
        response = RestAssured.given()
                .accept(Constants.APPLICATION_JSON)
                .header("X-Auth-Token", "c55b7a64e8424d46a52051bce36d1c0a")
                .when().get();
    }

    @Then("status code should be {int}")
    public void statusCodeValidation(int expectedStatusCode) {
        int actualStatusCode = response.statusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }

    @Then("competitions list must more than {int}")
    public void competitions_list_must_more_than(int sizeOfCompetitionList) {
        List<Map<String, Object>> competitions = response.jsonPath().getList("competitions");
        Assert.assertTrue(competitions.size() > sizeOfCompetitionList);

    }

}
