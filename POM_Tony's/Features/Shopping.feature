Feature: Shopping Page Feature

  Scenario Outline: Tony's Shopping Data Driven
    Given User is on Home Page
    Then User closes welcome message box
    Then User clicks Sign in link
    Then User enters email as "<Email>" and password as "<Password>"
    Then User click on Login button
    When User clicks on Shop
    Then User adds eggs and limes
    Then User hovers and clicks on Checkout button
    Then User clicks on pick up day dd menu and selects day as "<Day>"
    Then User clicks on time dd menu and selects time as "<Time>"
    Then User types instructions
    Then User clicks on begin Checkout button
    Then User enters CC holder name as "<CCName>"
    Then User enters CC number as "<CCNumber>"
    Then User enters CVV number as "<CVV>"
    Then User enters Expiration Date as "<Expiry>"
    Then User click on Sign out
    Then User closes the browser

    Examples: 
      |           Email             |  Password  |    Day    |      Time      |   CCName   |      CCNumber    | CVV | Expiry  | 
      | nnilpatel.2000@gmail.com    |  Nil@12345 | Tue 09/28 | 12:00pm-1:00pm | Tony Starc | 1234567812345678 | 456 | 11 / 22 |
