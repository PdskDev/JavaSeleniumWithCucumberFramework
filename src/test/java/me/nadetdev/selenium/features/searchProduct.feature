Feature: Search and Place the order for Products

  Scenario: Search Experience for product search in both Home and offers page
    Given user is on GreenKart landing page
    When user searched with shortname "tom" and extracted actual name of product
    Then user searched for "tom" shortname in Offers page
    And validate product name in Offers page matches with landing page
