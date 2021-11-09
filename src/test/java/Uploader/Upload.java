package Uploader;

import Driver.BaseTestSelenium;
import PageFactory.Registration;
import PageObject.AccountPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import Patterns.UserBuilder;
import Patterns.UserCreation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Upload extends BaseTestSelenium {
    HomePage homePage;
    LoginPage loginPage;
    Registration registration;
    UserCreation userCreation;
    AccountPage accountPage;

    @BeforeClass
    public void initialization() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registration = new Registration();
        userCreation = new UserCreation();
        accountPage = new AccountPage();
    }
    @BeforeMethod
    public void precondition() {
        homePage.openPage();
    }

    @Parameters({"email", "password"})
    @Test(priority = 1)
    public void LoginUser_test(String email, String password) {
        UserBuilder user = UserBuilder
                .builder()
                .email(email)
                .password(password)
                .build();
        homePage.clickLoginbtn();
        loginPage.loginWithUserData(user);
        homePage.openAccountPage();
        accountPage.dragDropUpload("img.png")
                .pause(10);
    }
}
