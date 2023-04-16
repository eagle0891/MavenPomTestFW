Feature: Login

  Background: Navigate to login page
    Given the user is on the login page

  Scenario: Login page healthcheck
    Then the page title is correct
    And the Forgot Password section is displayed
    And the Sign Up section is displayed

  Scenario: Login with existing user credentials
    And login with existing user credentials
#    Then the username is displayed correctly after login