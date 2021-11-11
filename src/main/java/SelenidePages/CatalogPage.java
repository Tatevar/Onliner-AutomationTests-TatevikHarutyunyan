package SelenidePages;

import PageObject.LoginPage;
import Patterns.UserBuilder;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage extends BasePageSelenide {

    SelenideElement addToBasket = $(byText("В корзину"));
    SelenideElement btnState = $(byXpath("//a[contains(@class,'button-style button-style_base-alter product-aside__item-button button-style_p')]"));
    SelenideElement checkBox = $(byXpath("//*[@id='schema-products']/div[1]/div/div[1]/div[1]/div/label"));
    SelenideElement compareProduct = $(By.cssSelector(".compare-button__sub.compare-button__sub_main"));
    SelenideElement removeComparedItem = $(byXpath("//a[@title='Очистить список сравнения']"));
    SelenideElement emptyCompList = $(byText("Очистить список сравнения"));
    SelenideElement compareCheckbox = $(byXpath("//span[@class='catalog-masthead-controls__input i-checkbox i-checkbox_yellow']//span[@class='i-checkbox__faux']"));
    SelenideElement favIcon = $(byXpath("//span[@class='catalog-masthead-controls__input i-checkbox i-checkbox_star']//span[@class='i-checkbox__faux']"));
    @FindBy(css = ".auth-bar__item.auth-bar__item--cart")
    SelenideElement basketBtn;

    public CatalogPage clickItem() {
        $(byText("Туристическая плита Tourist Krab [TM-300]")).click();
        return this;
    }

    public CatalogPage addItemToBasket() {
        addToBasket.shouldBe(visible).isDisplayed();
        addToBasket.click();
        btnState.shouldBe(matchText("В корзине"));
        basketBtn.click();
        return this;
    }

    public CatalogPage tickCheckbox() {
        checkBox.click();
        pause(5);
        compareProduct.shouldBe(text("1 товар в сравнении"));
        return this;
    }

    public CatalogPage EmptyComparedList() {
        removeComparedItem.click();
        emptyCompList.click();
        compareProduct.shouldBe(text("0 товаров в сравнении"));
        return this;
    }
    public CatalogPage tickCheckboxes() {
        compareCheckbox.click();
        favIcon.click();
        return this;
    }
    public CatalogPage checkTheValues() {
        compareCheckbox.shouldBe(text("Добавлен к сравнению"));
        favIcon.shouldBe(text("В закладках"));
        return this;
    }
}