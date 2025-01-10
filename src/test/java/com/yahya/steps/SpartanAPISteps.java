package com.yahya.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpartanAPISteps {

    RequestSpecification givenPart;
    Response response;
    ValidatableResponse thenPart;

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
    public void i_should_get_status_code(int expectStatusCode) {
        System.out.println(expectStatusCode);

        // make assertions and save it into class level variable if more validation is needed
        thenPart = response.then().statusCode(expectStatusCode);
    }

    @And("The response format should be {string}")
    public void theResponseFormatShouldBe(String expectedContentType) {
        thenPart.contentType(expectedContentType);
    }

    @And("the response payload should be Hello from Sparta")
    public void theResponsePayloadShouldBeHelloFromSparta() {

        thenPart.body(is("Hello from Sparta"));
    }
}
