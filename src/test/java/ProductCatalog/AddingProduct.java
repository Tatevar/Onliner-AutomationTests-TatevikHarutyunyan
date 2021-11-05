package ProductCatalog;

import Driver.BaseTest;
import Driver.BaseTestSelenide;
import PageFactory.Registration;
import PageObject.HomePage;
import PageObject.LoginPage;
import Patterns.UserCreation;
import SelenidePages.HomePageSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddingProduct extends BaseTestSelenide {
    @Test
    public void verifyTestimonialsPage_Test() {
        get(HomePageSelenide.class).openProduct();
    }
}