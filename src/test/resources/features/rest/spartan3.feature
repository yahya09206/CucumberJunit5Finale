Feature: Spartan API Single Data
  As a user,
  I should be able to get individual data
  using valid id and see details, update the value
  or delete the whole data

  Background:
    Given the base_uri and base_path set

    @database
  Scenario: Should be able to get single spartan using /spartans/{id}
    And I have valid spartan id
    And I ask for "json" response payload
    When I send get request to "/spartans/{id}" endpoint
    Then I should get status code 200
    Then the spartan data with that id should match the value in the database

  Scenario: Should be able to delete a single spartan using DELETE /spartans/{id}
    And I have valid random spartan id
    When I send delete request to "/spartans/{id}" endpoint
    Then I should get status code 204
    When I send get request to "/spartans/{id}" endpoint
    Then I should get status code 404

  Scenario: Should be able to update a single spartan using PUT /spartans/{id}
    And I have valid random spartan id
    And I send the data in json format
    And I am sending below valid spartan data
      | name   | Kimberley  |
      | gender | Female     |
      | phone  | 9876543210 |
    When I send put request to "/spartans/{id}" endpoint
    Then I should get status code 204
    When I send get request to "/spartans/{id}" endpoint
    Then the field value for "name" path should be equal to "Kimberley"
    Then the field value for "gender" path should be equal to "Female"

  Scenario: Should be able to partially update a single spartan using PATCH /spartans/{id}
    And I have valid random spartan id
    And I send the data in json format
    And I am sending below valid spartan data
      | name   | Mehmet  |
      | gender | Male     |
    When I send patch request to "/spartans/{id}" endpoint
    Then I should get status code 204
    When I send get request to "/spartans/{id}" endpoint
    Then the field value for "name" path should be equal to "Mehmet"
    Then the field value for "gender" path should be equal to "Male"

