package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private By loginBtn = By.xpath(" //*[@class='auth-bar__item auth-bar__item--text']");
    private By logo = By.cssSelector(".onliner_logo");
    private By accountDropdown = By.cssSelector(".b-top-profile__item.b-top-profile__item_arrow .b-top-profile__preview.js-toggle-bar");
    private By logoutBtn = By.xpath("//div[@class='b-top-profile__logout']//a[@class='b-top-profile__link b-top-profile__link_secondary']");

    public HomePage openPage() {
        open();
        return this;
    }

    public HomePage clickLoginbtn() {
        click(loginBtn);
        return this;
    }

    public HomePage verifyHomePage() {
        isDisplayed(logo);
        return this;
    }

    public HomePage logOutUser() {
        pause(5);
        click(accountDropdown);
        click(logoutBtn);
        return this;
    }
}
