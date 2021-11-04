package PageFactory;

import PageObject.BasePage;
import Patterns.UserCreation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
    WebElement buttonDisplayed;

    @FindBy(xpath = ("//div[contains(@class,'auth-form__title auth-form__title_big')]"))
    WebElement confirmText;

    public Registration() {
        PageFactory.initElements(driver, this);

    }

    public Registration createUser(UserCreation userCreation) {
        userCreation.setEmail("tataa@gmail.com");
        userCreation.setPassword("bestpassword");
        userCreation.setConfirmPassword("bestpassword");
        this.email.sendKeys(userCreation.getEmail());
        this.password.sendKeys(userCreation.getPassword());
        this.confirmPassword.sendKeys(userCreation.getConfirmPassword());
        this.submitBtn.click();
        return this;

    }
    public Registration checkConfirmationText(String expectedText) {
        pause(3);
        Assert.assertEquals(this.buttonDisplayed.getText(), expectedText);
        return this;

    }

}
