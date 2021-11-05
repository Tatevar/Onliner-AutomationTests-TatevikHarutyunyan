package SelenidePages;

import PageObject.HomePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class HomePageSelenide  {
    SelenideElement  loginBtn = $(By.xpath(" //*[@class='auth-bar__item auth-bar__item--text']"));
    SelenideElement  category =$(By.xpath("//span[contains(text(),'Красота и')]"));
    SelenideElement  categoryList = $( By.cssSelector(".catalog-navigation-list__aside-item.catalog-navigation-list__aside-item_active .catalog-navigation-list__aside-title"));
    SelenideElement categoryItem = $(linkText("gascylinder"));

    public HomePageSelenide openProduct() {
       category.click();
        Selenide.actions().moveToElement(categoryList).click(categoryList).perform();
        return this;
    }
}

