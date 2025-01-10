Feature: Spartan App Rest API Up and running

  As a user,
  I should be able to send api request to spartan rest api
  and get a valid response

  Scenario: Should be able to Get Valid response for GET /hello endpoint

    Given the base_uri and base_path set
    When I send request to "/hello" endpoint
    Then I should get status code 200
    And The response format should be "text/plain;charset=UTF-8"
    And the response payload should be Hello from Sparta


  Scenario: Should be able to call /spartan to get all data
    Given the base_uri and base_path set
    And I ask for "json" response payload
    When I send request to "/spartans" endpoint
    Then I should get status code 200
    Then The response format should be "application/json"
