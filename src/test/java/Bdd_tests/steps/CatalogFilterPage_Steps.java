package Bdd_tests.steps;

import Driver.BaseTestSelenide;
import SelenidePages.CatalogFilter.*;
import SelenidePages.HomePageSelenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogFilterPage_Steps extends BaseTestSelenide {
    @Given("The Electronics category page is opened and the category item is chosen")
    public void openPage(){
        get(HomePageSelenide.class)
                .openElectronicsProduct();

    }
    @When("Filter the products by Belt,Manufacturer,Price")
    public void filterTheProductPage() {
        get(ElectronicFilter.class);

    }
    @Then("The Hotel is displayed with the Rating Exceptional")
    public void hotelResults(){
        get(ElectronicFilter.class)
                ;


    }
}
