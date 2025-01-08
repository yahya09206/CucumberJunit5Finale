package com.yahya.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpartanAPISteps {

    @Given("the base_uri and base_path set")
    public void the_base_uri_and_base_path_set() {
        System.out.println("base_uri");
        // set up base uri and base path
        // save it into variable and make it global
    }
    @When("I send request to {string} endpoint")
    public void i_send_request_to_endpoint(String endpoint) {
        System.out.println(endpoint);
        // send your request and save the result into a variable and make it global
    }
    @Then("I should get status code {int}")
    public void i_should_get_status_code(Integer statusCode) {
        System.out.println(statusCode);

        // make assertions and save it into class level variable if more validation is needed
    }

}
