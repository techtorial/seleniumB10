package api.put;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utils.PayloadUtils;

import static utils.Constants.APPLICATION_JSON;

public class UpdatePet {

    @Test
    public void updatePetTest(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";

        RestAssured.given()
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .body(PayloadUtils.
                        getPetPayload("89789", "Zeus", "lucky"))
                .when().put()
                .then()
                .statusCode(200)
                .contentType(APPLICATION_JSON)
                .body("id", Matchers.equalTo(89789))
                .body("name", Matchers.is("Zeus"));






    }






}
