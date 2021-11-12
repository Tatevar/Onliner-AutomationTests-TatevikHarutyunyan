package Bdd_tests.steps;

import Driver.BaseTestSelenide;
import SelenidePages.ElectronicFilter;
import SelenidePages.Home;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogFilterPage_Steps extends BaseTestSelenide {
    @Given("The Electronics category page is opened and the category item is chosen")
    public void chooseProduct_step(){
        get(Home.class)
                .openElectronicsProduct();

    }
    @When("User filter the products by Belt,Manufacturer,Price")
    public void filterTheProductPage_step() {
        get(ElectronicFilter.class)
                .filterPage();

    }
    @Then("The filtered items are displayed on the top of the page")
    public void filterResults_step(){
        get(ElectronicFilter.class)
                .checkTheFilterIsDisplayed();

    }
}
