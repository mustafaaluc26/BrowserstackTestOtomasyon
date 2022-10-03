package com.browserstack.util;

import com.browserstack.RunWebDriverCucumberTests;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;


public class BrowserUtils {

    public static WebDriver webDriver;
    /**
     * Moves the mouse to given element
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions= new Actions(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver());
        actions.moveToElement(element).perform();
    }



    /**
     * Performs a pause
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for provided element to be clickable
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * Waits for element matching the locator to be clickable
     */
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    /**
     * waits for backgrounds processes on the browser to complete
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }


    /**
     * Clicks on an element using JavaScript
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver()).executeScript("arguments[0].click();", element);
    }


    /**
     * Scrolls down to an element using JavaScript
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToSize(int start, int finish) {
        JavascriptExecutor js = (JavascriptExecutor) RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver();
        js.executeScript("window.scrollBy("+start+","+finish+")");
        BrowserUtils.waitFor(1);
    }



    /**
     * Performs double click action on an element
     */
    public static void doubleClick(WebElement element) {
        new Actions(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver()).doubleClick(element).build().perform();
    }

    public static void changeMail(WebElement element, String mail) {
        String[] myEmail= mail.split("@");

        Actions actions = new Actions(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver());
        element.sendKeys(myEmail[0]);

        actions.keyDown(Keys.ALT).sendKeys("q").keyUp(Keys.ALT).sendKeys(myEmail[1]).perform();
    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }

    public static void clickCoordinate(int x, int y){
        BrowserUtils.waitFor(1);
        Actions actions = new Actions(RunWebDriverCucumberTests.getManagedWebDriver().getWebDriver());
      //  actions.moveByOffset(x,y).perform();
        actions.moveByOffset(x,y).click().perform();
        BrowserUtils.waitFor(1);
    }




}