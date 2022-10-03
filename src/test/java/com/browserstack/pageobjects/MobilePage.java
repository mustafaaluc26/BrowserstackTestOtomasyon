package com.browserstack.pageobjects;

import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.util.BrowserUtils;
import com.browserstack.util.ConfigurationPostmanReader;
import com.browserstack.util.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MobilePage extends BasePage{

    WebDriver webDriver= RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();
    String teslim = "";
    String price = "";
    double priceD=0.0;
    String officePriceText ="";
    String cardPriceText = "";
    String totalPriceText = "";
    double officePrice=0.00;
    double cardPrice=0.00;
    double totalPrice=0.00;
    String activePayment = "";


    String resSummaryTotalPriceText = "";
    String resSummaryCardPriceText = "";
    String resSummaryOfficePriceText = "";
    ReservationPage reservationPage=new ReservationPage();

    String reservationNumber="";


    @FindBy(className = "date-picker-mobile__container")
    public WebElement mobileDatePicker;

    @FindBy(css = "#mobile-date-picker__dropOff")
    public WebElement dropOffPicker;

    @FindBy(css = "button.btn.btn-default")
    public WebElement dropdownMobileMenu;

    @FindBy(css = "i.icon.icon-sign-in-icon")
    public WebElement signIn;

    @FindBy(css = "a.sign-out-link")
    public WebElement signOut;

    @FindBy(xpath = "//*[contains(@class,'mobile__search-button')]")
    public WebElement searchMobileButton;

    @FindBy(xpath = "//*[@*='btn filter-btn']")
    public WebElement filterMobile;

    @FindBy(xpath = "//*[@*='vendor_filter']")
    public WebElement filterVendor;

    @FindBy(css = "div.price-field__cta-btn")
    public List<WebElement> rentButton;

    @FindBy(xpath = "//input[@placeholder='E-Posta']")
    public WebElement emailMobile;

    @FindBy(xpath = "//input[@*='password']")
    public WebElement passwordMobile;

    @FindBy(css = "button.btn.login-btn.form-control")
    public WebElement loginMobile;

    @FindBy(css = "#modal_autocomplete")
    public WebElement searchBoxMobile;

    @FindBy(css = "i.icon-btn-arrow-right-2")
    public WebElement forwardArrow;

    @FindBy(css = "#input_registerApproved")
    public WebElement registerCheckBox;

    @FindBy(css = "span.checkbox-label")
    public List <WebElement> kvkkCheckBoxList;

    @FindBy(xpath = "//img[contains(@alt,'Yolcutest')]")
    public WebElement yolcuTestBrandImage;

    @FindBy(xpath = "(//a/span)[1]")
    public WebElement accountNameLocator;

    @FindBy(css = "#code")
    public WebElement campaignCodeBox;

    @FindBy(xpath = "//*[@*=('join-btn')]")
    public WebElement campaignApplyButton;

    @FindBy(css = "p.title")
    public List <WebElement> subAccountTitle;

    @FindBy(xpath = "//*[@*='dropdown-menu show']/a")
    public List <WebElement> allSortList;

    @FindBy(xpath = "//div[@class='left']/p")
    public WebElement priceCarLeft;

    @FindBy(css = "i.icon.icon-search-res")
    public WebElement reservationDropDown;

    @FindBy(xpath = "//h1")
    public WebElement bannerPageTitle;

    @FindBy(xpath = "//p/img")
    public WebElement locatorPageImage;

    @FindBy(xpath = "(//*[@*='count'])[2]")
    public WebElement vehicleCount;

    @FindBy(xpath = "(//*[@*='location'])[1]")
    public WebElement carLocationTitle;

    @FindBy(xpath = "(//*[@*='location'])[2]")
    public WebElement carDropLocationTitle;

    @FindBy(css = "input#smsCode")
    public WebElement smsCodeBox;

    @FindBy(css = "button#submitBtn")
    public WebElement smsSubmitButton;

    @FindBy(css = "#input_cardOwnerName")
    public WebElement cardNameBox;

    @FindBy(css = "#input_cardNumber")
    public WebElement cardNumberBox;

    @FindBy(css = "#sel1")
    public WebElement cardDay;

    @FindBy(css = "#sel2")
    public WebElement cardMonth;

    @FindBy(css = "#input_cardCvcNumber")
    public WebElement cardCvc;

    @FindBy(css = "#payment_verifiedTerms_checkbox")
    public WebElement verifiedTermsCheckbox;

    @FindBy(xpath = "//*[@*=('campaign-done-modal')]")
    public WebElement campaignActiveWindow;

    @FindBy(xpath = "//*[@*='title-clear-btn']")
    public WebElement clearFilterButton;

    @FindBy(css = "span.filter-btn-dot")
    public WebElement activeFilterDot;

    @FindBy(css = "span.price-field__labels__price2")
    public List <WebElement> vehiclePriceList;

    @FindBy(css = "button.btn.ok-btn")
    public WebElement campaignActiveOkButton;

    @FindBy(css = ".nav-link.currency-selector-mobile.active")  // aluc
    public WebElement currencySelectMobil;

    @FindBy(xpath = "(//*[@class='icon icon-euro'])[1]")     // aluc
    public WebElement mobileuro;

    @FindBy(xpath = "(//*[@class='icon icon-try'])[1]")     // aluc
    public WebElement mobiltlira;

    @FindBy(xpath = "(//*[@class='icon icon-dollar'])[1]")      // aluc
    public WebElement mobildolar;

    @FindBy(xpath = "(//*[@class='icon icon-pound'])[1]")       // aluc
    public WebElement mobilpound;

    @FindBy(css= ".nav-link.language-selector-mobile.active")       // aluc
    public WebElement currentlanguageSelectMobil;

    @FindBy(xpath = "(//li[@class='nav-item dropdown ls-selector-mobile']//a)[1]")                // aluc
    public WebElement trlanguageSelectMobil;

    @FindBy(xpath = "(//li[@class='nav-item dropdown ls-selector-mobile']//a)[2]")                // aluc
    public WebElement ENlanguageSelectMobil;

    @FindBy(xpath = "(//i[@class='icon icon-search-res'])[1]")      // aluc
    public WebElement findReservationMobile;

    @FindBy(xpath = "(//i[@class='icon icon-gift-box'])[1]")             // aluc
    public WebElement campaignsMobile;

    @FindBy(css = ".input-group.password")             // aluc
    public WebElement reservationNoMobile;

    @FindBy(css = ".icon.icon-new-member-icon")         // aluc
    public WebElement registerMobil;

    @FindBy(css = ".errorMessage")                  // aluc
    public WebElement registerErrorMessage;

    @FindBy(css = ".error-label")                  // aluc
    public WebElement wrongEmailMessage;

    @FindBy(css = ".input-group.forgot-password")                  // aluc
    public WebElement forgetPasswordMobil;

    @FindBy(css = "a.nav-link.promo-link-button")
    public WebElement promoCodeLocator;

    @FindBy(xpath = "//*[@rel='canonical']")
    public WebElement canonicalLoc;

    @FindBy(css = ".location-wrapper")
    public WebElement selectedLocation;

    @FindBy(xpath = "//*[@for='transmission-type']")
    public WebElement filterTransmission;

    @FindBy(xpath = "//*[@for='fuel-type']")
    public WebElement filterFuelType;

    @FindBy(css = "div.modal__close-icon.--mobile-filter>i")
    public WebElement filter_X_Button;

    @FindBy(xpath = "(//*[@class='sort-dot'])[2]")
    public List<WebElement> sortDotLoc;

    @FindBy(xpath = "//*[@class='filter-btn-dot']")
    public WebElement filterButtonDotLoc;

    @FindBy(css = "span.display-switch")
    public WebElement detailSwitchLocator;

    @FindBy(xpath = "(//*[@*='payment-info__title-wrapper']/span)[2]")
    public WebElement officePriceLoc;

    @FindBy(xpath = "(//*[@*='payment-info__container--middle']/span)[2]")
    public WebElement cardPriceLoc;

    @FindBy(xpath = "(//*[@*='payment-info__container--bottom']/span)[2]")
    public WebElement detailPagePriceLoc2;

    @FindBy(xpath = "//*[@data-count='1']")
    public List <WebElement> selectedMobilFilterTitleList;

    @FindBy(css = "i.icon-close-icon")
    public List <WebElement> cancelXButton;

    @FindBy(xpath = "(//*[@class='reservation-no__item']/span)[2]")
    public WebElement onlyReservationNumber;



    public void mobileLogin() {
        BrowserUtils.waitFor(2);
        signIn.click();

        String myEmail= ConfigurationReader.get("email");
        String myPassword=ConfigurationReader.get("password");

        BrowserUtils.waitForVisibility(emailMobile,8);
        emailMobile.sendKeys(myEmail);
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(passwordMobile,8);
        passwordMobile.sendKeys(myPassword);
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForClickablility(loginMobile,8);
        BrowserUtils.clickWithJS(loginMobile);
        BrowserUtils.waitFor(3);
    }

    public void mobileLogOut() {

        BrowserUtils.clickWithJS(dropdownMobileMenu);
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(signOut);
        BrowserUtils.waitFor(2);
    }

    public void searchTextBox(String location){
        searchBoxMobile.sendKeys(location);
        BrowserUtils.waitFor(3);

        if(!pickUpMenu.get(0).isEnabled()){
            BrowserUtils.waitFor(1);
            searchBoxMobile.sendKeys(Keys.COMMAND+"a");
            searchBoxMobile.sendKeys(Keys.BACK_SPACE);
            BrowserUtils.waitFor(1);
            searchBoxMobile.sendKeys(location);
        }

        pickUpMenu.get(0).click();
        BrowserUtils.waitFor(1);
    }


    public void selectMonthlyCalender(){
        if (!defaultCalendarDate.get(6).isDisplayed()){
            webDriver.findElement(By.xpath("//*[@*='date-picker__nav-next']/i")).click();
        }

        BrowserUtils.waitFor(1);
        defaultCalendarDate.get(6).click();
        timeSelected.click();

    }

    public void selectCalender(){
        if (!defaultCalendarDate.get(6).isDisplayed()){
            webDriver.findElement(By.xpath("//*[@*='date-picker__nav-next']/i")).click();
        }
        BrowserUtils.waitFor(2);
        defaultCalendarDate.get(6).click();
        timeSelected.click();
        BrowserUtils.waitFor(1);
        if (!defaultCalendarDate.get(3).isDisplayed()){
            webDriver.findElement(By.xpath("//*[@*='date-picker__nav-next']/i")).click();
        }
        BrowserUtils.waitFor(1);
        defaultCalendarDate.get(1).click();
        timeSelected.click();
        BrowserUtils.waitFor(1);
    }

    public void selectVendor(String vendor){
        BrowserUtils.waitForClickablility(filterVendor,5);
        filterVendor.click();
        WebElement vendorName = webDriver.findElement(By.id("vendor-"+vendor+"_wrapper"));
        BrowserUtils.scrollToElement(vendorName);
        BrowserUtils.waitFor(1);
        vendorName.click();
    }

    public void selectFirstCar(){
        rentButton.get(0).click();

        BrowserUtils.waitFor(1);
        try {
            BrowserUtils.waitForVisibility(priceCarLeft,3);
            price = priceCarLeft.getText();
        }catch (Exception e){
            BrowserUtils.waitFor(1);
            price = webDriver.findElement(By.cssSelector("span.display-price")).getText();
        }

        System.out.println("price = " + price);

        if(price.contains(".")){
            price=price.replace(".","");
        }
        price= price.replace(",",".");

        priceD = Double.parseDouble(price);
        System.out.println("price1 = " + priceD);
    }


    public void paymentInformation(){
        BrowserUtils.waitForClickablility(forwardArrow,5);
        System.out.println("new ActivePayment = " + ConfigurationPostmanReader.get("ActivePayment"));
        if (ConfigurationPostmanReader.get("ActivePayment").equals("MSU")){
            cardNumberBox.sendKeys(ConfigurationReader.get("MsuCreditCardNumber"));
        }else{
            cardNumberBox.sendKeys(ConfigurationReader.get("IyzicoCreditCardNumber"));
        }
        cardNameBox.sendKeys("QA test");

        Select select1 = new Select(cardDay);
        cardDay.click();
        select1.selectByValue(ConfigurationReader.get("creditCardMonth"));

        Select select2 = new Select(cardMonth);
        cardMonth.click();
        select2.selectByValue(ConfigurationReader.get("creditCardYear"));

        cardCvc.sendKeys(ConfigurationReader.get("creditCardCVV"));
        BrowserUtils.hover(webDriver.findElement(By.xpath("//*[@*='DriverInfo']")));



        if (!verifiedTermsCheckbox.isSelected()) {
            BrowserUtils.clickWithJS(verifiedTermsCheckbox);
            //verifiedTermsCheckbox.click();
            BrowserUtils.waitFor(1);
            webDriver.findElement(By.xpath("(//*[@*='checkboxes']/div/label/span)[2]")).click();
        }
    }

    /*public void sendSms(){
        if(priceD>1000){
            BrowserUtils.waitForVisibility(smsCodeBox,20);
            smsCodeBox.sendKeys("283126");
            smsSubmitButton.click();
        }
    }*/

    public void verifyAccountSubPage(){

        BrowserUtils.waitForVisibility(subAccountTitle.get(1),5);
        Assert.assertTrue(subAccountTitle.get(1).getText().equalsIgnoreCase("Adres Bilgileri"));
        Assert.assertTrue(subAccountTitle.get(2).getText().equalsIgnoreCase("İzin Bilgileri"));
    }

    public void enterCampaignCode(String campaign, String campaignCode){
        String locator= "//a[@href='/tr/kampanya/"+campaign+"/']";
        BrowserUtils.waitForVisibility(webDriver.findElement(By.xpath(locator)),10);
        webDriver.findElement(By.xpath(locator)).click();
        BrowserUtils.waitFor(1);
        campaignCodeBox.sendKeys(campaignCode);
        campaignApplyButton.click();
        BrowserUtils.waitFor(2);
    }
    public void verifyCampaignCode(String campaign){

        Assert.assertTrue(campaignActiveWindow.isEnabled());
        campaignActiveOkButton.click();
        BrowserUtils.waitForClickablility(findButton,5);
        findButton.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(webDriver.getCurrentUrl().contains(campaign));
        Assert.assertTrue(pickUpInput.isEnabled());
        Assert.assertTrue(findButton.isEnabled());
    }

    public void filtersAllCheck(List<String> filters){
        BrowserUtils.waitFor(2);

        for (String filter : filters) {
            filterMobile.click();

            Assert.assertEquals("",webDriver.findElement(By.xpath("//*[@for='"+filter+"-type']/b")).getText());

            webDriver.findElement(By.id(filter + "_filter")).click();

            WebElement filterElement = webDriver.findElements(By.xpath("//*[@filtername='" + filter + "']")).get(0);
            BrowserUtils.doubleClick(filterElement);
            filterElement.click();

            webDriver.findElement(By.xpath("//*[@*='btn btn-outline-secondary btn-filter']")).click();
            BrowserUtils.waitFor(1);
            Assert.assertEquals("( 1 )",webDriver.findElement(By.xpath("//*[@for='"+filter+"-type']/b")).getText());

            forwardArrow.click();

            Assert.assertTrue(activeFilterDot.isEnabled());

            BrowserUtils.waitFor(1);
            BrowserUtils.hover(filterMobile);
            filterMobile.click();
            clearFilterButton.click();
            BrowserUtils.waitFor(1);
        }
    }

    public void rangedFilter(List<String> rangedFilters){

        BrowserUtils.waitFor(1);

        for (String rangedFilter : rangedFilters) {

            filterMobile.click();
            webDriver.findElement(By.id(rangedFilter + "_filter")).click();
            BrowserUtils.waitFor(2);

            if (rangedFilter.equals("distance_limit")) {
                BrowserUtils.hover(webDriver.findElement(By.xpath("//*[@for='distance-500 - 1000 KM']")));
                //BrowserUtils.doubleClick(driver.findElement(By.xpath("//*[@for='distance-1000 - 1500 KM']")));
                webDriver.findElement(By.xpath("//*[@for='distance-500 - 1000 KM']")).click();
                BrowserUtils.waitFor(1);
            } else {
                BrowserUtils.hover(webDriver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[10]")));
                BrowserUtils.waitFor(1);
                BrowserUtils.clickWithJS(webDriver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[10]")));
                //driver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[7]")).click();
            }

            forwardArrow.click();
            Assert.assertTrue(activeFilterDot.isEnabled());

            BrowserUtils.waitFor(1);
            BrowserUtils.hover(filterMobile);
            filterMobile.click();
            BrowserUtils.waitFor(1);
            clearFilterButton.click();
            BrowserUtils.waitFor(1);

            filterMobile.click();

            webDriver.findElement(By.id(rangedFilter + "_filter")).click();
            BrowserUtils.waitFor(2);

            WebElement minValue = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div/div/input)[1]"));
            WebElement maxValue = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div/div/input)[2]"));
            WebElement arrow = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div)[3]"));

            BrowserUtils.hover(minValue);
            minValue.sendKeys("500");
            BrowserUtils.hover(maxValue);
            maxValue.sendKeys("2000");
            BrowserUtils.waitFor(2);
            BrowserUtils.hover(arrow);
            arrow.click();

            forwardArrow.click();
            BrowserUtils.hover(filterMobile);
            BrowserUtils.waitFor(1);
            filterMobile.click();
            clearFilterButton.click();
            BrowserUtils.waitFor(1);
        }
    }

    public void sortAndCheck(){
        for (int i = 0; i < 5; i++) {

            CampaignsLocationsPage campaignsLocationsPage = new CampaignsLocationsPage();
            BrowserUtils.waitFor(1);
            campaignsLocationsPage.sort.click();
            BrowserUtils.waitFor(3);

            String sortType = allSortList.get(i).getText();

            allSortList.get(i).click();

            BrowserUtils.waitForVisibility(vehiclePriceList.get(0),10);

            String listType= webDriver.findElement(By.xpath("(//*[@*='list-type'])[2]")).getText();

            Assert.assertTrue(sortType.contains(listType.trim()));

            double price1= Double.parseDouble(vehiclePriceList.get(0).getText().replace(".","").replace(",","."));
            double price2= Double.parseDouble(vehiclePriceList.get(1).getText().replace(".","").replace(",","."));

            if (i==1){
                Assert.assertTrue(price1<=price2);
            }
            if (i==2){
                Assert.assertTrue(price1>=price2);
            }
            if (i==3){

                double rate1= Double.parseDouble(webDriver.findElement(By.xpath("(//*[@*='rating-stars__rating-value'])[1]")).getText());
                double rate2= Double.parseDouble(webDriver.findElement(By.xpath("(//*[@*='rating-stars__rating-value'])[2]")).getText());

                Assert.assertTrue(rate1>=rate2);
            }
            if (i==4){

                String comment1= webDriver.findElement(By.xpath("(//*[@*='display-rating__comment  search-item']/span)[1]")).getText();
                String comment2= webDriver.findElement(By.xpath("(//*[@*='display-rating__comment  search-item']/span)[2]")).getText();

                int commentRate1= Integer.parseInt(comment1.substring(0, comment1.indexOf(" ")));
                int commentRate2= Integer.parseInt(comment1.substring(0, comment2.indexOf(" ")));

                Assert.assertTrue(commentRate1>=commentRate2);
            }
        }
    }

    public void verifyLocationPageOpen(String location){
        BrowserUtils.waitForClickablility(forwardArrow,8);
        Assert.assertEquals(location,bannerPageTitle.getText());
        BrowserUtils.verifyElementDisplayed(locatorPageImage);
        BrowserUtils.verifyElementDisplayed(forwardArrow);
    }

    public void verifyVehicleListingPage(String location){
        BrowserUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(vehicleCount);
        Assert.assertTrue(rentButton.size()>=0 || webDriver.findElement(By.cssSelector("p.title")).getText().contains("Maalesef aradığınız kriterlerde müsait araç yok."));
        String expectedLocate= "";
        if(location.contains("-")){
            String[] split = location.split("-");
            expectedLocate = split[0];
        }else{
            String[] split = location.split(" ");
            expectedLocate = split[0];
        }
        String text = carLocationTitle.getText();

        if(location.contains("esenboga")){
            text="ankara "+text;
        }
        System.out.println("text = " + text);

        String[] actualLocate = text.split(" ");
        System.out.println("arrayLocate[0] = " + actualLocate[0]);
        System.out.println("expectedLocate = " + expectedLocate);

        //  Assert.assertTrue(actualLocate[0].equalsIgnoreCase(expectedLocate));   Burası daha sonra düzeltilecek

    }

    public void changeLanguage(String language){

        WebElement element = webDriver.findElement(By.xpath("(//*[text()='"+ language +"'])[1]"));
        BrowserUtils.waitForVisibility(element,20);
        BrowserUtils.waitFor(1);
        element.click();
        BrowserUtils.waitFor(3);
    }

    public void verifyLanguage(String language){

        if(language.equalsIgnoreCase("EN")){
            Assert.assertTrue(filterMobile.getText().toLowerCase().contains("filter"));
            Assert.assertTrue(rentButton.get(0).getText().toLowerCase().contains("rent"));
            Assert.assertTrue(new CampaignsLocationsPage().listingVehicles.getText().toLowerCase().contains("listing"));
            Assert.assertTrue(new ReservationPage().sortLocator.getText().toLowerCase().contains("sort"));

        }else if(language.equalsIgnoreCase("TR")){
            Assert.assertTrue(filterMobile.getText().toLowerCase().contains("filtrele"));
            Assert.assertTrue(rentButton.get(0).getText().toLowerCase().contains("kirala"));
            Assert.assertTrue(new CampaignsLocationsPage().listingVehicles.getText().toLowerCase().contains("listeleniyor"));
            Assert.assertTrue(new ReservationPage().sortLocator.getText().toLowerCase().contains("sırala"));
        }else if(language.equalsIgnoreCase("DE")){
            Assert.assertTrue(filterMobile.getText().toLowerCase().contains("filter"));
            Assert.assertTrue(rentButton.get(0).getText().toLowerCase().contains("mieten!"));
            Assert.assertTrue(new CampaignsLocationsPage().listingVehicles.getText().toLowerCase().contains("optionen"));
            Assert.assertTrue(new ReservationPage().sortLocator.getText().toLowerCase().contains("sortieren"));
        }
    }

    public void changePriceType(List<String> currency){
        BrowserUtils.waitForClickablility(rentButton.get(0),20);

        for (int j = 0; j < currency.size(); j++) {

            String locator=  "//a/i[@*='icon icon-"+currency.get(j)+"']";
            dropdownMobileMenu.click();
            BrowserUtils.waitFor(1);
            BrowserUtils.waitForClickablility(webDriver.findElement(By.xpath(locator)),3);

            webDriver.findElement(By.xpath(locator)).click();
            BrowserUtils.waitFor(1);
            BrowserUtils.waitForVisibility(rentButton.get(0),20);

            Assert.assertTrue(webDriver.findElements(By.xpath("//i[@class='icon icon-"+currency.get(j)+"']")).size()>4);

        }
    }
    public void enterPromoCode(String code){
        //Multinet promosyon kodu kullanıldı
        promoCodeLocator.click();
        BrowserUtils.waitForClickablility( new CampaignsLocationsPage().promoCodeApplyButton,4);
        new CampaignsLocationsPage().promoCodeBox.sendKeys(code);
        new CampaignsLocationsPage().promoCodeApplyButton.click();
        BrowserUtils.waitFor(1);
    }

    public void verifyValidPromoCode(){
        webDriver.findElement(By.cssSelector("button.btn.try-again-btn")).click();
        BrowserUtils.waitForVisibility(rentButton.get(0),20);
        Assert.assertTrue(new CampaignsLocationsPage().promoCompanyFlagList.get(0).isDisplayed());
    }

    public void verifyInvalidPromoCode(){
        BrowserUtils.waitFor(1);
        Assert.assertTrue(new CampaignsLocationsPage().promoCodeErrorMessage.isEnabled());
        new CampaignsLocationsPage().campaignWindowCancelButton.click();
        BrowserUtils.waitForVisibility(new CampaignsLocationsPage().rentNowButton.get(1),20);
    }

    public void  filterOptionsMobil(Map<String,String> filters) {
        BrowserUtils.waitFor(1);
        String mainUrl = webDriver.getCurrentUrl();
        Assert.assertTrue(mainUrl.contains("rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/?from="));
        Assert.assertTrue(mainUrl.contains("&pickup_time="));
        Assert.assertTrue(mainUrl.contains("&dropoff_time="));

        BrowserUtils.waitFor(1);
       // String actualCanonicalUrl = canonicalLoc.getAttribute("href");
        String actualCanonicalUrl= webDriver.getCurrentUrl();
        String expectedCanonicalUrl="https://"+ConfigurationReader.get("environmentType")+".yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";
        //String expectedCanonicalUrl = "https://beta.yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";

        System.out.println("actualCanonicalUrl = " + actualCanonicalUrl);
        System.out.println("expectedCanonicalUrl = " + expectedCanonicalUrl);
      //  Assert.assertEquals(expectedCanonicalUrl, actualCanonicalUrl);
        Assert.assertTrue(actualCanonicalUrl.contains(expectedCanonicalUrl));


        for (Map.Entry<String, String> entry : filters.entrySet()) {
            filterMobile.click();

            String k = entry.getKey();
            String v = entry.getValue();

            WebElement filter = webDriver.findElement(By.xpath("//label[@for='" + k + "-type']"));
            BrowserUtils.waitForClickablility(filter, 3);
            filter.click();
            WebElement subFilter = webDriver.findElements(By.xpath("//*[@filtername='" + k + "']")).get(0);
            //BrowserUtils.waitForClickablility(subFilter,3);
            BrowserUtils.waitFor(1);
            subFilter.click();
            forwardArrow.click();
            BrowserUtils.waitFor(1);

            String actualUrl = webDriver.getCurrentUrl();

            String expectedUrl = mainUrl + "&" + v + "=" + subFilter.getAttribute("value").replace(" ", "_");

            String value = subFilter.getAttribute("value");
            switch (value) {
                case "deliveredToAddress":
                    expectedUrl = mainUrl + "&" + v + "=" + "delivery_to_address";
                    break;
                case "fromOffice":
                    expectedUrl = mainUrl + "&" + v + "=" + "office";
                    break;
                case "inTerminalOffice":
                    expectedUrl = mainUrl + "&" + v + "=" + "in_terminal_office";
                    break;
                case "meetAndGreet":
                    expectedUrl = mainUrl + "&" + v + "=" + "valet_service";
                    break;
                case "nonTerminalMeetAndGreet":
                    expectedUrl = mainUrl + "&" + v + "=" + "out_of_terminal_meeting_greeting";
                    break;
                case "nonTerminalValet":
                    expectedUrl = mainUrl + "&" + v + "=" + "out_of_terminal_valet_service";
                    break;
                case "diesel-gas-mixed":
                    expectedUrl = mainUrl + "&" + v + "=" + "diesel_gas_mixed";
                    break;
            }

            Assert.assertTrue(actualUrl.contains(expectedUrl));
            //     Assert.assertEquals(expectedUrl, actualUrl);
        //    String actualCanonical = canonicalLoc.getAttribute("href");
            String actualCanonical= webDriver.getCurrentUrl();
            expectedCanonicalUrl = "https://"+ConfigurationReader.get("environmentType")+".yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";
            //expectedCanonicalUrl = "https://beta.yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";


            if (k.equals("vendor") || k.equals("transmission") || k.equals("fuel")) {

                expectedCanonicalUrl =  v + "=" + subFilter.getAttribute("value");
                Assert.assertTrue(webDriver.getCurrentUrl().contains(expectedCanonicalUrl));
            }

          //  Assert.assertEquals(expectedCanonicalUrl, actualCanonical);
            BrowserUtils.waitFor(1);
            clearFilterButton.click();
            BrowserUtils.waitForClickablility(filterMobile, 5);
        }
    }
    public void verifyFilterUpdateURL(){
        filterMobile.click();
        String mainUrl= webDriver.getCurrentUrl();

        filterVendor.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(new CampaignsLocationsPage().vendorLoc.get(0));
        String vendorValue= new CampaignsLocationsPage().vendorLoc.get(0).getAttribute("value").replace(" ","_");
        BrowserUtils.waitFor(1);
        forwardArrow.click();
        BrowserUtils.waitFor(1);

        filterTransmission.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(new CampaignsLocationsPage().gearTypeLoc.get(0));
        String transmissionValue= new CampaignsLocationsPage().gearTypeLoc.get(0).getAttribute("value").replace(" ","_");
        System.out.println("transmissionValue = " + transmissionValue);
        BrowserUtils.waitFor(1);
        forwardArrow.click();

        filterFuelType.click();
        BrowserUtils.waitFor(1);
        new CampaignsLocationsPage().fuelTypeLoc.get(0).click();
        String fuelValue= new CampaignsLocationsPage().fuelTypeLoc.get(0).getAttribute("value").replace(" ","_");
        BrowserUtils.waitFor(1);
        forwardArrow.click();
        BrowserUtils.waitFor(1);
        forwardArrow.click();
        BrowserUtils.waitFor(1);

        String actualUrl= webDriver.getCurrentUrl();
        String expectedUrl= mainUrl+"&"+"v"+"="+vendorValue+"&"+"t"+"="+transmissionValue+"&"+"f"+"="+fuelValue;

        Assert.assertEquals(expectedUrl,actualUrl);
// canonical url kaldırıldığı için alt satırda ki kodlar yoruma alınmıştır!!!
        // String actualCanonical= canonicalLoc.getAttribute("href");
        //  String expectedCanonicalUrl="https://"+ConfigurationReader.get("environmentType")+".yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";
        //String expectedCanonicalUrl="https://beta.yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";

        //Assert.assertEquals(actualCanonical,expectedCanonicalUrl);
    }

    public void selectRangeFilter(List<String> rangedFilters){
        BrowserUtils.waitFor(1);

        String mainUrl= webDriver.getCurrentUrl();

        for (String rangedFilter : rangedFilters) {

            WebElement filter = webDriver.findElement(By.xpath("//label[contains(@id,'"+rangedFilter+"')]"));
            BrowserUtils.waitForClickablility(filter,3);
            filter.click();

            WebElement minValue = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div/div/input)[1]"));
            WebElement maxValue = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div/div/input)[2]"));
            WebElement arrow = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div)[3]"));


            BrowserUtils.waitFor(1);
            minValue.sendKeys("500");
            maxValue.sendKeys("2000");
            arrow.click();
            BrowserUtils.waitFor(1);

            String actualUrl = webDriver.getCurrentUrl();
            String expectedUrl ;
            switch (rangedFilter) {
                case "price" :
                    expectedUrl= mainUrl + "&p=500-2000";
                    break;
                case "distance" :
                    expectedUrl= mainUrl + "&km=500-2000";
                    break;
                case "provision" :
                    expectedUrl=mainUrl + "&d=500-2000";
                    break;
                default : expectedUrl=mainUrl;
            }

            Assert.assertEquals(expectedUrl, actualUrl);
            BrowserUtils.waitFor(1);

            BrowserUtils.hover(clearFilterButton);
            clearFilterButton.click();

            BrowserUtils.waitForClickablility(rentButton.get(0),8);
            filterMobile.click();
            BrowserUtils.waitFor(1);
        }
    }
    public void selectcarForReview() {
        BrowserUtils.waitFor(2);
        teslim = new ReservationPage().deliveryType.getText();
        price = new ReservationPage().allCarsTotalPrice.get(0).getText();
        rentButton.get(0).click();
        BrowserUtils.waitFor(2);
    }
    public void verifyPriceOfficeTypeMobil() {
        BrowserUtils.waitForClickablility(forwardArrow,10);
        try {
            BrowserUtils.waitForVisibility(priceCarLeft,3);
            Assert.assertEquals(priceCarLeft.getText(),price);// bir üstteki method da gelmeli yoksa null alır
        }catch (Exception e){
            BrowserUtils.waitFor(1);
            Assert.assertEquals(webDriver.findElement(By.cssSelector("span.display-price")).getText(),price);
        }

        BrowserUtils.waitFor(1);
        Assert.assertEquals(webDriver.findElement(By.xpath("//*[@*='value']/b")).getText(),teslim);
    }

    public void carNameAndPriceMobil() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(webDriver.findElement(By.xpath("(//*[@*='icon icon-try'])[7]")).isDisplayed());
        String carName1= webDriver.findElement(By.xpath("(//span[@itemprop='name'])[4]")).getText();
        String carname2= webDriver.findElement(By.xpath("//span[@*='car-property__car-name']")).getText();
        Assert.assertEquals(carName1,carname2);
        Assert.assertEquals("veya benzeri", webDriver.findElement(By.xpath("//span[@*='car-property__subheading']")).getText());
    }
    public void verifyDriverInformationMobil() {
        List<String> expectedInfo = Arrays.asList("test","test","12/12/1945","qa2@yolcu360.com","(+90) 5410000000","12345678901"
                ,"test","test","İSTANBUL TÜRKİYE");

        for(int i=1; i<10; i++){
            Assert.assertEquals(webDriver.findElement(By.xpath("(//span[@*='val'])["+i+"]")).getText(),expectedInfo.get(i-1));
        }
        Assert.assertTrue(forwardArrow.isEnabled());


    }

    public void checkSortDot(){

        for (int i = 1; i < 5; i++) {
            new CampaignsLocationsPage().sort.click();
            BrowserUtils.waitFor(3);
            allSortList.get(i).click();
            BrowserUtils.waitFor(1);

            Assert.assertTrue(sortDotLoc.size()>0);
        }
        new CampaignsLocationsPage().sort.click();
        BrowserUtils.waitFor(1);
        allSortList.get(0).click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(sortDotLoc.size()==0);
    }

    public void checkOrangeText(){

        for (int i = 1; i < 5; i++) {
            new CampaignsLocationsPage().sort.click();
            BrowserUtils.waitFor(1);
            allSortList.get(i).click();
            BrowserUtils.waitFor(1);

            new CampaignsLocationsPage().sort.click();
            BrowserUtils.waitFor(1);
            Assert.assertTrue(allSortList.get(i).getCssValue("color").equals("rgba(255, 169, 0, 1)")); // turuncu renk kodu
            new CampaignsLocationsPage().sort.click();
        }
        new CampaignsLocationsPage().sort.click();
        BrowserUtils.waitFor(1);
        allSortList.get(0).click();
        BrowserUtils.waitFor(1);

        new CampaignsLocationsPage().sort.click();
        Assert.assertTrue(allSortList.get(0).getCssValue("color").equals("rgba(155, 155, 155, 1)")); // siyah renk kodu
    }

    public void mobileLoginString(String mail, String password) {
        BrowserUtils.waitFor(1);
        signIn.click();

        BrowserUtils.waitForVisibility(emailMobile,3);
        emailMobile.sendKeys(mail);
        BrowserUtils.waitForVisibility(passwordMobile,5);
        passwordMobile.sendKeys(password);
        BrowserUtils.waitForClickablility(loginMobile,2);
        loginMobile.click();
    }

    public void changeStringPassword(String password, String confirmationPassword){

        new LoginPage().inputPass.sendKeys("Yolcu360");
        BrowserUtils.waitFor(1);
        new LoginPage().inputNewPass.sendKeys(password);
        new LoginPage().inputNewPassVerify.sendKeys(confirmationPassword);
        BrowserUtils.waitForClickablility(new LoginPage().SaveButtonList.get(0),3);
        BrowserUtils.clickWithJS(new LoginPage().SaveButtonList.get(3));
        BrowserUtils.waitFor(1);
    }

    public void changeMobilCurrency(String currency) {
        WebElement element=webDriver.findElement(By.xpath("//a/i[@*='icon icon-"+currency+"']"));
        BrowserUtils.clickWithJS(dropdownMobileMenu);
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForClickablility(element,5);
        BrowserUtils.clickWithJS(element);
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForVisibility(rentButton.get(0),30);
        Assert.assertTrue(webDriver.findElement(By.xpath("(//i[@class='icon icon-"+currency+"'])[7]")).isDisplayed());

    }
    public void selectFirstCarForMobil() {
        BrowserUtils.waitFor(3);
        rentButton.get(0).click();
        BrowserUtils.waitFor(3);
    }

    public void addMobilExtraProductsAssurances(){
        detailSwitchLocator.click();
        BrowserUtils.waitFor(2);


        try {
            officePriceText =officePriceLoc.getText();
        }catch (Exception e){
            officePriceText = webDriver.findElement(By.xpath("(//*[@*='office-price--top']/span)[2]")).getText();
        }

        Assert.assertTrue(officePriceText.contains("0,00"));
        detailSwitchLocator.click();


        BrowserUtils.waitFor(2);
        BrowserUtils.scrollToElement(new ReservationPage().extraProductsMultiPlus.get(0));
        new ReservationPage().extraProductsMultiPlus.get(0).click();
        BrowserUtils.clickWithJS(new ReservationPage().extraProductsSingle.get(0));
    }

    public void verifyMobilPrice(){
        BrowserUtils.waitFor(1);

         try {
             if(webDriver.findElements(By.xpath("(//*[@*='payment-info__container--middle']/span)")).size()==0){
                detailSwitchLocator.click();
            }
             Assert.assertTrue(webDriver.findElement(By.cssSelector("span.display-switch.display-switch--open")).isDisplayed());
        }catch (Exception e){
             detailSwitchLocator.click();
         }

        BrowserUtils.waitFor(1);

        try {
            cardPriceText = cardPriceLoc.getText();
            totalPriceText = detailPagePriceLoc2.getText();
            officePriceText =officePriceLoc.getText();
            BrowserUtils.waitForVisibility(priceCarLeft,3);
            Assert.assertTrue(priceCarLeft.getText().equals(totalPriceText));
        }catch (Exception e){
            cardPriceText= webDriver.findElement(By.xpath("(//*[@*='row card-price']/span)[2]")).getText();
            totalPriceText= webDriver.findElement(By.cssSelector("span.price")).getText();
            officePriceText= webDriver.findElement(By.xpath("(//*[@*='office-price--top']/span)[2]")).getText();
            BrowserUtils.waitFor(1);
            Assert.assertTrue(webDriver.findElement(By.cssSelector("span.display-price")).getText().equals(totalPriceText));
        }

        System.out.println("officePriceTextverr = " + officePriceText);
        BrowserUtils.waitFor(1);

        if(officePriceText.contains(".")){
            officePriceText = officePriceText.replace(".","");
        }
        if(cardPriceText.contains(".")){
            cardPriceText = cardPriceText.replace(".","");
        }
        if(totalPriceText.contains(".")){
            totalPriceText = totalPriceText.replace(".","");
        }
        BrowserUtils.waitFor(1);
        officePrice=Double.parseDouble(officePriceText.replace(",","."));
        cardPrice=Double.parseDouble(cardPriceText.replace(",","."));
        totalPrice=Double.parseDouble(totalPriceText.replace(",","."));
        BrowserUtils.waitFor(1);

        Assert.assertTrue(officePrice+cardPrice==totalPrice);
        detailSwitchLocator.click();

    }

    public void sendMobilSms(){

     //   System.out.println("activePayment = " + activePayment);
        if (ConfigurationPostmanReader.get("ActivePayment").equals("IYZICO")){
            BrowserUtils.waitForVisibility(smsCodeBox,30);
            BrowserUtils.waitFor(1);
            smsCodeBox.sendKeys("283126");
            BrowserUtils.waitFor(1);
            smsSubmitButton.click();
        }else{
            BrowserUtils.waitFor(1);
            BrowserUtils.waitForVisibility(new ReservationPage().newSmsCodeBox,15);
            new ReservationPage().newSmsCodeBox.sendKeys("a");
            BrowserUtils.waitFor(1);
            new ReservationPage().newSmsSubmitButton.click();
        }
            BrowserUtils.waitFor(4);

        if(webDriver.findElements(By.id("proceed-button")).size()==2){
            webDriver.findElements(By.id("proceed-button")).get(1).click();
        }
    }

    public void verifyMobilPriceAfterPayment(){
        BrowserUtils.waitFor(1);

        if(webDriver.findElements(By.cssSelector("span.payment__total__first--right")).size()==0){
            BrowserUtils.scrollToElement(new ReservationPage().resSummaryTotalPriceLocator);
        }
        resSummaryTotalPriceText = new ReservationPage().resSummaryTotalPriceLocator.getText();
        resSummaryCardPriceText = new ReservationPage().resSummaryCardPriceLocator.getText();


        BrowserUtils.waitFor(1);


        if(resSummaryCardPriceText.contains(".")){
            resSummaryCardPriceText = resSummaryCardPriceText.replace(".","");
        }
        if(resSummaryTotalPriceText.contains(".")){
            resSummaryTotalPriceText = resSummaryTotalPriceText.replace(".","");
        }
        BrowserUtils.waitFor(1);

        double resSummaryTotalPrice=Double.parseDouble(resSummaryTotalPriceText.replace(",","."));
        double resSummaryCardPrice=Double.parseDouble(resSummaryCardPriceText.replace(",","."));
        double resSummaryOfficePrice=0.00;

        if(webDriver.findElements(By.cssSelector("div[class^='payment']")).size()>8){
            resSummaryOfficePriceText = new ReservationPage().resSummaryOfficePriceLocator.getText();
            if(resSummaryOfficePriceText.contains(".")){
                resSummaryOfficePriceText = resSummaryOfficePriceText.replace(".","");
            }
            resSummaryOfficePrice=Double.parseDouble(resSummaryOfficePriceText.replace(",","."));

            Assert.assertTrue(resSummaryOfficePrice+0==officePrice);
            Assert.assertTrue( resSummaryOfficePrice+resSummaryCardPrice==resSummaryTotalPrice);
        }

        BrowserUtils.waitFor(1);

        System.out.println("resSummaryCardPrice = " + resSummaryCardPrice);
        System.out.println("resSummaryOfficePrice = " + resSummaryOfficePrice);
        System.out.println("resSummaryTotalPrice = " + resSummaryTotalPrice);
        System.out.println("cardPrice = " + cardPrice);
        System.out.println("totalPrice = " + totalPrice);

        Assert.assertTrue( resSummaryOfficePrice+resSummaryCardPrice==resSummaryTotalPrice);
        Assert.assertTrue(resSummaryCardPrice+0==cardPrice);
        Assert.assertTrue(resSummaryTotalPrice+0==totalPrice);

    }

    public void selectMobilFilter(String filter){
        if(filter.contains("Dizel")|| filter.contains("Benzin")){
            filterFuelType.click();
            webDriver.findElement(By.xpath("//span[contains(text(),'"+filter+"')]")).click();
        }else{
            filterTransmission.click();
            webDriver.findElement(By.xpath("//span[contains(text(),'"+filter+"')]")).click();
        }

    }

    public void changeLanguageMainPageMobil(List<String> language) {
        BrowserUtils.waitForPageToLoad(3);
        for (String languageString : language) {
            WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + languageString + "'])[1]"));
            BrowserUtils.waitFor(1);
            BrowserUtils.clickWithJS(dropdownMobileMenu);
            BrowserUtils.waitFor(2);
            try {
                element.click();

            } catch (Exception e) {
                BrowserUtils.clickWithJS(dropdownMobileMenu);
                element.click();
            }
            BrowserUtils.waitFor(2);

            String mainTitleText = mainTitle.getText();
            String mainCampaignTitle = webDriver.findElement(By.cssSelector("div.title")).getText();
            String differentLocatorCheckBoxText = webDriver.findElement(By.cssSelector("span.checkbox-label")).getText();

            switch (languageString){
                case"TR":
                    Assert.assertEquals("Araç kiralamak ne kolaymış!",mainTitleText);
                    Assert.assertEquals("Araç Kiralama Kampanyaları",mainCampaignTitle);
                    Assert.assertEquals("Farklı yerde bırakmak istiyorum",differentLocatorCheckBoxText);
                    break;
                case"EN":
                    Assert.assertEquals("Easy car rental!",mainTitleText);
                    Assert.assertEquals("Rent a Car Campaigns",mainCampaignTitle);
                    Assert.assertEquals("Different Drop Off Location?",differentLocatorCheckBoxText);
                    break;
                case"DE":
                    Assert.assertEquals("Auto mieten ganz einfach!",mainTitleText);
                    Assert.assertEquals("Mietwagen Kampagnen",mainCampaignTitle);
                    Assert.assertEquals("Rückgabe an einem anderen Ort",differentLocatorCheckBoxText);
                    break;
            }
        }
    }
    public void changeLanguageDetailPageMobil(List<String> language) {
        BrowserUtils.waitForPageToLoad(3);
        for (String languageString : language) {
            WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + languageString + "'])[1]"));
            BrowserUtils.waitFor(1);
            BrowserUtils.clickWithJS(dropdownMobileMenu);
            BrowserUtils.waitFor(2);
            try {
                element.click();

            } catch (Exception e) {
                BrowserUtils.clickWithJS(dropdownMobileMenu);
                element.click();
            }
            BrowserUtils.waitFor(2);
            String timeText = webDriver.findElement(By.cssSelector("span.timer-warning-text1")).getText();
            String deliveryType= webDriver.findElement(By.cssSelector("span.ttitle")).getText();
            String continiousButton = webDriver.findElement(By.xpath("(//*[@class='right'])[2]")).getText();

            switch (languageString){
                case"TR":
                    Assert.assertEquals("Rezervasyonu tamamlamak için",timeText);
                    Assert.assertEquals("Aracı nasıl teslim alacağım?",deliveryType);
                    Assert.assertEquals("Devam Et",continiousButton);
                    break;
                case"EN":
                    Assert.assertEquals("To complete reservation",timeText);
                    Assert.assertEquals("How to pick up your car?",deliveryType);
                    Assert.assertEquals("Keep going!",continiousButton);
                    break;
                case"DE":
                    Assert.assertEquals("Um die Reservierung abzuschließen",timeText);
                    Assert.assertEquals("Wie holen Sie Ihr Auto ab?",deliveryType);
                    Assert.assertEquals("Machen Sie weiter.",continiousButton);
                    break;
            }
        }
    }

    public void changeLanguageReservationSummaryPageMobil(List<String> language) {

        BrowserUtils.waitForPageToLoad(3);
        for (String languageString : language) {
            WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + languageString + "'])[1]"));
            BrowserUtils.waitFor(1);
            BrowserUtils.clickWithJS(dropdownMobileMenu);
            BrowserUtils.waitFor(2);
            try {
                element.click();

            } catch (Exception e) {
                BrowserUtils.clickWithJS(dropdownMobileMenu);
                element.click();
            }
            BrowserUtils.waitFor(2);
            String reservationMessageText = new ReservationPage().reservationMessage.getText();
            String deliveryType= webDriver.findElement(By.cssSelector("span.ttitle")).getText();
            String reservationMessage2Text = new ReservationPage().reservationMessage2.getText();

            switch (languageString){
                case"TR":
                    Assert.assertTrue(reservationMessageText.contains("rezervasyonunuz onaylandı!"));
                    Assert.assertEquals("Aracı nasıl teslim alacağım?",deliveryType);
                    Assert.assertEquals("Rezervasyon bilgileriniz e-mail ve sms olarak size gönderildi.",reservationMessage2Text);
                    break;
                case"EN":
                    Assert.assertTrue(reservationMessageText.contains("was confirmed!"));
                    Assert.assertEquals("How to pick up your car?",deliveryType);
                    Assert.assertEquals("Your reservation information was sent to you by e-mail and sms.",reservationMessage2Text);
                    break;
                case"DE":
                    Assert.assertTrue(reservationMessageText.contains("wurde bestätigt!"));
                    Assert.assertEquals("Wie holen Sie Ihr Auto ab?",deliveryType);
                    Assert.assertEquals("Ihre Reservierung Informationen wurden Ihnen per E-Mail und SMS zugesandt.",reservationMessage2Text);
                    break;

            }
        }
    }

    public void changeLanguageCampaignsPageMobil(List<String> language) {
        BrowserUtils.waitForPageToLoad(5);
        for (String languageString : language) {
            WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + languageString + "'])[1]"));
            BrowserUtils.waitFor(1);
            BrowserUtils.clickWithJS(dropdownMobileMenu);
            BrowserUtils.waitFor(2);
            try {
                element.click();

            } catch (Exception e) {
                BrowserUtils.clickWithJS(dropdownMobileMenu);
                element.click();
            }
            BrowserUtils.waitFor(2);
            String campaignGlobal = new CampaignsLocationsPage().campaignsList.get(0).getText();
            String campaignTitle = webDriver.findElement(By.xpath("//h1")).getText();

            switch (languageString) {
                case "TR":
                    Assert.assertEquals("ARAÇ KİRALAMA KAMPANYALARI", campaignTitle);
                    Assert.assertEquals("Kampanyayı İncele", campaignGlobal);
                    break;
                case "EN":
                    Assert.assertEquals("CAR RENTAL CAMPAIGNS", campaignTitle);
                    Assert.assertEquals("Details", campaignGlobal);
                    break;
                case "DE":
                    Assert.assertEquals("AUTOVERMIETUNG AKTIONEN", campaignTitle);
                    Assert.assertEquals("Einzelheiten", campaignGlobal);
                    break;
            }

        }
    }

    public void changeLanguageCampaignsDetailPageMobil(List<String> language) {
        BrowserUtils.waitForPageToLoad(5);
        for (String languageString : language) {
            WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + languageString + "'])[1]"));
            BrowserUtils.waitFor(1);
            BrowserUtils.clickWithJS(dropdownMobileMenu);
            BrowserUtils.waitFor(2);
            try {
                element.click();

            } catch (Exception e) {
                BrowserUtils.clickWithJS(dropdownMobileMenu);
                element.click();
            }
            BrowserUtils.waitFor(2);

            String campaignButtonText = campaignApplyButton.getText();
            String campaignHeaderButtonText = campaigns.getText();
            String campaignDetail = webDriver.findElement(By.xpath("(//strong)[3]")).getText();
            System.out.println("campaignHeaderButtonText = " + campaignButtonText);
           // System.out.println("campaignHeaderButtonText = " + campaignHeaderButtonText);
            System.out.println("campaignDetail = " + campaignDetail);

            switch (languageString){
                case"TR":
                 //   Assert.assertEquals("Kampanyalar",campaignHeaderButtonText);
                    Assert.assertEquals("Kampanyaya Katıl!",campaignButtonText);
                    Assert.assertEquals("Kampanyadan Nasıl Yararlanabilirsiniz?",campaignDetail);
                    break;
                case"EN":
                  //  Assert.assertEquals("Campaigns",campaignHeaderButtonText);
                    Assert.assertEquals("Activate Campaign!",campaignButtonText);
                    Assert.assertEquals("How Can You Benefit From The Campaign?",campaignDetail);
                    break;
                case"DE":
                  //  Assert.assertEquals("Aktionen",campaignHeaderButtonText);
                    Assert.assertEquals("Mach mit bei der Aktion!",campaignButtonText);
                    Assert.assertEquals("Wie können Sie von der Kampagne profitieren?",campaignDetail);
                    break;
            }
        }
    }
