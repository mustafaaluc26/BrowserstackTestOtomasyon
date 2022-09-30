package com.browserstack.stepdefs;

import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.pageobjects.CampaignsLocationsPage;
import com.browserstack.pageobjects.MainPage;
import com.browserstack.pageobjects.ReservationPage;
import com.browserstack.util.BrowserUtils;
import com.browserstack.util.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class CampaignsLocationsDefs {

    CampaignsLocationsPage campaignsLocationsPage =new CampaignsLocationsPage();
    public WebDriver webDriver;
    ReservationPage reservationPage = new ReservationPage();

    @When("the user changes currency {string}")
    public void the_user_changes_currency(String currency) {
        String locator= "//a/span/i[@*='icon icon-"+currency+"']";
        campaignsLocationsPage.currencySelect.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(webDriver.findElement(By.xpath(locator)));
    }


    @When("the user goes the {string} and enter {string}")
    public void the_user_goes_the_and_enter(String campaign, String campaignCode) {
        campaignsLocationsPage.selectCampaignAndCode(campaign,campaignCode);
    }

    @Then("the user can join the {string}")
    public void the_user_can_join_the(String campaign) {
        campaignsLocationsPage.verifyJoinCampaign(campaign);
    }

    @Given("the user is on the popular locations")
    public void the_user_is_on_the_popular_locations() {
        BrowserUtils.waitForVisibility(new MainPage().popularLocationsTable,10);
        BrowserUtils.hover(new MainPage().popularLocationsTable);
    }

    @When("the user goes the {string}")
    public void the_user_goes_the(String location) {
        campaignsLocationsPage.selectPopularLocation(location);
    }

    @Then("the user can view vehicle listing page of {string}")
    public void the_user_can_view_vehicle_listing_page_of(String location) {
        campaignsLocationsPage.verifyVehicleListingPageToCampaign(location);
    }

    @Given("the user is on the landing pages")
    public void The_user_is_on_the_landing_pages() {

        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.scrollToSize(0,3200);
        BrowserUtils.waitFor(4);
    }

    @When("the user goes the {string} landing page")
    public void the_user_goes_the_landing_page(String location) {
        campaignsLocationsPage.searchBannerLocation(location);
    }

    @When("the user selects following filters then listing page should be filtered")
    public void the_user_selects_following_filters_then_listing_page_should_be_filtered(List<String> filters) {
        campaignsLocationsPage.filterMenu(filters);
    }

    @And("the user selects ranged filters then listing page should be filtered")
    public void the_user_selects_ranged_filters_then_listing_page_should_be_filtered(List<String> rangedFilters) {
        campaignsLocationsPage.rangedFilter(rangedFilters);
    }

    @Then("the user selects following filters and check all cars details information")
    public void the_user_selects_following_filters_and_check_all_cars_details_information(List<String> filters) {

        campaignsLocationsPage.filterDetailCheck(filters);

    }
    @When("the user uses sorting criteria then vehicle listing can sorted")
    public void the_user_uses_sorting_criteria_then_vehicle_listing_can_sorted() {
        reservationPage.sortAll();
    }

    @When("the user changes currency then page currency should be changed")
    public void the_user_changes_currency_then_page_currency_should_be_changed(List<String> currency) {
        campaignsLocationsPage.changePriceType(currency);
    }

    @Then("the promotion code can be applied")
    public void the_promotion_code_can_be_applied() {
        BrowserUtils.waitForVisibility(campaignsLocationsPage.rentNowButton.get(0),50);
        Assert.assertTrue(campaignsLocationsPage.promoCompanyFlagList.get(0).isDisplayed());
    }

    @Then("the promotion code can not be applied")
    public void the_promotion_code_can_not_be_applied() {
        Assert.assertTrue(campaignsLocationsPage.promoCodeErrorMessage.isEnabled());
        campaignsLocationsPage.campaignWindowCancelButton.click();
        BrowserUtils.waitForVisibility(campaignsLocationsPage.rentNowButton.get(1),20);
    }

    @When("the user goes to comments")
    public void the_user_goes_to_comments() {
        BrowserUtils.waitFor(2);
        campaignsLocationsPage.commentLocator.get(0).click();
        BrowserUtils.waitFor(3);
    }

    @Then("user comments should be opened")
    public void user_comments_should_be_opened() {
        campaignsLocationsPage.verifyCommitWindow();
    }

    @When("the user select filter option then URL contains selected option")
    public void the_user_select_filter_option_then_URL_contains_selected_option(Map<String,String> filters) {
        campaignsLocationsPage.filterOptions(filters);
    }

    @And("the user selects more filter option then URL should be updated")
    public void the_user_selects_more_filter_option_then_URL_should_be_updated() {
        campaignsLocationsPage.verifyFilterUpdateURL();
    }


    @When("the user selects ranged filters then URL contains selected option")
    public void the_user_selects_ranged_filters_then_URL_contains_selected_option(List<String> rangedFilters) {
        campaignsLocationsPage.selectRangeFilter(rangedFilters);
    }


    @Given("the user is on the bottom of the main page")
    public void the_user_is_on_the_bottom_of_the_main_page() {
        BrowserUtils.hover(webDriver.findElement(By.xpath("//div[@*='bottom__right ']")));
        BrowserUtils.waitFor(1);
    }

    @When("the user clicks flat page on the footer then flat page should be opened")
    public void the_user_clicks_flat_page_on_the_footer_then_flat_page_should_be_opened(List<String> flatPages) {
        campaignsLocationsPage.flatPageonThefooter(flatPages);
    }

    @And("the user clicks iletisim, blog and kariyer then pages should be opened")
    public void the_user_clicks_iletisim_blog_and_kariyer_then_pages_should_be_opened() {
        campaignsLocationsPage.clickContactAndCareer();
    }
    @When("the user scroll down")
    public void the_user_scroll_down() {
        BrowserUtils.waitFor(3);
        BrowserUtils.scrollToSize(0,1000);
       // BrowserUtils.scrollToElement(driver.findElement(By.xpath("//*[@*='partners']")));
        //BrowserUtils.hover(driver.findElement(By.xpath("//*[@*='partners']")));
    }

    @Given("the user should see our partners banner")
    public void the_user_should_see_our_partners_banner() {
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='owl-carousel carousel-slider home-partners owl-loaded owl-drag']")).isEnabled());
        BrowserUtils.waitFor(2);

    }

    @When("the user should see Why rent with Yolcu360")
    public void the_user_should_see_Why_rent_with_Yolcu360() {
        campaignsLocationsPage.whyRentwithYolcu360();
    }



    @Then("the user should see Yolcu360 in press")
    public void the_user_should_see_Yolcu360_in_press() {
        //basında yolcu
        campaignsLocationsPage.yolcu360InPress();
    }

    @Then("the user should see Blog")
    public void the_user_should_see_Blog() {
        campaignsLocationsPage.blogSeen();
    }

    @Then("the user should see Car Rental Service")
    public void the_user_should_see_Car_Rental_Service() {
        BrowserUtils.hover(webDriver.findElement(By.xpath("//*[@*='about']")));
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='about']/div/div/p")).isDisplayed());
        BrowserUtils.waitFor(1);
    }

    @And("click cancel campaign code Window")
    public void clickCancelCampaignCodeWindow() {
        campaignsLocationsPage.campaignWindowCancelButton.click();
    }

    @And("verify promo code is working")
    public void verifyPromoCodeIsWorking() {
        BrowserUtils.clickWithJS(campaignsLocationsPage.promotionCodeLocator);
        BrowserUtils.waitFor(1);
        Assert.assertTrue(campaignsLocationsPage.promoCodeWindow.isDisplayed());
    }

    @When("the user enters {string} promotion code")
    public void theUserEntersPromotionCode(String code) {
        campaignsLocationsPage.enterPromoCode(code);
    }

    /*@Given("click left and right arrow on campaign banner")
    public void clickLeftAndRightArrowOnCampaignBanner() {
        BrowserUtils.scrollToElement(campaignsLocationsPage.allCampaignButton);
       BrowserUtils.waitFor(3);
        //  String ilkKampanya= driver.findElement(By.xpath("(//p[@data-slug='global'])[2]")).getAttribute("innerHTML");
        //  System.out.println("ilkKampanya = " + ilkKampanya);
          campaignsLocationsPage.rightArrowCampaign.isEnabled();
        BrowserUtils.waitFor(1);
        //   String ikinciKampanya= driver.findElement(By.xpath("(//p[@class='c-title'])[40]")).getAttribute("innerHTML");
        //  System.out.println("ikinciKampanya = " + ikinciKampanya);
        //  Assert.assertFalse(ilkKampanya.equals(ikinciKampanya));
        campaignsLocationsPage.leftArrowCampaign.isEnabled();
    }*/
    @Given("click left and right arrow on campaign banner")
    public void clickLeftAndRightArrowOnCampaignBanner() {
        BrowserUtils.waitFor(1);
        BrowserUtils.scrollToSize(0,600);
        //  BrowserUtils.scrollToElement(driver.findElement(By.xpath("(//span[contains(text(),'HEMEN KATIL')])[12]")));
        BrowserUtils.waitFor(3);
        String ilkKampanya= webDriver.findElement(By.xpath("(//span[contains(text(),'HEMEN KATIL')])[12]")).getAttribute("data-slug");
        System.out.println("ilkKampanya = " + ilkKampanya);
        campaignsLocationsPage.rightArrowCampaign.isEnabled();
        campaignsLocationsPage.rightArrowCampaign.click();
        BrowserUtils.waitFor(1);
        String ikinciKampanya= webDriver.findElement(By.xpath("(//span[contains(text(),'HEMEN KATIL')])[13]")).getAttribute("data-slug");
        System.out.println("ikinciKampanya = " + ikinciKampanya);
        Assert.assertFalse(ilkKampanya.equals(ikinciKampanya));
        campaignsLocationsPage.leftArrowCampaign.isEnabled();
        campaignsLocationsPage.leftArrowCampaign.click();
    }

    @And("click all campaigns button")
    public void clickAllCampaignsButton() {
        BrowserUtils.clickWithJS(campaignsLocationsPage.allCampaignButton);
        //campaignsLocationsPage.allCampaignButton.click();
    }

    @Then("verify open campaign page")
    public void verifyOpenCampaignPage() {
        BrowserUtils.waitForVisibility(campaignsLocationsPage.campaignsList.get(1),5);
        BrowserUtils.verifyElementDisplayed(campaignsLocationsPage.campaignsList.get(1));
    }

    @Then("verify {string} search page open")
    public void verifySearchPageOpen(String location) {
        campaignsLocationsPage.verifyLocationPageOpen(location);
    }

    @And("the user changes language {string}")
    public void theUserChangesLanguage(String language) {
        campaignsLocationsPage.changeLanguage(language);
    }

    @And("the user changes country {string}")
    public void theUserChangesCountry(String country) {
        campaignsLocationsPage.changeCountry(country);
    }

    @Then("page language should be {string}")
    public void pageLanguageShouldBe(String language) {
        campaignsLocationsPage.verifyLanguage(language);
    }

    @And("select breadcrumb {int}")
    public void selectBreadcrumb(int number) {
        campaignsLocationsPage.selectBreadcrumb(number);
    }

    @And("select popular locations breadcrumb {int}")
    public void selectPopularLocationsBreadcrumb(int number) {
        campaignsLocationsPage.selectPopularBreadcrumb(number);
    }

    @When("select {string} vendor")
    public void selectVendor(String vendor) {
        campaignsLocationsPage.selectVendor(vendor);
    }

    @Then("verify head filter is keeping")
    public void verifyHeadFilterIsKeeping() {
        BrowserUtils.verifyElementDisplayed(campaignsLocationsPage.selectedFilterTitle);
    }

    @And("select random filter")
    public void selectRandomFilter() {
        campaignsLocationsPage.selectRandomFilter();
    }

    @Then("verify the number of filters selected must be {int}")
    public void verifyTheNumberOfFiltersSelectedMustBe(int number) {
        Assert.assertTrue(campaignsLocationsPage.selectedFilterTitleList.size()==number);
    }

    @Then("delete location box")
    public void delete_location_box() {
        new MainPage().pickUpInput.clear();
        new MainPage().pickUpInput.sendKeys(Keys.COMMAND+"a");
        new MainPage().pickUpInput.sendKeys(Keys.BACK_SPACE);
        BrowserUtils.waitFor(1);
    }

    @When("enter {string} on pick-up box")
    public void enter_on_pick_up_box(String string) {
        new MainPage().pickUpInput.sendKeys(string);
        BrowserUtils.waitFor(2);
    }

    @Then("First selected location should be deleted")
    public void First_selected_location_should_be_deleted() {
        Assert.assertTrue(new MainPage().pickUpInput.getAttribute("value").equals("s"));
    }

    @Then("{string} text should be seen")
    public void text_should_be_seen(String string) {
        Assert.assertTrue(new MainPage().pickUpInput.getAttribute("placeholder").equals(string));
    }

    @Then("delete drop off location box")
    public void delete_drop_off_location_box() {
        reservationPage.differentLocatorBox.clear();
        reservationPage.differentLocatorBox.sendKeys(Keys.COMMAND+"a");
        reservationPage.differentLocatorBox.sendKeys(Keys.BACK_SPACE);
        BrowserUtils.waitFor(1);
    }

    @Then("enter {string} on drop off location box")
    public void enter_on_drop_off_location_box(String string) {
        reservationPage.differentLocatorBox.sendKeys(string);
        BrowserUtils.waitFor(2);
    }

    @Then("First selected drop off location should be deleted")
    public void first_selected_drop_off_location_should_be_deleted() {
        System.out.println("resPage.differentLocatorBox.getAttribute(\"value\") = " + reservationPage.differentLocatorBox.getAttribute("value"));
        Assert.assertTrue(reservationPage.differentLocatorBox.getAttribute("value").equals("s"));
    }

    @Then("{string} text should be seen on drop off location box")
    public void text_should_be_seen_on_drop_off_location_box(String string) {
        Assert.assertTrue(reservationPage.differentLocatorBox.getAttribute("placeholder").equals(string));
    }


    @Given("user select language and verify on campaign page")
    public void userSelectLanguageAndVerifyOnCampaignPage(List<String> language) {
        campaignsLocationsPage.changeLanguageAllCampaignPage(language);
    }

    @And("select {int} campaign on all campaign page")
    public void selectCampaignOnAllCampaignPage(int number) {
        campaignsLocationsPage.selectCampaign(number);
    }

    @When("user select language and verify on campaign detail page")
    public void userSelectLanguageAndVerifyOnCampaignDetailPage(List<String> language) {
        campaignsLocationsPage.changeLanguageCampaignDetailPage(language);
    }

    @When("the user select filter option then title & description contains selected option")
    public void theUserSelectFilterOptionThenTitleDescriptionContainsSelectedOption(List<String> filters) {
        campaignsLocationsPage.selectVerifyFilterTitleDescription(filters);
    }

    @And("go to url {string}")
    public void goToUrl(String url) {
        webDriver.navigate().to(url);
    }

    @Then("The Campaigns Page link must also appear in the source code on the home page")
    public void theCampaignsPageLinkMustAlsoAppearInTheSourceCodeOnTheHomePage() {
        for (WebElement element : webDriver.findElements(By.xpath("//a[contains(@href,'arac-kiralama-kampanyalari/')]"))) {
            Assert.assertTrue(element.getAttribute("href").equals("https://"+ ConfigurationReader.get("environmentType") +".yolcu360.com/tr/arac-kiralama-kampanyalari/"));
        }

        String pageSource = webDriver.getPageSource();
        Assert.assertTrue(pageSource.contains("/tr/arac-kiralama-kampanyalari/"));
    }

    @And("click car rental contract")
    public void clickCarRentalContract() {
        BrowserUtils.scrollToElement(webDriver.findElement(By.cssSelector("a.rental-conditions__link__title")));
        BrowserUtils.waitFor(1);
        webDriver.findElement(By.cssSelector("a.rental-conditions__link__title")).click();
        BrowserUtils.waitFor(2);

    }

    @And("click clear filter button")
    public void clickClearFilterButton() {
        BrowserUtils.waitFor(2);
        campaignsLocationsPage.cleanFilter.click();
    }

    @Then("User should be able to see results in less than {int} seconds without requesting BE")
    public void userShouldBeAbleToSeeResultsInLessThanSecondsWithoutRequestingBE(int second) {
        BrowserUtils.waitFor(second);
        BrowserUtils.verifyElementDisplayed(campaignsLocationsPage.rentNowButton.get(0));
    }

    @And("select {string} or {string} vendor")
    public void selectOrVendor(String vendor1, String vendor2) {
        campaignsLocationsPage.selectORVendor(vendor1,vendor2);
    }

    @Then("verify campaign text on google")
    public void verifyCampaignTextOnGoogle() {
        String text = "";
        for (WebElement element : webDriver.findElements(By.xpath("//h3"))) {
            text = text + element.getText();
        }
        for (WebElement element : webDriver.findElements(By.xpath("//div[@style='-webkit-line-clamp:2']"))) {
            text = text + element.getText();
        }
        System.out.println("text = " + text);
        BrowserUtils.waitFor(1);
        Assert.assertTrue(text.contains("Araç Kiralama Kampanyaları - Yolcu360") || text.contains("Araç Kiralama Kampanyaları | Yolcu360"));
        Assert.assertTrue(text.contains("Güncel araç kiralama kampanya ve tekliflerini keşfetmek için hemen tıklayın. Fırsatları kaçırmayın!"));
    }

    @Then("Verify that URL is not returning {int}")
    public void verify_that_URL_is_not_returning(Integer int1) {
        BrowserUtils.waitFor(5);
        Assert.assertTrue(reservationPage.findButton.isDisplayed());

    }


    @When("go to extensions and add environment type {string}")
    public void goToExtensionsAndAddEnvironmentType(String extensions) {
        String url = "https://"+ConfigurationReader.get("environmentType")+".yolcu360.com"+ extensions;
        webDriver.navigate().to(url);

    }

    @When("click yolcu360 logo")
    public void click_yolcu360_logo() {
        webDriver.findElement(By.cssSelector(".navbar-brand")).click();
        BrowserUtils.waitFor(2);
    }
}
