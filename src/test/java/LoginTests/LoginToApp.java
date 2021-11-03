package LoginTests;

import Driver.BaseTest;
import PageObject.HomePage;
import PageObject.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginToApp extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void precondition() {
        homePage.openPage();
    }
    @Test
    public void LoginToHomePage_test(){
        homePage.clickLoginbtn();
        loginPage.loginToApp("tatevar93@gmail.com", "onlinertest");


    }
}