//    public void paymentTypeinMobil(){////This method required for send sms step and reservation
//        RestAssured.baseURI="https://api.360y.co/api/v1/payment-api";
//        Response response=RestAssured.given()
//                .when().get("/active");
//        response.prettyPrint();
//        Assert.assertEquals(response.statusCode(),200);
//        JsonPath jsonPath=response.jsonPath();
//        activePayment=jsonPath.getString("active");
//        System.out.println("activePayment = " + activePayment);
//    }

    public void selectVerifyFilterTitleDescriptionInMobil(List<String> filters) {
        String defaultTittleText = webDriver.findElement(By.xpath("//title")).getAttribute("textContent");
        for (String filter : filters) {
            filterMobile.click();
            BrowserUtils.waitFor(2);
            webDriver.findElement(By.id(filter + "_filter")).click();
            WebElement filterElement = webDriver.findElements(By.xpath("//*[@filtername='" + filter + "']")).get(0);
            filterElement.click();

            forwardArrow.click();
            BrowserUtils.waitFor(1);
            forwardArrow.click();
            BrowserUtils.waitFor(1);

            String actualDescription = webDriver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content");
            String expectedDescription="";

            String[] arrayDescription = actualDescription.split(" ");
            String newArrayDescription ="";
            String newENArrayDescription ="";

            for (int i = 0; i < arrayDescription.length ; i++) {
                if(i>=9 || i<=13){
                    newArrayDescription = newArrayDescription+arrayDescription[i]+" ";
                }else if(i>=18){
                    if(i== arrayDescription.length-1){
                        newArrayDescription = newArrayDescription+arrayDescription[i];
                    }else{
                        newENArrayDescription = newENArrayDescription+arrayDescription[i]+" ";
                    }
                }
            }

            String[] arrayTitle =  webDriver.findElement(By.xpath("//title")).getAttribute("textContent").split(" ");
            String actualTitle=webDriver.findElement(By.xpath("//title")).getAttribute("textContent");
            String expectedTitle="";

            switch (defaultTittleText) {
                case "İstanbul Sabiha Gökçen Havalimanı Araç Kiralama - Yolcu360":
                    expectedTitle = "İstanbul - Sabiha Gökçen Havalimanı " + arrayTitle[5] + " Araç Kiralama | Yolcu360.com";
                    expectedDescription="İstanbul - Sabiha Gökçen Havalimanı lokasyonumuzdan en ucuz fiyatlarla "+ newArrayDescription +"sahip araçlardan istediğinizi seçip kiralayabilirsiniz.";
                    Assert.assertFalse(defaultTittleText.equals(actualTitle));
                    Assert.assertTrue(actualTitle.equals(expectedTitle));
                    break;
                case "İstanbul Sabiha Gökçen Havalimanı Car Rental - Yolcu360":
                    expectedTitle = "Istanbul - Sabiha Gokcen Airport " + arrayTitle[5] + " Car Rental | Yolcu360.com";
                    expectedDescription="From the Istanbul - Sabiha Gokcen Airport location, you can rent the vehicle you want from the vehicles " + newENArrayDescription;
                    if(actualDescription.contains("automatic")){
                        expectedDescription="Choose and rent one of the vehicles with automatic type at the cheapest prices from our Istanbul - Sabiha Gokcen Airport location.";
                    }
                    Assert.assertFalse(defaultTittleText.equals(actualTitle));
                    Assert.assertTrue(actualTitle.equals(expectedTitle));
                    break;
                case "Günstig Autovermietung in İstanbul Sabiha Gökçen Havalimanı":
                    expectedTitle = "Istanbul - Sabiha Gokcen Flughafen " + arrayTitle[5] + " undefined | Yolcu360.com";
                    Assert.assertFalse(defaultTittleText.equals(actualTitle));
                    Assert.assertTrue(actualTitle.equals(expectedTitle));
                    break;
            }
            BrowserUtils.waitFor(2);
            filterMobile.click();
            BrowserUtils.waitFor(2);

            WebElement clearFilterMobil=webDriver.findElement(By.className("title-clear-btn"));
            BrowserUtils.waitForVisibility(clearFilterMobil,5);
            BrowserUtils.hover(clearFilterMobil);
            BrowserUtils.waitFor(1);
            BrowserUtils.clickWithJS(clearFilterMobil);
            BrowserUtils.waitFor(2);
        }
    }

    public void saveReservationNumber(){
        reservationNumber = onlyReservationNumber.getText();
    }

    public void verifyReservationNumber(){
        String reservationNumberText = webDriver.findElements(By.cssSelector("div.col-inner")).get(0).getText();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(reservationNumberText.contains(reservationNumber));
    }

    public void selectDateWithoutTime(int date) {
        if (!new MainPage().defaultCalendarDate.get(date).isDisplayed()){
            BrowserUtils.waitFor(1);
            webDriver.findElement(By.xpath("//*[@*='date-picker__nav-next']/i")).click();
        }
        BrowserUtils.waitFor(2);
        new MainPage().defaultCalendarDate.get(date).click();
        BrowserUtils.waitFor(2);
    }

    public MobilePage(){
        PageFactory.initElements(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver(), this);
    }



}