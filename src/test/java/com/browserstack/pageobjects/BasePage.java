package com.browserstack.pageobjects;

import com.browserstack.RunWebDriverCucumberTests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public abstract class BasePage{
    public WebDriver webDriver;

    @FindBy(xpath = "//div[@*='search-bar__search-btn']")
    public WebElement findButton;  // Reservation pageden geldi

    @FindBy(xpath = "//*[contains(@class,'time-picker__option')]")
    public List<WebElement> month; // Reservation pageden geldi

    @FindBy(xpath = "//div[@class='rental-type__monthly']")
    public WebElement monthlyRental;

    @FindBy(xpath = "//*[@*='monthly-info']")
    public WebElement monthlyInfoMassage;

    @FindBy(xpath = "//span[text()='Ay']")
    public WebElement monthPicker;

    @FindBy(className = "rental-type__daily")
    public WebElement dailyRental;

    @FindBy(xpath = "//span[text()='Bırakış Tarihi']" )
    public WebElement dropOffDate;

    //alış lokasyon box
     @FindBy(xpath = "//input[@data-input-type='pickup']")
    @CacheLookup
    public WebElement pickUpInput;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement pickUpInputLandingPage;

    //alış lokasyon box
    //@FindBy(css = ".pickUpAutoCompleteInput")
    //@CacheLookup
    //public WebElement pickUpInput;

    //@FindBy(xpath = "//input[@data-input-type='pickup']")
    //public WebElement pickUpInputInListPage;

    //farklı yerde bırak
    @FindBy(css = "span.checkmark")
    public WebElement diffDropOffCheck;

    //bırakış lokasyon box
    @FindBy(css = ".dropOffAutoCompleteInput")
    public WebElement dropOffInput;

    // alış lokasyonu menüsü
    @FindBy(css = "div.autocomplete__item-wrapper")
    public List<WebElement> pickUpMenu;

    // bırakış lokasyonu menüsü
    @FindBy(css = "div.autocomplete__item-wrapper")
    public List<WebElement> dropOffMenu;

    @FindBy(xpath = "//td[contains(@class,'CalendarDay__default_2')]")
    public List<WebElement> defaultCalendarDate;

    @FindBy(css = "span.time-picker__option.selected")
    public WebElement timeSelected;

    @FindBy(css = "div.header-call-center")
    public WebElement callCenter;

    @FindBy (xpath = "//p[text()='MİSAFİR MERKEZİ']")
    public WebElement guessCenter;

    @FindBy(xpath = "//p[text()='0850 360 5 360']")
    public WebElement centerPhone;

    @FindBy(xpath = "//*[@*='nav-link currency-selector dropdown-toggle']")
    public WebElement currencySelect;

    @FindBy(xpath = "//a/span/i[@*='icon icon-euro']")
    public WebElement euro;

    @FindBy(xpath = "//a/span/i[@*='icon icon-try']")
    public WebElement tlira;

    @FindBy(xpath = "//a/span/i[@*='icon icon-dollar']")
    public WebElement dolar;

    @FindBy(xpath = "//a/span/i[@*='icon icon-pound']")
    public WebElement pound;

    @FindBy(css = "a.nav-link.language-selector.dropdown-toggle")
    public WebElement languageSelect;

    @FindBy(css = "a.nav-link.country-selector.dropdown-toggle")
    public WebElement countrySelect;

    @FindBy(xpath = "//*[@class='nav-link language-selector dropdown-toggle']")
    public WebElement currentLanguage;

    @FindBy(css = "div.home-slider__title")
    public WebElement mainTitle;

//    @FindBy(xpath = "//*[@*='icon-notification-search']")
//    public WebElement recentSearch;

    @FindBy(css = "div.dropdown.web-notifications")
    public WebElement recentSearch;

    @FindBy(xpath = "//*[@*='nav-item dropdown search-res']/a/i")
    public WebElement findReservation;

    @FindBy(xpath = "//*[@*='reservation-lookup-d-menu reservation-modal align-middle']")
    public WebElement findResMenu;

    @FindBy(xpath = "//*[@*='nav-item dropdown search-res campaign']/a/div")
    public WebElement campaigns;

    @FindBy(css = "a.allCampaignsItem__button>span")
    public List<WebElement> allCampaigns;

    @FindBy(css = "div.popular-locations")
    public WebElement popularLocationsTable;

    @FindBy(xpath = "//h1")
    public WebElement pageTitle;

    @FindBy(xpath = "//*[@rel='nofollow']")
    public List<WebElement> socialMediaLinks;





    public BasePage() {
        PageFactory.initElements(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver(), this);

    }


}
