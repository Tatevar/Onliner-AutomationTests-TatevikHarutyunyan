package SelenidePages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    SelenideElement addToBasket = $(byText("В корзину"));
    SelenideElement btnState = $(byXpath("//a[contains(@class,'button-style button-style_base-alter product-aside__item-button button-style_p')]"));

    @FindBy(css = ".https://cart.onliner.by/")
    SelenideElement basketBtn;

    public CatalogPage clickItem() {
        $(byText("Туристическая плита Tourist Krab [TM-300]")).click();
        return this;
    }
    public CatalogPage addItemToBasket() {
       addToBasket.shouldBe(visible).isDisplayed();
        addToBasket.click();
        btnState.shouldBe(matchText("В корзине"));
        basketBtn.shouldBe(visible).isDisplayed();
        basketBtn.click();
        return this;
    }

}