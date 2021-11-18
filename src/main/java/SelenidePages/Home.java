package SelenidePages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import javax.annotation.Nonnull;
import static com.codeborne.selenide.Selenide.$;

public class Home extends BasePageSelenide {
    SelenideElement  categoryBeauty =$(By.xpath("//div[@class='g-middle-i']//span[contains(text(),'Красота и')]"));
    SelenideElement  categoryList = $( By.xpath("//div[@class='catalog-navigation-list__aside-title'][contains(text(),'Туризм и')]"));
    SelenideElement categoryItem = $(By.xpath("//a[contains(@href,'gascylinder')]"));
    SelenideElement  categoryElectronics =$(By.xpath("//div[@class='g-middle-i']//span[contains(text(),'Электроника')]"));
    SelenideElement  electronicslist =$(By.xpath("//div[@class='catalog-navigation-list__aside-title'][contains(text(),'Гаджеты')]"));
    SelenideElement  electronicsItem =$(By.xpath("//span[contains(@class,'catalog-navigation-list__dropdown-title') and contains(text(),'Сменные ремешки и')]"));
    SelenideElement logoutBtn = $(By.xpath("//*[@class='auth-bar__item auth-bar__item--text']"));
    @FindBy(css = ".b-top-profile__cart")
    SelenideElement basketBtn;

    @Nonnull
    @CanIgnoreReturnValue
    public Home addBeautyAndSportProduct(){
        categoryBeauty.click();
        Selenide.actions().moveToElement(categoryList).click(categoryList).perform();
        pause(2);
        categoryItem.scrollTo().click();
        return this;
    }
    @Nonnull
    @CanIgnoreReturnValue
    public Home addElectronicsProduct(){
        categoryElectronics.click();
        Selenide.actions().moveToElement(electronicslist).click(electronicslist).perform();
        electronicsItem.click();
        return this;
    }
    public Home clickLoginbtn() {
        logoutBtn.click();
        return this;
    }
    public Home clickBasketBtn() {
        pause(3);
        basketBtn.click();
        return this;
    }
}

