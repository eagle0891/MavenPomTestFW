Feature: Amazon homepage

  Background: Navigate to the homepage
    Given I am on the Amazon homepage
    And I accept cookies

  Scenario: Perform homepage healthcheck
    Then I should see the Amazon logo

  Scenario: Click through header menu links
    Then I should see the header menu links
    And the landing page is correct after clicking on the header menu links

#  Scenario: Click through footer menu links
#    Then I should see the footer menu links