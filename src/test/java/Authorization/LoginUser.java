package Authorization;

import Driver.BaseTestSelenium;
import Driver.DriverCreation;
import PageFactory.Registration;
import PageObject.HomePage;
import PageObject.LoginPage;
import Patterns.UserBuilder;
import Patterns.UserCreation;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class LoginUser extends BaseTestSelenium {
    HomePage homePage;
    LoginPage loginPage;
    Registration registration;
    UserCreation userCreation;

    @BeforeClass
    public void initialization() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registration = new Registration();
        userCreation = new UserCreation();
    }

    @BeforeMethod
    public void precondition() {
        homePage.openPage();
    }

    @Parameters({"email", "password"})
    @Test
    public void LoginUser_test(String email, String password) {
        UserBuilder user = UserBuilder
                .builder()
                .email(email)
                .password(password)
                .build();
        homePage.clickLoginbtn();
        loginPage.loginWithUserData(user);
    }

    @Parameters({"errorText"})
    @Test
    public void LoginUserWithInvalidValue_test(String errorText) {
        UserBuilder user = UserBuilder
                .builder()
                .email("tatevar93gmail.com")
                .password("password")
                .build();
        homePage.clickLoginbtn();
        loginPage.loginWithUserData(user)
                .errorTextIsShown(errorText);
    }
    @Test
    public void LoginUserWithEmptySubmit_test() {
        UserBuilder user = UserBuilder
                .builder()
                .email("")
                .password("")
                .build();
        homePage.clickLoginbtn();
        loginPage.loginWithUserData(user)
                .errorTextIsShown("Укажите ник или e-mail");
    }
}
