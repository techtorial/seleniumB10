package api.post;

import api.pojo.PetPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PayloadUtils;

import java.io.File;

public class CreatePet {


    @Test
    public void createTest1() {
//        https://petstore.swagger.io/v2/pet
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";

        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(PayloadUtils.getPetPayload("8788", "Zippi", "funny"))
                .when().post()
                .then().statusCode(200)
                .and().contentType("application/json").log().all().extract().response();

    }

    @Test
    public void createPet2() {

        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";


        File petJson = new File("src/test/resources/payloads/pet.json");
        Response response = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .body(petJson)
                .when().post()
                .then().statusCode(200)
                .contentType("application/json").log().all().extract().response();

        PetPojo parsedPostResponse = response.as(PetPojo.class);
        Assert.assertEquals(parsedPostResponse.getId(), 100910);
        Assert.assertEquals(parsedPostResponse.getName(), "pet from json file");
        Assert.assertEquals(parsedPostResponse.getStatus(), "don't touch");
    }

    @Test
    public void createPet3() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";

        PetPojo petPojo = new PetPojo();

        petPojo.setId(878934);
        petPojo.setName("pet from java object");
        petPojo.setStatus("created by java automation");

        RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .body(petPojo)
                .when().post()
                .then().statusCode(200)
                .and()
                .contentType("application/json")
                .log().all();
    }

}
