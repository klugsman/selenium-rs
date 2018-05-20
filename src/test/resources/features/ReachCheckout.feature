@ReachCheckout
Feature: Reach Checkout
  As an end user
  I want to be able to reach the checkout page after selecting items

  Scenario: Add a Battery Hydrometer to the basket and get To Checkout page
    When I try to checkout after adding a Battery Hydrometer to my basket using search filters
    Then I can see the checkout page

  Scenario: Add Belden Blue Twinaxialuse to the basket and get To the Checkout page
    When I try to checkout after adding a Belden Blue Twinaxialuse to my basket using the search box
    Then I can start to checkout
