package com.yahya.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {

    public static void waitFor(int seconds) {

        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will check for visibility of element within the time given
     *
     * @param locator    By.id or By.xpath or By. Whatever
     * @param timeToWait in time to wait
     * @return true if the element is found within the time and given, false if not
     */
    public static boolean checkVisibilityOfElement(By locator, int timeToWait) {

        boolean result = false;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWait));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_status")));
        } catch (TimeoutException e) {
            System.out.println("The error message is " + e.getMessage());
        }

        return true;
    }

    /**
     * A utility method to get the texts out of list of web elements
     * @param lstOfWebElements the target list of weblement
     * @return the text inside those web element as List<String>
     */
    public static List<String> getAllText(List<WebElement> lstOfWebElements ){

        List<String> allTextLst = new ArrayList<>();
        for (WebElement eachElement : lstOfWebElements) {
            allTextLst.add(  eachElement.getText()  );
        }

        return  allTextLst ;

    }
}