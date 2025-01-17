package com.yahya.steps;

import com.github.javafaker.Faker;
import com.yahya.utility.DB_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpartanAPISteps {

    RequestSpecification givenPart;
    Response response;
    ValidatableResponse thenPart;
    int lastId;

    @Given("the base_uri and base_path set")
    public void the_base_uri_and_base_path_set() {
        System.out.println("base_uri");
        // set up base uri and base path
        // save it into variable and make it global
        givenPart = given().log().all().baseUri("http://44.211.192.252:8000")
                .basePath("/api");


    }
    @When("I send get request to {string} endpoint")
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


    @And("I ask for {string} response payload")
    public void iAskForResponsePayload(String responseFormat) {

        if (responseFormat.equals("json")) {
            givenPart.accept(ContentType.JSON);
        } else if (responseFormat.equals("xml")) {
            givenPart.accept(ContentType.XML);
        }
    }

    @Given("I send the data in json format")
    public void iSendTheDataInJsonFormat() {

        givenPart.contentType(ContentType.JSON);
    }

    @And("I am sending below valid spartan data")
    public void iAmSendingBelowValidSpartanData(Map<String, Object> requestPayloadMap) {

        givenPart.body(requestPayloadMap);
    }

    @When("I send post request to {string}")
    public void iSendPostRequestTo(String endpoint) {

        response = givenPart
                        .when()
                        .post(endpoint).prettyPeek();

    }

    @Then("the success field value should be A Spartan is Born!")
    public void theSuccessFieldValueShouldBeASpartanIsBorn() {

        thenPart.body("success", is("A Spartan is Born!"));
    }

    @And("I have valid spartan id")
    public void iHaveValidSpartanId() {

        // get a valid spartan id and make it available for all methods
        // think about whether I need the name, phone and gender
        lastId = givenPart.get("/spartans").path("id[-1]");
        // set id into path variable in this method
        givenPart.pathParam("id", lastId);

    }

//    @When("I send get request to {string} endpoint with valid id")
//    public void iSendGetRequestToEndpointWithValidId(String endpoint) {
//
//
//    }

    @Then("the spartan data with that id should match the value in the database")
    public void theSpartanDataWithThatIdShouldMatchTheValueInTheDatabase() {

        // SELECT * FROM SPARTANS WHERE SPARTAN_ID = VALIDHERE
        DB_Util.runQuery("SELECT * FROM SPARTANS WHERE SPARTAN_ID = " + lastId);
    }

    @When("I send delete request to {string} endpoint")
    public void iSendDeleteRequestToEndpoint(String endpoint) {

        response = givenPart.when().delete(endpoint).prettyPeek();
    }


    @And("I have valid random spartan id")
    public void iHaveValidRandomSpartanId() {

        // send get request to GET /spartans
        // for the index, use 0 to all spartanCount - 1
        List<Integer> allIds = givenPart.get("/spartans").path("id");
        // get random ID at a location from 0 to allIds.size()-1
        Random rand = new Random();
        int randomID = rand.nextInt(allIds.size());
    }
}
