package com.browserstack.pageobjects;

import com.browserstack.util.BrowserUtils;
import com.browserstack.util.ConfigurationReader;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class LoginPage extends BasePage{

    Faker faker=new Faker();
    String expectedEmail="";
    String actualEmail="";
    public WebDriver webDriver;

    public LoginPage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//span[@class='menu-title']")
    public WebElement loginDropdown;

    @FindBy(xpath = "//a[@class='dropdown-item register']")
    public WebElement register;

    @FindBy(id = "name")
    public WebElement nameBox;

    @FindBy(id = "surname")
    public WebElement surnameBox;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "passwordVerified")
    public WebElement passwordVerifiedBox;

    @FindBy(xpath = "//label[@*='register-kvkk-checkbox']/span[2]")
    public WebElement checkKvkk;

    @FindBy(xpath = "//div[@class='input-group']")
    public WebElement registerButton;

    @FindBy(xpath = "//div[@class='register-request']")
    public WebElement registerRequest;

    @FindBy(xpath = "//div[@class='register-request']")
    public List<WebElement> registerRequest2;

    @FindBy(xpath = "//div[@class='approve-btn']")
    public WebElement registerApprove;

    @FindBy(xpath = "//a[@class='dropdown-item sign-in']")
    public WebElement signIn;

    @FindBy(xpath = "//div[@class='input-group email   ']/input")
    public WebElement emailLogin;

    @FindBy(xpath = "//div[@class='input-group password   ']/input")
    public WebElement passwordLogin;

    @FindBy(xpath = "//button[@class='btn login-btn form-control']")
    public WebElement loginButton;

    @FindBy(xpath = "//i[@class='icon icon-sign-in-icon']")
    public WebElement singinIcon;

    @FindBy(xpath = "//div[@class='username-wrapper']/a[2]")
    public WebElement logOut;

    @FindBy(xpath = "(//*[@class='sign-out-link'])[2]")
    public WebElement logOutGlobalLocator;

    @FindBy(xpath = "//div[@class='input-group forgot-password']/a")
    public WebElement forgotPassword;

    @FindBy(xpath = "//input[@*='basic-addon1']")
    public WebElement forgotEmail;

    @FindBy(xpath = "//button[@*='submit']")
    public WebElement forgotPassButton;

    @FindBy(xpath = "//*[@*='error-modal']/p")
    public WebElement resetPassMassage;

    @FindBy(id = "input_name")
    public WebElement firstName;

    @FindBy(xpath = "//span[@class='form-alert']")
    public WebElement updateAlert;

    @FindBy(id = "input_address")
    public WebElement userAddress;

    @FindBy(id = "input_phoneNumber")
    public WebElement phoneNumber;

    @FindBy(css = "div.save-btn")
    public List <WebElement> SaveButtonList;

    @FindBy(id = "account-kvkk-checkbox-email")
    public WebElement emailCheck;

    @FindBy(xpath = "//div[@class='permission-form']/div/div/div/span")
    public WebElement permissionAlert;

    @FindBy(css = "span.form-alert")
    public List <WebElement> adressUpdateAlertMassageList;

    @FindBy(xpath = "//div[text()='Geçmiş Rezervasyonlarım']")
    public WebElement pastReservations;

    @FindBy(xpath = "//p[text()='Geçmiş Rezervasyonlarım']")
    public WebElement pastResTitle;

    @FindBy(xpath = "//div[text()='Şifre Değiştirme']")
    public WebElement changePass;

    @FindBy(id = "input_password")
    public WebElement inputPass;

    @FindBy(id = "input_newPassword")
    public WebElement inputNewPass;

    @FindBy(id = "input_newPasswordVerify")
    public WebElement inputNewPassVerify;

    @FindBy(css = "span.error-label")
    public List <WebElement> errorMessage;

    @FindBy(css = "i.icon-error")
    public WebElement kvkkerrorMassage;

    @FindBy(css = "span.header__title")
    public WebElement registerTitle;

    @FindBy(css = "p.title")
    public WebElement accountsSubTitle;

    @FindBy(xpath = "//*[@*='cookie-policy__close-icon']")
    public WebElement cookieXButton;

    @FindBy(css = "span.errorMessage")
    public WebElement accountErrorMessage;

    @FindBy(css = "span.errorMessage")
    public List<WebElement> accountErrorMessage2;


    public void login() {
        String myEmail= ConfigurationReader.get("email");
        String myPassword=ConfigurationReader.get("password");

        if(!signIn.isDisplayed()) {
            loginDropdown.click();
        }
        BrowserUtils.waitForClickablility(signIn,8);
        signIn.click();
        BrowserUtils.waitForClickablility(loginButton,8);

        BrowserUtils.waitFor(1);
        emailLogin.sendKeys(myEmail);
        //BrowserUtils.changeMail(emailLogin,myEmail);
        BrowserUtils.waitFor(1);
        passwordLogin.sendKeys(myPassword);
        BrowserUtils.waitFor(1);
        loginButton.click();
        BrowserUtils.waitFor(1);
    }

    public void registerInformation(){

        String name= faker.name().firstName();
        String surname= faker.name().lastName();
        String email=name+surname+"@qatest.com";
        String myPassword="Yolcu360";

        nameBox.sendKeys(name);
        surnameBox.sendKeys(surname);
        emailBox.sendKeys(email);
        //BrowserUtils.changeMail(emailBox,email);
        passwordBox.sendKeys(myPassword);
        passwordVerifiedBox.sendKeys(myPassword);
    }

    public void invalidManualRegister(String email, String password){
        String name= faker.name().firstName();
        String surname= faker.name().lastName();

        nameBox.sendKeys(name);
        surnameBox.sendKeys(surname);
        emailBox.sendKeys(email);
        //BrowserUtils.changeMail(emailBox,email);
        passwordBox.sendKeys(password);
        passwordVerifiedBox.sendKeys(password);

    }

    public void validManualRegister(String email, String password){
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        passwordVerifiedBox.sendKeys(password);

    }

    public void validManualLogin(String email, String password){
        emailLogin.sendKeys(email);
        passwordLogin.sendKeys(password);
    }

    public void changeEmailDriverInfo(String email){
        new ReservationPage().mailBox.sendKeys(Keys.COMMAND+"a");
        new ReservationPage().mailBox.sendKeys(Keys.BACK_SPACE);
        new ReservationPage().mailBox.clear();
        new ReservationPage().mailBox.sendKeys(email);

    }

    public void checkTurkishChar(){
        expectedEmail="cgui@as-d.com";
        actualEmail=emailBox.getAttribute("value");
        BrowserUtils.waitFor(1);
        Assert.assertTrue(expectedEmail.equals(actualEmail));
        //Assert.assertTrue(expectedEmail.equals(actualEmail));
    }

    public void checkTurkishCharonLoginPage(){
        expectedEmail="cgui@as-d.com";
        actualEmail=emailLogin.getAttribute("value");
        BrowserUtils.waitFor(1);
        Assert.assertTrue(expectedEmail.equals(actualEmail));
    }

    public void checkTurkishCharOnDriverInfo(){
        expectedEmail="cgui@as-d.com";
        actualEmail=new ReservationPage().mailBox.getAttribute("value");
        BrowserUtils.waitFor(1);
        Assert.assertTrue(expectedEmail.equals(actualEmail));
        firstName.click();
    }

    public void checkTurkishCharOnReservationSearch(){
        expectedEmail="cgui@as-d.com";
        actualEmail=new ReservationPage().mailReservSearchBox.getAttribute("value");
        BrowserUtils.waitFor(1);
        Assert.assertTrue(expectedEmail.equals(actualEmail));
    }


    public void updateAccountInf(){

        firstName.sendKeys("");
        BrowserUtils.waitFor(1);

        new ReservationPage().surnameBox.sendKeys("");
        BrowserUtils.waitFor(1);
        SaveButtonList.get(0).click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(adressUpdateAlertMassageList.size()>0);

        Assert.assertTrue(updateAlert.isDisplayed());

        BrowserUtils.scrollToSize(0,500);

        BrowserUtils.waitFor(1);
        phoneNumber.sendKeys("");

        userAddress.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        BrowserUtils.waitFor(1);
        userAddress.sendKeys(Keys.BACK_SPACE);
        BrowserUtils.waitFor(1);

        String newAddress= faker.address().fullAddress();
        userAddress.sendKeys(newAddress);
        BrowserUtils.waitFor(2);

    }

    public void changePassword(){
        String oldPass= ConfigurationReader.get("password");
        String newPass= ConfigurationReader.get("password");

        inputPass.sendKeys(oldPass);
        BrowserUtils.waitFor(1);
        inputNewPass.sendKeys(newPass);
        inputNewPassVerify.sendKeys(newPass);
        SaveButtonList.get(0).click();
    }

    public void invalidLogin(String email, String password){
        if(!signIn.isDisplayed()) {
            loginDropdown.click();
        }
        BrowserUtils.waitForClickablility(signIn,3);
        signIn.click();
        BrowserUtils.waitForClickablility(loginButton,5);

        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(loginButton,5);
        BrowserUtils.waitFor(1);
        emailLogin.sendKeys(email);
        passwordLogin.sendKeys(password);

        loginButton.click();
        BrowserUtils.waitFor(1);

    }

    public void changeInvalidPassword(String password, String confirmationPassword){

        inputPass.sendKeys("Yolcu360");
        BrowserUtils.waitFor(1);
        inputNewPass.sendKeys(password);
        inputNewPassVerify.sendKeys(confirmationPassword);
        BrowserUtils.waitForClickablility(SaveButtonList.get(0),3);
        BrowserUtils.clickWithJS(SaveButtonList.get(0));
        BrowserUtils.waitFor(1);
    }

    public void nonReslogin() {
        String myEmail= ConfigurationReader.get("atlantisUser");
        String myPassword=ConfigurationReader.get("atlantisPass");

        if(!signIn.isDisplayed()) {
            loginDropdown.click();
        }
        BrowserUtils.waitForClickablility(signIn,3);
        signIn.click();
        BrowserUtils.waitForClickablility(loginButton,5);

        BrowserUtils.waitFor(1);
        emailLogin.sendKeys(myEmail);
        //BrowserUtils.changeMail(emailLogin,myEmail);
        passwordLogin.sendKeys(myPassword);

        loginButton.click();
    }



}
