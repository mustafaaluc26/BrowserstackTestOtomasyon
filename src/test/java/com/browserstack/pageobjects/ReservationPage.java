package com.browserstack.pageobjects;


import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.util.BrowserUtils;
import com.browserstack.util.ConfigurationPostmanReader;
import com.browserstack.util.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ReservationPage extends MainPage{



    @FindBy(xpath = "//*[@*='price-field__cta-btn']")
    public List<WebElement> rentNowButton;

    @FindBy(xpath = "//*[contains(@for,'vendor')]")
    public List<WebElement> vendorfilter;

    @FindBy(xpath = "//*[@class='reservation-success__title--first']")
    public WebElement reservationMessage;

    @FindBy(xpath = "//*[@class='reservation-success__title--second']")
    public WebElement reservationMessage2;

    @FindBy(css = "span.reservation-no__item")
    public List<WebElement> reservationNumber;

    @FindBy(css = "span.checkbox-label")
    public WebElement driverKvkkTextLocator;

    @FindBy(xpath = "//div[@*='search-results']")
    public WebElement reservationTableTitle;

    @FindBy(xpath = "((//div[@class='title'])/h1/span)[1]")
    public WebElement reservationCityLocator;

    @FindBy(xpath = "(//*[@*='picker-item__label'])[1]")
    public WebElement startDate;

    @FindBy(xpath = "(//*[@*='picker-item__label'])[2]")
    public WebElement finishDate;

    @FindBy(xpath = "(//*[@class='date-value focused'])[1]")
    public WebElement startDateSelected;

    @FindBy(xpath = "(//*[@class='date-value focused'])[2]")
    public WebElement finishDateSelected;

    @FindBy(xpath = "(//*[@class='icon-calendar2-icon'])[1]")
    public WebElement pickUpIcon;

    @FindBy(xpath = "(//*[@class='icon-calendar2-icon'])[2]")
    public WebElement dropUpIcon;

    @FindBy(xpath = "//td[contains(@class,'CalendarDay__today')]")
    public WebElement todayInCalender;

    @FindBy(xpath = "//td[contains(@class,'CalendarDay__selected')]")
    public List <WebElement> calenderDaySelected;

    @FindBy(xpath = "//*[@class='month-value focused']")
    public WebElement calenderMonthSelected;

    @FindBy(xpath = "//*[@for='vendor-Yolcutest']")
    public WebElement yolcuTestVendor;

    @FindBy(id = "input_name")
    public WebElement nameBox;

    @FindBy(id = "input_surname")
    public WebElement surnameBox;

    @FindBy(id = "input_phoneNumber")
    public WebElement phoneNumberBox;

    @FindBy(id = "input_email")
    public WebElement mailBox;

    @FindBy(id = "input_birthday")
    public WebElement birthdayBox;

    @FindBy(id = "input_identityNumber")
    public WebElement identityNumberBox;

    @FindBy(xpath = "(//*[@class='checkmark'])[1]")
    public WebElement kvkkCheckBox;

    @FindBy(xpath = "(//*[@class='checkmark'])[2]")
    public WebElement registerCheckBox;

    @FindBy(xpath = "(//*[@class='checkmark'])[3]")
    public WebElement orderNotificationLoc;

    @FindBy(xpath = "(//*[@class='checkmark'])[4]")
    public WebElement orderNotificationPostaLoc;

    @FindBy(xpath = "(//*[@class='checkmark'])[5]")
    public WebElement orderNotificationSmsLoc;

    @FindBy(css = "#input_city")
    public WebElement cityBox;

    @FindBy(css = "#input_zip")
    public WebElement zipBox;

    @FindBy(css = "#input_taxDivision")
    public WebElement taxNameLoc;

    @FindBy(css = "#input_personDetailsIdentityNumber")
    public WebElement passaportNoLoc;

    @FindBy(xpath = "//button[contains(@class,'rent-now')]")
    public WebElement continuousRentButton;

    @FindBy(xpath = "//button[@class='btn btn-outline-secondary rent-now']")
    public WebElement payButton;// son iki devam et (payment)adımı da içeriyor

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

    @FindBy(css = "#payment_verifiedAge_checkbox")
    public WebElement verifiedAgeCheckbox;

    @FindBy(css = "#payment_verifiedTerms_checkbox")
    public WebElement verifiedTermsCheckbox;

    @FindBy(css = "input#smsCode")
    public WebElement smsCodeBox;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement newSmsCodeBox;

    @FindBy(css = "button#submitBtn")
    public WebElement smsSubmitButton;

    @FindBy(css = "#submitbutton")
    public WebElement newSmsSubmitButton;

    @FindBy(xpath = "//span[@*='checkmark']")
    public List <WebElement> allCheckbox;

    @FindBy(xpath = "(//input[@class='form-control'])[4]")
    public WebElement reservationSearchBox;

    @FindBy(xpath = "(//input[@class='form-control'])[5]")
    public WebElement mailReservSearchBox;

    @FindBy(css = "i.icon-btn-arrow-right")
    public WebElement ReservationSearchButton;

    @FindBy(xpath = "(//*[@class='reservation-no']/span/span)[2]")
    public WebElement searchReservationNoLocator;

    @FindBy(xpath = "((//*[@class='customer-info']/ul/li)[3]/span)[3]")
    public WebElement searchReservationMailLocator;

    @FindBy(css = "div.input-group.search-input-1")
    public WebElement inputLocator;

    @FindBy(css = "#search-dropOffLocation")
    public WebElement differentLocatorCheck;

    @FindBy(xpath = "//*[@*='Nerede Bırakacaksınız?']")
    public WebElement differentLocatorBox;

    @FindBy(css = "div.dropoff-location-wrapper")
    public WebElement differentLocatorBoxDisplay;

    @FindBy(xpath = "(//span[@data-container='body'])[3]//b")
    public WebElement differentPriceLoc;

    @FindBy(xpath = "//div[@class='prices__office-price__extra-product']//b")
    public WebElement differentPriceLoc2;

    @FindBy(xpath = "(//*[@*='icon-pin'])[3]")
    public WebElement secondLocatorFirstPlace;

    @FindBy(css = "i.icon-handglass-icon")
    public WebElement secondSearchButton;

    @FindBy(css = "span.timer-warning-time")
    public WebElement warningTime;

    @FindBy(css = "span.search-item__title--first")
    public List <WebElement> allCarsBrand;

    @FindBy(css = "span.price-field__labels__daily-price")
    public List <WebElement> allCarsDailyPrice;

    @FindBy(css = "span.price-field__labels__price2")
    public List <WebElement> allCarsTotalPrice;

    @FindBy(css = "i.icon-gear-icon")
    public List <WebElement> allCarsGearType;

    @FindBy(css = "i.icon-fuel-icon")
    public List <WebElement> allCarsFuelType;

    @FindBy(css = "i.icon-car")
    public List <WebElement> allCarsType;

    @FindBy(css = "provision-type-label")
    public WebElement provisionTypeTitle;

    @FindBy(css = "span.scroll-to-top-button__icon")
    public WebElement scrollUp;

    @FindBy(xpath = "(//*[@*='btn dropdown-toggle'])[2]")
    public WebElement sortLocator;

    @FindBy(xpath = "//*[@*='teslim']/span/b")
    public WebElement deliveryType;

    @FindBy(xpath = "//*[@*='dropdown-menu show']/a")
    public List <WebElement> allSortList;

    @FindBy(xpath = "(//*[@*='price']/p)[2]")
    public WebElement detailPagePriceLoc;

    @FindBy(xpath = "(//*[@*='prices__total-price--total']/span)[2]")
    public WebElement detailPagePriceLoc2;

    @FindBy(xpath = "(//*[@*='price']/p)[3]")
    public WebElement dailyPriceLoc;

    @FindBy(xpath = "(//*[@*='prices__card-price']/span)[2]")
    public WebElement cardPriceLoc;

    @FindBy(xpath = "(//*[@*='prices__office-price__total']/span)[2]")
    public WebElement officePriceLoc;

    @FindBy(xpath = "//p[@class='date']/span")
    public List <WebElement> dateLoc;

    @FindBy(xpath = "//div[@*='search-bar__search-btn']")
    public WebElement findButton;  // Reservation pageden geldi

    @FindBy(css = "label.switch")
    public List <WebElement> extraProductsSingle;

    @FindBy(css = "div.plus")
    public List <WebElement> extraProductsMultiPlus;

    @FindBy(css = "span.payment__total__first--right")
    public WebElement resSummaryTotalPriceLocator;

    @FindBy(xpath = "//div[@class='payment__office__first']/span[2]")
    public WebElement resSummaryOfficePriceLocator;

    @FindBy(xpath = "//div[@class='payment__card common']/span[2]")
    public WebElement resSummaryCardPriceLocator;

    @FindBy(css = "i.icon-close-icon")
    public WebElement cancelXButton;

    @FindBy(xpath = "//div[@class='empty-screen']/p")
    public List<WebElement> emptyMessageLoc;

    @FindBy(xpath = "//div[@class='empty-recommend']/p")
    public List<WebElement> recommendMessageLoc;

    @FindBy(css = "div.gif-bg")
    public WebElement waitCarAnimation;

    @FindBy(xpath = "((//*[@id='page-content-container']/div)[1]/div)[2]//span")
    public WebElement backButton;

    @FindBy(xpath = "(//*[@class='picker-item__label'])[1]")
    public WebElement pickupDateonListpage;

    @FindBy(css = ".input-group-addon.check")
    public List<WebElement> greenCheckLoc;

    @FindBy(css = "span.scroll-to-top-button__text")
    public WebElement upTopButton;

    @FindBy(css = "#proceed-button")
    public List<WebElement> sendAnyWay;

    WebDriver webDriver= RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();

    public ReservationPage(){
        PageFactory.initElements(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver(), this);
    }

    String teslim = "";
    String price = "";
    double priceD=0.0;
    String officePriceText ="";
    String cardPriceText = "";
    String totalPriceText = "";
    double officePrice=0.00;
    double cardPrice=0.00;
    double totalPrice=0.00;

    String resSummaryTotalPriceText = "";
    String resSummaryCardPriceText = "";
    String resSummaryOfficePriceText = "";

    String activePayment="";
    Properties props = new Properties();


    public void sortPrice(String str){
        BrowserUtils.waitForClickablility(sortLocator,10);
        BrowserUtils.waitFor(1);
        if(webDriver.findElements(By.cssSelector("i.icon-close-circle-icon")).size()>0){
            webDriver.findElement(By.cssSelector("i.icon-close-circle-icon")).click();
        }
        BrowserUtils.waitFor(1);

        BrowserUtils.clickWithJS(sortLocator);
        // sortLocator.click();

        WebElement sortType = webDriver.findElement(By.xpath("(//*[text()='" + str + "'])[2]"));
        try {
            BrowserUtils.waitForClickablility(sortType,3);

        }catch (Exception e){
            BrowserUtils.clickWithJS(sortLocator);
            BrowserUtils.waitFor(1);
            BrowserUtils.clickWithJS(sortLocator);
        }

        BrowserUtils.clickWithJS(sortType);
        // sortType.click();

        int totalSize = allCarsTotalPrice.size();
        String first = allCarsTotalPrice.get(0).getText();
        String last = allCarsTotalPrice.get(totalSize - 1).getText();

        if(first.contains(".")){
            first=first.replace(".","");
        }
        if(last.contains(".")){
            last= last.replace(".","");
        }

        double top = Double.parseDouble(first.replace(",", "."));
        double bottom = Double.parseDouble(last.replace(",", "."));
        BrowserUtils.waitFor(1);

        switch (str){
            case "En Düşük Fiyat":
                Assert.assertTrue(top<bottom);
                break;
            case "En Yüksek Fiyat":
                Assert.assertTrue(top>bottom);
                break;

        }
    }
    public void sortAll(){
        List<String> actual= Arrays.asList("Önerilen","En Düşük Fiyat","En Yüksek Fiyat","En Yüksek Puan","En Çok Değerlendirilen");
        for (int i = 0; i < 5; i++) {
            BrowserUtils.waitFor(1);
            new CampaignsLocationsPage().sort.click();

            String sortType= allSortList.get(i).getText();
            Assert.assertTrue(sortType.equals(actual.get(i)));
            allSortList.get(i).click();
            BrowserUtils.waitForVisibility(new ReservationPage().allCarsTotalPrice.get(0),10);

            String listType= webDriver.findElement(By.xpath("(//*[@*='list-type'])[2]")).getText();
            Assert.assertTrue(sortType.contains(listType.trim()));

            int totalSize = allCarsTotalPrice.size();
            String first = allCarsTotalPrice.get(0).getText();
            String last = allCarsTotalPrice.get(totalSize - 1).getText();

            double price1= Double.parseDouble(first.replace(".","").replace(",","."));
            double price2= Double.parseDouble(last.replace(".","").replace(",","."));

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
        BrowserUtils.waitFor(1);
    }

    public void sortAllforURL(){
        List<String> actual= Arrays.asList("sort_by=recommended","sort_by=lowest_price_first","sort_by=highest_price_first","sort_by=highest_rating","sort_by=most_reviewed");
        for (int i = 0; i < 5; i++) {
            BrowserUtils.waitFor(2);
            new CampaignsLocationsPage().sort.click();

            allSortList.get(i).click();
            BrowserUtils.waitForVisibility(new ReservationPage().allCarsTotalPrice.get(0),10);
            String url=webDriver.getCurrentUrl();
            Assert.assertTrue(url.contains(actual.get(i)));
        }
    }

    public void locationSearch(String location){

        pickUpInput.sendKeys(location);
        if(!pickUpMenu.get(0).isEnabled()){
            pickUpInput.sendKeys(location);
        }
        BrowserUtils.waitForVisibility(pickUpMenu.get(0),20);
        //BrowserUtils.waitFor(3);
        pickUpMenu.get(0).click();
        BrowserUtils.waitFor(1);

    }

    public void differentSearchLocation(String location2){
        if(rentNowButton.size()>0){
            BrowserUtils.waitForClickablility(rentNowButton.get(1),20);
            Assert.assertTrue(inputLocator.isDisplayed());
            BrowserUtils.clickWithJS(differentLocatorCheck);
        }

        // differentLocatorCheck.click();
        differentLocatorBox.sendKeys(location2);

        BrowserUtils.waitForVisibility(secondLocatorFirstPlace,10);
        secondLocatorFirstPlace.click();
        BrowserUtils.waitFor(1);
        pickUpIcon.click();
    }

    public void monthlyEnterDay(){

        //pickUpMenu.get(0).click();
        BrowserUtils.waitFor(1);
        defaultCalendarDate.get(15).click();
        timeSelected.click();
        month.get(2);
        BrowserUtils.waitFor(1);
    }

    public void selectVendor_Car() {
        BrowserUtils.waitForClickablility(rentNowButton.get(0),10);
        boolean select= false;
        for (int j = 1; j <= 5; j++) {

            String vendor = ConfigurationReader.get("vendor" + j);
            for (int k = vendorfilter.size() - 1; k >= 2; k--) {
                if (vendorfilter.get(k).getText().contains(vendor)) {
                    BrowserUtils.waitFor(1);
                    vendorfilter.get(k).click();
                    select =true;
                }
            }
            if(select==true) break;

        }

        BrowserUtils.waitForClickablility(rentNowButton.get(1),5);
        BrowserUtils.waitFor(1);
        teslim = deliveryType.getText();
        price = allCarsTotalPrice.get(1).getText();

        rentNowButton.get(1).click();
    }

    public void selectVendor_CarforReview(String vendor) {
        BrowserUtils.waitForClickablility(rentNowButton.get(0),10);

        for(WebElement element: vendorfilter){
            try {
                if(element.getText().contains(vendor)) {
                    element.click();
                }
            } catch (Exception e) {
                element.click();
            }
        }

        BrowserUtils.waitForClickablility(rentNowButton.get(0),15);
        BrowserUtils.waitFor(2);
        teslim = deliveryType.getText();
        price = allCarsTotalPrice.get(0).getText();
        System.out.println("price = " + price);
        BrowserUtils.clickWithJS(rentNowButton.get(0));

    }

    public void verifyPriceOfficeType(){
        BrowserUtils.waitForClickablility(continuousRentButton,10);

        Assert.assertEquals(detailPagePriceLoc.getText(),price);// bir üstteki method da gelmeli yoksa null alır
        BrowserUtils.waitFor(2);

        Assert.assertEquals(webDriver.findElement(By.xpath("//*[@*='value']/b")).getText(),teslim);
    }



    public void enterReservationInformation(){
        BrowserUtils.waitForVisibility(nameBox,10);
        BrowserUtils.waitFor(1);



        // if(mailBox.getText().isEmpty()) {
        //mailBox.sendKeys(Keys.COMMAND + "a");
        //mailBox.sendKeys(Keys.BACK_SPACE);
        //mailBox.clear();
        // }

        birthdayBox.clear();
        birthdayBox.sendKeys(ConfigurationReader.get("birthday"));
        BrowserUtils.waitFor(1);


        if(allCheckbox.size()>1){

            nameBox.sendKeys(Keys.COMMAND+"a");
            nameBox.sendKeys(Keys.BACK_SPACE);
            BrowserUtils.waitFor(1);
            nameBox.sendKeys("test");
            BrowserUtils.waitFor(1);
            surnameBox.sendKeys(Keys.COMMAND+"a");
            surnameBox.sendKeys(Keys.BACK_SPACE);
            BrowserUtils.waitFor(1);
            surnameBox.sendKeys("test");
            phoneNumberBox.sendKeys(Keys.COMMAND+"a");
            phoneNumberBox.sendKeys(Keys.BACK_SPACE);
            phoneNumberBox.sendKeys("5410000000");

            identityNumberBox.sendKeys(Keys.COMMAND+"a");
            identityNumberBox.sendKeys(Keys.BACK_SPACE);
            identityNumberBox.clear();
            BrowserUtils.waitFor(1);
            identityNumberBox.sendKeys(ConfigurationReader.get("tckn"));
            BrowserUtils.waitFor(1);

            String email = ConfigurationReader.get("email");
            mailBox.sendKeys(email);

            System.out.println("allCheckbox.size() = " + allCheckbox.size());
            registerCheckBox.click();

            cityBox.sendKeys(Keys.COMMAND+"a");
            cityBox.sendKeys(Keys.BACK_SPACE);
            cityBox.sendKeys("Istanbul");

            zipBox.sendKeys(Keys.COMMAND+"a");
            zipBox.sendKeys(Keys.BACK_SPACE);
            zipBox.sendKeys("34500");
            new LoginPage().userAddress.sendKeys(Keys.COMMAND+"a");
            new LoginPage().userAddress.sendKeys(Keys.BACK_SPACE);
            new LoginPage().userAddress.sendKeys("İSTANBUL TÜRKİYE");
        }

        kvkkCheckBox.click();


    }

    public void paymentCard() {
        BrowserUtils.waitFor(2);

   //     System.out.println("activePayment = " + activePayment);

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
        BrowserUtils.waitFor(5);
        if (!verifiedTermsCheckbox.isSelected()) {
            BrowserUtils.clickWithJS(verifiedTermsCheckbox);
            //verifiedTermsCheckbox.click();
            BrowserUtils.waitFor(1);
            verifiedAgeCheckbox.click();
        }
    }

    public void invalidPaymentCard() {

        cardNumberBox.sendKeys("1111111111111111");
        cardNameBox.sendKeys("QA test");

        Select select1 = new Select(cardDay);
        cardDay.click();
        select1.selectByValue(ConfigurationReader.get("creditCardMonth"));

        Select select2 = new Select(cardMonth);
        cardMonth.click();
        select2.selectByValue(ConfigurationReader.get("creditCardYear"));

        cardCvc.sendKeys(ConfigurationReader.get("creditCardCVV"));
        BrowserUtils.waitFor(5);
        if (!verifiedTermsCheckbox.isSelected()) {
            BrowserUtils.clickWithJS(verifiedTermsCheckbox);
            //verifiedTermsCheckbox.click();
            BrowserUtils.waitFor(1);
            verifiedAgeCheckbox.click();
        }

    }

    public void invalidPaymentCardDate() {


        if (ConfigurationPostmanReader.get("ActivePayment").equals("MSU")){
            cardNumberBox.sendKeys(ConfigurationReader.get("MsuCreditCardNumber"));
        }else{
            cardNumberBox.sendKeys(ConfigurationReader.get("IyzicoCreditCardNumber"));
        }
        cardNameBox.sendKeys("QA test");

        Select select1 = new Select(cardDay);
        cardDay.click();
        select1.selectByValue("01");

        Select select2 = new Select(cardMonth);
        cardMonth.click();
        select2.selectByValue("22");

        cardCvc.sendKeys(ConfigurationReader.get("creditCardCVV"));
        BrowserUtils.waitFor(5);
        if (!verifiedTermsCheckbox.isSelected()) {
            BrowserUtils.clickWithJS(verifiedTermsCheckbox);
            //verifiedTermsCheckbox.click();
            BrowserUtils.waitFor(1);
            verifiedAgeCheckbox.click();
        }

    }

    public void sendSms(){
       // BrowserUtils.waitFor(5);
       // System.out.println("activePayment = " + activePayment);
        String activePaymentnewConf = ConfigurationPostmanReader.get("ActivePayment");
        System.out.println("activePaymentnewConf **NEW** = " + activePaymentnewConf);
        if(activePaymentnewConf.equals("IYZICO")){
            BrowserUtils.waitForVisibility(smsCodeBox,25);
        }else{
            BrowserUtils.waitForVisibility(newSmsCodeBox,25);
        }

        if(price.contains(".")){
            price=price.replace(".","");
        }
        price= price.replace(",",".");

        priceD = Double.parseDouble(price);
        System.out.println("price1 = " + priceD);


        if (ConfigurationPostmanReader.get("ActivePayment").equals("IYZICO")){
            smsCodeBox.sendKeys("283126");
            smsSubmitButton.click();
        }else{
            newSmsCodeBox.sendKeys("a");
            newSmsSubmitButton.click();
        }
            BrowserUtils.waitFor(4);

        if(sendAnyWay.size()==2){
            BrowserUtils.waitFor(1);
            BrowserUtils.clickWithJS(sendAnyWay.get(1));
            BrowserUtils.waitFor(1);
        }

    }

    public void verifyReservation(){
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForVisibility(reservationMessage,25);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(reservationMessage.isDisplayed());
        //İstanbul - Sabiha Gökçen Havalimanı rezervasyonunuz onaylandı!
        BrowserUtils.waitFor(1);
        Assert.assertTrue(reservationMessage2.isDisplayed());
        //Rezervasyon bilgileriniz e-mail ve sms olarak size gönderildi.
        BrowserUtils.waitFor(1);
    }

    public void defaultDailySearch(){
        BrowserUtils.waitFor(5);
        BrowserUtils.waitForVisibility(pickUpIcon,10);
        pickUpIcon.click();
        BrowserUtils.waitFor(2);
        String pickUp= startDateSelected.getText();
        String dropUp= finishDateSelected.getText();

        int today=0;
        //BrowserUtils.waitForVisibility(todayInCalender,5);
        BrowserUtils.waitFor(2);
        if (todayInCalender.isDisplayed()){
            today= Integer.parseInt(todayInCalender.getText());
            System.out.println("today = " + today);
        }
        int pickUpDate= Integer.parseInt(pickUp.substring(0,2));
        int dropOffDate= Integer.parseInt(dropUp.substring(0,2));
        int pickUpMontDate= Integer.parseInt(pickUp.substring(3,5));
        int dropOffMontDate= Integer.parseInt(dropUp.substring(3,5));
        int selectedDates= calenderDaySelected.size();
        BrowserUtils.waitFor(2);
        Assert.assertEquals(selectedDates,4);

        if(pickUpMontDate==dropOffMontDate){
            if(today+1==pickUpDate){
                if (pickUpDate>today){Assert.assertEquals(pickUpDate, today + 1);}
                if (dropOffDate>today){Assert.assertEquals(dropOffDate, today + 4);}
            }
            Assert.assertTrue(pickUpDate+3==dropOffDate);
        }else{
            int pickUpSelected= Integer.parseInt(calenderDaySelected.get(0).getText());

            webDriver.findElement(By.xpath("//*[@*='date-picker__nav-next']/i")).click();
                BrowserUtils.waitFor(1);

            int dropOffSelected= Integer.parseInt(calenderDaySelected.get(3).getText());

            Assert.assertTrue(dropOffMontDate>pickUpMontDate);
            Assert.assertTrue(pickUpSelected==pickUpDate);
            Assert.assertTrue(dropOffSelected==dropOffDate);
        }
    }

    public void defaultMonthlySearch() {
        BrowserUtils.waitFor(2);
        pickUpIcon.click();
        String pickUp = startDateSelected.getText();

        int pickUpDate= Integer.parseInt(pickUp.substring(0,2));

        int today=0;
        BrowserUtils.waitFor(2);
        if (todayInCalender.isDisplayed()){
            today= Integer.parseInt(todayInCalender.getText());
        }

        if (pickUpDate>today){Assert.assertEquals(pickUpDate, today + 1);}

        dropUpIcon.click();
        BrowserUtils.waitFor(1);
        int defaultMonth= Integer.parseInt(calenderMonthSelected.getText().substring(0,1));
        Assert.assertEquals(2, defaultMonth);
    }

    public void verifyReservationDetail(String reservationNo,String email){
        BrowserUtils.waitFor(1);

        Assert.assertTrue(searchReservationNoLocator.isDisplayed());

        String actualResNo= searchReservationNoLocator.getText();
        BrowserUtils.scrollToSize(0,900);
        String actualEmail=searchReservationMailLocator.getText();

        Assert.assertEquals(reservationNo, actualResNo);
        Assert.assertEquals(email, actualEmail);
    }

    public void verifyVehicleListingPage() {
        //kampanyalar üzerinden arama yaptığında kullan

       // BrowserUtils.verifyElementDisplayed(reservationTableTitle);
        Assert.assertTrue(differentLocatorBoxDisplay.isEnabled());
        Assert.assertTrue(rentNowButton.get(0).isDisplayed());

        Assert.assertTrue(startDate.isEnabled());
        //check the drop-off date input box
        Assert.assertTrue(finishDate.isEnabled());
       // BrowserUtils.verifyElementDisplayed(rentNowButton.get(0));
    }

    public void selectDate(){
        // BrowserUtils.clickWithJS(defaultCalendarDate.get(3));
        defaultCalendarDate.get(3).click();
        //BrowserUtils.clickWithJS(timeSelected);
        timeSelected.click();
        //BrowserUtils.clickWithJS(defaultCalendarDate.get(1));
        defaultCalendarDate.get(6).click();
        //BrowserUtils.clickWithJS(timeSelected);
        timeSelected.click();
        //BrowserUtils.waitFor(1);

    }
    public void checkFunctionDetailPage(){
        BrowserUtils.waitForVisibility(detailPagePriceLoc,10);
        String totalPrice= detailPagePriceLoc.getText();
        System.out.println("totalPrice = " + totalPrice);
        // int price1= Integer.parseInt(totalPrice.substring(0,totalPrice.lastIndexOf(",")));

        //double price2 = 0;
        String newPrice= detailPagePriceLoc2.getText();
        //int lastPrice = Integer.parseInt(newPrice.substring(0,newPrice.lastIndexOf(',')));

        if(totalPrice.contains(".")){
            totalPrice=totalPrice.replace(".","");
        }
        if(newPrice.contains(".")){
            newPrice= newPrice.replace(".","");
        }

        double price1 = Double.parseDouble(totalPrice.replace(",", "."));
        double lastPrice = Double.parseDouble(newPrice.replace(",", "."));

        System.out.println("price1 = " + price1);
        System.out.println("lastPrice = " + lastPrice);

        Assert.assertTrue(price1-lastPrice==0);
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='car-property__car-img']")).isDisplayed());//car image

    }

    public void carNameAndPrice(){
        String price1= detailPagePriceLoc.getText();
        String price2= detailPagePriceLoc2.getText();
        Assert.assertEquals(price1,price2);
        BrowserUtils.waitFor(3);
        Assert.assertTrue(webDriver.findElement(By.xpath("(//*[@*='icon icon-try'])[8]")).isDisplayed());

        String carName1= webDriver.findElement(By.xpath("(//span[@itemprop='name'])[4]")).getText();
        String carname2= webDriver.findElement(By.xpath("//span[@*='car-property__car-name']")).getText();
        Assert.assertEquals(carName1,carname2);
        Assert.assertEquals("veya benzeri", webDriver.findElement(By.xpath("//span[@*='car-property__subheading']")).getText());
    }

    public void rentalCondition(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='rental-conditions__title']")).isDisplayed());
        Assert.assertEquals("Kiralama Şartları", webDriver.findElement(By.xpath("//*[@*='rental-conditions__title']")).getText());
        Assert.assertTrue(webDriver.findElement(By.cssSelector(".rental-conditions__link__title")).isEnabled());// kiralama sözleşmesi için tıklayın tıklanabilir olmalı
    }

    public void driverRequirement(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='rental-requirements__title']")).isDisplayed());
        Assert.assertEquals("Sürücü Gereksinimleri", webDriver.findElement(By.xpath("//*[@*='rental-requirements__title']")).getText());
    }

    public void review(){
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@*='review-container__main-title']/span")).isDisplayed());
        Assert.assertEquals("Değerlendirmeler", webDriver.findElement(By.xpath("//*[@*='review-container__main-title']/span")).getText());
    }

    public void confirmationDetailPages(){

        BrowserUtils.waitForClickablility(continuousRentButton,20);

        String firstPrice1= detailPagePriceLoc.getText();
        String dailyPrice1= dailyPriceLoc.getText();
        String cardPrice1= cardPriceLoc.getText();
        String officePrice1= officePriceLoc.getText();
        String totalPrice1= detailPagePriceLoc2.getText();
        BrowserUtils.waitFor(2);
        String pickupDate1= dateLoc.get(0).getText();
        String pickupTime1= dateLoc.get(1).getText();
        String dropOffDate1= dateLoc.get(2).getText();
        String dropOffTime1= dateLoc.get(3).getText();
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(continuousRentButton);
        BrowserUtils.waitForVisibility(continuousRentButton,30);
        BrowserUtils.waitFor(2);
        String firstPrice2= detailPagePriceLoc.getText();
        String dailyPrice2= dailyPriceLoc.getText();
        String cardPrice2=cardPriceLoc.getText();
        String officePrice2= officePriceLoc.getText();
        String totalPrice2= detailPagePriceLoc2.getText();
        BrowserUtils.waitFor(2);
        String pickupDate2=dateLoc.get(0).getText();
        String pickupTime2= dateLoc.get(1).getText();
        String dropOffDate2= dateLoc.get(2).getText();
        String dropOffTime2= dateLoc.get(3).getText();

        Assert.assertEquals(firstPrice1,firstPrice2);
        Assert.assertEquals(dailyPrice1,dailyPrice2);
        Assert.assertEquals(cardPrice1,cardPrice2);
        Assert.assertEquals(officePrice1,officePrice2);
        Assert.assertEquals(totalPrice1,totalPrice2);
        Assert.assertEquals(pickupDate1,pickupDate2);
        Assert.assertEquals(pickupTime1,pickupTime2);
        Assert.assertEquals(dropOffDate1,dropOffDate2);
        Assert.assertEquals(dropOffTime1,dropOffTime2);
    }

    public void verifyTaxInformation() {
        BrowserUtils.waitFor(1);
        Select invoice = new Select(webDriver.findElement(By.xpath("(//select[@*='form-control'])[2]")));
        invoice.selectByValue("person");
        Assert.assertTrue(taxNameLoc.isEnabled());

        BrowserUtils.waitFor(1);
        invoice.selectByValue("customer");

        Assert.assertTrue(zipBox.isEnabled());

        BrowserUtils.waitFor(1);
        invoice.selectByValue("company");
        Assert.assertTrue(taxNameLoc.isEnabled());

        BrowserUtils.waitFor(1);
        invoice.selectByValue("abroad");
        Assert.assertTrue(passaportNoLoc.isEnabled());
    }

    public void checkDriverInformation() {
        Assert.assertTrue(nameBox.isEnabled());
        Assert.assertTrue(surnameBox.isEnabled());
        Assert.assertTrue(phoneNumberBox.isEnabled());
        Assert.assertTrue(mailBox.isEnabled());
        Assert.assertTrue(birthdayBox.isEnabled());
        Assert.assertTrue(identityNumberBox.isEnabled());

        for (WebElement element : allCheckbox) {
            Assert.assertTrue(element.isEnabled());
        }
        Assert.assertTrue(cityBox.isEnabled());
        Assert.assertTrue(zipBox.isEnabled());
        Assert.assertTrue(new LoginPage().userAddress.isEnabled());
    }

    public void verifyDriverInformation(){

        List<String> expectedInfo = Arrays.asList("test","test","12/12/1945","qa2@yolcu360.com","(+90) 5410000000","12345678901"
                ,"test","test","İSTANBUL TÜRKİYE");

        for(int i=1; i<10; i++){
            //System.out.println("span[@*='val'])["+i+"]\")).getText() = " + Driver.get().findElement(By.xpath("(//span[@*='val'])[" + i + "]")).getText());
            //System.out.println("expectedInfo.get(i-1) = " + expectedInfo.get(i - 1));
            Assert.assertEquals(webDriver.findElement(By.xpath("(//span[@*='val'])["+i+"]")).getText(),expectedInfo.get(i-1));
        }

        try {
            Assert.assertTrue(continuousRentButton.isEnabled());
        }catch (Exception e){
            new MobilePage().forwardArrow.click();
        }


    }

    public void addExtraProductsAssurances(){
        officePriceText =officePriceLoc.getText();
        Assert.assertTrue(officePriceText.contains("0,00"));

        BrowserUtils.waitFor(2);
        extraProductsMultiPlus.get(0).click();
        //BrowserUtils.clickWithJS(extraProductsSingle.get(0));
    }

    public void verifyPrice(){
        cardPriceText = cardPriceLoc.getText();
        totalPriceText = detailPagePriceLoc2.getText();
        officePriceText =officePriceLoc.getText();

        Assert.assertTrue(detailPagePriceLoc.getText().equals(totalPriceText));
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
        System.out.println("officePrice = " + officePrice);
        System.out.println("cardPrice = " + cardPrice);
        System.out.println("totalPrice = " + totalPrice);
        Assert.assertTrue((officePrice+cardPrice)==totalPrice);
    }

    public void verifyPriceAfterPayment(){
        BrowserUtils.waitFor(1);

        if(webDriver.findElements(By.cssSelector("span.payment__total__first--right")).size()==0){
            BrowserUtils.scrollToElement(resSummaryTotalPriceLocator);
        }
        resSummaryTotalPriceText = resSummaryTotalPriceLocator.getText();
        resSummaryCardPriceText = resSummaryCardPriceLocator.getText();


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
            resSummaryOfficePriceText = resSummaryOfficePriceLocator.getText();
            if(resSummaryOfficePriceText.contains(".")){
                resSummaryOfficePriceText = resSummaryOfficePriceText.replace(".","");
            }
            resSummaryOfficePrice=Double.parseDouble(resSummaryOfficePriceText.replace(",","."));

            Assert.assertTrue(resSummaryOfficePrice+0==officePrice);
            Assert.assertTrue( resSummaryOfficePrice+resSummaryCardPrice==resSummaryTotalPrice);
        }

        BrowserUtils.waitFor(1);

        Assert.assertTrue( resSummaryOfficePrice+resSummaryCardPrice==resSummaryTotalPrice);
        Assert.assertTrue(resSummaryCardPrice+0==cardPrice);
        Assert.assertTrue(resSummaryTotalPrice+0==totalPrice);

    }

    public void selectSpecificCar(String rowNumber){
        BrowserUtils.waitForClickablility(rentNowButton.get(0),8);
        int i = Integer.parseInt(rowNumber);
        rentNowButton.get(i-1).click();
        BrowserUtils.waitFor(2);
    }
    public void enterInformationWithoutCheckBox(String userType){
        BrowserUtils.waitForVisibility(nameBox,10);
        BrowserUtils.waitFor(1);
        if(userType.equals("invalid")){
            nameBox.sendKeys("testdeneme");
            BrowserUtils.waitFor(2);
            kvkkCheckBox.click();
            //registerCheckBox.click();
        }else{
            nameBox.sendKeys("test");
        }

        birthdayBox.sendKeys(ConfigurationReader.get("birthday"));
        BrowserUtils.waitFor(1);

        surnameBox.sendKeys("test");
        phoneNumberBox.sendKeys("5410000000");
        identityNumberBox.sendKeys(ConfigurationReader.get("tckn"));
        BrowserUtils.waitFor(1);
        String email = ConfigurationReader.get("email");
        mailBox.sendKeys(email);
        cityBox.sendKeys("Istanbul");
        zipBox.sendKeys("34500");
        new LoginPage().userAddress.sendKeys("İSTANBUL TÜRKİYE");
    }

    public void selectForwardDate(){

        BrowserUtils.waitFor(2);

        if(webDriver.findElements(By.xpath("//*[@*='date-picker__nav-next']/i")).size()==0){
            webDriver.findElement(By.cssSelector("span.picker-item__label")).click();
        }

        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(webDriver.findElement(By.xpath("//*[@*='date-picker__nav-next']/i")));
        BrowserUtils.waitFor(2);

        BrowserUtils.clickWithJS(defaultCalendarDate.get(5));
        BrowserUtils.clickWithJS(timeSelected);
        BrowserUtils.clickWithJS(defaultCalendarDate.get(6));
        BrowserUtils.clickWithJS(timeSelected);
        BrowserUtils.waitFor(1);

    }
    public void differentSearchLocationMainPage(String location2){
        differentLocatorBox.sendKeys(location2);
        BrowserUtils.hover(differentLocatorBox);
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForVisibility(secondLocatorFirstPlace,10);
        secondLocatorFirstPlace.click();
        BrowserUtils.waitFor(1);

    }

    public void selectPickUpDate(){
        BrowserUtils.clickWithJS(defaultCalendarDate.get(3));
        //defaultCalendarDate.get(3).click();
        BrowserUtils.clickWithJS(timeSelected);
        //timeSelected.click();
        BrowserUtils.waitFor(1);
        BrowserUtils.hover(mainTitle);
        mainTitle.click();

    }

    public void hoverToElement(String string) {
        BrowserUtils.waitFor(2);
        WebElement element=webDriver.findElement(By.xpath("(//*[text()='"+string+"'])[1]"));
        BrowserUtils.hover(element);
        BrowserUtils.waitFor(2);
    }


    public static String paymentType(){//This method required for send sms step and reservation
        String stagingToken="eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiJhN2YwMGY2NS0yZGRmLTQ0NzctYjA4Mi1mMTY1NDQ4ZGYwYzkiLCJlbWFpbCI6ImFwaUB5b2xjdTM2MC5jb20iLCJpc3MiOiJ5b2xjdTM2MCIsImV4cCI6MTY4NTk2NDM2MSwiaWF0IjoxNjU0ODYwMzYxLCJqdGkiOiIzODI1OTY1Zi0xOGIwLTRjOGMtYWQzZC1mNjEyMzk1YjFjODYifQ.f5mxsOUkOKf-AS8fsqLIV9AHT56fTnu5_RY2JyT2CLcap3SogwODSaLis3jiSpMKUyapOJXPnPm0RRQcYWWb4w";
        String prodToken="eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiJhN2YwMGY2NS0yZGRmLTQ0NzctYjA4Mi1mMTY1NDQ4ZGYwYzkiLCJlbWFpbCI6ImFwaUB5b2xjdTM2MC5jb20iLCJpc3MiOiJ5b2xjdTM2MCIsImV4cCI6MTY4NTk2NDQ1NSwiaWF0IjoxNjU0ODYwNDU1LCJqdGkiOiIxZDYzMzgwOS1lZTViLTRiYmUtOGJhYi0zOTExMTBiYmM0YTIifQ.rGd3x2vDejZz6-I7YXo0Ph--iV9bzMTcPQslZM_2cpCSB6cEMibVNk0J17oV3r2t8t4IOj43P6U4HSOqSYfYiw";
        RestAssured.baseURI="https://api.360y.co/api/v1/payment-api";
        Response response=RestAssured.given().headers("Authorization",
                        "Bearer " + stagingToken,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().post("/active");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(),200);
        JsonPath jsonPath=response.jsonPath();
        String activePayment=jsonPath.getString("active");
        System.out.println("activePayment = " + activePayment);
        return activePayment;
    }

    public void sendStringProperties(){

        try {
            String path = "postman.properties";
            FileWriter writer =new FileWriter(path);//write kullanıyor

            props.put("ActivePayment",paymentType());
//            props.setProperty("ActivePayment", "www.codejava.net");//yazdı
//            props.replace("ActivePayment", paymentType());//replace etti

            props.store(writer, "**POSTMAN**");
            writer.close();

            System.out.println("ConfigurationReader *****ActivePayment**** " + props.getProperty("ActivePayment"));
        } catch (FileNotFoundException ex) {
            // file does not exist
        } catch (IOException ex) {
            // I/O error
        }
    }

    public void checkDocumentation(String text){
        ArrayList<String> tabs2 = new ArrayList<String> (webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs2.get(1));
        BrowserUtils.waitFor(1);

        System.out.println("dış");
        String texts ="";
        List<WebElement> elements = webDriver.findElements(By.xpath("//h6/span"));
        for (WebElement element : elements) {
            texts = texts+element.getText();
        }
        Assert.assertTrue(texts.contains(text));
    }




}