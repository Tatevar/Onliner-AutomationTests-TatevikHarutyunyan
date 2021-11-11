package SelenidePages.CatalogFilter;
import SelenidePages.BasePageSelenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ElectronicFilter extends BasePageSelenide {
    SelenideElement filterType = $(byXpath("//span[@class='schema-filter__checkbox-text' and contains(text(),'Apple')]"));
    SelenideElement filterDisp = $(byXpath("//span[@class='schema-tags__text' and contains(text(),'Apple')]"));
    SelenideElement filterDisp2 = $(byXpath("//span[@class='schema-tags__text' and contains(text(),'ремешок')]"));
    SelenideElement beltType = $(byXpath("//span[@class='schema-filter__checkbox-text' and contains(text(),'ремешок')]"));
    SelenideElement priceFrom = $(byXpath("//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price' and @placeholder='от']"));
    SelenideElement priceTo = $(byXpath("//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price' and @placeholder='до']"));
    SelenideElement getFilterDisp3 = $(byXpath("//div[@class='schema-tags__item' and @title='Минимальная цена']"));


    public ElectronicFilter filterPage() {
        filterType.click();
        priceFrom.scrollTo().setValue("100");
        priceTo.scrollTo().setValue("200");
        beltType.click();
        return this;
    }
    public ElectronicFilter checkTheFilterIsDisplayed(){
        filterDisp.scrollTo().isDisplayed();
        filterDisp2.scrollTo().isDisplayed();
        getFilterDisp3.scrollTo().isDisplayed();
        return this;
    }
}
