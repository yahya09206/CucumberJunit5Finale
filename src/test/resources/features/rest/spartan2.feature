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