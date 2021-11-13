package Authorization;

import Patterns.UserCreation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class CreateUser {

    String token;
Use
    {
        {
            userCreation.setEmail("tatevar93@gmail.com");
            userCreation.setPassword("onlinertest");
        }
    }

    @BeforeTest
    public void preconditions()  {
        Gson gson = new Gson();
        baseURI = "https://www.onliner.by";
        String response = given().when().body(userCreation)
                .and().header("Content-Type", "application/json; charset=utf-8")
                .when().post("/sdapi/user.api/login")
                .getBody().asPrettyString();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        System.out.println(token = String.valueOf(jsonObject.get("access_token")));
    }

    @Test()
    public void test() {
        baseURI = "https://cart.onliner.by";
        given().when().header("Authorization", "Bearer " + token).and().header("Content-Type", "application/json; charset=utf-8").get("/sdapi/cart.api/orders").prettyPrint();
    }
}
