Feature: Spartan App Rest API Data

  As a user,
  I should be able to send api request to spartan rest api
  and get a valid response

  Background:
    Given the base_uri and base_path set

  Scenario Outline: Should be able to call /spartan to get all data in desired format
    And I ask for "<formatAskedFor>" response payload
    When I send request to "/spartans" endpoint
    Then I should get status code 200
    Then The response format should be "<expectedContentTypeHeader>"
    Examples:
      | formatAskedFor | expectedContentTypeHeader |
      | json           | application/json          |
      | xml            | application/xml           |

  Scenario: Should be able to add valid data to Spartan app
    # Set the content type, provide the json body or map ody send request and verify 201
    Given I send the data in json format
    And I am sending below valid spartan data
      | name   | Kimberley  |
      | gender | Female     |
      | phone  | 9876543210 |
    When I send post request to "/spartans"
    Then I should get status code 201
    Then the success field value should be A Spartan is Born!


#  Scenario: Should be able to call /spartan to get all data in JSON format
#    Given the base_uri and base_path set
#    And I ask for "json" response payload
#    When I send request to "/spartans" endpoint
#    Then I should get status code 200
#    Then The response format should be "application/json"
#
#
#  Scenario: Should be able to call /spartan to get all data in XML format
#    Given the base_uri and base_path set
#    And I ask for "xml" response payload
#    When I send request to "/spartans" endpoint
#    Then I should get status code 200
#    Then The response format should be "application/xml"