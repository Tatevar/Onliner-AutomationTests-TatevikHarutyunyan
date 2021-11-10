package SelenidePages.CatalogFilter;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ElectronicFilter {
    SelenideElement filterDisp2 = $(byXpath("//span[@class='schema-tags__text' and contains(text(),'ремешок')]"));
    SelenideElement filterType = $(byXpath("//span[@class='schema-filter__checkbox-text' and contains(text(),'Apple')]"));
    SelenideElement filterDisp = $(byXpath("//span[@class='schema-tags__text' and contains(text(),'Apple')]"));
    SelenideElement beltType = $(byXpath("//span[@class='schema-filter__checkbox-text' and contains(text(),'ремешок')]"));
    SelenideElement priceFrom = $(byXpath("//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price' and @placeholder='от']"));
    SelenideElement priceTo = $(byXpath("//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price' and @placeholder='до']"));
    SelenideElement getFilterDisp3 = $(byXpath("//div[@class='schema-tags__item' and @title='Минимальная цена']"));

    public ElectronicFilter CheckPageDisplayed() {

        return this;
    }
    public ElectronicFilter enterHotelNameAndSubmit() {
        return this;
    }
}
