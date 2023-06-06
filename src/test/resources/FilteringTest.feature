Feature: Search Filtering
  As a user
  I want to be able to filter my search results
  So that I can find specific products more easily


  Scenario: User applies filters to search results
    Given I am a user searching for a product
    And I am on the search page
    When I select the "Filter" option
    And I choose the desired filters (e.g., category, price range, brand)
    And I click on the "Apply Filters" button
    Then the search results should be updated according to the selected filters

  Scenario: User clears applied filters
    Given I am a user who has applied filters to my search results
    And I am on the search page
    When I click on the "Clear Filters" button
    Then all applied filters should be reset
    And the search results should show all available products again

  Scenario: User adjusts filters dynamically
    Given I am a user searching for a product
    And I am on the search page
    When I adjust the filters dynamically (e.g., sliding price range, selecting/unselecting categories)
    Then the search results should be updated in real-time to reflect the changes in the applied filters
