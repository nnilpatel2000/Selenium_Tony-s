Feature: Create Account Page Feature

  Scenario Outline: Tony's Create Account Data Driven
    Given user is on Home Page
    Then user closes welcome message
    Then user clicks on create account link
    Then user enters Firstname as "<firstname>"
    Then user enters Lastname as "<lastname>"
    Then User enters Email and re_enters email address
    Then User enters password and re_enters password
    Then User clicks store selection dropdown menu
    Then User selects Store as "<featurestore>"
    Then User clicks month selection dropdown menu
    Then User selects Month as "<featuremonth>"
    Then User enters Day as "<day>"
    Then User clicks year selection dropdown menu
    Then User selects year as "<featureyear>"
    Then User enters Address as "<address>" and City as "<city>"
    Then User clicks state selection dropdown menu
    Then User selects State as "<featurestate>"
    Then User enters postal code and phone
    Then user close the browser

    Examples: 
      | firstname | lastname | featurestore  | featuremonth  | day | featureyear | address     | city        | featurestate | 
      | Faisal    | Saiyed   | IL - Prospect |   Nov (11)    | 21  |   1990      | 456 Park Ln | Des Plaines |  Illinois    |

