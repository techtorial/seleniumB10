package api.post;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PayloadUtils;

import java.util.Map;

import static utils.Constants.APPLICATION_JSON;


public class SlackMessage {


    @Test
    public void sendMessageTest() {
        RestAssured.baseURI = "https://slack.com";
        RestAssured.basePath = "api/chat.postMessage";

        Response response = RestAssured.given()
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .body(PayloadUtils.getSlackPayload())
                .header("Authorization",
                        "Bearer ")
                .when().post()
                .then().statusCode(200).contentType(APPLICATION_JSON + "; charset=utf-8")
                .and()
                .body("ok", Matchers.equalTo(true))
                .body("channel", Matchers.is("C02QAME99B7"))
                .body("message.type", Matchers.is("message"))
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        String channelName = jsonPath.getString("channel");

        Map<String, Object> message = jsonPath.getMap("message");


        String text = jsonPath.getString("message.text");

        Assert.assertEquals(text, "Temirlan: hello world");


    }


    @Test
    public void getListOfMessagesTest(){
        //https://slack.com/api/conversations.history?channel=C02QAME99B7
        RestAssured.baseURI = "https://slack.com";
        RestAssured.basePath = "api/conversations.history";

        Response response = RestAssured.given()
                .accept(APPLICATION_JSON)
                .header("Authorization",
                        "Bearer ")
                .param("channel", "C02QAME99B7")
                .when().get()
                .then().statusCode(200)
                .contentType(APPLICATION_JSON + "; charset=utf-8")
                .body("ok", Matchers.equalTo(true))
                .extract().response();


        JsonPath jsonPath = response.jsonPath();


        String botId = jsonPath.getString("messages[0].bot_id");

        Assert.assertEquals(botId, "B02Q6U38Y94");


    }


}
