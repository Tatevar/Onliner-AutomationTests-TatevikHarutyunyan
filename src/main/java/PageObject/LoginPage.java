package PageObject;

import Patterns.UserBuilder;
import com.mysql.cj.log.Log;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By username = By.xpath("//*[@placeholder='Ник или e-mail']");
    private By password = By.xpath("//*[@type='password']");
    private By loginBtn = By.xpath("//button[contains(@class,'auth-button auth-button_primary')]");
    private By registerBtn = By.xpath("//a[contains(text(),'Зарегистрироваться')]");

    public LoginPage loginWithUserData(UserBuilder user) {
        enter(this.username, user.username);
        enter(this.password, user.password);
        click(this.loginBtn);
        return this;

    }
    public LoginPage clickRegbtn() {
        click(registerBtn);
        return this;
    }


}
