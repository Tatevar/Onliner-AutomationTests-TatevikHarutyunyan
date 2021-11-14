package Uploader_tests;

import Driver.BaseTestSelenium;
import PageFactory.Registration;
import PageObject.AccountPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import Users.UserBuilder;
import Users.UserCreation;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Upload extends BaseTestSelenium {
    HomePage homePage;
    LoginPage loginPage;
    Registration registration;
    UserCreation userCreation;
    AccountPage accountPage;

    @BeforeClass(alwaysRun = true)
    public void initialization() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registration = new Registration();
        userCreation = new UserCreation();
        accountPage = new AccountPage();
    }
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        homePage.openPage();
    }

    @Parameters({"email", "password"})
    @Test(groups = {"smokeTest"},priority = 1)
    public void uploadPhotoToAccountAvatar_test(String email, String password) {
        UserBuilder user = UserBuilder
                .builder()
                .email(email)
                .password(password)
                .build();
        homePage.clickLoginbtn();
        loginPage.loginWithUserData(user);
        homePage.openAccountPage();
        accountPage.dragDropUpload("img.png")
                   .deletePhoto()
                   .verifyAccountPage()
                   .logOutUser();
    }

    //here bug , user can delete a photo, of there is no any photo uploaded
    @Parameters({"email", "password"})
    @Test(groups = {"regressionTest"},dependsOnGroups = {"smokeTest"},priority = 1)
    public void deletePhoto_test(String email, String password) {
        UserBuilder user = UserBuilder
                .builder()
                .email(email)
                .password(password)
                .build();
        homePage.clickLoginbtn();
        loginPage.loginWithUserData(user);
        homePage.openAccountPage();
        accountPage.deletePhoto()
                .verifyAccountPage()
                .logOutUser();

    }

    @AfterMethod(alwaysRun = true)
    public void post() {
        closeWebDriver();
    }
}
