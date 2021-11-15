package RestApi_tests;


import UserRestApi.UserCreation.InvalidUser;
import UserRestApi.UserCreation.ErrorMessage;
import Users.UserCreation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class CreateUser {
    ErrorMessage root = new ErrorMessage();
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    UserCreation userCreation = new UserCreation() {{
        setEmail("qa05qa@mail.ru");
        setPassword("qa05qa05");
        setRepeat_password("qa05qa05");
    }};
    InvalidUser invalidUser = new InvalidUser() {{
            setEmail(Collections.singletonList("test@test.com"));
            setPassword(Collections.singletonList("qa05qa05"));
            setRepeat_password(Collections.singletonList("qa05qa05"));
        }};
        @Test()
        public void createUser_test() throws JsonProcessingException {
            baseURI = "https://profile.onliner.by";
            String endpoint = ("/sdapi/user.api/registration");
            given().when().body(mapper.writeValueAsString(userCreation)).
                    when().header("Content-Type", "application/json")
                    .post(endpoint).then().statusCode(HttpStatus.SC_CREATED).extract().response();
        }
//не могу получить ассерт на еррор
        @Test()
        public void createInvalidUser_test() throws JsonProcessingException {
            baseURI = "https://profile.onliner.by";
            String endpoint = ("/sdapi/user.api/registration");
            Response response = given().when().body(mapper.writeValueAsString(invalidUser)).
                    when().header("Content-Type", "application/json")
                    .post(endpoint).then().statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY).extract().response();
             gson.fromJson(response.asPrettyString(), JsonObject.class);
             Assert.assertEquals(root.errors,"E-mail находится в черном списке");
        }
    }