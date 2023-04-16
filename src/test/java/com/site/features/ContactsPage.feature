Feature: Contacts Page

  Background: Navigate to the contacts page
    Given the user is on the contacts page

  Scenario: Contacts page healthcheck
    Then the contacts page healthcheck is successful

  Scenario: Create contacts data
    Then create new contacts 'name' 'names' 'namess'