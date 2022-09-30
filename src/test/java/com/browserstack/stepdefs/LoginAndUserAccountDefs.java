package com.browserstack.stepdefs;

import com.browserstack.pageobjects.LoginPage;
import com.browserstack.pageobjects.ReservationPage;
import com.browserstack.util.BrowserUtils;
import com.browserstack.util.ConfigurationReader;
import com.github.javafaker.Faker;
import com.browserstack.RunWebDriverCucumberTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginAndUserAccountDefs {

    Faker faker=new Faker();
    String name= faker.name().firstName();
    String surname= faker.name().lastName();
    String email=name+surname+"@qatest.com";
    public WebDriver webDriver;
    // String myEmail= ConfigurationReader.get("email"); @ hatası bitince bu çalıştırılıp action silinecek

    String myPassword= ConfigurationReader.get("password");
    String mainUrl=ConfigurationReader.get("url");
    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login dropdown")
    public void the_user_is_on_the_login_dropdown() {

        loginPage.loginDropdown.click();
    }

    @When("click the register and enter the personal information")
    public void click_the_register_and_enter_the_personal_information() {

        loginPage.registerInformation();
    }

    @Then("the user should be able to register")
    public void the_user_should_be_able_to_register(){
        BrowserUtils.waitForVisibility(loginPage.registerRequest,5);
        Assert.assertTrue(loginPage.registerRequest.isDisplayed());
        //Assert.assertTrue(loginPage.registerRequest.isDisplayed());
        BrowserUtils.waitForClickablility(loginPage.registerApprove,2);
        loginPage.registerApprove.click();
    }

    @When("the user enter valid credentials")
    public void the_user_enter_valid_credentials() {
        loginPage.login();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.verifyElementDisplayed(loginPage.logOutGlobalLocator);
    }

    @And("user click logout")
    public void user_click_logout() {
        loginPage.logOutGlobalLocator.click();
        BrowserUtils.waitFor(1);
    }

    @Then("the user should be able to logout")
    public void the_user_should_be_able_to_logout() {
        BrowserUtils.waitFor(1);
        String expectedUrl= mainUrl;
        String actualUrl= webDriver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @When("the registered user click forgot password button")
    public void the_registered_user_click_forgot_password_button() {
        loginPage.signIn.click();
        loginPage.forgotPassword.click();
        BrowserUtils.waitForVisibility(loginPage.forgotEmail,5);
    }

    @And("send e-mail")
    public void sendEMail() {
        String myEmail= ConfigurationReader.get("email");
        loginPage.forgotEmail.sendKeys(myEmail);
        //BrowserUtils.changeMail(loginPage.forgotEmail,myEmail);
    }

    @And("click forgot password button")
    public void clickForgotPasswordButton() {
        loginPage.forgotPassButton.click();
    }

    @Then("the user should be able to receive forgot password mail")
    public void the_user_should_be_able_to_receive_forgot_password_mail() {
        BrowserUtils.waitForVisibility(loginPage.resetPassMassage,5);
        Assert.assertTrue(loginPage.resetPassMassage.isDisplayed());
    }

    @Then("the user should be able to update account information")
    public void the_user_should_be_able_to_update_account_information() {
        String firstaddress=loginPage.userAddress.getText();

        loginPage.updateAccountInf();

        String lastaddress=loginPage.userAddress.getText();
        Assert.assertFalse(firstaddress.equals(lastaddress));

    }

   @Then("the user should save address information")
    public void the_user_should_save_address_information() {
        BrowserUtils.clickWithJS(loginPage.SaveButtonList.get(1));
        loginPage.SaveButtonList.get(1).click();
        BrowserUtils.waitFor(5);
        Assert.assertTrue(loginPage.adressUpdateAlertMassageList.size()>1);
        BrowserUtils.clickWithJS(loginPage.SaveButtonList.get(1));
        BrowserUtils.waitFor(5);
        Assert.assertTrue(loginPage.adressUpdateAlertMassageList.size()>1);
    }

    @Then("the user should click permission information")
    public void the_user_should_click_permission_information() {
        BrowserUtils.waitFor(2);
        loginPage.emailCheck.click();
    }

    @Then("the user should save permission save")
    public void the_user_should_save_permission_save() {
        loginPage.SaveButtonList.get(2).click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(loginPage.permissionAlert.isDisplayed());
    }


    @Then("past reservations should be shown")
    public void past_reservations_should_be_shown(){
        Assert.assertTrue(loginPage.pastResTitle.isDisplayed());
        Assert.assertTrue(webDriver.findElements(By.cssSelector("div.row.reservation")).size()>0);
    }



    @Then("the user should be able to change password")
    public void the_user_should_be_able_to_change_password() {
        loginPage.changePassword();
    }

    @And("enter the personal information")
    public void enterThePersonalInformation() {
        loginPage.registerInformation();
    }

    @And("click Membership agreement")
    public void clickMembershipAgreement() {
        loginPage.checkKvkk.click();
    }

    @When("click the register")
    public void clickTheRegister() {
        loginPage.register.click();
    }

    @And("click registerButton")
    public void clickRegisterButton() {
        loginPage.registerButton.click();
    }

    @And("enter the invalid {string} and {string} information")
    public void enterTheInvalidAndInformation(String email, String password) {
        loginPage.invalidManualRegister(email,password);
        BrowserUtils.waitFor(2);
    }

    @When("enter the {string} and {string} information")
    public void enter_the_and_information(String email, String password) {
        loginPage.validManualRegister(email,password);
        BrowserUtils.waitFor(1);
    }

    @When("enter the {string} and {string} information on Login Page")
    public void enter_the_and_information_on_Login_Page(String email, String password) {
        loginPage.validManualLogin(email,password);
        BrowserUtils.waitFor(1);
    }

    @Then("Register emailBox should be able to fix Turkish character")
    public void register_emailBox_should_be_able_to_fix_Turkish_character() {
        loginPage.checkTurkishChar();
    }

    @Then("Login emailBox should be able to fix Turkish character on Login Page")
    public void login_emailBox_should_be_able_to_fix_Turkish_character_on_Login_Page() {
        loginPage.checkTurkishCharonLoginPage();
    }

    @Then("Reservation emailBox should be able to fix Turkish character")
    public void reservation_emailBox_should_be_able_to_fix_Turkish_character() {
        loginPage.checkTurkishCharOnReservationSearch();
    }


    @Then("emailBox should be accept email address consist \\(-)")
    public void emailBox_should_be_accept_email_address_consist() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(loginPage.errorMessage.size()==0);
    }

    @Then("Driver Info Page emailBox should be accept email address consist \\(-)")
    public void driver_Info_Page_emailBox_should_be_accept_email_address_consist() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(loginPage.accountErrorMessage2.size()==0);
    }

    @Then("enter the {string} information on Driver information Page")
    public void enter_the_information_on_Driver_information_Page(String email) {
        loginPage.changeEmailDriverInfo(email);
        BrowserUtils.waitFor(1);
    }

    @Then("Register box should be able to fix Turkish character on Login Page")
    public void register_box_should_be_able_to_fix_Turkish_character_on_Login_Page() {
        loginPage.checkTurkishCharOnDriverInfo();
        BrowserUtils.waitFor(1);
    }


    @Then("the user should not able to register")
    public void theUserShouldNotAbleToRegister() {

        Assert.assertTrue(loginPage.registerRequest2.size()==0);
        //Assert.assertTrue(loginPage.kvkkerrorMassage.isDisplayed());
    }

    @When("click account button")
    public void clickAccountButton() {
        BrowserUtils.waitForVisibility(loginPage.singinIcon,5);
        loginPage.singinIcon.click();
        BrowserUtils.waitForVisibility(loginPage.firstName,10);
    }

    @And("user should see account page")
    public void userShouldSeeAccountPage() {

        BrowserUtils.waitFor(1);
        String expectedUrl= mainUrl+"account";
        String actualUrl= webDriver.getCurrentUrl();
        BrowserUtils.waitFor(1);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @And("click past reservations")
    public void clickPastReservations() {
        loginPage.pastReservations.click();
        BrowserUtils.waitForVisibility(loginPage.pastResTitle,5);
    }

    @And("click change password button")
    public void clickChangePasswordButton() {
        loginPage.changePass.click();
    }

    @Then("verify open {string} page")
    public void verifyOpenPage(String pageTitle) {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(loginPage.accountsSubTitle.getText().contains(pageTitle));
    }

    @Then("verify update message")
    public void verifyUpdateMessage() {
        Assert.assertTrue(loginPage.updateAlert.isDisplayed());
    }


    @When("Enters {string} and enters invalid {string}")
    public void entersAndEntersInvalid(String username, String password) {
        loginPage.invalidLogin(username,password);
    }

    @Then("Users should see {string} message")
    public void usersShouldSeeMessage(String errorMessage) {
        Assert.assertEquals(loginPage.errorMessage.get(0).getText(),errorMessage);
    }

    @And("Enter invalid {string}  and {string}")
    public void enterInvalidAnd(String password, String confirmationPassword) {
        loginPage.changeInvalidPassword(password,confirmationPassword);
    }

    @Then("Users should see {string}")
    public void usersShouldSee(String message) {
        Assert.assertEquals(loginPage.accountErrorMessage.getText(),message);
    }

    @When("user enters valid credentials with non-reservation")
    public void userEntersValidCredentialsWithNonReservation() {
        loginPage.nonReslogin();
    }

    @And("past reservations should be shown but result should be empty")
    public void pastReservationsShouldBeShownButResultShouldBeEmpty() {
        Assert.assertTrue(loginPage.pastResTitle.isDisplayed());
        BrowserUtils.verifyElementDisplayed(webDriver.findElement(By.cssSelector("div.empty-reservation")));
    }
    @Then("verify open main page")
    public void verifyOpenMainPage() {
        BrowserUtils.waitFor(2);
        String expectedUrl= mainUrl;
        String actualUrl= webDriver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @When("click the signin")
    public void click_the_signin() {
       loginPage.signIn.click();
       BrowserUtils.waitFor(1);
    }

    @When("the user enters {string} and {string} on Reservation Search")
    public void the_user_enters_and_on_Reservation_Search(String reservationNo, String email) {
        new ReservationPage().reservationSearchBox.sendKeys(reservationNo);
        new ReservationPage().mailReservSearchBox.sendKeys(email);
        BrowserUtils.waitFor(1);
        new ReservationPage().reservationSearchBox.click();
    }

}
