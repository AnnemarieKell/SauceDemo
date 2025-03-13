@task
Feature: Task: add priced Item to Cart
  # Testing the inventory page by selecting item and adding to cart

  Scenario Outline: add <priced> price item to cart
    Given Sergey logged into the website
    When he looks up the <priced> price item
    And he puts this item in the cart
    Then he can see that the itemcounter in the cart icon displays "1"
  Examples:
    | priced    |
    | "highest" |
    | "lowest"  |

  Scenario: Select highest price item to cart through image link
    Given Sergey logged into the website
    When he looks up the highest price item
    When he selects the highest priced item
    And he puts this item in the cart
    Then he can see that the itemcounter in the cart icon displays "1"

  Scenario: Select highest price item to cart through Title Link
    Given Sergey logged into the website
    When he looks up the highest price item
    When he selects the highest priced item through title link
    And he puts this item in the cart
    Then he can see that the itemcounter in the cart icon displays "1"



