package api.delete;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utils.Constants;
import utils.PayloadUtils;

public class DeletePet {

    @Test
    public void deletePetTest() throws InterruptedException {

        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";

        //pre-creating a pet, to be able to delete
        RestAssured.given()
                .accept(Constants.APPLICATION_JSON)
                .contentType(Constants.APPLICATION_JSON)
                .body(PayloadUtils.
                        getPetPayload("716767", "Hatiko", "waiting"))
                .when().post()
                .then().statusCode(200).contentType(Constants.APPLICATION_JSON);

        Thread.sleep(2000);
        //deleting a pet
        //https://petstore.swagger.io/v2/pet/{petId}
        RestAssured.given()
                .accept(Constants.APPLICATION_JSON)
                .when().delete("716767")
                .then().statusCode(200).contentType(Constants.APPLICATION_JSON).log().body();

        //validing get call returns 404(NOT FOUND)
        RestAssured.given()
                .accept(Constants.APPLICATION_JSON)
                .when().get("716767")
                .then().statusCode(404).contentType(Constants.APPLICATION_JSON)
                .body("message", Matchers.is("Pet not found"));

    }




}
