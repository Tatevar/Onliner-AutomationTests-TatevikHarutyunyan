package ProductCatalog;
import Driver.BaseTestSelenide;
import SelenidePages.Basket;
import SelenidePages.Catalog;
import SelenidePages.Home;
import UserRestApi.DeleteProduct.Position;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;;
import java.util.Arrays;
import java.util.List;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import UserRestApi.DeleteProduct.Root;
import UserRestApi.AddProduct.Login;
import UserRestApi.AddProduct.NewProduct;

public class BasketTest extends BaseTestSelenide {

    String token;
    Gson gson = new Gson();
    ObjectMapper mapper = new ObjectMapper();
    Login login = new Login() {{
        setLogin("tatevar93@gmail.com");
        setPassword("onlinertest");
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
        baseURI = "https://catalog.onliner.by/";
        String response = given().when().body(mapper.writeValueAsString(login)).and().header("Content-Type", "application/json").when().post("/sdapi/user.api/login").getBody().asPrettyString();
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        token = jsonObject.get("access_token").getAsString();
    }

    @Test(priority = 1)
    public void addProductToBasket() throws JsonProcessingException, InterruptedException {
        baseURI = "https://cart.onliner.by/";
        Response response = given().when().body(mapper.writeValueAsString(newProduct))
                .header("Authorization", "Bearer " + token)
                .and().contentType(ContentType.JSON)
                .when().post("sdapi/cart.api/positions");
        JsonObject jsonObject = gson.fromJson(response.asPrettyString(), JsonObject.class);
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(jsonObject.get("shop_id").toString().replace("\"", ""), "19151");
    }

    @Test(priority = 2)
    public void deleteAProduct_test() throws JsonProcessingException {
        baseURI = "https://cart.onliner.by";
        String endpoint = "sdapi/cart.api/positions";
        Response response = given().when().body(mapper.writeValueAsString(root))
                .and().header("Authorization", "Bearer " + token)
                .and().contentType(ContentType.JSON).delete(endpoint);
        Assert.assertEquals(response.statusCode(), 204);
        get(Catalog.class)
         .clickBasketBtn();
        get(Basket.class)
                .checkProductsAreNotDisplayed();

    }
}
