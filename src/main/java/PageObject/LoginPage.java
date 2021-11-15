package PageObject;

import Users.UserBuilder;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private By email = By.xpath("//*[@placeholder='Ник или e-mail']");
    private By password = By.xpath("//*[@type='password']");
    private By loginBtn = By.xpath("//button[contains(@class,'auth-button auth-button_primary')]");
    private By registerBtn = By.xpath("//a[contains(text(),'Зарегистрироваться')]");
    private By errTxt = By.xpath("//div[contains(@class,'auth-form__description auth-form__description_error auth')]");

    public LoginPage loginWithUserData(UserBuilder user) {
        enter(this.email, user.email);
        enter(this.password, user.password);
        click(this.loginBtn);
        return this;

    }
    public LoginPage clickRegbtn() {
        click(registerBtn);
        return this;
    }
    public LoginPage errorTextIsShown(String expectedText) {
        pause(2);
        Assert.assertEquals(getElementText(errTxt), expectedText);
        return this;
    }
}
