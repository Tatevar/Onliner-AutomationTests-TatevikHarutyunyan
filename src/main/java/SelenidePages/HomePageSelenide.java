package SelenidePages;

import PageObject.HomePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.openqa.selenium.By;
import javax.annotation.Nonnull;
import static com.codeborne.selenide.Selenide.$;

public class HomePageSelenide extends BasePageSelenide {
    SelenideElement  category =$(By.xpath("//div[@class='g-middle-i']//span[contains(text(),'Красота и')]"));
    SelenideElement  categoryList = $( By.xpath("//div[@class='catalog-navigation-list__aside-title'][contains(text(),'Туризм и')]"));
    SelenideElement categoryItem = $(By.xpath("//a[contains(@href,'gascylinder')]"));
    SelenideElement accountDropdown = $(".b-top-profile__preview.js-toggle-bar");
    SelenideElement logoutBtn = $(By.xpath("//div[@class='b-top-profile__logout']//a[@class='b-top-profile__link b-top-profile__link_secondary']"));

    @Nonnull
    @CanIgnoreReturnValue
    public HomePageSelenide openProduct(){
        category.click();
        Selenide.actions().moveToElement(categoryList).click(categoryList).perform();
        categoryItem.scrollTo().click();
        return this;
    }
    public HomePageSelenide logOutUser(){
        Selenide.actions().moveToElement(accountDropdown).click().perform();
        Selenide.actions().moveToElement(logoutBtn).click().perform();
        return this;
    }
}

