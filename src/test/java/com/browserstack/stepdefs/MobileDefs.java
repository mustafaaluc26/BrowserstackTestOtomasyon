package com.browserstack.stepdefs;

import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.pageobjects.CampaignsLocationsPage;
import com.browserstack.pageobjects.LoginPage;
import com.browserstack.pageobjects.MobilePage;
import com.browserstack.pageobjects.ReservationPage;
import com.browserstack.util.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Map;

public class MobileDefs {
    ReservationPage page= new ReservationPage();
    MobilePage mobilePage= new MobilePage();
    WebDriver webDriver=RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();
    LoginPage loginPage = new LoginPage();

    @When("the user changes language {string} in mobil view")
    public void the_user_changes_language_in_mobil_view(String lang) {
        BrowserUtils.waitForClickablility(mobilePage.dropdownMobileMenu,4);
        mobilePage.dropdownMobileMenu.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(mobilePage.trlanguageSelectMobil); //click
        BrowserUtils.waitFor(1);

    }

    @When("the user changes currency {string} in mobil view")
    public void the_user_changes_currency_in_mobil_view(String currency) {
        BrowserUtils.waitForClickablility(mobilePage.dropdownMobileMenu,4);
        mobilePage.dropdownMobileMenu.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(mobilePage.mobiltlira);
        BrowserUtils.waitFor(3);

    }

    @Given("the page is on the mobile view")
    public void the_page_is_on_the_mobile_view() {
        BrowserUtils.waitFor(1);
        //IphoneX configuration
        webDriver.manage().window().setSize(new Dimension(375, 812));
        BrowserUtils.waitFor(2);
    }

    @When("click the monthly rental in mobile view")
    public void click_the_monthly_rental_in_mobile_view()  {
        BrowserUtils.clickWithJS(mobilePage.monthlyRental);
    }

    @Then("monthly rental function should be available in mobile view")
    public void monthly_rental_function_should_be_available_in_mobile_view(){
        Assert.assertTrue(mobilePage.monthlyInfoMassage.isDisplayed());
        Assert.assertTrue(mobilePage.monthPicker.isEnabled());
        BrowserUtils.waitFor(1);
    }

    @When("click the daily rental in mobile view")
    public void click_the_daily_rental_in_mobile_view() {
        BrowserUtils.clickWithJS(mobilePage.dailyRental);
    }

    @Then("daily rental function should be available in mobile view")
    public void daily_rental_function_should_be_available_in_mobile_view(){
        Assert.assertTrue(mobilePage.dropOffDate.isEnabled());
        BrowserUtils.waitFor(1);
    }

    @When("enter word to pick-up information box in mobile view")
    public void enter_word_to_pick_up_information_box_in_mobile_view(){

        mobilePage.pickUpInput.click();
        BrowserUtils.waitFor(1);

        mobilePage.searchBoxMobile.sendKeys("saw");
        BrowserUtils.waitFor(1);
    }

    @Then("location list should be available in mobile view")
    public void location_list_should_be_available_in_mobile_view() {

        Assert.assertFalse(mobilePage.pickUpMenu.isEmpty());

        String actualLocation="Sabiha Gökçen Havalimanı";
        String expectedLocation=mobilePage.pickUpMenu.get(0).getText();
        Assert.assertTrue(expectedLocation.contains(actualLocation));
    }

    @When("select location from location list in mobile view")
    public void select_location_from_location_list_in_mobile_view(){
        mobilePage.pickUpMenu.get(0).click();
        BrowserUtils.waitFor(1);
    }

    @Then("calender should be opened in mobile view")
    public void calender_should_be_opened_in_mobile_view(){
        Assert.assertTrue(mobilePage.mobileDatePicker.isDisplayed());
        BrowserUtils.waitFor(1);
    }

    @When("select date and time from calendar in mobile view")
    public void select_date_and_time_from_calendar_in_mobile_view(){
        mobilePage.selectCalender();
    }

