Feature: Verify the key functionality
  Scenario: verify the home page
    Given launch the browser
    When search the product
    And filter search result
    And add a product to the cart
    Then proceed to checkout