package LoginTests;

import Driver.BaseTest;
import PageFactory.Registration;
import PageObject.HomePage;
import PageObject.LoginPage;
import Patterns.UserBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Registration extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    Registration registration;

    @BeforeClass
    public void initialization() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registration = new Registration();
    }

    @BeforeMethod
    public void precondition() {
        homePage.openPage();
    }

    //@Test
    public void LoginToHomePage_test() {
        UserBuilder user = UserBuilder
                .builder()
                .username("tatevar93@gmail.com")
                .password("onlinertest")
                .build();
        homePage.clickLoginbtn();
        loginPage.loginWithUserData(user);
    }

    @Test
    public void createUser_test() {
        homePage.clickLoginbtn();
        loginPage.clickRegbtn();
        registration.createUser("tata@zenia.com","password55","password55")
                    .verifyConfirmPage();
    }
}

