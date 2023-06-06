Feature: Create New Order
  As a Buyer
  I want to create a new order
  So that I can purchase products

  Scenario: Successful order creation
    Given I am on my orders page
    When I fill URL with "https://www.amazon.com/-/es/Corsair-Vengeance-3200MHz-memoria-escritorio/dp/B0143UM4TC/"
    And I fill in the name product with "Corsair Vengeance LPX 16GB"
    And I specify the weight as "0.25 kg"
    And I specify the amount as "1"
    And I specify the price as "29.99"
    And I specify the commission product as "6.99"
    And I click the "Registered" button
    Then I should see a success message "Order registered"
    And the order should be added to my order history

  Scenario: Failed order creation with empty URL
    Given I am on my orders page
    When I fill in the name product with "Corsair Vengeance LPX 16GB"
    And I specify the weight as "0.25 kg"
    And I specify the amount as "1"
    And I specify the price as "29.99"
    And I specify the commission product as "6.99"
    And I click the "Registered" button
    Then I should see a success message "Please enter the url of the product."

  Scenario: Failed order creation with invalid weight
    Given I am on my orders page
    When I fill URL with "https://www.example.com"
    And I fill in the name product with "Example Product"
    And I specify the weight as "-1 kg"
    And I specify the amount as "1"
    And I specify the price as "9.99"
    And I specify the commission product as "2.99"
    And I click the "Registered" button
    Then I should see an error message "Invalid weight. Please enter a positive value."