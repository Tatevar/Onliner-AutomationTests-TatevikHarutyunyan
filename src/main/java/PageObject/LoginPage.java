package PageObject;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By username = By.xpath("//*[@placeholder='Ник или e-mail']");
    private By password = By.xpath("//*[@type='password']");
    private By loginBtn = By.xpath("//button[contains(@class,'auth-button auth-button_primary')]");
    private By errorTxt = By.cssSelector("[data-test=error]");

    public LoginPage loginToApp(String username, String password) {
        enter(this.username, username);
        enter(this.password, password);
        click(this.loginBtn);
        return this;
    }

}
