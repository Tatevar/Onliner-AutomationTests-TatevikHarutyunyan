package PageFactory;

import PageObject.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends BasePage {

    @FindBy(xpath = "//input[(@type='email')]")
    WebElement email;

    @FindBy(xpath = "//input[@type='password' and @placeholder='Придумайте пароль']")
    WebElement password;

    @FindBy(xpath = "//input[@type='password' and @placeholder='Повторите пароль']")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//a[contains(@class,'auth-button auth-button_appendant auth-button')]")
    WebElement verifyPage;

    public Registration() {
        PageFactory.initElements(driver, this);

    }
    public Registration createUser(String email, String password, String confirmPassword) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        this.submitBtn.click();
        return this;
    }
    public Registration verifyConfirmPage() {
        this.verifyPage.isDisplayed();
        return this;
    }

}
