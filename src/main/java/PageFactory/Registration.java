package PageFactory;

import PageObject.BasePage;
import Users.UserCreation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Registration extends BasePage {

    @FindBy(xpath = "//input[(@type='email')]")
    WebElement email;

    @FindBy(css = ".profile-form__checkbox-text")
    WebElement checkbox;

    @FindBy(xpath = "//input[@type='password' and @placeholder='Придумайте пароль']")
    WebElement password;

    @FindBy(xpath = "//input[@type='password' and @placeholder='Повторите пароль']")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//a[contains(@class,'auth-button auth-button_appendant auth-button')]")
    WebElement buttonDisplayed;

    @FindBy(xpath = ("//div[contains(@class,'auth-form__description auth-form__description_error auth-form')]"))
    WebElement errorText;

    public Registration() {
        PageFactory.initElements(driver, this);

    }

    public Registration createUser(String email, String password,String repeat_password) {

        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(repeat_password);
        this.submitBtn.click();
        this.checkbox.click();
        return this;

    }
    public Registration checkConfirmationText(String expectedText) {
        pause(3);
        Assert.assertEquals(this.buttonDisplayed.getText(), expectedText);
        return this;

    }
    public Registration checkErrorText(String expectedText) {
        pause(3);
        Assert.assertEquals(this.errorText.getText(), expectedText);
        return this;

    }
}
