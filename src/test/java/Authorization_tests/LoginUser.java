package Authorization_tests;

import Driver.BaseTestSelenium;
import PageFactory.Registration;
import PageObject.HomePage;
import PageObject.HomeMenuItemEnum;
import PageObject.LoginPage;
import TestNg.Retry;
import Users.UserBuilder;
import Users.UserCreation;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class LoginUser extends BaseTestSelenium {
    HomePage homePage;
    LoginPage loginPage;
    Registration registration;
    UserCreation userCreation;

    @BeforeClass(alwaysRun=true)
    public void initialization() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registration = new Registration();
        userCreation = new UserCreation();
    }

    @BeforeMethod(alwaysRun=true)
    public void precondition() {
        homePage.openPage();
    }

    @Parameters({"email", "password"})
    @Test(groups = {"smokeTest"},priority = 1,retryAnalyzer= Retry.class)
    public void LoginUser_test(String email, String password) {
        UserBuilder user = UserBuilder
                .builder()
                .email(email)
                .password(password)
                .build();
        homePage.clickLoginbtn();
        loginPage.loginWithUserData(user);
        homePage.verifyHomePage();
        HomeMenuItemEnum.ELECTRONICS.getMenuText();
        HomeMenuItemEnum.APPLIANCES.getMenuText();
        HomeMenuItemEnum.COMPUTERS.getMenuText();
        HomeMenuItemEnum.CAR.getMenuText();
        HomeMenuItemEnum.BEUTYANDSPORT.getMenuText();
        HomeMenuItemEnum.CONSTRACTIONSANDREPAIR.getMenuText();
        HomeMenuItemEnum.HOUSE.getMenuText();
        HomeMenuItemEnum.FOOD.getMenuText();
        HomeMenuItemEnum.MOMMIESANDBABIES.getMenuText();
        HomeMenuItemEnum.WORKANDOFFICE.getMenuText();

    }

    @Parameters({"errorText"})
    @Test(groups = {"regressionTest"},dependsOnGroups = {"smokeTest"}, priority=3)
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

    @Test(groups = {"regressionTest"},dependsOnGroups = {"smokeTest"}, priority= 2)
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

    @Parameters({"email", "password"})
    @Test(groups = {"smokeTest"},priority = 2)
    public void LogOutUser_test(String email, String password) {
        UserBuilder user = UserBuilder
                .builder()
                .email(email)
                .password(password)
                .build();
        homePage.clickLoginbtn();
        loginPage.loginWithUserData(user);
        homePage
                .logOutUser()
                .verifyHomePage();
    }
    @Parameters({"email", "password"})
   @Test(groups = {"regressionTest"},dependsOnGroups = {"smokeTest"}, priority= 4)
    public void openDialogWindow_test(String email, String password) {
        UserBuilder user = UserBuilder
                .builder()
                .email(email)
                .password(password)
                .build();
        homePage.clickLoginbtn();
        loginPage.loginWithUserData(user);
        homePage
                .verifyHomePage()
                .clickNotificationIocn("Отметить все как прочитанные");
    }
}
