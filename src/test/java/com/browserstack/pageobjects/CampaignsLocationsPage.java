package com.browserstack.pageobjects;

import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.util.BrowserUtils;
import com.browserstack.util.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CampaignsLocationsPage extends BasePage{

    //WebDriver driver = Driver.get();
     WebDriver webDriver=RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();

    @FindBy(xpath = "//*[@*='price-field__cta-btn']")
    public List<WebElement> rentNowButton;

    @FindBy(xpath = "//*[@*='head-filter-clear']")
    public WebElement cleanFilter;

    @FindBy(xpath = "(//*[@*='icon-arrows-up-down-icon'])[2]")
    public WebElement sort;

    @FindBy(xpath = "//*[@*='promo-link-button']")
    public WebElement promotionCodeLocator;

    @FindBy(xpath = "//*[@*='promo-modal__wrapper']")
    public WebElement promoCodeWindow;

    @FindBy(xpath = "//*[@*='modal__close-icon undefined']")
    public WebElement campaignWindowCancelButton;

    @FindBy(css = "#promo-text-field")
    public WebElement promoCodeBox;

    @FindBy(css = "button.promo-modal__cta")
    public WebElement promoCodeApplyButton;

    @FindBy(css = "div.promo__container")
    public List <WebElement> promoCompanyFlagList;

    @FindBy(css = "span.errorMessage")
    public WebElement promoCodeErrorMessage;

    @FindBy(xpath = "//*[@*=('icon icon-btn-arrow-right-2')]")
    public WebElement rightArrowCampaign;

    @FindBy(xpath = "//*[@*=('icon icon-button-arrow-left')]")
    public WebElement leftArrowCampaign;

    @FindBy(xpath = "(//*[@*='/tr/arac-kiralama-kampanyalari/'])[2]")
    public WebElement allCampaignButton;

    @FindBy(css = "a.allCampaignsItem__button")
    public List <WebElement> campaignsList;

    @FindBy(css = "#code")
    public WebElement campaignCodeBox;

    @FindBy(css = "div.join-btn")
    public WebElement campaignApplyButton;

    @FindBy(xpath = "//*[@*=('campaign-done-modal')]")
    public WebElement campaignActiveWindow;

    @FindBy(css = "button.btn.ok-btn")
    public WebElement campaignActiveOkButton;

    @FindBy(xpath = "((//div[@class='title'])/h1/span)[1]")
    public WebElement reservationCityLocator;

    @FindBy(xpath = "//h1")
    public WebElement bannerPageTitle;

    @FindBy(xpath = "(//p/img)[2]")
    public WebElement locatorPageImage;

    @FindBy(xpath = "(//h1/span)[3]")
    public WebElement carLocationTitle;

    @FindBy(xpath = "//*[@*='head-filter-subtitle']")
    public WebElement selectedFilterTitle;

    @FindBy(xpath = "//*[@*='head-filter-subtitle']")
    public List <WebElement> selectedFilterTitleList;

    //TR->EN EN->TR
    @FindBy(css = "div.dropdown-menu.show")
    public WebElement otherLanguage;

    @FindBy(xpath = "(//*[@*='count'])[2]")
    public WebElement listingVehicles;

    @FindBy(xpath = "//*[@*='display-rating__comment  search-item']")
    public List <WebElement> commentLocator;

    @FindBy(xpath = "//*[@filtername='vendor']")
    public List <WebElement> vendorLoc;

    @FindBy(xpath = "//*[@filtername='transmission']")
    public List <WebElement> gearTypeLoc;

    @FindBy(xpath = "//*[@filtername='fuel']")
    public List <WebElement> fuelTypeLoc;

    @FindBy(xpath = "//*[@rel='canonical']")
    public WebElement canonicalLoc;

    @FindBy(xpath = "//*[contains(@for,'vendor')]")
    public List<WebElement> vendorfilter;


    public CampaignsLocationsPage(){
      //  this.webDriver = webDriver;
        PageFactory.initElements(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver(), this);
    }

    public void enterPromoCode(String code){
        //Multinet promosyon kodu kullanıldı
        BrowserUtils.waitFor(1);
        promotionCodeLocator.click();
        promoCodeBox.sendKeys(code);
        promoCodeApplyButton.click();
        BrowserUtils.waitFor(2);
    }

    public void selectCampaignAndCode(String campaign, String campaignCode){
        String locator= "//a[@href='/tr/kampanya/"+campaign+"/']";  // kampanya incele locatoru
        BrowserUtils.waitForVisibility(webDriver.findElement(By.xpath(locator)),10);
        BrowserUtils.clickWithJS(webDriver.findElement(By.xpath(locator)));
        //Driver.get().findElement(By.xpath(locator)).click();
        BrowserUtils.waitFor(1);
        campaignCodeBox.sendKeys(campaignCode);
        campaignApplyButton.click();
        BrowserUtils.waitFor(2);
    }

    public void verifyJoinCampaign (String campaign){
        Assert.assertTrue(campaignActiveWindow.isEnabled());
        campaignActiveOkButton.click();
        BrowserUtils.waitFor(1);

        Assert.assertTrue(webDriver.getCurrentUrl().contains(campaign));
        Assert.assertTrue(pickUpInput.isEnabled());
        BrowserUtils.verifyElementDisplayed(new MainPage().findButton);
    }

    public void verifyVehicleListingPageToCampaign(String location){
        BrowserUtils.verifyElementDisplayed(new ReservationPage().reservationTableTitle);
        Assert.assertTrue(new ReservationPage().differentLocatorBoxDisplay.isEnabled());
        Assert.assertTrue(rentNowButton.get(0).isDisplayed());
        String expectedLocate= "";
        if(location.contains("-")){
            String[] split = location.split("-");
            expectedLocate = split[0];
        }else{
            String[] split = location.split(" ");
            expectedLocate = split[0];
        }
        BrowserUtils.waitFor(2);
        String text = carLocationTitle.getText();
        System.out.println("text = " + text);

        String[] actualLocate = text.split(" ");
        System.out.println("arrayLocate[0] = " + actualLocate[0]);

        Assert.assertTrue(actualLocate[0].equalsIgnoreCase(expectedLocate));

    }

    public void searchBannerLocation(String location){
        BrowserUtils.waitFor(2);
        String locator= "//a[text()='"+location+"']";
        BrowserUtils.clickWithJS(webDriver.findElement(By.xpath(locator)));
        //Driver.get().findElement(By.xpath(locator)).click();
        BrowserUtils.waitForVisibility(new MainPage().findButton,20);
        BrowserUtils.waitFor(5);
        BrowserUtils.scrollToSize(0,250);
    }

    public void verifyLocationPageOpen(String location){
        BrowserUtils.waitForClickablility(new MainPage().findButton,8);
        System.out.println("location = " + location);
        System.out.println("bannerPageTitle.getText() = " + bannerPageTitle.getText());
        Assert.assertEquals(location,bannerPageTitle.getText());
        BrowserUtils.verifyElementDisplayed(locatorPageImage);
        BrowserUtils.verifyElementDisplayed(new MainPage().findButton);
    }

    public void filterMenu(List<String> filters){
        BrowserUtils.waitFor(2);

        for (int i = 0; i < filters.size(); i++) {

            WebElement filterElement=webDriver.findElements(By.xpath("//*[@filtername='"+filters.get(i)+"']")).get(0);
            BrowserUtils.hover(filterElement);
            BrowserUtils.waitFor(2);
            filterElement.click();

            BrowserUtils.waitForVisibility(selectedFilterTitle,5);
            BrowserUtils.verifyElementDisplayed(selectedFilterTitle);

            BrowserUtils.hover(filterElement);
            BrowserUtils.waitFor(2);
            BrowserUtils.clickWithJS(filterElement);

        }
    }

    public void filterDetailCheck(List<String> filters){
        BrowserUtils.waitFor(2);
        List<String> actual= Arrays.asList("gear","fuel");
        List<String> expected= Arrays.asList("Otomatik","Dizel");
        for (int i = 0; i < 2; i++) {

            WebElement filterElement=webDriver.findElements(By.xpath("//*[@filtername='"+filters.get(i)+"']")).get(0);
            new BrowserUtils().hover(filterElement);
            BrowserUtils.waitFor(3);
            BrowserUtils.clickWithJS(filterElement);
            BrowserUtils.waitFor(3);
            List<WebElement> element = webDriver.findElements(By.xpath("//i[@class='icon-"+actual.get(i)+"-icon']/.."));

           for(int j=0;j<10; j++) {
               Assert.assertTrue(element.get(j).getText().equals(expected.get(i)));
           }

            BrowserUtils.hover(filterElement);
            BrowserUtils.waitFor(2);
            BrowserUtils.clickWithJS(filterElement);

        }
    }
    public void rangedFilter(List<String> rangedFilters){
        BrowserUtils.waitFor(4);

        for (String rangedFilter : rangedFilters) {

            WebElement minValue = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div/div/input)[1]"));
            WebElement maxValue = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div/div/input)[2]"));
            WebElement arrow = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div)[3]"));

            if (rangedFilter.equals("distance") || rangedFilter.equals("provision") ) {
                WebElement element=webDriver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[3]"));
                BrowserUtils.hover(element);
                element.click();

                BrowserUtils.waitFor(2);
            } else {
                WebElement price=webDriver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[9]"));
                BrowserUtils.scrollToElement(price);
                BrowserUtils.clickWithJS(webDriver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[9]")));
                BrowserUtils.waitFor(2);
                int minPrice=Integer.parseInt(price.getText().substring(0,price.getText().indexOf("-")).trim());
                int maxPrice=Integer.parseInt(price.getText().substring(price.getText().indexOf("-")+2,price.getText().indexOf("(")-3).trim());
                BrowserUtils.hover(sort);
                BrowserUtils.waitFor(2);
                sort.click();
                new ReservationPage().allSortList.get(1).click();
                BrowserUtils.waitForVisibility(new ReservationPage().allCarsTotalPrice.get(0),10);
                int actualPrice1= Integer.parseInt(new ReservationPage().allCarsTotalPrice.get(0).getText().substring(0,new ReservationPage().allCarsTotalPrice.get(0).getText().indexOf(",")).replace(".",""));
                Assert.assertTrue(actualPrice1>=minPrice);
                BrowserUtils.hover(sort);
                BrowserUtils.waitFor(2);
                sort.click();
                new ReservationPage().allSortList.get(2).click();
                BrowserUtils.waitFor(1);
                int actualPrice2= Integer.parseInt(new ReservationPage().allCarsTotalPrice.get(0).getText().substring(0,new ReservationPage().allCarsTotalPrice.get(0).getText().indexOf(",")).replace(".",""));
                Assert.assertTrue(actualPrice2<=maxPrice);
            }

            BrowserUtils.waitFor(1);

            minValue.sendKeys("500");
            maxValue.sendKeys("2000");
            BrowserUtils.waitFor(1);
            arrow.click();
            BrowserUtils.waitFor(1);
            BrowserUtils.waitForVisibility(selectedFilterTitle,5);
            Assert.assertTrue(selectedFilterTitle.isEnabled());

            BrowserUtils.waitForVisibility(cleanFilter,5);
            BrowserUtils.hover(cleanFilter);
            BrowserUtils.waitFor(1);
            BrowserUtils.clickWithJS(cleanFilter);
            BrowserUtils.waitFor(2);
        }
    }

    public void changeLanguage(String language){
        languageSelect.click();
        WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + language + "'])[2]"));
        BrowserUtils.waitForVisibility(otherLanguage,20);
        //BrowserUtils.waitFor(4);
        element.click();
        //otherLanguage.click();
        BrowserUtils.waitFor(3);
    }

    public void changeCountry(String country){
        countrySelect.click();
        //WebElement element = Driver.get().findElement(By.xpath("(//*[text()='" + country + "'])[2]"));
        WebElement element=webDriver.findElement(By.xpath("(//*[@class='dropdown-item'])[242]"));
        BrowserUtils.waitFor(1);
        element.click();
        BrowserUtils.waitFor(1);
    }

    public void verifyLanguage(String language){

            if(language.equalsIgnoreCase("EN")){
            Assert.assertTrue(rentNowButton.get(0).getText().toLowerCase().contains("rent"));
            Assert.assertTrue(listingVehicles.getText().toLowerCase().contains("listing"));
            Assert.assertTrue(new ReservationPage().sortLocator.getText().toLowerCase().contains("recommended"));
            Assert.assertTrue(new ReservationPage().startDate.getText().toLowerCase().contains("pick-up"));

        }else if(language.equalsIgnoreCase("TR")){
            Assert.assertTrue(rentNowButton.get(0).getText().toLowerCase().contains("kirala"));
            Assert.assertTrue(listingVehicles.getText().toLowerCase().contains("listeleniyor"));
            Assert.assertTrue(new ReservationPage().sortLocator.getText().toLowerCase().contains("önerilen"));
            Assert.assertTrue(new ReservationPage().startDate.getText().toLowerCase().contains("alış"));
        }
            else if(language.equalsIgnoreCase("DE")){
                Assert.assertTrue(rentNowButton.get(0).getText().toLowerCase().contains("mieten!"));
                Assert.assertTrue(listingVehicles.getText().toLowerCase().contains("optionen"));
                Assert.assertTrue(new ReservationPage().sortLocator.getText().toLowerCase().contains("empfohlen"));
                Assert.assertTrue(new ReservationPage().startDate.getText().toLowerCase().contains("abholdatum"));
            }
    }

    public void changePriceType(List<String> currency){
        BrowserUtils.waitFor(1);

        for (int j = 0; j < currency.size(); j++) {

            String locator= "//a/span/i[@*='icon icon-"+currency.get(j)+"']";
            BrowserUtils.waitFor(1);
            currencySelect.click();

            try {
                webDriver.findElement(By.xpath(locator)).click();

            }catch (Exception e){
                currencySelect.click();
                webDriver.findElement(By.xpath(locator)).click();
            }
            //reservationPage.secondSearchButton.click();
            BrowserUtils.waitForVisibility(rentNowButton.get(1),20);
            for (int i = 4; i < 8; i++) {
                Assert.assertTrue(webDriver.findElement(By.xpath("(//*[@*='icon icon-"+currency.get(j)+"'])["+i+"]")).isEnabled());
            }
        }
    }

    public void verifyCommitWindow(){
        BrowserUtils.waitForVisibility(webDriver.findElement(By.xpath("//*[@*='review-container__main-title']")),5);
        String actualTitle= webDriver.findElement(By.xpath("//*[@*='review-container__main-title']")).getText();
        String expectedTitle= "Değerlendirmeler";
        String agencyLogo= webDriver.findElement(By.xpath("//*[@*='display-rating__brand review']/img")).getAttribute("alt").toLowerCase();
        String agencyTitle= webDriver.findElement(By.xpath("//*[@*='review-container__general-review-location']/span")).getText().toLowerCase();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Assert.assertTrue(agencyTitle.contains(agencyLogo));
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='review-container__general-review']")).isEnabled());
    }

    public void filterOptions(Map<String,String> filters){
        BrowserUtils.waitFor(3);
        String mainUrl= webDriver.getCurrentUrl();
        Assert.assertTrue(mainUrl.contains("rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/?from="));
        Assert.assertTrue(mainUrl.contains("&pickup_time="));
        Assert.assertTrue(mainUrl.contains("&dropoff_time="));

        BrowserUtils.waitFor(1);
      //  String actualCanonicalUrl= canonicalLoc.getAttribute("href");
        String actualCanonicalUrl= webDriver.getCurrentUrl();

        String expectedCanonicalUrl="https://"+ ConfigurationReader.get("environmentType") +".yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";
        //String expectedCanonicalUrl="https://beta.yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";
        BrowserUtils.waitFor(1);

     //   Assert.assertEquals(expectedCanonicalUrl,actualCanonicalUrl);
        Assert.assertTrue(actualCanonicalUrl.contains(expectedCanonicalUrl));

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();

            //BrowserUtils.hover(driver.findElements(By.xpath("//*[@filtername='"+k+"']")).get(0));
            WebElement filter =webDriver.findElements(By.xpath("//*[@filtername='"+k+"']")).get(0);
            BrowserUtils.hover(filter);

            BrowserUtils.waitFor(1);
            filter.click();
            BrowserUtils.waitFor(1);

            String actualUrl= webDriver.getCurrentUrl();
            String expectedUrl= mainUrl+"&"+v+"="+filter.getAttribute("value").replace(" ","_");

            String value= filter.getAttribute("value");
            switch (value) {
                case "deliveredToAddress" :
                    expectedUrl = mainUrl + "&" + v + "=" + "delivery_to_address";
                    break;
                case "fromOffice" :
                    expectedUrl = mainUrl + "&" + v + "=" + "office";
                    break;
                case "inTerminalOffice" :
                    expectedUrl = mainUrl + "&" + v + "=" + "in_terminal_office";
                    break;
                case "meetAndGreet" :
                    expectedUrl = mainUrl + "&" + v + "=" + "valet_service";
                    break;
                case "nonTerminalMeetAndGreet" :
                    expectedUrl = mainUrl + "&" + v + "=" + "out_of_terminal_meeting_greeting";
                    break;
                case "nonTerminalValet" :
                    expectedUrl = mainUrl + "&" + v + "=" + "out_of_terminal_valet_service";
                    break;
                case "diesel-gas-mixed" :
                    expectedUrl = mainUrl + "&" + v + "=" + "diesel_gas_mixed";
                    break;
            }

            Assert.assertTrue(actualUrl.contains(expectedUrl));
            //Assert.assertEquals(expectedUrl,actualUrl);
         //   String actualCanonical= canonicalLoc.getAttribute("href");
            String actualCanonical= webDriver.getCurrentUrl();

            expectedCanonicalUrl="https://"+ ConfigurationReader.get("environmentType") +".yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";
            //expectedCanonicalUrl="https://beta.yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";

            if (k.equals("vendor")||k.equals("transmission")||k.equals("fuel")) {

                expectedCanonicalUrl= v+"="+filter.getAttribute("value");
                Assert.assertTrue(webDriver.getCurrentUrl().contains(expectedCanonicalUrl));
            }

        //    Assert.assertEquals(expectedCanonicalUrl,actualCanonical);
            BrowserUtils.hover(filter);
            BrowserUtils.clickWithJS(filter);
            //filter.click();
            BrowserUtils.waitFor(2);
        }
    }

    public void verifyFilterUpdateURL(){
        String mainUrl= webDriver.getCurrentUrl();

        BrowserUtils.hover(vendorLoc.get(0));
        vendorLoc.get(0).click();
        String vendorValue= vendorLoc.get(0).getAttribute("value").replace(" ","_");
        BrowserUtils.waitFor(1);

        BrowserUtils.hover(gearTypeLoc.get(0));
        gearTypeLoc.get(0).click();
        String transmissionValue= gearTypeLoc.get(0).getAttribute("value").replace(" ","_");
        BrowserUtils.waitFor(1);

        BrowserUtils.hover(fuelTypeLoc.get(0));
        fuelTypeLoc.get(0).click();
        String fuelValue= fuelTypeLoc.get(0).getAttribute("value").replace(" ","_");
        BrowserUtils.waitFor(1);

        String actualUrl= webDriver.getCurrentUrl();
        String expectedUrl= mainUrl+"&"+"v"+"="+vendorValue+"&"+"t"+"="+transmissionValue+"&"+"f"+"="+fuelValue;

        Assert.assertEquals(expectedUrl,actualUrl);
// canonical url kaldırıldığı için alt satırda ki kodlar yoruma alınmıştır!!!

        //String actualCanonical= canonicalLoc.getAttribute("href");
        //String expectedCanonicalUrl="https://"+ConfigurationReader.get("environmentType")+".yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";
        //String expectedCanonicalUrl="https://beta.yolcu360.com/tr/rent-a-car/istanbul-sabiha-gokcen-havalimani-arac-kiralama/";
        //Assert.assertEquals(actualCanonical,expectedCanonicalUrl);
    }

    public void selectPopularLocation(String location) {
        BrowserUtils.waitFor(5);

        if (location.equals("istanbul-istanbul-havalimani")){
            webDriver.findElement(By.xpath("(//div[@class='PopularLocationItem location'])[1]")).click();
        }else {
            webDriver.findElement(By.xpath("(//div[@class='PopularLocationItem location'])[2]")).click();
        }

        BrowserUtils.waitForVisibility(new MainPage().findButton,50);
        BrowserUtils.scrollToSize(0,500);
        BrowserUtils.waitFor(5);
    }

    public void whyRentwithYolcu360() {
        BrowserUtils.hover(webDriver.findElement(By.xpath("//*[@*='why-yolcu360']")));

        for (int i = 1; i < 4; i++) {

            Assert.assertTrue(webDriver.findElement(By.xpath("(//*[@*='box-inner'])["+i+"]")).isDisplayed());
            Assert.assertTrue(webDriver.findElement(By.xpath("(//*[@*='box-title'])["+i+"]")).isDisplayed());
            Assert.assertTrue(webDriver.findElement(By.xpath("(//*[@*='box-desc'])["+i+"]")).isDisplayed());
        }
        BrowserUtils.waitFor(1);
    }

    public void yolcu360InPress() {
        BrowserUtils.hover(webDriver.findElement(By.xpath("//*[@*='press-yolcu360']")));
        Assert.assertTrue(webDriver.findElement(By.xpath("(//*[@*='icon-play'])[1]")).isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath("(//*[@*='icon-play'])[2]")).isDisplayed());
        BrowserUtils.waitFor(1);
    }

    public void blogSeen() {
        WebElement blog = webDriver.findElement(By.xpath("//*[@*='row posts']"));
        BrowserUtils.hover(blog);
        BrowserUtils.waitForVisibility(blog,10);
        Assert.assertTrue(blog.isDisplayed());
        List<WebElement> blogPost= webDriver.findElements(By.className("post-inner"));
        List<WebElement> blogImage= webDriver.findElements(By.xpath("//*[@*='blog-image normal']"));

        for (WebElement element : blogPost) {
            Assert.assertTrue(element.isDisplayed());
        }
        for (WebElement element : blogImage) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    public void flatPageonThefooter(List<String> flatPages) {
        for (int i = 0; i < flatPages.size(); i++) {
            BrowserUtils.waitFor(3);
            BrowserUtils.hover(webDriver.findElement(By.xpath("//*[@href='/tr/firma/"+flatPages.get(i)+"/']")));
            WebElement flatPagesElement=webDriver.findElement(By.xpath("//*[@href='/tr/firma/"+flatPages.get(i)+"/']"));
            //String flatPageName= flatPagesElement.getText().toUpperCase().trim();

            BrowserUtils.waitFor(2);
            flatPagesElement.click();
            BrowserUtils.waitFor(2);
            String flatPageUrl= webDriver.getCurrentUrl();

            BrowserUtils.waitFor(2);
            Assert.assertTrue(flatPageUrl.contains(flatPages.get(i)));
        }
    }

    public void clickContactAndCareer() {
        BrowserUtils.hover(webDriver.findElement(By.xpath("//div[@*='bottom__right ']")));
        webDriver.findElement(By.xpath("//a[@href='/tr/iletisim/']")).click();
        String url=webDriver.getCurrentUrl();

        BrowserUtils.hover(webDriver.findElement(By.xpath("//*[@*='adress-info__full']")));
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='adress-info__full']")).isDisplayed());

        String winHandleBefore = webDriver.getWindowHandle();
        WebElement blog=webDriver.findElement(By.xpath("//*[@href='https://yolcu360.com/blog/']"));
        BrowserUtils.hover(blog);
        blog.click();
        BrowserUtils.waitFor(5);

        for(String winHandle : webDriver.getWindowHandles()){
            webDriver.switchTo().window(winHandle);
            url=webDriver.getCurrentUrl();
        }

        Assert.assertEquals(url,"https://yolcu360.com/blog/");

        webDriver.switchTo().window(winHandleBefore);
        BrowserUtils.waitFor(1);

        WebElement kariyer= webDriver.findElement(By.xpath("//*[@href='https://labs.yolcu360.com/yolcu360ta-acik-pozisyonlar/']"));
        BrowserUtils.hover(kariyer);
        kariyer.click();

        BrowserUtils.waitFor(5);
        for(String winHandle : webDriver.getWindowHandles()){
            webDriver .switchTo().window(winHandle);
            url=webDriver.getCurrentUrl();
        }

        Assert.assertEquals(url,"https://labs.yolcu360.com/yolcu360ta-acik-pozisyonlar/");

        webDriver.switchTo().window(winHandleBefore);
        BrowserUtils.waitFor(1);
    }

    public void selectRangeFilter(List<String> rangedFilters) {

        BrowserUtils.waitFor(3);

        String mainUrl= webDriver.getCurrentUrl();

        for (String rangedFilter : rangedFilters) {

            WebElement minValue = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div/div/input)[1]"));
            WebElement maxValue = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div/div/input)[2]"));
            WebElement arrow = webDriver.findElement(By.xpath("(//div[contains(@id,'" + rangedFilter + "')]/div/div/div/div)[3]"));

            if (rangedFilter.equals("distance") || rangedFilter.equals("provision")) {
                BrowserUtils.hover(webDriver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[3]")));
                webDriver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[3]")).click();
            } else {
                BrowserUtils.scrollToElement(webDriver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[8]")));
                //BrowserUtils.hover(driver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[8]")));
                BrowserUtils.clickWithJS(webDriver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[8]")));
                //driver.findElement(By.xpath("(//label[contains(@for,'" + rangedFilter + "')])[8]")).click();
            }

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

            BrowserUtils.hover(cleanFilter);
            BrowserUtils.clickWithJS(cleanFilter);
            //cleanFilter.click();
        }
    }
    public void selectBreadcrumb(int number){
        BrowserUtils.waitFor(1);
        List<WebElement> breadcrumbElements = webDriver.findElements(By.cssSelector("ol.breadcrumb>li"));
        breadcrumbElements.get(number-1).click();
    }

    public void selectPopularBreadcrumb(int number){
        BrowserUtils.waitFor(1);
        List<WebElement> breadcrumbElements = webDriver.findElements(By.cssSelector("div.landing-bottom-text>div>a"));
        breadcrumbElements.get(number-1).click();
    }

    public void selectVendor(String vendor){
        BrowserUtils.waitForClickablility(rentNowButton.get(0),10);
        BrowserUtils.waitFor(1);

        for(WebElement element: vendorfilter){
            if(element.getText().contains(vendor)) element.click();
        }
    }

    public void selectRandomFilter(){
        int i=3;
        int size = selectedFilterTitleList.size();

        List<WebElement> element = webDriver.findElements(By.cssSelector("span.checkmark"));

            if(size>0){
                i=i+size;
            }
        element.get(i).click();
        BrowserUtils.waitFor(1);
    }

    public void changeLanguageMainPage(List<String> language) {

        BrowserUtils.waitForPageToLoad(3);
            for (String languageString : language) {
            WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + languageString + "'])[2]"));
                languageSelect.click();
                BrowserUtils.waitForVisibility(otherLanguage, 20);
                BrowserUtils.waitFor(1);
            try {
                element.click();

            } catch (Exception e) {
                languageSelect.click();
                element.click();
            }
                BrowserUtils.waitFor(1);

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

    public void changeLanguageCarDetailPage(List<String> language) {

        BrowserUtils.waitFor(1);
        for (String languageString : language) {
            WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + languageString + "'])[2]"));
            languageSelect.click();
            BrowserUtils.waitForClickablility(otherLanguage,5);
            BrowserUtils.waitFor(1);
            try {
                BrowserUtils.clickWithJS(element);
                //element.click();
            } catch (Exception e) {
                languageSelect.click();
                BrowserUtils.clickWithJS(element);
                //element.click();
            }
            BrowserUtils.waitFor(1);
            String timeText = webDriver.findElement(By.cssSelector("span.timer-warning-text1")).getText();
            String deliveryType= webDriver.findElement(By.cssSelector("span.ttitle")).getText();
            String continiousButton = webDriver.findElement(By.xpath("(//button[@type='button'])[2]")).getText();

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

    public void changeLanguageReservationSummaryPage(List<String> language) {

        BrowserUtils.waitFor(1);
        for (String languageString : language) {
            WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + languageString + "'])[2]"));
            languageSelect.click();
            BrowserUtils.waitForClickablility(otherLanguage,5);
            BrowserUtils.waitFor(1);
            try {
                BrowserUtils.clickWithJS(element);
                //element.click();
            } catch (Exception e) {
                languageSelect.click();
                BrowserUtils.clickWithJS(element);
                //element.click();
            }
            BrowserUtils.waitFor(1);
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

    public void changeLanguageAllCampaignPage(List<String> language) {

        BrowserUtils.waitFor(1);
        for (String languageString : language) {
            WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + languageString + "'])[2]"));
            languageSelect.click();
            BrowserUtils.waitForClickablility(otherLanguage,5);
            BrowserUtils.waitFor(1);
            try {
                BrowserUtils.clickWithJS(element);
                //element.click();
            } catch (Exception e) {
                languageSelect.click();
                BrowserUtils.clickWithJS(element);
                //element.click();
            }
            BrowserUtils.waitFor(1);
            String campaignGlobal = campaignsList.get(0).getText();
            String campaignTitle = webDriver.findElement(By.xpath("//h1")).getText();

            switch (languageString){
                case"TR":
                    Assert.assertEquals("ARAÇ KİRALAMA KAMPANYALARI",campaignTitle);
                    Assert.assertEquals("Kampanyayı İncele",campaignGlobal);
                    break;
                case"EN":
                    Assert.assertEquals("CAR RENTAL CAMPAIGNS",campaignTitle);
                    Assert.assertEquals("Details",campaignGlobal);
                    break;
                case"DE":
                    Assert.assertEquals("AUTOVERMIETUNG AKTIONEN",campaignTitle);
                    Assert.assertEquals("Einzelheiten",campaignGlobal);
                    break;
            }
        }
    }

    public void selectCampaign(int campaignNumber){
        int newCampaignNumber= campaignNumber-1;
        campaignsList.get(newCampaignNumber).click();
        BrowserUtils.waitFor(2);
    }

    public void changeLanguageCampaignDetailPage(List<String> language) {

        BrowserUtils.waitFor(1);
        for (String languageString : language) {
            WebElement element = webDriver.findElement(By.xpath("(//*[text()='" + languageString + "'])[2]"));
            languageSelect.click();
            BrowserUtils.waitForClickablility(otherLanguage,5);
            BrowserUtils.waitFor(1);
            try {
                BrowserUtils.clickWithJS(element);
                //element.click();
            } catch (Exception e) {
                languageSelect.click();
                BrowserUtils.clickWithJS(element);
                //element.click();
            }
            BrowserUtils.waitFor(1);
            String campaignButtonText = campaignApplyButton.getText();
            String campaignHeaderButtonText = campaigns.getText();
            String campaignDetail = webDriver.findElement(By.xpath("(//strong)[3]")).getText();
            System.out.println("campaignHeaderButtonText = " + campaignButtonText);
            System.out.println("campaignHeaderButtonText = " + campaignHeaderButtonText);
            System.out.println("campaignDetail = " + campaignDetail);

            switch (languageString){
                case"TR":
                    Assert.assertEquals("Kampanyalar",campaignHeaderButtonText);
                    Assert.assertEquals("Kampanyaya Katıl!",campaignButtonText);
                    Assert.assertEquals("Kampanyadan Nasıl Yararlanabilirsiniz?",campaignDetail);
                    break;
                case"EN":
                    Assert.assertEquals("Campaigns",campaignHeaderButtonText);
                    Assert.assertEquals("Activate Campaign!",campaignButtonText);
                    Assert.assertEquals("How Can You Benefit From The Campaign?",campaignDetail);
                    break;
                case"DE":
                    Assert.assertEquals("Aktionen",campaignHeaderButtonText);
                    Assert.assertEquals("Mach mit bei der Aktion!",campaignButtonText);
                    Assert.assertEquals("Wie können Sie von der Kampagne profitieren?",campaignDetail);
                    break;
            }
        }
    }

    public void selectVerifyFilterTitleDescription(List<String> filters){
        String defaultTittleText = webDriver.findElement(By.xpath("//title")).getAttribute("textContent");

        for (String filter : filters) {
            WebElement filterElement =webDriver.findElements(By.xpath("//*[@filtername='"+filter+"']")).get(0);
            filterElement.click();

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

            BrowserUtils.waitForVisibility(cleanFilter,5);
            BrowserUtils.hover(cleanFilter);
            BrowserUtils.waitFor(1);
            BrowserUtils.clickWithJS(cleanFilter);
            BrowserUtils.waitFor(2);
        }
    }

    public void selectORVendor(String vendor1, String vendor2){
        BrowserUtils.waitForClickablility(rentNowButton.get(0),10);
        BrowserUtils.waitFor(1);

        boolean flag = true;
        for(WebElement element: vendorfilter){
                if(element.getText().contains(vendor1)) {
                    if(flag){
                        element.click();
                        flag=false;
                    }
                }else if(element.getText().contains(vendor2)){
                    if(flag){
                        element.click();
                        flag=false;
                    }
                }
        }
    }

    public void socialMedia(){
        List<String> expected= Arrays.asList("facebook","twitter","instagram","linkedin","youtube","apple","play","huawei");
        for(int i=2; i<=9; i++){
            new MainPage().socialMediaLinks.get(i).click();
            String currentWindowHandle=webDriver.getWindowHandle();
            Set<String> windowHandles= webDriver.getWindowHandles();
            for(String handle : windowHandles){
                if(!handle.equals(currentWindowHandle)){
                    webDriver.switchTo().window(handle);
                    String currentURL=webDriver.getCurrentUrl();
                    Assert.assertTrue(currentURL.contains(expected.get(i-2)));
                    webDriver.close();
                    BrowserUtils.waitFor(2);
                    webDriver.switchTo().window(currentWindowHandle);
                }
            }
        }
    }



}
