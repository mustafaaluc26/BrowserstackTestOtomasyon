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
        BrowserUtils.waitFor(1);
        driver.manage().window().maximize();
        BrowserUtils.waitFor(1);
        driver.get(ConfigurationReader.get("url"));
        BrowserUtils.waitForPageToLoad(30);

        try {
            if (loginPage.cookieXButton.isDisplayed()) {
                BrowserUtils.waitForClickablility(loginPage.cookieXButton, 20);
                loginPage.cookieXButton.click();
            }
        }catch (Exception e){

        }

    }



    @After
    public void teardown(Scenario scenario){
        if (scenario.isFailed()) {
            System.out.println("kaldı");
            Utility.setSessionStatus(driver, "failed", String.format("%s failed.", scenario.getName()));
        } else {
            System.out.println("geçti");
            Utility.setSessionStatus(driver, "passed", String.format("%s passed.", scenario.getName()));
        }
        BrowserUtils.waitFor(2);
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
