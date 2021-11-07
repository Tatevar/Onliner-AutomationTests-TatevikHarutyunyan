package SelenidePages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    SelenideElement addToBasket = $(byText("В корзину"));
    SelenideElement btnState = $(byXpath("//a[contains(@class,'button-style button-style_base-alter product-aside__item-button button-style_p')]"));
    SelenideElement checkBox = $(byXpath("//*[@id='schema-products']/div[1]/div/div[1]/div[1]/div/label"));
    SelenideElement compareProduct = $(byText("товар в сравнении"));

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
       $(byText("товар в сравнении")).hover().shouldBe(text("1 товар в сравнении"));
        return this;
    }
}