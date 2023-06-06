Feature: Wholesale Product Reservation
  As a Buyer
  I want to reserve wholesale products
  So that I can receive them once the required number of reservations is reached

  Background:
    Given The Endpoint "https://importidbackend.herokuapp.com/api/products/wholesale" is available

  @post-reservation
  Scenario: Reserve Wholesale Product
    When A Reservation Request is sent with product ID "123", quantity "10", and payment details
    Then A Reservation Confirmation with status 201 is received

  @get-reservation-status
  Scenario: Get Reservation Status
    When A Reservation status request is sent for reservation ID "123"
    Then The Reservation status with status 200 is received

  @cancel-reservation
  Scenario: Cancel Reservation
    When A Reservation cancellation request is sent for reservation ID "123"
    Then The Reservation cancellation confirmation with status 200 is received

  @notification
  Scenario: Receive Reservation Notification
    When A notification is received for reservation ID "123"
    Then The Notification with status 200 is received
    And The notification contains "Your reservation has reached the required number of participants. We will proceed with the product acquisition and shipment."