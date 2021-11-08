package PageObject;

import org.openqa.selenium.By;

public class AccountPage extends BasePage {
    private String userDir = System.getProperty("user.dir");
    private By uploadBtn = By.cssSelector(".profile-header__download");
    private By hoverTheImage = By.cssSelector(".profile-header__image.profile-header__image_person.profile-header__image_person_1");
    private By uploadFile = By.cssSelector(".profile-form__control.profile-form__control_condensed-default .button-style.button-style_appendant.button-style_middle.profile-form__button.profile-form__button_narrow.profile-form__button_width_full");

    public AccountPage uploadFile() {
        actions.contextClick(driver.findElement(hoverTheImage)).perform();
        click(uploadBtn);
        pause(5);
        driver.findElement(uploadFile).sendKeys(userDir + properties.getProperty("filePath"));
        return this;
    }
}
