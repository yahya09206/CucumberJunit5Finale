package com.yahya.steps;

import com.yahya.utility.ConfigReader;
import com.yahya.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

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
    public void userShouldSeeBelowLinks(List<String> links) {

        System.out.println(links);
    }
}
