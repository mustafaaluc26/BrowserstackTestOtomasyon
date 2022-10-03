package com.browserstack.stepdefs;

import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.pageobjects.CampaignsLocationsPage;
import com.browserstack.pageobjects.ChangePage;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class PageFunctionsDefs {

    MainPage page= new MainPage();
    CampaignsLocationsPage campaignsLocationsPage = new CampaignsLocationsPage();
    WebDriver webDriver=RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();

    @When("click the monthly rental")
    public void click_the_monthly_rental()  {
        page.monthlyRental.click();
    }

    @Then("monthly rental function should be available")
    public void monthly_rental_function_should_be_available(){
        BrowserUtils.waitFor(3);
        Assert.assertTrue(page.monthlyInfoMassage.isDisplayed());
        Assert.assertTrue(page.monthPicker.isEnabled());
        BrowserUtils.waitFor(1);
    }

    @When("click the daily rental")
    public void click_the_daily_rental() {
        page.dailyRental.click();
    }

    @Then("daily rental function should be available")
    public void daily_rental_function_should_be_available(){
        Assert.assertTrue(page.dropOffDate.isEnabled());
        BrowserUtils.waitFor(1);
    }

    @When("enter word to pick-up information box")
    public void enter_word_to_pick_up_information_box(){
        page.pickUpInput.sendKeys("saw");
        BrowserUtils.waitFor(1);
    }

    @Then("location list should be available")
    public void location_list_should_be_available() {

        Assert.assertFalse(page.pickUpMenu.isEmpty());

        String actualLocation="Sabiha Gökçen Havalimanı";
        String expectedLocation=page.pickUpMenu.get(0).getText();
        Assert.assertTrue(expectedLocation.contains(actualLocation));
    }

    @When("select location from location list")
    public void select_location_from_location_list(){
        page.pickUpMenu.get(0).click();
        BrowserUtils.waitFor(1);
    }

    @Then("calender should be opened")
    public void calender_should_be_opened(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='position: absolute;']")).isEnabled());
        BrowserUtils.waitFor(1);
    }

    @When("select date and time from calendar")
    public void select_date_and_time_from_calendar(){
        //BrowserUtils.waitForClickablility(page.defaultCalendarDate.get(3),5);
        BrowserUtils.waitFor(1);
        new ReservationPage().selectDate();
    }

    @Then("dates should be selected")
    public void dates_should_be_selected(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='picker-item__selected-field']")).isEnabled());
        BrowserUtils.waitFor(1);
    }


    @When("click the different drop off location checkbox")
    public void click_the_different_drop_off_location_checkbox() {
        BrowserUtils.clickWithJS(page.diffDropOffCheck);
    }

    @Then("drop-off information box should be available")
    public void drop_off_information_box_should_be_available() {
        Assert.assertTrue(page.dropOffInput.isEnabled());
    }

    @When("enter word to drop-off information box")
    public void enter_word_to_drop_off_information_box() {
        page.dropOffInput.sendKeys("ist");
    }

    @Then("drop-off location list should be available")
    public void drop_off_location_list_should_be_available() {
        Assert.assertFalse(page.dropOffMenu.isEmpty());
    }

    @When("select location from drop-off location list")
    public void select_location_from_drop_off_location_list(){
        page.dropOffMenu.get(1).click();
        BrowserUtils.waitFor(1);
    }

    @Then("location should be selected")
    public void location_should_be_selected() {
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='İstanbul-İstanbul Havalimanı (IST)']")).isEnabled());
        BrowserUtils.waitFor(1);
    }

    @When("click the currency selector")
    public void click_the_currency_selector(){
        BrowserUtils.waitFor(1);
        page.currencySelect.click();
    }

    @Then("currency selector dropdown should be opened")
    public void currency_selector_dropdown_should_be_opened(){
        BrowserUtils.waitFor(3);
        Assert.assertTrue(webDriver.findElement(By.xpath("//li/a/span/i[contains(@class,'icon icon')]")).isEnabled());

        Assert.assertTrue(page.euro.isEnabled());
        Assert.assertTrue(page.tlira.isEnabled());
        Assert.assertTrue(page.dolar.isEnabled());
        Assert.assertTrue(page.pound.isEnabled());
    }

    @When("click the language")
    public void click_the_language() {
        page.languageSelect.click();
    }

    @Then("language dropdown should be opened")
    public void language_dropdown_should_be_opened() {
        Assert.assertTrue(page.currentLanguage.isEnabled());
        Assert.assertEquals("TR", page.currentLanguage.getText());
        Assert.assertTrue(webDriver.findElement(By.xpath("//div/a[text()='EN']")).isEnabled());
    }

    @When("check the call center")
    public void check_the_call_center(){
        Assert.assertTrue(page.callCenter.isEnabled());
        BrowserUtils.waitFor(1);
    }

    @Then("call center number and text should be correct")
    public void call_center_number_and_text_should_be_correct() throws InterruptedException {

        String expectedText= "MİSAFİR MERKEZİ";
        Assert.assertEquals(page.guessCenter.getText(), expectedText);

        String expectedPhone="0850 360 5 360";
        Assert.assertEquals(page.centerPhone.getText(), expectedPhone);

    }

    @When("click the popular locations")
    public void click_the_popular_locations(){

        BrowserUtils.waitFor(1);
        page.recentSearch.click();
        BrowserUtils.waitFor(1);
    }

    @Then("popular locations dropdown should be opened")
    public void popular_locations_dropdown_should_be_opened() {
        Assert.assertFalse(webDriver.findElements(By.xpath("//div/a[@class='dropdown-item']")).isEmpty());
    }

    @When("click the find reservation")
    public void click_the_find_reservation() {
        page.findReservation.click();
        BrowserUtils.waitForVisibility(page.findResMenu,10);
    }

    @Then("find reservation page should be opened")
    public void find_reservation_page_should_be_opened() {
        Assert.assertTrue(page.findResMenu.isEnabled());
        webDriver.findElement(By.xpath("//i[@*='icon-close-icon']")).click();
    }

    @When("click the campaigns on header bar")
    public void click_the_campaigns_on_header_bar() {
        page.campaigns.click();
    }

    @Then("campaigns page should be opened")
    public void campaigns_page_should_be_opened(){
        BrowserUtils.waitFor(2);

        String expectedTitle="ARAÇ KİRALAMA KAMPANYALARI";
        Assert.assertEquals( expectedTitle,webDriver.findElement(By.xpath("//div/h1")).getText());

        page.allCampaigns.get(0).click();
        Assert.assertTrue(webDriver.findElement(By.className("campaign-content")).isEnabled());

    }
    @Given("The user goes to Atlantis and log in")              // aluc
    public void the_user_goes_to_Atlantis_and_log_in() {
        webDriver.navigate().to("https://"+ ConfigurationReader.get("environmentType")+".yolcu360.com/atlantis/login/?next=/atlantis/");
        //Driver.get().navigate().to("https://beta.yolcu360.com/atlantis/login/?next=/atlantis/");

        String atlantisUserMail = ConfigurationReader.get("atlantisUser");
        new ChangePage().username.sendKeys(atlantisUserMail);
        new ChangePage(). password.sendKeys(ConfigurationReader.get("atlantisPass"));
        new ChangePage().login.click();
    }

    @When("click {string}")                 // aluc
    public void click(String vendor) {
        WebElement element=webDriver.findElement(By.xpath("//a[contains(text(),'"+vendor+"')]"));
        BrowserUtils.clickWithJS(element);

    }

    @Then("Vendor Configurations page should be open")                  // aluc
    public void vendor_Configurations_page_should_be_open() {
        BrowserUtils.waitForVisibility(webDriver.findElement(By.className("breadcrumbs")),20);
        String expectedUrl="https://"+ConfigurationReader.get("environmentType")+".yolcu360.com/atlantis/car_rental/vendorconfiguration/";
        Assert.assertTrue(webDriver.getCurrentUrl().equals(expectedUrl));
    }

    @Then("click page {int}")                   // aluc
    public void click_page(Integer pageNumber) {
        String newURL="https://"+ConfigurationReader.get("environmentType")+".yolcu360.com/atlantis/car_rental/vendorconfiguration/?p="+""+(pageNumber-1);
        webDriver.navigate().to(newURL);
        BrowserUtils.waitForVisibility(webDriver.findElement(By.className("breadcrumbs")),20);
        BrowserUtils.waitFor(2);
    }
    @When("The user click {string}")                     // aluc
    public void the_user_click(String vendor) {
       WebElement element=webDriver.findElement(By.xpath("(//*[.='"+vendor+"'])[2]"));
       BrowserUtils.clickWithJS(element);
        BrowserUtils.waitForVisibility(webDriver.findElement(By.className("breadcrumbs")),20);
        BrowserUtils.waitFor(2);

    }
    @Then("Check the vendor status active or not active")                // aluc
    public void check_the_vendor_status_active_or_not_active() {
        WebElement element=webDriver.findElement(By.id("id_active"));
        if(!element.isSelected()){
            BrowserUtils.clickWithJS(element);
        }
            Assert.assertTrue(element.isSelected());
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(webDriver.findElement(By.xpath("//input[@value='Save']")));
        BrowserUtils.waitFor(1);
        WebElement ele=webDriver.findElement(By.xpath("//li[@class='success']"));
        BrowserUtils.waitForVisibility(ele,15);
        Assert.assertTrue(ele.getText().contains("was changed successfully"));

    }

    @When("user select language and verify on main page")
    public void userSelectLanguageAndVerifyOnMainPage(List<String> language) {
        campaignsLocationsPage.changeLanguageMainPage(language);
    }

    @And("user select language and verify on car detail page")
    public void userSelectLanguageAndVerifyOnCarDetailPage(List<String> language) {
        campaignsLocationsPage.changeLanguageCarDetailPage(language);
    }

    @And("user select language and verify on reservation summary page")
    public void userSelectLanguageAndVerifyOnReservationSummaryPage(List<String> language) {
        campaignsLocationsPage.changeLanguageReservationSummaryPage(language);
    }

    @Given("{string} tab should be seen on header")
    public void tab_should_be_seen_on_header(String string) {
        List<WebElement> element=webDriver.findElements(By.linkText(string));
        BrowserUtils.waitFor(1);
        Assert.assertTrue(element.size()>0);
        BrowserUtils.waitFor(1);
    }

    @Then("{string} tab should be not seen on header")
    public void tab_should_be_not_seen_on_header(String string) {
        List<WebElement> element=webDriver.findElements(By.linkText(string));
        BrowserUtils.waitFor(1);
        Assert.assertTrue(element.size()==0);
    }

    @Then("User see partners")
    public void userSeePartners() {
        Assert.assertTrue(webDriver.findElements(By.xpath("//h3")).size()==5);

//        System.out.println("size()) = " + (Driver.get().findElements(By.xpath("(//button[@class='owl-dot'])")).size()));
//        Assert.assertTrue((Driver.get().findElements(By.xpath("(//button[@class='owl-dot'])")).size()>25));

//        BrowserUtils.verifyElementDisplayed(Driver.get().findElement(By.xpath("(//button[@class='owl-dot'])[23]")));
//        BrowserUtils.verifyElementDisplayed(Driver.get().findElement(By.xpath("(//button[@class='owl-dot'])[27]")));
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(webDriver.findElement(By.xpath("(//*[starts-with(@src, \"https://static.yolcu360.com/thumbnails\")])[47]")),20);

        BrowserUtils.verifyElementDisplayed(webDriver.findElement(By.xpath("(//*[starts-with(@src, \"https://static.yolcu360.com/thumbnails\")])[47]")));
     //   BrowserUtils.verifyElementDisplayed(Driver.get().findElement(By.xpath("(//*[starts-with(@src, \"https://static.yolcu360.com/thumbnails\")])[11]")));

    }

    @And("select google language {string}")
    public void selectGoogleLanguage(String language) {
        if(webDriver.findElements(By.cssSelector("div.FYXSad")).size()>0){
        String actualLanguage = webDriver.findElement(By.cssSelector("div.FYXSad")).getText();
        if(!actualLanguage.equalsIgnoreCase(language)){
            webDriver.findElement(By.cssSelector("div.FYXSad")).click();
            BrowserUtils.waitFor(1);
            webDriver.findElement(By.xpath("//*[@data-hl='"+language+"']")).click();
        }
        BrowserUtils.waitFor(1);
            webDriver.findElement(By.xpath("//*[text()='Tümünü kabul et']")).click();
        }
    }

    @Then("the user should be able to see social media links")
    public void the_user_should_be_able_to_see_social_media_links() {
       campaignsLocationsPage.socialMedia();
    }

    @And("verify {string} message")
    public void verifyMessage(String message) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(webDriver.findElement(By.cssSelector(".popover-body")).isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.cssSelector(".popover-body")).getText().contains(message));

    }
}
