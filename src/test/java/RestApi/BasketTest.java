package RestApi;
import Driver.BaseTestSelenide;
import SelenidePages.Basket;
import SelenidePages.Catalog;
import SelenidePages.Home;
import SelenidePages.UserData;
import UserRestApi.DeleteProduct.Position;
import Users.UserBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import UserRestApi.DeleteProduct.Root;
import UserRestApi.AddProduct.Login;
import UserRestApi.AddProduct.NewProduct;

public class BasketTest extends BaseTestSelenide{

    String token;
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    Login login = new Login() {{
        setLogin("qa07qa@mail.ru");
        setPassword("qa07qa07");
    }};
    NewProduct newProduct = new NewProduct() {{
        setQuantity(1);
        setPosition_id("19151:2249476001");
        setShop_id(19151);
        setProduct_id(2249476);
        setProduct_key("myaa2");
    }};
    Position position = new Position() {{
        setPosition_id("19151:2249476001");
        setShop_id(19151);
        setProduct_id(2249476);
    }};
    List<Position> list = Arrays.asList(position);
    Root root = new Root() {{
        setPositions(list);
    }};

    @BeforeTest
    public void preconditions() throws JsonProcessingException {
        baseURI = "https://www.onliner.by";
        String response = given().when().body(mapper.writeValueAsString(login))
                .and().header("Content-Type", "application/json")
                .when().post("/sdapi/user.api/login").getBody()
                .asPrettyString();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        token = jsonObject.get("access_token").getAsString();
    }
    @Test()
    public void AddProductToBasket_test() throws JsonProcessingException, InterruptedException {
        baseURI = "https://cart.onliner.by/";
        Response response = given().when().body(mapper.writeValueAsString(newProduct))
                .header("Authorization", "Bearer " + token)
                .and().header("Content-Type", "application/json")
                .when().post("sdapi/cart.api/positions");
        Assert.assertEquals(response.statusCode(), 201);
        get(Home.class).clickLoginbtn();
        UserBuilder user = UserBuilder
                .builder()
                .email("qa07qa@mail.ru")
                .password("qa07qa07")
                .build();
        get(UserData.class)
                .loginWithUserData(user);
        get(Home.class)
                .clickBasketBtn();
        get(Basket.class)
                .checkProductsDisplayed();
    }
    @Test(priority = 2)
    public void deleteAProduct_test() throws JsonProcessingException {
        baseURI = "https://cart.onliner.by";
        String endpoint = "sdapi/cart.api/positions";
        Response response = given().when().body(mapper.writeValueAsString(root))
                .and().header("Authorization", "Bearer " + token)
                .and().header("Content-Type", "application/json").delete(endpoint);
        Assert.assertEquals(response.statusCode(), 204);
        get(Home.class).clickLoginbtn();
        UserBuilder user = UserBuilder
                .builder()
                .email("qa07qa@mail.ru")
                .password("qa07qa07")
                .build();
        get(UserData.class)
                .loginWithUserData(user);
        get(Home.class)
                .clickBasketBtn();
        get(Basket.class)
                .checkProductsAreNotDisplayed();

    }
    @AfterMethod
    public void post() {
        closeWebDriver();
    }
}

