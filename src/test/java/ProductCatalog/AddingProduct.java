package ProductCatalog;

import Driver.BaseTestSelenide;
import SelenidePages.BasketPage;
import SelenidePages.CatalogPage;
import SelenidePages.HomePageSelenide;
import org.testng.annotations.Test;


public class AddingProduct extends BaseTestSelenide {

    //@Test( priority = 3)
    public void addAProductAndDelete_test(){
        get(HomePageSelenide.class)
                .openProduct();
        get(CatalogPage.class)
                .clickItem()
                .addItemToBasket();
        get(BasketPage.class)
                .removeTheItem();
    }
    //@Test(priority = 2)
    public void compareTheproducts_test() {
        get(HomePageSelenide.class)
                .openProduct();
        get(CatalogPage.class)
                .tickCheckbox();
    }
    @Test(priority = 1)
    public void emptyTheComparedList_test() {
        get(HomePageSelenide.class)
                .openProduct();
        get(CatalogPage.class)
                .tickCheckbox()
                .EmptyComparedList();
    }
}