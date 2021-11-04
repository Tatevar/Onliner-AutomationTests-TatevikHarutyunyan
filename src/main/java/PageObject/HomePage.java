package PageObject;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By loginBtn = By.xpath(" //*[@class='auth-bar__item auth-bar__item--text']");
    private By loginForm = By.cssSelector("[data-test=password]");

    public HomePage openPage() {
        open();
        return this;
    }
    public HomePage clickLoginbtn() {
        click(loginBtn);
        return this;
    }
}
