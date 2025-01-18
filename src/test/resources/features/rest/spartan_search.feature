Feature: Spartan Search Feature

  As a user,
  I should be able to filter data
  using partial name and gender

  Background:
    Given the base_uri and base_path set


  Scenario: Should be able to search to get valid data using GET /spartans/search

    And I search for spartan with name contains "Ea" and gender "Male"
    When I send get request to "/spartans/search" endpoint
    Then I should get status code 200
    Then All names in the result should contain "Ea" and gender should be "Male"
    Then the count in the response should match the count in the database