    @Then("dates should be selected in mobile view")
    public void dates_should_be_selected_in_mobile_view(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='picker-item__selected-field']")).isEnabled());
        BrowserUtils.waitFor(1);
    }


    @When("click the different drop off location checkbox in mobile view")
    public void click_the_different_drop_off_location_checkbox_in_mobile_view() {
        mobilePage.dropOffPicker.click();
    }

    @Then("drop-off information box should be available in mobile view")
    public void drop_off_information_box_should_be_available_in_mobile_view() {
        Assert.assertTrue(mobilePage.dropOffInput.isEnabled());
    }

    @When("enter word to drop-off information box in mobile view")
    public void enter_word_to_drop_off_information_box_in_mobile_view() {
        BrowserUtils.waitFor(1);
        mobilePage.searchBoxMobile.sendKeys("esb");
    }

    @Then("drop-off location list should be available in mobile view")
    public void drop_off_location_list_should_be_available_in_mobile_view() {
        Assert.assertFalse(mobilePage.dropOffMenu.isEmpty());
    }

    @When("select location from drop-off location list in mobile view")
    public void select_location_from_drop_off_location_list_in_mobile_view(){
        BrowserUtils.waitFor(1);
        mobilePage.dropOffMenu.get(0).click();
    }

    @Then("location should be selected in mobile view")
    public void location_should_be_selected_in_mobile_view() {

        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='Ankara-Esenboğa Havalimanı (ESB)']")).isEnabled());
        BrowserUtils.waitFor(1);
    }

    @Then("the user should be able to make reservation in mobile view")
    public void the_user_should_be_able_to_make_reservation_in_mobile_view() {
        new ReservationPage().verifyReservation();
    }

    @Given("the user is on the rent a car campaigns page in mobile view")
    public void the_user_is_on_the_rent_a_car_campaigns_page_in_mobile_view() {
        mobilePage.dropdownMobileMenu.click();
        BrowserUtils.doubleClick(webDriver.findElement(By.xpath("//*[@*='nav-item search-res campaign']")));
        BrowserUtils.waitFor(1);
    }

    @When("the user goes the {string} and enter {string} in mobile view")
    public void the_user_goes_the_and_enter_in_mobile_view(String campaign, String campaignCode) {
        mobilePage.enterCampaignCode(campaign,campaignCode);
    }

    @Then("the user can join the {string} in mobile view")
    public void the_user_can_join_the_in_mobile_view(String campaign) {
        mobilePage.verifyCampaignCode(campaign);
    }

    @When("the user selects following filters then listing page should be filtered in mobile view")
    public void the_user_selects_following_filters_then_listing_page_should_be_filtered_in_mobile_view(List<String> filters) {
        mobilePage.filtersAllCheck(filters);
    }

    @When("the user uses sorting criteria then vehicle listing can sorted in mobile view")
    public void the_user_uses_sorting_criteria_then_vehicle_listing_can_sorted_in_mobile_view() {
        mobilePage.sortAndCheck();
    }

    @And("click mobil search box")
    public void clickMobilSearchBox() {
        BrowserUtils.waitForClickablility(mobilePage.pickUpInput,5);
        try {
            mobilePage.pickUpInput.click();
            Assert.assertTrue(mobilePage.searchBoxMobile.isDisplayed());
        } catch (NoSuchElementException e) {
            mobilePage.pickUpInput.click();
            e.printStackTrace();
        }

        BrowserUtils.waitFor(2);
    }

    @And("search mobil {string}")
    public void searchMobil(String location) {
        mobilePage.searchTextBox(location);
    }

    @And("click mobil find button")
    public void clickMobilFindButton() {
        BrowserUtils.waitForClickablility(mobilePage.searchMobileButton,10);
        mobilePage.searchMobileButton.click();
//        BrowserUtils.waitFor(20);
        BrowserUtils.waitForClickablility(mobilePage.rentButton.get(0),50);
    }

    @Then("verify mobil open vehicle page")
    public void verifyMobilOpenVehiclePage() {
        BrowserUtils.waitForVisibility(mobilePage.rentButton.get(0),20);
        Assert.assertTrue(mobilePage.rentButton.get(0).isDisplayed());
    }

    @When("click mobil filter button")
    public void clickMobilFilterButton() {
        BrowserUtils.waitFor(2);
        mobilePage.filterMobile.click();
    }

  //  @And("select mobil filter vendor")
    //   public void selectMobilFilterVendor() {
    //      mobilePage.selectVendor();
    //   }

    @When("select mobil vendor filter {string}")
    public void select_vendor_mobil_filter(String vendor) {
        mobilePage.selectVendor(vendor);
    }

    @And("click mobil forward arrow")
    public void clickMobilForwardArrow() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(mobilePage.forwardArrow,3);
        mobilePage.forwardArrow.click();
        BrowserUtils.waitFor(1);
    }

    @Then("verify mobil filter {string} vendor")
    public void verifyMobilFilterVendor(String vendorName) {
        BrowserUtils.waitForVisibility(mobilePage.rentButton.get(0),4);
        BrowserUtils.verifyElementDisplayed(webDriver.findElement(By.xpath("//img[contains(@alt,'"+vendorName+"')]")));
    }

    @When("select car and check delivery type")         //aluc
    public void select_car_and_check_delivery_type() {
        mobilePage.selectcarForReview();
    }

    @Then("the user verify price and office type in mobil view")
    public void the_user_verify_price_and_office_type_in_mobil_view() {
        mobilePage.verifyPriceOfficeTypeMobil();
    }
    @Then("the user verify car model and price in mobil view")
    public void the_user_verify_car_model_and_price_in_mobil_view() {
        mobilePage.carNameAndPriceMobil();
    }

    @When("select mobil first car")
    public void selectMobilFirstCar() {
        mobilePage.selectFirstCar();
    }


    @And("enter mobil payment method")
    public void enterMobilPaymentMethod() {
        mobilePage.paymentInformation();
    }

    @Given("mobil login")
    public void mobilLogin() {
        mobilePage.mobileLogin();
    }

    @And("select monthly date and time from calendar in mobile view")
    public void selectMonthlyDateAndTimeFromCalendarInMobileView() {
        mobilePage.selectMonthlyCalender();
    }

    @Then("the mobil user should be able to login")
    public void theMobilUserShouldBeAbleToLogin() {
        BrowserUtils.waitForClickablility(mobilePage.dropdownMobileMenu,8);
        mobilePage.dropdownMobileMenu.click();
        BrowserUtils.waitForClickablility(mobilePage.signOut,8);
        BrowserUtils.verifyElementDisplayed(mobilePage.signOut);
    }

    @When("click mobil account button")
    public void clickMobilAccountButton() {
        mobilePage.accountNameLocator.click();
    }

    @Then("verify mobil account page")
    public void verifyMobilAccountPage() {
        mobilePage.verifyAccountSubPage();
    }

    @Then("verify mobil past reservations view")
    public void verifyMobilPastReservationsView() {
        Assert.assertTrue(webDriver.findElements(By.cssSelector("div.col-inner")).size()>2);
    }

    @And("the mobil user should be able to change password")
    public void theMobilUserShouldBeAbleToChangePassword() {

    }

    @When("mobil logOut")
    public void mobilLogOut() {
        mobilePage.mobileLogOut();
        BrowserUtils.waitFor(1);
    }

    @And("the user selects ranged filters then listing page should be filtered in mobile view")
    public void the_user_selects_ranged_filters_then_listing_page_should_be_filtered_in_mobile_view(List<String> rangedFilters) {
        mobilePage.rangedFilter(rangedFilters);
    }

    @Given("click mobil dropdown")
    public void clickMobilDropdown() {
        BrowserUtils.waitForClickablility(mobilePage.dropdownMobileMenu,4);
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(mobilePage.dropdownMobileMenu);
       // mobilePage.dropdownMobileMenu.click();
        BrowserUtils.waitFor(1);
    }

    @When("click mobil reservation search")
    public void clickMobilReservationSearch() {
        BrowserUtils.waitForClickablility(mobilePage.reservationDropDown,3);
        mobilePage.reservationDropDown.click();
    }

    @Then("verify mobil {string} search page open")
    public void verifyMobilSearchPageOpen(String location) {
        mobilePage.verifyLocationPageOpen(location);
    }
    @Then("the mobil user can view vehicle listing page of {string}")
    public void theMobilUserCanViewVehicleListingPageOf(String location) {
        mobilePage.verifyVehicleListingPage(location);
    }

    /*@And("send mobil sms key")
    public void sendMobilSmsKey() {
        mobilePage.sendSms();
    }*/


    @When("click the currency selector in mobile view")                 // aluc
    public void click_the_currency_selector_in_mobile_view() {
        mobilePage.currencySelectMobil.click();
    }

    @Then("currency selector dropdown should be opened in mobile view")             // aluc
    public void currency_selector_dropdown_should_be_opened_in_mobile_view() {
        mobilePage.dropdownMobileMenu.click();
        BrowserUtils.waitFor(1);

        //  Assert.assertTrue(Driver.get().findElement(By.xpath("//li/a/span/i[@*='icon icon-try']")).isEnabled());

        Assert.assertTrue(mobilePage.mobileuro.isEnabled());
        Assert.assertTrue(mobilePage.mobiltlira.isEnabled());
        Assert.assertTrue(mobilePage.mobildolar.isEnabled());
        Assert.assertTrue(mobilePage.mobilpound.isEnabled());
    }

    @When("click the language in mobile view")                  // aluc
    public void click_the_language_in_mobile_view() {

        BrowserUtils.clickWithJS(mobilePage.trlanguageSelectMobil); //click
        BrowserUtils.waitFor(1);
    }

    @Then("language dropdown should be opened in mobile view")                  // aluc
    public void language_dropdown_should_be_opened_in_mobile_view() {
        mobilePage.dropdownMobileMenu.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(mobilePage.trlanguageSelectMobil.isEnabled());
        Assert.assertEquals("TR", mobilePage.currentlanguageSelectMobil.getText());
        Assert.assertTrue(mobilePage.ENlanguageSelectMobil.isEnabled());
    }

    @When("check the call center in mobile view")                           // aluc
    public void check_the_call_center_in_mobile_view() {
        Assert.assertTrue(page.callCenter.isEnabled());
        BrowserUtils.waitFor(1);
    }

    @Then("call center number and text should be correct in mobile view")  // aluc
    public void call_center_number_and_text_should_be_correct_in_mobile_view() {
        String expectedText= "MİSAFİR MERKEZİ";
        Assert.assertEquals(page.guessCenter.getText(), expectedText);

        String expectedPhone="0850 360 5 360";
        Assert.assertEquals(page.centerPhone.getText(), expectedPhone);
    }

    @When("click the popular locations in mobile view")                     // aluc
    public void click_the_popular_locations_in_mobile_view() {
        BrowserUtils.waitFor(2);
        BrowserUtils.doubleClick(page.recentSearch);
        //page.recentSearch.click();
        BrowserUtils.waitFor(1);
    }

    @Then("popular locations dropdown should be opened in mobile view")         // aluc
    public void popular_locations_dropdown_should_be_opened_in_mobile_view() {
        Assert.assertFalse(webDriver.findElements(By.xpath("//div/a[@class='dropdown-item']")).isEmpty());
    }

    @When("click the find reservation in mobile view")                      // aluc
    public void click_the_find_reservation_in_mobile_view() {
        if(mobilePage.dropdownMobileMenu.getAttribute("aria-expanded").equalsIgnoreCase("false")){
            mobilePage.dropdownMobileMenu.click();
        }
        //BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(mobilePage.findReservationMobile,3);
        mobilePage.findReservationMobile.click();
        //BrowserUtils.waitForVisibility(mobilePage.reservationNoMobile,10);
    }

    @Then("find reservation page should be opened in mobile view")                            // aluc
    public void find_reservation_page_should_be_opened_in_mobile_view() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(mobilePage.reservationNoMobile.isEnabled());
        webDriver.findElement(By.xpath("//i[@*='icon-close-icon']")).click();
    }

    @When("click the campaigns on header bar in mobile view")                             // aluc
    public void click_the_campaigns_on_header_bar_in_mobile_view() {
        mobilePage.dropdownMobileMenu.click();
        BrowserUtils.waitFor(1);
        mobilePage.campaignsMobile.click();
    }

    @Then("campaigns page should be opened in mobile view")                               // aluc
    public void campaigns_page_should_be_opened_in_mobile_view() {
        BrowserUtils.waitFor(2);

        String expectedTitle="ARAÇ KİRALAMA KAMPANYALARI";
        Assert.assertEquals( expectedTitle,webDriver.findElement(By.xpath("//div/h1")).getText());

    }

    @When("the mobil user click the register")                         // aluc
    public void the_mobil_user_click_the_register() {

        mobilePage.registerMobil.click();
        BrowserUtils.waitFor(1);
    }

    @When("the mobil user enter the personal information")                         // aluc
    public void the_mobil_user_enter_the_personal_information() {
        loginPage.registerInformation();
    }

    @When("the mobil user click Membership agreement")                         // aluc
    public void the_mobil_user_click_Membership_agreement() {
        loginPage.checkKvkk.click();
    }

    @When("the mobil user click registerButton")                       // aluc
    public void the_mobil_user_click_registerButton() {
        loginPage.registerButton.click();
    }

    @Then("the mobil user should be able to register")                 // aluc
    public void the_mobil_user_should_be_able_to_register() {
        BrowserUtils.waitForVisibility(loginPage.registerRequest,5);
        Assert.assertTrue(loginPage.registerRequest.isDisplayed());
        //Assert.assertTrue(loginPage.registerRequest.isDisplayed());
        BrowserUtils.waitForClickablility(loginPage.registerApprove,2);
        loginPage.registerApprove.click();
    }

    @When("the mobil user should not able to register without membership agreement")    // aluc
    public void the_mobil_user_should_not_able_to_register_without_membership_agreement() {
        String expectedErrorText="Üye olmak için üyelik sözleşmesini kabul etmeniz gerekmektedir.";
        String actualErrorText=mobilePage.registerErrorMessage.getText();
        Assert.assertEquals(expectedErrorText,actualErrorText);
    }

    @When("the mobil user should not able to register with wrong email")            // aluc
    public void the_mobil_user_should_not_able_to_register_with_wrong_email() {
        String expectedErrorText="Lütfen geçerli bir e-posta adresi giriniz.";
        String actualErrorText=mobilePage.wrongEmailMessage.getText();
        Assert.assertEquals(expectedErrorText,actualErrorText);
    }

    @And("the mobil user changes language {string}")
    public void theMobilUserChangesLanguage(String language) {
        mobilePage.changeLanguage(language);
    }

    @Then("mobil page language should be {string}")
    public void mobilPageLanguageShouldBe(String language) {
        mobilePage.verifyLanguage(language);
    }

    @And("the mobil user changes currency then page currency should be changed")
    public void theMobilUserChangesCurrencyThenPageCurrencyShouldBeChanged(List<String> currency) {
        mobilePage.changePriceType(currency);
    }

    @Given("click sing in button")         // aluc
    public void click_sing_in_button() {
        BrowserUtils.waitFor(1);
        mobilePage.signIn.click();
    }

    @Given("the mobil registered user click forgot password button")                 // aluc
    public void the_mobil_registered_user_click_forgot_password_button() {
        mobilePage.forgetPasswordMobil.click();
    }

    @And("the mobil user enters {string} promotion code")
    public void theMobilUserEntersPromotionCode(String code) {
        mobilePage.enterPromoCode(code);
    }

    @Then("the mobil promotion code can be applied")
    public void theMobilPromotionCodeCanBeApplied() {
        mobilePage.verifyValidPromoCode();
    }

    @Then("the mobil promotion code can not be applied")
    public void theMobilPromotionCodeCanNotBeApplied() {
        mobilePage.verifyInvalidPromoCode();
    }

    @When("the mobil user select filter option then URL contains selected option")
    public void theMobilUserSelectFilterOptionThenURLContainsSelectedOption(Map<String,String> filters) {
        mobilePage.filterOptionsMobil(filters);
    }

    @Then("the mobil user selects more filter option then URL should be updated")
    public void theMobilUserSelectsMoreFilterOptionThenURLShouldBeUpdated() {
        mobilePage.verifyFilterUpdateURL();
    }

    @Then("the mobil user selects ranged filters then URL contains selected option")
    public void theMobilUserSelectsRangedFiltersThenURLContainsSelectedOption(List<String> rangedFilters) {
        mobilePage.selectRangeFilter(rangedFilters);
    }

    @When("click selected location in mobil")                   //aluc
    public void click_selected_location_in_mobil() {
        BrowserUtils.clickWithJS(mobilePage.selectedLocation);
    }

    @When("enter different drop location {string} in mobil view")                 //aluc
    public void enter_different_drop_location_in_mobil_view(String location) {
        BrowserUtils.waitFor(1);
        mobilePage.searchBoxMobile.sendKeys(location);
        mobilePage.dropOffMenu.get(0).click();
        BrowserUtils.waitFor(1);
    }

    @When("the mobil user click promotion code button")
    public void the_mobil_user_click_promotion_code_button() {
        mobilePage.promoCodeLocator.click();
        BrowserUtils.waitFor(1);
    }

    @Then("verify promo code is working  in mobil view")
    public void verify_promo_code_is_working_in_mobil_view() {
        Assert.assertTrue(new CampaignsLocationsPage().promoCodeWindow.isDisplayed());
    }
    @Then("input boxes should be enabled and driver&invoice information should be matched in mobil view")
    public void input_boxes_should_be_enabled_and_driver_invoice_information_should_be_matched_in_mobil_view() {

        BrowserUtils.waitFor(1);
        mobilePage.verifyDriverInformationMobil();
        BrowserUtils.hover(webDriver.findElement(By.xpath("//*[@*='/tr/firma/hakkimizda/']")));
        BrowserUtils.waitFor(1);
    }
    @When("the mobil user scroll down")
    public void theMobilUserScrollDown() {
        BrowserUtils.scrollToSize(0,900);
    }

    @And("click mobil X button on filter page")
    public void clickMobilXButtonOnFilterPage() {
        BrowserUtils.waitForClickablility(mobilePage.filter_X_Button,3);
        mobilePage.filter_X_Button.click();
    }
    @Then("User click sort button and able to see orange sort dot in mobil view")
    public void user_click_sort_button_and_able_to_see_orange_sort_dot_in_mobil_view() {
        mobilePage.checkSortDot();
    }

    @Then("User able to see selected sort criteria with orange text in mobil view")
    public void user_able_to_see_selected_sort_criteria_with_orange_text_in_mobil_view() {
        mobilePage.checkOrangeText();
    }

    @When("Enters {string} and enters invalid {string} in mobil view")
    public void entersAndEntersInvalidInMobilView(String mail, String password) {
        mobilePage.mobileLoginString(mail,password);
    }

    @And("Enter invalid {string}  and {string} in mobil view")
    public void enterInvalidAndInMobilView(String password1, String password2) {
        mobilePage.changeStringPassword(password1,password2);
    }

    @When("the mobil user changes currency {string} then page currency should be changed")
    public void the_mobil_user_changes_currency_then_page_currency_should_be_changed(String currency) {
        mobilePage.changeMobilCurrency(currency);
    }

    @When("select first car for mobil without check price")
    public void select_first_car_for_mobil_without_check_price() {
        mobilePage.selectFirstCarForMobil();
    }

    @Then("the mobil user should be able to see vehicle listing")
    public void the_mobil_user_should_be_able_to_see_vehicle_listing() {
        BrowserUtils.waitForVisibility(mobilePage.vehicleCount,10);
        Assert.assertTrue(mobilePage.vehicleCount.isDisplayed());
    }

    @And("add extra Products & Assurances in mobil view")
    public void addExtraProductsAssurancesInMobilView() {
        mobilePage.addMobilExtraProductsAssurances();
    }

    @Then("verify price on driver information page &Vehicle Selection in mobil view")
    public void verifyPriceOnDriverInformationPageVehicleSelectionInMobilView() {
        mobilePage.verifyMobilPrice();
    }

    @And("mobil send sms key")
    public void mobilSendSmsKey() {
        mobilePage.sendMobilSms();
    }

    @Then("verify price on reservation summary page in mobil view")
    public void verifyPriceOnReservationSummaryPageInMobilView() {
        mobilePage.verifyMobilPriceAfterPayment();
    }

    @When("click Detaylar için tıklayınız")
    public void click_Detaylar_için_tıklayınız() {
        webDriver.findElement(By.cssSelector(".display-switch ")).click();
    }

    @Then("verify filter button orange dot available")
    public void verify_filter_button_orange_dot_available() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(mobilePage.filterButtonDotLoc.isDisplayed());
    }

    @Then("mobil verify the number of filters selected must be {int}")
    public void mobilVerifyTheNumberOfFiltersSelectedMustBe(int number) {
        Assert.assertTrue(mobilePage.selectedMobilFilterTitleList.size()==number);

    }

    @And("select mobil filter {string}")
    public void selectMobilFilter(String filter) {
        mobilePage.selectMobilFilter(filter);
    }

    @Then("mobil verify {string} search page open")
    public void mobilVerifySearchPageOpen(String arg0) {
    }

    @When("click mobil find button inside landing page")
    public void clickMobilFindButtonInsideLandingPage() {
        new ReservationPage().findButton.click();
        BrowserUtils.waitFor(20);
//        BrowserUtils.waitForClickablility(mobilePage.rentButton.get(0),30);
    }

    @Given("user select language and verify on main page in mobil")
    public void user_select_language_and_verify_on_main_page_in_mobil(List<String> language) {
        mobilePage.changeLanguageMainPageMobil(language);
    }

    @When("user select language and verify on car detail page in mobil")
    public void user_select_language_and_verify_on_car_detail_page_in_mobil(List<String> language) {
        mobilePage.changeLanguageDetailPageMobil(language);
    }

    @Then("user select language and verify on reservation summary page in mobil")
    public void user_select_language_and_verify_on_reservation_summary_page_in_mobil(List<String> language) {
        mobilePage.changeLanguageReservationSummaryPageMobil(language);
    }

    @When("click mobil search box in landing page")
    public void click_mobil_search_box_in_landing_page() {
        BrowserUtils.waitForClickablility(mobilePage.pickUpInputLandingPage,5);
        try {
            mobilePage.pickUpInputLandingPage.click();
            Assert.assertTrue(mobilePage.searchBoxMobile.isDisplayed());
        } catch (NoSuchElementException e) {
            mobilePage.pickUpInputLandingPage.click();
            e.printStackTrace();
        }

        BrowserUtils.waitFor(2);
    }

    @Then("verify drop off box {string} location in mobil view")
    public void verify_drop_off_box_location_in_mobil_view(String expectedLocation) {
        BrowserUtils.waitForVisibility(new ReservationPage().rentNowButton.get(0),10);
        String actualLocation = mobilePage.carDropLocationTitle.getText();
        Assert.assertTrue(actualLocation.contains(expectedLocation));
    }

    @And("mobil cancel different location click X button in listing page")
    public void mobilCancelDifferentLocationClickXButtonInListingPage() {
        BrowserUtils.clickWithJS(mobilePage.cancelXButton.get(2));
    }

    @When("user select language and verify on campaign page in mobil")
    public void user_select_language_and_verify_on_campaign_page_in_mobil(List<String> language) {
        mobilePage.changeLanguageCampaignsPageMobil(language);
    }

    @When("user select language and verify on campaign detail page in mobil")
    public void user_select_language_and_verify_on_campaign_detail_page_in_mobil(List<String> language) {
        mobilePage.changeLanguageCampaignsDetailPageMobil(language);

    }

    @And("click only mobil find button")
    public void clickOnlyMobilFindButton() {
        BrowserUtils.waitFor(3);
        mobilePage.searchMobileButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("click monthly date in landing page")
    public void click_monthly_date_in_landing_page() {
        BrowserUtils.waitFor(1);
        webDriver.findElement(By.cssSelector(".icon-calendar-monthly")).click();
        BrowserUtils.waitFor(1);
    }

    @When("the user select filter option then title & description contains selected option in mobil view")
    public void the_user_select_filter_option_then_title_description_contains_selected_option_in_mobil_view(List<String> filters) {
        mobilePage.selectVerifyFilterTitleDescriptionInMobil(filters);
    }

    @And("mobil click different drop off location box")
    public void mobilClickDifferentDropOffLocationBox() {
        new ReservationPage().mailReservSearchBox.click();
    }

    @And("mobil cancel different location click X button in main page")
    public void mobilCancelDifferentLocationClickXButtonInMainPage() {
        BrowserUtils.clickWithJS(mobilePage.cancelXButton.get(1));

    }

    @Then("select forward date for monthly date on listingpage in mobil")
    public void select_forward_date_for_monthly_date_on_listingpage_in_mobil() {
        new ReservationPage().pickUpIcon.click();
        webDriver.findElement(By.cssSelector(".icon-chevron-down")).click();
        webDriver.findElement(By.xpath("(//*[@class='time-picker__option'])[3]")).click();
    }

    @Then("verify the search is monthly")
    public void verify_the_search_is_monthly() {
        String actual=webDriver.findElement(By.xpath("(//*[@class='date'])[2]")).getText();
        Assert.assertTrue(actual.substring(0,2).equals("Ay"));
    }

    @When("user click pickUp button")
    public void user_click_pickUp_button() {
        new ReservationPage().pickUpIcon.click();
        BrowserUtils.waitFor(2);
    }

    @When("search mobil {string} in listingPage")
    public void search_mobil_in_listingPage(String location) {
        webDriver.findElement(By.cssSelector(".input-group-prepend")).click();
        mobilePage.searchTextBox(location);
    }

    @Then("verify the search is default monthly")
    public void verifyTheSearchIsDefaultMonthly() {
        String actual=webDriver.findElement(By.xpath("(//*[@class='date'])[2]")).getText();
        Assert.assertTrue(actual.substring(5,9).equals("2 Ay"));
    }

    @And("click mobil clear filter button")
    public void clickMobilClearFilterButton() {
        BrowserUtils.waitForClickablility(mobilePage.clearFilterButton,5);
        mobilePage.clearFilterButton.click();
    }

    @Given("user click login button")
    public void user_click_login_button() {
        webDriver.findElement(By.xpath("(//i[@class='icon icon-sign-in-icon'])[1]")).click();
        BrowserUtils.waitFor(2);
    }

    @Then("verify mobil {string} and {string} is seen on the page")
    public void verifyMobilAndIsSeenOnThePage(String pickUp, String drop) {
        String y=pickUp.substring(1);
        String x=drop.substring(1,5);
        BrowserUtils.waitFor(1);
        Assert.assertTrue(webDriver.findElements(By.cssSelector(".location")).get(0).getText().contains(y));
        BrowserUtils.waitFor(1);
        Assert.assertTrue(webDriver.findElements(By.cssSelector(".location")).get(1).getText().contains(x));
    }

    @When("click {string} with text locator")
    public void click_with_text_locator(String string) {
        WebElement element=webDriver.findElement(By.xpath("//span[text()='"+string+"']"));
        BrowserUtils.clickWithJS(element);
        element.click();
        BrowserUtils.waitFor(2);
    }

   @When("select date {int} without time in mobil")
   public void select_date_without_time_in_mobil(Integer date) {
        mobilePage.selectDateWithoutTime(date);
   }

    @When("save reservation no on reservation detail page")
    public void saveReservationNoOnReservationDetailPage() {
        mobilePage.saveReservationNumber();
    }

    @Then("verify past reservations number in my account page")
    public void verifyPastReservationsNumberInMyAccountPage() {
        mobilePage.verifyReservationNumber();
    }

    @When("user scroll to {string}")
    public void user_scroll_to(String string) {
        BrowserUtils.scrollToElement(webDriver.findElement(By.xpath("(//*[text()='"+string+"'])[1]")));
        BrowserUtils.waitFor(1);
    }

    @Then("click Nerede Bırakacaksınız? box in mobil landing page")
    public void click_Nerede_Bırakacaksınız_box_in_mobil_landing_page() {
        new ReservationPage().differentLocatorBox.click();
        BrowserUtils.waitFor(1);
    }



}
