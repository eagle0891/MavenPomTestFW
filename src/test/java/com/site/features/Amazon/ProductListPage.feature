Feature: Product List Page

  Background: Navigate to the homepage
    Given I am on the Amazon homepage
    And I accept cookies

  Scenario Outline: Search for a product
    And I search for a product '<searchTerm>'
    And I see the search results for '<searchTerm>'
    When I click on a '<brand>' product
#    Then I should see the product details page
    Examples:
      | searchTerm | brand |
      | games      |  |

  Scenario Outline: Add to cart and remove from cart
    And I search for a product '<searchTerm>'
    And I see the search results for '<searchTerm>'
    When I click on a '<brand>' product
    When I add item to cart
    Then I should see the mini cart
#    And the subtotal should be correct
#    When I delete the item from cart
#    Then I should see the cart page empty
    Examples:
      | searchTerm | brand |
      | watch      | Casio |