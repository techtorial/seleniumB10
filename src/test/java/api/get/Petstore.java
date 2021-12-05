package api.get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Petstore {


    @Test
    public void getIntro() {
        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get("https://petstore.swagger.io/v2/pet/1")
                .then().statusCode(200).extract().response();


        Map<String, Object> deserializedResponse = response.as(new TypeRef<Map<String, Object>>() {});

        deserializedResponse.get("name");  // => Object

//        System.out.println(deserializedResponse);



        ArrayList<Map<String,Object>> tagsValue = (ArrayList<Map<String,Object>>)deserializedResponse.get("tags");



        System.out.println(deserializedResponse.get("tags"));
//        System.out.println(deserializedResponse.get("name"));
    }


}
