package com.yahya.steps;

import io.cucumber.java.en.Given;

public class SpartanUISteps {

    HomePage homePage = new HomePage() ;

    @Given("user navigate to home page")
    public void userNavigateToHomePage() {
        // open the browser --  set up the hook

        // navigate to the homepage


        homePage.goTo() ;
    }
}
