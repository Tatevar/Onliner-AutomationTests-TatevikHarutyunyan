package ProductCatalog;

import Driver.BaseTestSelenide;
import SelenidePages.BasketPage;
import SelenidePages.CatalogPage;
import SelenidePages.HomePageSelenide;
import org.testng.annotations.Test;


public class AddingProduct extends BaseTestSelenide {

    //@Test( priority = 2)
    public void addAProduct(){
        get(HomePageSelenide.class)
                .openProduct();
        get(CatalogPage.class)
                .clickItem()
                .addItemToBasket();
        get(BasketPage.class)
                .removeTheItem();
    }
    @Test(priority = 1)
    public void addAProduc() throws InterruptedException {
        get(HomePageSelenide.class)
                .openProduct();
        Thread.sleep(3000);
        get(CatalogPage.class)
                .tickCheckbox();
    }
}