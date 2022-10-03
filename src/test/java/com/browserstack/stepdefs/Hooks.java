package com.browserstack.stepdefs;

import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.pageobjects.LoginPage;
import com.browserstack.util.BrowserUtils;
import com.browserstack.util.ConfigurationReader;
import com.browserstack.util.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks {
    WebDriver driver=RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();

    @Before
    public void setUp() {
        driver = RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoginPage loginPage = new LoginPage();
        driver.manage().window().maximize();
        driver.get("https://staging.yolcu360.com/");

        BrowserUtils.waitForPageToLoad(30);

        try {
            if (loginPage.cookieXButton.isDisplayed()) {
                BrowserUtils.waitForClickablility(loginPage.cookieXButton, 10);
                loginPage.cookieXButton.click();
            }
        }catch (Exception e){

        }

    }



    @After
    public void teardown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            Utility.setSessionStatus(driver, "failed", String.format("%s failed.", scenario.getName()));
        } else {
            Utility.setSessionStatus(driver, "passed", String.format("%s passed.", scenario.getName()));
        }
        Thread.sleep(2000);
        driver.quit();
    }

    @Before("@abc")
    public void setUpdb(){
        System.out.println("\tconnecting to database...");
    }

    @After("@abc")
    public void closeDb(){
        System.out.println("\tdisconnecting to database...");

    }


}
