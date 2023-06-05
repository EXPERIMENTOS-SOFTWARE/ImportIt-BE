Feature: Messaging
  As a user
  I want to be able to communicate with the Traveler
  So that I can ask questions about the status of my package

  Scenario: User sends a message to the Traveler
    Given I am a user who has bought an item
    And I am logged in
    And I am on the package tracking page
    When I click on the "Send Message" button
    And I fill in the message field with "Could you send me an update of my package?"
    And I click on the "Send" button
    Then I should see a message that says "Message sent"

  Scenario: User receives a response from the Traveler
    Given I am a user who has bought an item
    And I am logged in
    And I have received a new message notification
    When I click on the "See Messages" button
    Then I should see the following messages from the traveler
    | Message |
    | Hey! Your package is secured |
    | I will be arriving in 2 day |
    | Hey, sorry ?? Flight was delayed by 8 hours |

  Scenario: User request media from the Traveler
    Given I am a user who has bought an item
    And I am logged in
    And I am on the package tracking page
    When I click on the "Send Message" button
    And I fill in the message field with "Could you send me a picture of the package?"
    Then I receive a picture of the package from the traveler