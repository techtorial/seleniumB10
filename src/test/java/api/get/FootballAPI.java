package api.get;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;

import java.util.List;
import java.util.Map;

public class FootballAPI {

    @Test
    public void getPremierLeagueTest() {
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "v2/competitions/";

        //get list of all competition
        Response response = RestAssured.given()
                .accept(Constants.APPLICATION_JSON)
                .header("X-Auth-Token", "c55b7a64e8424d46a52051bce36d1c0a")
                .when().get()
                .then()
                .statusCode(200)
                .contentType(Constants.APPLICATION_JSON)
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<Map<String, ?>> competitionList = jsonPath.getList("competitions");
        for (int i = 0; i < competitionList.size(); i++) {
            Map<String, ?> competitionMap = competitionList.get(i);
            if (competitionMap.get("name").equals("Premier Liga")) {
                int id = (int) competitionMap.get("id");
                Assert.assertEquals(id, 2035);
            }
        }
    }

    @Test
    public void getPremierLeagueTest2(){
        RestAssured.baseURI = "http://api.football-data.org";
        RestAssured.basePath = "v2/competitions/";

        //get list of all competition
        Response response = RestAssured.given()
                .accept(Constants.APPLICATION_JSON)
                .header("X-Auth-Token", "c55b7a64e8424d46a52051bce36d1c0a")
                .when().get()
                .then()
                .statusCode(200)
                .contentType(Constants.APPLICATION_JSON)
                .body("competitions.find { it.name == 'Premier Liga' }.id", Matchers.equalTo(2035))
                .extract().response();

        int competitionId = response.path("competitions.find { it.name == 'Premier Liga' }.id");
        System.out.println(competitionId);
        Assert.assertEquals(competitionId, 2035);
    }


}
