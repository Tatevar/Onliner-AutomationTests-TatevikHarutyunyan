package Authorization_tests;
import Driver.BaseTestSelenium;

import PageObject.HomePage;
import PageObject.LoginPage;
import Users.UserCreation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationUser extends BaseTestSelenium {
    HomePage homePage;
    LoginPage loginPage;
    PageFactory.Registration registration;
    UserCreation userCreation;

    @BeforeClass(alwaysRun = true)
    public void initialization() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registration = new PageFactory.Registration();
        userCreation = new UserCreation();
    }

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        homePage.openPage();
    }

//This case found a bug , User can create different accounts with the same email address
   @Test(groups = {"smokeTest"},priority = 1,invocationCount = 2)
    public void createUser_test() {
        homePage.clickLoginbtn();
        loginPage.clickRegbtn();
        registration.createUser("tata@gmail.com","Password", "Password")
                    .checkConfirmationText("Перейти в почту Gmail");
    }
    @Test(groups = {"regressionTest"},priority = 1)
    public void createInvalidUser_test() {
        homePage.clickLoginbtn();
        loginPage.clickRegbtn();
        registration.createUser("test@test.com","Password", "Password")
                .checkErrorText("E-mail находится в черном списке");
    }
}

