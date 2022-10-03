package com.browserstack.stepdefs;

import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.pageobjects.BasePage;
import com.browserstack.pageobjects.ChangePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ChangeDefs extends BasePage {


    ChangePage changePage=new ChangePage();
    WebDriver webDriver=RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();


    @Given("User goes to non-canceled order on atlantis page")
    public void user_goes_to_non_canceled_order_on_atlantis_page() {

        changePage.goestoAtlantis();
    }

    @When("User changes the reservation detail and selects less price vehicle")
    public void user_changes_the_reservation_detail_and_selects_less_price_vehicle() {
        changePage.reservationDetail();
    }

    @Then("reservation details should be changed and payment should be revised")
    public void reservation_details_should_be_changed_and_payment_should_be_revised() {
        changePage.shouldBeChange();

    }

    @When("User changes the reservation detail and selects higher price vehicle")
    public void user_changes_the_reservation_detail_and_selects_higher_price_vehicle() {



    }


}
