package com.yahya.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpartanAPISteps {

    RequestSpecification givenPart;
    Response response;

    @Given("the base_uri and base_path set")
    public void the_base_uri_and_base_path_set() {
        System.out.println("base_uri");
        // set up base uri and base path
        // save it into variable and make it global
        givenPart = given().log().all().baseUri("http://44.211.192.252:8000")
                .basePath("/api");


    }
    @When("I send request to {string} endpoint")
    public void i_send_request_to_endpoint(String endpoint) {
        System.out.println(endpoint);
        // send your request and save the result into a variable and make it global
        response = givenPart.when().get(endpoint).prettyPeek();
    }
    @Then("I should get status code {int}")
    public void i_should_get_status_code(Integer statusCode) {
        System.out.println(statusCode);

        // make assertions and save it into class level variable if more validation is needed
    }

}
