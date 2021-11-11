package SelenidePages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.openqa.selenium.By;
import javax.annotation.Nonnull;
import static com.codeborne.selenide.Selenide.$;

public class HomePageSelenide extends BasePageSelenide {
    SelenideElement  categoryBeauty =$(By.xpath("//div[@class='g-middle-i']//span[contains(text(),'Красота и')]"));
    SelenideElement  categoryList = $( By.xpath("//div[@class='catalog-navigation-list__aside-title'][contains(text(),'Туризм и')]"));
    SelenideElement categoryItem = $(By.xpath("//a[contains(@href,'gascylinder')]"));
    SelenideElement  categoryElectronics =$(By.xpath("//div[@class='g-middle-i']//span[contains(text(),'Электроника')]"));
    SelenideElement  electronicslist =$(By.xpath("//div[@class='catalog-navigation-list__aside-title'][contains(text(),'Гаджеты')]"));
    SelenideElement  electronicsItem =$(By.xpath("//span[contains(@class,'catalog-navigation-list__dropdown-title') and contains(text(),'Сменные ремешки и')]"));

    @Nonnull
    @CanIgnoreReturnValue
    public HomePageSelenide openBeautyAndSportProduct(){
        categoryBeauty.click();
        Selenide.actions().moveToElement(categoryList).click(categoryList).perform();
        categoryItem.scrollTo().click();
        return this;
    }
    @Nonnull
    @CanIgnoreReturnValue
    public HomePageSelenide openElectronicsProduct(){
        categoryElectronics.click();
        Selenide.actions().moveToElement(electronicslist).click(electronicslist).perform();
        electronicsItem.click();
        return this;
    }
}

