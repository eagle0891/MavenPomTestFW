Feature: Product List Page

  Background: Navigate to the homepage
    Given I am on the Amazon homepage
    And I accept cookies

  Scenario Outline: Search for a product
    And I search for a product '<searchTerm>'
    And I see the search results for '<searchTerm>'
#    When I click on a '<brand>' product
#    Then I should see the product details page for the '<brand>' product
    Examples:
      | searchTerm | brand |
      | watch      | Casio |