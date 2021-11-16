package PageObject;

import org.openqa.selenium.By;
import org.testng.Assert;


public class HomePage extends BasePage {
    private By loginBtn = By.xpath(" //*[@class='auth-bar__item auth-bar__item--text']");
    private By logo = By.cssSelector(".onliner_logo");
    private By accountDropdown = By.cssSelector(".b-top-profile__item.b-top-profile__item_arrow .b-top-profile__preview.js-toggle-bar");
    private By logoutBtn = By.xpath("//div[@class='b-top-profile__logout']//a[@class='b-top-profile__link b-top-profile__link_secondary']");
    private By notificationIcon = By.cssSelector(".b-top-profile__notice.js-toggle-bar");
    private By dialogWindow = By.cssSelector(".b-top-profile__select");
    private By profile = By.xpath("//div[contains(@class,'b-top-profile__name')]//a[contains(@href,'profile')]");

    public HomePage openPage() {
        open();
        return this;
    }

    public HomePage clickLoginbtn() {
        click(loginBtn);
        return this;
    }

    public HomePage verifyHomePage() {
        pause(5);
        isDisplayed(logo);
        return this;
    }

    public HomePage logOutUser() {
        pause(5);
        click(accountDropdown);
        click(logoutBtn);
        return this;
    }

    public HomePage clickNotificationIocn(String expectedText) {
        pause(5);
        click(notificationIcon);
        Assert.assertEquals(getElementText(dialogWindow), expectedText);
        return this;
    }

    public HomePage openAccountPage() {
        pause(5);
        click(accountDropdown);
        pause(10);
        click(profile);
        return this;
    }
}
