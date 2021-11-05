package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    private By loginBtn = By.xpath(" //*[@class='auth-bar__item auth-bar__item--text']");
    private By category = By.xpath("//span[contains(text(),'Красота и')]");
    private By categoryList = By.cssSelector(".catalog-navigation-list__aside-item.catalog-navigation-list__aside-item_active .catalog-navigation-list__aside-title");
    private By categoryItem = By.linkText("gascylinder");

    public HomePage openPage() {
        open();
        return this;
    }
    public HomePage clickLoginbtn() {
        click(loginBtn);
        return this;
    }

}
