package SelenidePages;

import Users.UserBuilder;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class UserData extends BasePageSelenide {
    @FindBy(xpath = "//input[(@placeholder='Ник или e-mail')]")
    SelenideElement email;
    @FindBy(xpath = "//*[@type='password']")
    SelenideElement password;
    SelenideElement loginBtn = $(By.xpath("//button[contains(@class,'auth-button auth-button_primary')]"));

    public UserData loginWithUserData(UserBuilder user) {
        this.email.sendKeys(user.email);
        this.password.sendKeys(user.password);
        this.loginBtn.click();
        return this;

    }
}
