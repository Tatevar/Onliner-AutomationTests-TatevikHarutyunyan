package SelenidePages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ElectronicFilter extends BasePageSelenide {
    SelenideElement filterType = $(byXpath("//span[@class='schema-filter__checkbox-text' and contains(text(),'Apple')]"));
    SelenideElement filterDisp = $(byXpath("//span[@class='schema-tags__text' and contains(text(),'Apple')]"));
    SelenideElement filterDisp2 = $(byXpath("//span[@class='schema-tags__text' and contains(text(),'ремешок')]"));
    SelenideElement beltType = $(byXpath("//span[@class='schema-filter__checkbox-text' and contains(text(),'ремешок')]"));
    SelenideElement priceFrom = $(byXpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/div/div[1]/input"));
    SelenideElement priceTo = $(byXpath("//*[@id=\"schema-filter\"]/div[3]/div[5]/div[2]/div/div[2]/input"));
    SelenideElement getFilterDisp3 = $(byXpath("//div[@class='schema-tags__item' and @title='Минимальная цена']"));
    SelenideElement chooseProduct = $(byText("Ремешок Apple из плетеного нейлона 44 мм (угольный, размер R) MYAA2"));

    public ElectronicFilter filterPage() {
        pause(5);
        filterType.scrollTo().click();
        priceFrom.scrollTo().setValue("100");
        priceTo.setValue("200");
        beltType.click();
        return this;
    }
    public ElectronicFilter checkTheFilterIsDisplayed(){
        filterDisp.scrollTo().isDisplayed();
        filterDisp2.scrollTo().isDisplayed();
        getFilterDisp3.scrollTo().isDisplayed();
        return this;
    }
    public ElectronicFilter chooseProduct(){
       chooseProduct.click();
        return this;
    }
}
