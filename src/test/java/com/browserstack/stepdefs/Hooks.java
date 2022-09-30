package com.browserstack.stepdefs;

import com.browserstack.RunWebDriverCucumberTests;
import com.browserstack.pageobjects.LoginPage;
import com.browserstack.util.BrowserUtils;
import com.browserstack.util.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public WebDriver webDriver;
    @Before
    public void setUp() {

        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage();

        String browser= ConfigurationReader.get("browser");

        switch (browser) {
            case "chrome-headless" :
                webDriver.manage().window().setSize(new Dimension(1440, 900));
                break;
            //case "chrome", "firefox", "safari", "edge","browserstack" :
            default:
                webDriver.manage().window().maximize();
        }

        webDriver.get(ConfigurationReader.get("url"));

        BrowserUtils.waitForPageToLoad(30);
try {
    if (loginPage.cookieXButton.isDisplayed()) {
        BrowserUtils.waitForClickablility(loginPage.cookieXButton, 10);
        loginPage.cookieXButton.click();
    }
}catch (Exception e){

}
        BrowserUtils.scrollToSize(0,-500);
    }

    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        webDriver.quit(); // burayı ayrıca kontrol et
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
