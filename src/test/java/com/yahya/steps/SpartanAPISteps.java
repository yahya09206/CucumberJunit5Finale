package com.yahya.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpartanAPISteps {

    @Given("the base_uri and base_path set")
    public void the_base_uri_and_base_path_set() {
        System.out.println("base_uri");
    }
    @When("I send request to {string} endpoint")
    public void i_send_request_to_endpoint(String endpoint) {
        System.out.println(endpoint);
    }
    @Then("I should get status code {int}")
    public void i_should_get_status_code(Integer int1) {
        System.out.println(int1);
    }

}
