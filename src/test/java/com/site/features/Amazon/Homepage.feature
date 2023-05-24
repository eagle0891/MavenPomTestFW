Feature: Amazon homepage

  Background: Navigate to the homepage
    Given I am on the Amazon homepage
    And I accept cookies

  Scenario: Perform homepage healthcheck
    Then I should see the Amazon logo