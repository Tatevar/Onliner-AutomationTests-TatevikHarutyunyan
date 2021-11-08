package PageObject;

import org.openqa.selenium.By;

import java.util.Arrays;

public class HomePage extends BasePage {
    private By loginBtn = By.xpath(" //*[@class='auth-bar__item auth-bar__item--text']");
    private By logo = By.cssSelector(".onliner_logo");

    private By getLink(HomePageLinksEnum homePageLinksEnum) {
        return By.linkText(homePageLinksEnum.getLinkText());
    }

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
        Arrays.asList(HomePageLinksEnum.values()).forEach(homePageLinksEnum -> isDisplayed(getLink(homePageLinksEnum)));
        return this;
    }

}
