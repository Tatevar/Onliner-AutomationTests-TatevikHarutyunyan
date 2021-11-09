package Bdd_tests.steps;

import CatalogFilter.ElectonicFilter;
import Driver.BaseTestSelenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CatalogFilterPage_Steps extends BaseTestSelenide {
    @Given("The booking page is loaded")
    public void openPage(){
        get(ElectonicFilter.class)
                .CheckPageDisplayed();
    }
    @When("Enter Hotel Name And Click the Search Button")
    public void searchTheHotel() {
        get(ElectonicFilter.class)
                .enterHotelNameAndSubmit();
    }
    @Then("The Hotel is displayed with the Rating Exceptional")
    public void hotelResults(){
        get(ElectonicFilter.class);


    }
}
