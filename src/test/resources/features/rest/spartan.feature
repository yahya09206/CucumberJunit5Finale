Feature: Spartan App Rest API Up and running

  As a user,
  I should be able to send api request to spartan rest api
  and get a valid response

  Scenario: Should be able to Get Valid response for GET /hello endpoint

    Given the base_uri and base_path set
    When I send request to "/hello" endpoint
    Then I should get status code 200
