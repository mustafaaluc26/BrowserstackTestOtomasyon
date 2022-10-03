package com.browserstack.stepdefs;

import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.pageobjects.CampaignsLocationsPage;
import com.browserstack.pageobjects.LoginPage;
import com.browserstack.pageobjects.MainPage;
import com.browserstack.pageobjects.ReservationPage;
import com.browserstack.util.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ReservationDefs {

    ReservationPage resPage=new ReservationPage();
    MainPage main = new MainPage() ;
    WebDriver driver=RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();

    String differentPrice1="";
    String differentPrice2="";
    String currentURL;

    String firstUrl = "";
    String secondUrl= "";
    String araçListesi1="";
    String araçListesi2="";


    @Given("the user is on the daily rental")
    public void the_user_is_on_the_daily_rental() {
        resPage.dailyRental.click();
        BrowserUtils.waitFor(1);
    }

    @When("the user enters required information to daily rental")
    public void the_user_enters_required_information_to_daily_rental() {
        BrowserUtils.waitFor(3);
        resPage.locationSearch("SAW");

        BrowserUtils.waitForVisibility(resPage.rentNowButton.get(1),20);
        BrowserUtils.waitFor(3);
    }

    @Then("the user should be able to see vehicle listing")
    public void the_user_should_be_able_to_see_vehicle_listing() {
        resPage.verifyVehicleListingPage();
    }

    @Given("the user is on the monthly rental")
    public void the_user_is_on_the_monthly_rental() {
        BrowserUtils.waitForClickablility(resPage.monthlyRental,5);
        resPage.monthlyRental.click();
    }

    @Then("the user should be able to make reservation")
    public void the_user_should_be_able_to_make_reservation() {
        resPage.verifyReservation();
    }

    @Given("registered user is on the monthly rental")
    public void registered_user_is_on_the_monthly_rental() {

        new LoginPage().login();
        BrowserUtils.waitFor(2);
        resPage.monthlyRental.click();
    }

    @Then("the user should be able to see default daily search")
    public void the_user_should_be_able_to_see_default_daily_search() {
        resPage.defaultDailySearch();
    }

    @Then("the user should be able to see default monthly search")
    public void the_user_should_be_able_to_see_default_monthly_search() {
        resPage.defaultMonthlySearch();
    }

    @Given("the user is on the find reservation box")
    public void the_user_is_on_the_find_reservation_box() {

        new MainPage().findReservation.click();
        BrowserUtils.waitFor(1);
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String reservationNo, String email) {
        resPage.reservationSearchBox.sendKeys(reservationNo);
        resPage.mailReservSearchBox.sendKeys(email);
        //BrowserUtils.changeMail(resPage.mailReservSearchBox,email);
        resPage.ReservationSearchButton.click();
    }

    @Then("the user should be able to match {string} and {string} on reservation detail page")
    public void the_user_should_be_able_to_match_and_on_reservation_detail_page(String reservationNo, String email) {
        resPage.verifyReservationDetail(reservationNo,email);
    }

    @Then("Reservation time should be seen")
    public void reservation_time_should_be_seen() {
        Assert.assertTrue(resPage.warningTime.isDisplayed());
    }

    @Then("the functions should be enabled and information should be matched with search details")
    public void the_functions_should_be_enabled_and_information_should_be_matched_with_search_details() {

        //Assert.assertTrue(resPage.differentLocatorBoxDisplay.isEnabled());
        Assert.assertTrue(resPage.allCarsBrand.get(0).isDisplayed());
        Assert.assertTrue(resPage.allCarsDailyPrice.get(0).isDisplayed());
        Assert.assertTrue(resPage.allCarsTotalPrice.get(0).isDisplayed());

        Assert.assertTrue(resPage.allCarsFuelType.get(0).isDisplayed());
        Assert.assertTrue(resPage.allCarsGearType.get(0).isDisplayed());
        Assert.assertTrue(resPage.allCarsType.get(0).isDisplayed());

        BrowserUtils.scrollToSize(0,400);
        BrowserUtils.waitForClickablility(resPage.scrollUp,5);
        Assert.assertTrue(resPage.scrollUp.isDisplayed());
    }

    @Given("the user verify price and office type")
    public void the_user_verify_price_and_office_type() {
        resPage.verifyPriceOfficeType();
    }

    @When("the user checks and uses the functions of the detail page")
    public void the_user_checks_and_uses_the_functions_of_the_detail_page() {
        resPage.checkFunctionDetailPage();
    }

    @Then("the user verify car model and price")
    public void the_user_verify_car_model_and_price() {
        resPage.carNameAndPrice();
    }

    @Then("the user verify rental conditions")
    public void the_user_verify_rental_conditions() {
        resPage.rentalCondition();
    }
    @Then("the user verify driver requirements")
    public void the_user_verify_driver_requirements() {
        resPage.driverRequirement();
    }
    @Then("the user verify reviews")
    public void the_user_verify_reviews() {
        resPage.review();
    }

    @Given("the user is on the driver information page")
    public void the_user_is_on_the_driver_information_page() {
        resPage.confirmationDetailPages();
    }

    @When("the user checks the functions and enters driver information")
    public void the_user_checks_the_functions_and_enters_driver_information() {
        resPage.enterReservationInformation();
        resPage.verifyTaxInformation();
    }

    @Then("the functions should be enabled and information should be entered to input boxes")
    public void the_functions_should_be_enabled_and_information_should_be_entered_to_input_boxes() {
        resPage.checkDriverInformation();
    }

    @Then("input boxes should be enabled and driver&invoice information should be matched")
    public void input_boxes_should_be_enabled_and_driver_and_invoice_information_should_be_matched() {

        BrowserUtils.waitFor(1);
        resPage.verifyDriverInformation();
     //   BrowserUtils.hover(driver.findElement(By.xpath("//*[@*='/tr/firma/hakkimizda/']")));
        BrowserUtils.waitFor(1);
    }

    @Given("the user is on the rent a car url")
    public void the_user_is_on_the_rent_a_car_url() {

        //Actions act=new Actions(driver);
        // act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
        BrowserUtils.waitFor(1);
        driver.navigate().to("https://staging.yolcu360.com/tr/rent-a-car/istanbul-arac-kiralama/");
        BrowserUtils.waitFor(2);
        driver.navigate().to("https://staging.yolcu360.com/tr/rent-a-car/");
        BrowserUtils.waitFor(2);
        // driver.get("https://staging.yolcu360.com/tr/rent-a-car");
    }

    @When("search {string}")
    public void search(String location) {
        BrowserUtils.waitForVisibility(new MainPage().findButton,20);
        //BrowserUtils.waitFor(3);
        resPage.locationSearch(location);
    }

    @And("click find button")
    public void clickFindButton() {
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(resPage.findButton);
        // resPage.findButton.click();
        BrowserUtils.waitForVisibility(resPage.rentNowButton.get(0),70);
        //  BrowserUtils.waitFor(20);

    }

    @And("enter driver information")
    public void enterDriverInformation() {
        resPage.enterReservationInformation();
    }

    @And("select month date and time from calendar")
    public void selectMonthDateAndTimeFromCalendar() {
        resPage.monthlyEnterDay();
    }

    @And("enter payment method")
    public void enterPaymentMethod() {
        resPage.paymentCard();
    }
    @And("click pay button")
    public void clickPayButton() {
        resPage.payButton.click();
    }

    @And("send sms key")
    public void sendSmsKey() {
        resPage.sendSms();
        BrowserUtils.waitForVisibility(resPage.reservationMessage,50);
    }

    @And("click find button inside reservation page")
    public void clickFindButtonInsideReservationPage() {
        resPage.secondSearchButton.click();
        BrowserUtils.waitForVisibility(resPage.rentNowButton.get(0),30);
    }

    @And("select vendor and car")
    public void selectVendorAndCar() {
        resPage.selectVendor_Car();
    }

    @When("select {string} and car for review")
    public void select_and_car_for_review(String vendor) {
        resPage.selectVendor_CarforReview(vendor);
    }

    @And("enter different drop location {string}")
    public void enterDifferentDropLocation(String location2) {
        resPage.differentSearchLocation(location2);
    }

    @And("verify {string} and {string} search location")
    public void verifyAndSearchLocation(String location1, String location2) {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(driver.getCurrentUrl().contains(location1));
        Assert.assertTrue(driver.getCurrentUrl().contains(location2));

    }

    @And("sort by {string}")
    public void sortBy(String priceType) {
        BrowserUtils.waitFor(1);
        resPage.sortPrice(priceType);
    }

    @And("click continuous button")
    public void clickContinuousButton() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(resPage.continuousRentButton);
        BrowserUtils.waitFor(1);
    }

    @And("click pickUp icon")
    public void clickPickUpIcon() {
        resPage.pickUpIcon.click();
        BrowserUtils.waitFor(1);
    }
    @And("add extra Products & Assurances")
    public void addExtraProductsAssurances() {
        resPage.addExtraProductsAssurances();
    }

    @Then("verify price on driver information page &Vehicle Selection")
    public void verifyPriceOnDriverInformationPageVehicleSelection() {
        resPage.verifyPrice();
    }

    @And("verify price on reservation summary page")
    public void verifyPriceOnReservationSummaryPage() {
        resPage.verifyPriceAfterPayment();
    }

    @And("click back to previous page")
    public void clickBackToPreviousPage() {
        driver.navigate().back();
        BrowserUtils.waitFor(3);
    }

    @And("Select vehicle in row {string}")
    public void selectVehicleInRow(String rowNumber) {
        resPage.selectSpecificCar(rowNumber);
    }

    @Then("verify error message {string}")
    public void verifyErrorMessageCount(String text) {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(text.equals(new CampaignsLocationsPage().promoCodeErrorMessage.getText()));
    }

    @And("enter {string} driver information without check box")
    public void enterDriverInformationWithoutCheckBox(String userType) {
        resPage.enterInformationWithoutCheckBox(userType);
    }

    @And("click KVKK check box on driver information")
    public void clickKVKKCheckBoxOnDriverInformation() {
        resPage.kvkkCheckBox.click();
    }

    @When("enter {string} driver information")
    public void enterInvalidDriverInformation(String userType) {
        resPage.enterInformationWithoutCheckBox(userType);
    }

    @Then("Users should see error exclamation mark")
    public void usersShouldSeeErrorExclamationMark() {
        BrowserUtils.verifyElementDisplayed(driver.findElement(By.cssSelector("i.icon-icon-info")));
    }

    @Then("verify user can not past reservation")
    public void verifyUserCanNotPastReservation() {
        BrowserUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(driver.findElement(By.cssSelector("div.col-lg-12.inner")));
    }

    @Then("check different price on first car detail")
    public void check_different_price_on_first_car_detail() {
        Assert.assertTrue(resPage.differentPriceLoc.isDisplayed());
        BrowserUtils.waitFor(2);
        differentPrice1=resPage.differentPriceLoc.getText();
        BrowserUtils.waitFor(2);
    }

    @Then("click rentNowButton")
    public void click_rentNowButton() {
        BrowserUtils.waitFor(4);
        resPage.rentNowButton.get(0).click();
        BrowserUtils.waitForVisibility(resPage.continuousRentButton,20);
    }

    @Then("check different price list page and car details page")
    public void check_different_price_list_page_and_car_details_page() {
        Assert.assertTrue(resPage.differentPriceLoc2.isDisplayed());
        differentPrice2=resPage.differentPriceLoc2.getText();
        System.out.println("differentPrice1 = " + differentPrice1);
        System.out.println("differentPrice2 = " + differentPrice2);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(differentPrice1.equals(differentPrice2));
    }

    @When("select forward date and time from calendar")
    public void selectForwardDateAndTimeFromCalendar() {
        resPage.selectForwardDate();
    }
    @When("click start date")
    public void click_start_date() {
        BrowserUtils.waitFor(4);
        resPage.pickUpIcon.click();
        BrowserUtils.waitFor(2);
    }

    @When("saved current URL")
    public void saved_current_URL() {
        currentURL= driver.getCurrentUrl();
        BrowserUtils.waitFor(1);
    }

    @Then("URL should be contains selected filter options")
    public void url_should_be_contains_selected_filter_options() {
        String actualURL= driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);
        System.out.println("actualURL = " + actualURL);
        Assert.assertEquals(actualURL,currentURL);
    }

    @When("select transmission filter")
    public void select_transmission_filter() {
        new CampaignsLocationsPage().gearTypeLoc.get(0).click();
        BrowserUtils.waitForVisibility(new CampaignsLocationsPage().selectedFilterTitle,10);
    }

    @And("save first url")
    public void saveFirstUrl() {
        BrowserUtils.waitForClickablility(resPage.rentNowButton.get(0),7);
        BrowserUtils.waitFor(2);
        araçListesi1 = driver.findElement(By.xpath("(//b[contains(text(),'Araç')])[2]")).getText();
        firstUrl = driver.getCurrentUrl();
        System.out.println("firstUrl = " + firstUrl);
        System.out.println("araçListesi1 = " + araçListesi1);
    }

    @And("save second url")
    public void saveSecondUrl() {
        BrowserUtils.waitFor(2);
        araçListesi2 = driver.findElement(By.xpath("(//b[contains(text(),'Araç')])[2]")).getText();
        secondUrl = driver.getCurrentUrl();
        System.out.println("secondUrl = " + secondUrl);
        System.out.println("araçListesi2 = " + araçListesi2);
    }

    @Then("url should {string}")
    public void urlShould(String equal) {
        if(equal.equals("equal")){
            Assert.assertTrue(firstUrl.equals(secondUrl));
            Assert.assertTrue(araçListesi1.equals(araçListesi2));
        }else{
            Assert.assertFalse(firstUrl.equals(secondUrl));
            Assert.assertFalse(araçListesi1.equals(araçListesi2));
        }
    }

    @And("cancel different location click X button")
    public void cancelDifferentLocationClickXButton() {
        BrowserUtils.clickWithJS(resPage.cancelXButton);
    }

    @Then("url contains {string}")
    public void urlContains(String str) {
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains(str));
    }

    @Then("url must not contain {string}")
    public void urlMustNotContain(String str) {
        Assert.assertFalse(driver.getCurrentUrl().contains(str));
    }

    @When("click only find button")
    public void click_only_find_button() {
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(resPage.findButton);
        BrowserUtils.waitFor(1);
    }

    @Then("Users should see warning text when the vehicle is not be found")
    public void users_should_see_warning_text_when_the_vehicle_is_not_be_found() {
        BrowserUtils.waitForVisibility(driver.findElement(By.xpath("(//div[@class='empty-screen']/p)[1]")),10);
        Assert.assertEquals("Maalesef aradığınız kriterlerde müsait araç yok.",resPage.emptyMessageLoc.get(0).getText());
        Assert.assertEquals("Sizin için önerilerimiz:",resPage.emptyMessageLoc.get(1).getText());
        Assert.assertEquals("-Yakındaki farklı bir konumu seçerek arama yapabilirsiniz.",resPage.recommendMessageLoc.get(0).getText());
        Assert.assertEquals("-Araç alış tarihini ve saatini değiştirebilirsiniz.",resPage.recommendMessageLoc.get(1).getText());
        Assert.assertEquals("-Araç bırakış tarihini ve saatini değiştirebilirsiniz.",resPage.recommendMessageLoc.get(2).getText());
    }

    @And("wait until car image animation on vehicle page")
    public void waitUntilCarImageAnimationOnVehiclePage() {
        BrowserUtils.waitFor(15);
    }

    @And("enter different drop location {string} on main page")
    public void enterDifferentDropLocationOnMainPage(String location) {
        resPage.differentSearchLocationMainPage(location);
    }

    @When("select start date")
    public void select_start_date() {
        new MainPage().defaultCalendarDate.get(3).click();
        new MainPage().timeSelected.click();
    }

    @When("click empty field")
    public void click_empty_field() {
        Actions actions = new Actions(driver);
        actions.moveByOffset(930,330).click().perform();
        //   driver.findElement(By.cssSelector(".home-slider__title")).click();
    }

    @When("click pick-up box")
    public void click_pick_up_box() {
        BrowserUtils.clickWithJS(resPage.pickUpInput);
    }

    @When("double click pick-up box")
    public void double_click_pick_up_box() {
        BrowserUtils.doubleClick(main.pickUpInput);
    }

    @When("click different drop off location box")
    public void click_different_drop_off_location_box() {
        BrowserUtils.clickWithJS(resPage.differentLocatorBox);
    }

    @When("double click different drop off location box")
    public void double_click_different_drop_off_location_box() {
        BrowserUtils.doubleClick(resPage.differentLocatorBox);
    }


    @And("verify drop off box {string} location")
    public void verifyDropOffBoxLocation(String expectedLocation) {
        BrowserUtils.waitForVisibility(resPage.rentNowButton.get(0),5);
        String actualLocation = driver.findElement(By.xpath("//input[contains(@data-input-type,'dropoff')]")).getAttribute("value");
        Assert.assertTrue(actualLocation.contains(expectedLocation));
    }

    @When("the user uses sorting criteria then url should change")
    public void the_user_uses_sorting_criteria_then_url_should_change() {
        resPage.sortAllforURL();
    }

    @Then("click back button")
    public void click_back_button() {
        resPage.backButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("Verify driver information page open")
    public void verify_driver_information_page_open() {
        BrowserUtils.waitForVisibility(resPage.nameBox,10);
        Assert.assertTrue(resPage.nameBox.isDisplayed());
    }

    @Then("verify user on detail page")
    public void verify_user_on_detail_page() {
        String url= driver.getCurrentUrl();
        Assert.assertTrue(url.contains("detail"));
    }

    @Then("select forward date for monthly date on listingpage")
    public void select_forward_date_for_monthly_date_on_listingpage() {
        resPage.pickupDateonListpage.click();
        resPage.defaultCalendarDate.get(20).click();
    }

    @Then("search {string} on listing page")
    public void search_on_listing_page(String location) {
        new MainPage().pickUpInput.sendKeys(location);
        new MainPage().pickUpMenu.get(0).click();
        BrowserUtils.waitFor(1);
    }

    @And("click empty {int} X and {int} Y coordinate")
    public void clickEmptyXAndYCoordinate(int X, int Y) {
        BrowserUtils.clickCoordinate(X,Y);
    }

    @Then("verify {string} inside car rental contract")
    public void verifyInsideCarRentalContract(String text) {
        resPage.checkDocumentation(text);
    }

    @And("select pick up default date +{int} without time")
    public void selectPickUpDefaultDateWithoutTime(int date) {
        resPage.pickUpIcon.click();
        new MainPage().defaultCalendarDate.get(date).click();
    }

    @And("select drop up default date +{int} without time")
    public void selectDropUpDefaultDateWithoutTime(int date) {
        resPage.dropUpIcon.click();
        BrowserUtils.waitFor(1);
        new MainPage().defaultCalendarDate.get(date).click();
    }
    @When("User hover {string} on vehicle detail")
    public void user_hover_on_vehicle_detail(String string) {
        resPage.hoverToElement(string);
    }

    @Then("User should see detail delivery type")
    public void user_should_see_detail_delivery_type() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(driver.findElement(By.cssSelector(".popover-container-content")).isDisplayed());
    }

    @When("User select {string} for Delivery Type")
    public void user_select_for_Delivery_Type(String deliveryType) {
        BrowserUtils.waitFor(6);
        WebElement element= driver.findElement(By.xpath("//input[@id='delivery_type-"+deliveryType+"']"));
        BrowserUtils.scrollToSize(0,1750);
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(element);
        BrowserUtils.waitFor(2);
    }

    @When("User hover Aracı nasıl teslim alacağım? on vehicle detail")
    public void user_hover_Aracı_nasıl_teslim_alacağım_on_vehicle_detail() {
        BrowserUtils.waitFor(2);
        WebElement element2= driver.findElement(By.xpath("(//*[@class='teslim'])[1]/span/b"));
        BrowserUtils.waitForVisibility(element2,10);
        BrowserUtils.hover(element2);
        BrowserUtils.waitFor(2);
    }

    @When("User scroll up")
    public void user_scroll_up() {
        resPage.upTopButton.click();
       BrowserUtils.waitFor(3);
    }

    @Then("the user should be able to see Rezervasyon No and Rezervasyon Numarası")
    public void the_user_should_be_able_to_see_Rezervasyon_No_and_Rezervasyon_Numarası() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(resPage.reservationNumber.get(0).isDisplayed());
        Assert.assertTrue(resPage.reservationNumber.get(1).isDisplayed());

    }

    @And("enter invalid card number")
    public void enterInvalidPaymentMethod() {
        resPage.invalidPaymentCard();
    }

    @Then("select {int} installments")
    public void select_installments(Integer int1) {
        driver.findElement(By.id("installment_"+int1)).click();
    }

    @Then("User should be see green check icon for card number and Card owner name")
    public void user_should_be_see_green_check_icon_for_card_number_and_Card_owner_name() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(resPage.greenCheckLoc.get(0).isDisplayed());
        BrowserUtils.waitFor(1);
        Assert.assertTrue(resPage.greenCheckLoc.get(1).isDisplayed());

    }

    @And("enter invalid card date")
    public void enterInvalidCardDate() {
        resPage.invalidPaymentCardDate();

    }

    @Then("verify pop up error message {string}")
    public void verifyPopUpErrorMessage(String errorText) {
        BrowserUtils.waitFor(10);
        Assert.assertTrue(errorText.equals(driver.findElement(By.cssSelector(".error-message")).getText()));

    }

    @Then("verify {string} and {string} is seen on the page")
    public void verify_and_is_seen_on_the_page(String pickUp, String drop) {
        String y=pickUp.substring(1);
        String x=drop.substring(1,5);
        BrowserUtils.waitFor(1);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        Assert.assertTrue(driver.findElements(By.cssSelector(".city-location")).get(0).getText().contains(y));
        BrowserUtils.waitFor(1);
        Assert.assertTrue(driver.findElements(By.cssSelector(".city-location")).get(1).getText().contains(x));
    }

    @Then("second verify {string} and {string} is seen on the page")
    public void second_verify_and_is_seen_on_the_page(String pickUp, String drop) {
        String y=pickUp.substring(1);
        String x=drop.substring(1,5);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(driver.findElements(By.cssSelector(".office-text-secondary")).get(0).getText().contains(y));
        BrowserUtils.waitFor(2);
        System.out.println("Driver.get().findElements(By.cssSelector(\".office-text-secondary\")).get(1).getText() = " + driver.findElements(By.cssSelector(".office-text-secondary")).get(1).getText());
        System.out.println("x = " + x);
        Assert.assertTrue(driver.findElements(By.cssSelector(".office-text-secondary")).get(1).getText().contains(x));
    }

    @And("User can not see payment page")
    public void userCanNotSeePaymentPage() {
        BrowserUtils.waitFor(5);
        Assert.assertTrue(resPage.nameBox.isDisplayed());
        Assert.assertTrue(resPage.kvkkCheckBox.isDisplayed());
        Assert.assertTrue(resPage.birthdayBox.isDisplayed());
    }

    @Then("verify find button seen main page")
    public void verifyFindButtonSeenMainPage() {
        BrowserUtils.waitForClickablility(resPage.findButton,5);
        resPage.findButton.click();
    }


    @Given("Postman get payment type")
    public void postmanGetPaymentType() {
        resPage.sendStringProperties();
    }

    @Then("verify open payment page")
    public void verifyOpenPaymentPage() {
        BrowserUtils.waitForVisibility(resPage.cardNameBox,8);
        Assert.assertTrue(resPage.cardNameBox.isDisplayed());
        Assert.assertTrue(resPage.cardCvc.isDisplayed());
    }
}
