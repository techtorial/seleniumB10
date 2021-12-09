package api.get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class GameOfThrones {


    // https://api.got.show/api/show/characters
    @Test
    public void snowHouse() {

        RestAssured.baseURI = "https://api.got.show";
        RestAssured.basePath = "api/show/characters";

        Response response = RestAssured.given().header("Accept", "application/json")
                .when().get()
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().response();

        List<Map<String, Object>> charactersList = response.as(
                new TypeRef<List<Map<String, Object>>>() {
                });

        for (int i = 0; i < charactersList.size(); i++) {

            Map<String, Object> characterMap = charactersList.get(i);
            String characterName = String.valueOf(characterMap.get("name"));
            String characterName2 = ""+characterMap.get("name");
            if (characterName.equals("Jon Snow")){
                System.out.println("Character name: " + characterName);
                System.out.println("Character name2: " + characterName2);
                System.out.println(characterMap.get("house"));
            }





        }


    }


}
