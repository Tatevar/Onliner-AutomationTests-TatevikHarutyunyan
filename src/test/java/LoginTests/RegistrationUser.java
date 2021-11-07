package LoginTests;

import Driver.BaseTest;
import PageObject.HomePage;
import PageObject.LoginPage;
import Patterns.UserCreation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationUser extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    PageFactory.Registration registration;
    UserCreation userCreation;

    @BeforeClass
    public void initialization() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registration = new PageFactory.Registration();
        userCreation = new UserCreation();
    }

    @BeforeMethod
    public void precondition() {
        homePage.openPage();
    }

//This case found a bug , User can create different accounts with the same email address
    @Test(invocationCount = 2)
    public void createUser_test() {
        homePage.clickLoginbtn();
        loginPage.clickRegbtn();
        registration.createUser(userCreation)
                    .checkConfirmationText("Перейти в почту Gmail");
    }
}

