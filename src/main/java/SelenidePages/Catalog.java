package SelenidePages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Catalog extends BasePageSelenide {

    SelenideElement addToBasket = $(byText("В корзину"));
    SelenideElement btnState = $(byXpath("//a[contains(@class,'button-style button-style_base-alter product-aside__item-button button-style_p')]"));
    SelenideElement checkBox = $(byXpath("//*[@id='schema-products']/div[1]/div/div[1]/div[1]/div/label"));
    SelenideElement compareProduct = $(By.cssSelector(".compare-button__sub.compare-button__sub_main"));
    SelenideElement removeComparedItem = $(byXpath("//a[@title='Очистить список сравнения']"));
    SelenideElement emptyCompList = $(byText("Очистить список сравнения"));
    SelenideElement compareCheckbox = $(byCssSelector(".catalog-masthead-controls__text.helpers_hide_tablet"));
    SelenideElement favIcon = $(byXpath("//li[@id='product-bookmark-control']"));
    @FindBy(css = ".auth-bar__item.auth-bar__item--cart")
    SelenideElement basketBtn;
    SelenideElement favIconText= $(By.xpath("//span[@class='catalog-masthead-controls__text' and contains(text(),'В закладках')]"));

    public Catalog clickItem() {
        $(byText("Туристическая плита Tourist Krab [TM-300]")).click();
        return this;
    }

    public Catalog addItemToBasket() {
        addToBasket.shouldBe(visible).isDisplayed();
        addToBasket.click();
        btnState.shouldBe(matchText("В корзине"));
        basketBtn.click();
        return this;
    }

    public Catalog tickCheckbox() {
        checkBox.click();
        pause(5);
        compareProduct.shouldBe(text("1 товар в сравнении"));
        return this;
    }

    public Catalog EmptyComparedList() {
        removeComparedItem.click();
        emptyCompList.click();
        compareProduct.shouldBe(text("0 товаров в сравнении"));
        return this;
    }
    public Catalog tickCheckboxes() {
        compareCheckbox.click();
        favIcon.click();
        return this;
    }
    public Catalog checkTheValues() {
        compareCheckbox.shouldBe(text("Добавлен к сравнению"));
        favIconText.shouldBe(text("В закладках"));
        return this;
    }
}