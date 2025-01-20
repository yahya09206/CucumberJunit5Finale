package com.yahya.steps;

import com.yahya.utility.BrowserUtil;
import com.yahya.utility.ConfigReader;
import com.yahya.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpartanUISteps {

//    HomePage homePage = new HomePage() ;

    @Given("user navigate to home page")
    public void userNavigateToHomePage() {
        // open the browser --  set up the hook

        // navigate to the homepage


//        homePage.goTo() ;
        Driver.getDriver().get(ConfigReader.read("sp.base.url"));
    }

    @Then("user should see below links")
    public void userShouldSeeBelowLinks(List<String> expectedLinks) {

        System.out.println(expectedLinks);

        // get list of links from main page
        List<WebElement> allLinks = Driver.getDriver().findElements(By.xpath("//div[@class='display-4 card']//a"));
        List<String> actualLinks = BrowserUtil.getAllText(allLinks);
        assertEquals(expectedLinks, actualLinks);
    }
}
