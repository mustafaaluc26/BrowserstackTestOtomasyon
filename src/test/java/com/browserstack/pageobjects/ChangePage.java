package com.browserstack.pageobjects;

import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.util.BrowserUtils;
import com.browserstack.util.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ChangePage extends BasePage {

    ReservationPage reservationPage=new ReservationPage();


    @FindBy(xpath = "//input[@*='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@*='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@*='submit']")
    public WebElement login;

    @FindBy(xpath = "//a[contains(text(),'Rental orders')]")
    public WebElement rentalOrders;

    @FindBy(xpath = "//*[@*='price-field__cta-btn']")
    public List<WebElement> rentNowButton;

    @FindBy(xpath = "//*[contains(@for,'vendor')]")
    public List<WebElement> vendorfilter;

    @FindBy(xpath = "(//*[@*='icon-arrows-up-down-icon'])[2]")
    public WebElement sort;

    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    public WebElement faturaLoc;

   // WebDriver driver= Driver.get();
   WebDriver webDriver= RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();

   public void changeRes(){

        webDriver.findElement(By.id("change-order")).click();

        BrowserUtils.waitForVisibility(By.className("search-bar__search-btn"),10);

        webDriver.findElement(By.xpath("(//*[@*='icon-calendar2-icon'])[1]")).click();
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(defaultCalendarDate.get(7));
        //new ReservationPage().defaultCalendarDate.get(7).click();
        timeSelected.click();
        BrowserUtils.clickWithJS(defaultCalendarDate.get(1));
        //new ReservationPage().defaultCalendarDate.get(1).click();
        BrowserUtils.waitFor(1);
        timeSelected.click();
        BrowserUtils.waitFor(1);
        new MainPage().findButton.click(); // rezerv page deki loc maine taşındı

        BrowserUtils.waitForVisibility(rentNowButton.get(1),10);

        if (webDriver.findElement(By.xpath("//*[@id='vendor-Yolcutest']")).isEnabled()){

            BrowserUtils.waitFor(1);
            webDriver.findElement(By.xpath("//*[@id='vendor-Yolcutest']")).click();

            BrowserUtils.waitForClickablility(rentNowButton.get(1),10);

           //sort.click();
            BrowserUtils.waitFor(1);
            //BrowserUtils.clickWithJS(sort);    // sort a tıklıyor ama bir sıralama yaptırmıyor!!!!!
            //BrowserUtils.clickWithJS(driver.findElements(By.className("dropdown-item")).get(19));
            //BrowserUtils.waitFor(1);

            rentNowButton.get(1).click();

        } else {
            for (int j = 1; j <= 4; j++) {//conf.properties vendor güncellenirse burasıda güncellenmeli

                String vendor= ConfigurationReader.get("vendor"+j);

                for (int k = 2; k < vendorfilter.size(); k++) {

                    if (vendorfilter.get(k).getText().equals(vendor)){

                        sort.click();

                        vendorfilter.get(k).click();
                    }
                }
            }

            BrowserUtils.waitForClickablility(rentNowButton.get(1),5);
            rentNowButton.get(1).click();
        }

        webDriver.findElement(By.xpath("//button[contains(@class,'rent-now')]")).click();

        BrowserUtils.waitForVisibility(webDriver.findElement(By.id("input_name")),10);

        webDriver.findElement(By.id("payment_verifiedKvkk_checkbox")).click();
        BrowserUtils.waitFor(1);
        new MobilePage().registerCheckBox.click();
        BrowserUtils.waitFor(2);
        //BrowserUtils.waitForClickablility(Driver.get().findElement(By.id("input_zip")),5);
        BrowserUtils.waitFor(2);
        Select select=new Select(faturaLoc);
        select.selectByIndex(0);
        webDriver.findElement(By.id("input_zip")).sendKeys("1");
        BrowserUtils.waitFor(2);
        webDriver.findElement(By.id("input_zip")).sendKeys(Keys.BACK_SPACE);

        webDriver.findElement(By.xpath("//button[@class='btn btn-outline-secondary rent-now']")).click();

        BrowserUtils.waitForVisibility(By.id("input_cardOwnerName"),10);
        webDriver.findElement(By.id("input_cardOwnerName")).sendKeys("QA test");

        webDriver.findElement(By.id("payment_verifiedAge_checkbox")).click();
        webDriver.findElement(By.id("payment_verifiedTerms_checkbox")).click();
       // Driver.get().findElement(By.xpath("//button[@class='btn btn-outline-secondary rent-now']")).click();
        BrowserUtils.clickWithJS(webDriver.findElement(By.xpath("//button[@class='btn btn-outline-secondary rent-now']")));
         BrowserUtils.waitFor(7);

        BrowserUtils.waitForVisibility(webDriver.findElement(By.className("reservation-no")),40);

    }

    public void goestoAtlantis() {

        webDriver.navigate().to("https://"+ConfigurationReader.get("environmentType")+".yolcu360.com/atlantis/login/?next=/atlantis/");
        //driver.navigate().to("https://beta.yolcu360.com/atlantis/login/?next=/atlantis/");

        // changePage.username.sendKeys(ConfigurationReader.get("atlantisUser"));
        String atlantisUserMail = ConfigurationReader.get("atlantisUser");
        username.sendKeys(atlantisUserMail);
        //BrowserUtils.changeMail(username,atlantisUserMail);

        password.sendKeys(ConfigurationReader.get("atlantisPass"));
        login.click();
        rentalOrders.click();
        BrowserUtils.waitForClickablility(webDriver.findElement(By.xpath("//a[@*='?cancelled__exact=0']")),5);

        BrowserUtils.clickWithJS(webDriver.findElement(By.xpath("//a[@*='?cancelled__exact=0']")));
        //driver.findElement(By.xpath("//a[@*='?cancelled__exact=0']")).click();
        webDriver.findElement(By.xpath("//input[@*='searchbar']")).sendKeys(ConfigurationReader.get("email"));
       // BrowserUtils.changeMail(driver.findElement(By.xpath("//input[@*='searchbar']")),ConfigurationReader.get("email"));
        BrowserUtils.clickWithJS(webDriver.findElement(By.xpath("(//*[@*='submit'])[1]")));
        //driver.findElement(By.xpath("(//*[@*='submit'])[1]")).click();

        BrowserUtils.waitForVisibility(By.xpath("(//*[@*='field-reservation_id']/a)[1]"),5);
        webDriver.findElement(By.xpath("(//*[@*='field-reservation_id']/a)[1]")).click();
        BrowserUtils.waitForVisibility(By.xpath("(//*[@*='readonly'])[1]"),10);
    }

    public void reservationDetail() {

        String firstResNo= webDriver.findElement(By.xpath("(//*[@*='readonly'])[1]")).getText();

        changeRes();

        BrowserUtils.waitForVisibility(webDriver.findElement(By.className("icon-button-arrow-left")),10);
        webDriver.findElement(By.className("icon-button-arrow-left")).click();

        BrowserUtils.waitForVisibility(By.xpath("(//a[@*='?cancelled__exact=1'])[1]"),5);
        webDriver.findElement(By.xpath("(//a[@*='?cancelled__exact=1'])[1]")).click();

        webDriver.findElement(By.xpath("//input[@*='searchbar']")).sendKeys(ConfigurationReader.get("email"));
        webDriver.findElement(By.xpath("(//*[@*='submit'])[1]")).click();

        BrowserUtils.waitFor(2);
        BrowserUtils.waitForVisibility(By.xpath("(//*[@*='field-reservation_id']/a)[1]"),10);
        String lastResNo= webDriver.findElement(By.xpath("(//*[@*='field-reservation_id']/a)[1]")).getText();

        System.out.println("firstResNo = " + firstResNo);
        System.out.println("lastResNo = " + lastResNo);
        Assert.assertEquals(firstResNo,lastResNo);
    }

    public void shouldBeChange() {
        webDriver.findElement(By.xpath("(//*[@title='No'])[1]")).click();

        BrowserUtils.waitForVisibility(By.xpath("(//*[@*='field-reservation_id']/a)[1]"),15);
        webDriver.findElement(By.xpath("(//*[@*='field-reservation_id']/a)[1]")).click();

        BrowserUtils.waitForVisibility(By.xpath("//*[contains(@href,'/atlantis/payment/payment/')]"),15);
        webDriver.findElement(By.xpath("//*[contains(@href,'/atlantis/payment/payment/')]")).click();

        BrowserUtils.waitForVisibility(By.xpath("//*[@*='form-row field-get_charged_amount']/div/div"),15);

        double chargedAmount= Double.parseDouble((webDriver.findElement(By.xpath("//*[@*='form-row field-get_charged_amount']/div/div")).getText().substring(4)));
        double refundedAmount= Double.parseDouble(webDriver.findElement(By.xpath("//*[@*='form-row field-get_refunded_amount']/div/div")).getText().substring(4));
        double remainingAmount= Double.parseDouble(webDriver.findElement(By.xpath("//*[@*='form-row field-get_remaining_amount']/div/div")).getText().substring(4));

        Assert.assertTrue(chargedAmount==refundedAmount+remainingAmount);

    }
}
