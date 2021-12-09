package api.get;

import api.pojo.RatesPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Rates {

    @Test
    public void ratesTest() {
        RestAssured.baseURI = "http://rates.akchabar.kg";
        RestAssured.basePath = "get.json";
        Response response = given().accept("application/json")
                .when().get()
                .then().statusCode(200)
                .and()
                .contentType("application/json").extract().response();

        RatesPojo deserializedRatesResponse = response.as(RatesPojo.class);
        Assert.assertEquals(deserializedRatesResponse.getDate(), "19.01.2021");
        Assert.assertEquals(deserializedRatesResponse.getRates().get("btc"), "3080263.948713");

    }


}
