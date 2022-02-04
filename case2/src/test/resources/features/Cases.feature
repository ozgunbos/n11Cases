Feature: Second Case with 3 homeworks

  Background:
    Given User goes to Home Page


  @homework
  Scenario: Get all Shops and Check Comments for a specific Shop
    And Wait for pop up
    And User Hover over "Mağazalar" and Select "Mağazaları Gör"
    And Write all shops to csv
    When Go to the second shop that starts with the letter "S"
    Then Total Reviews checked

  @homework
  Scenario: Search Iphone
    And Wrong word is written as "ayfon"
    And 3 Iphone products are added to the basket
    When Navigate to the cart and increase the quantity of the cheaper item by 2
    Then Try to buy products entering wrong credit card credentials


  @homework
  Scenario: Search Telefon using specific filters
    And "Telefon" is searched
    And On the product listing screen the second brand is selected from the filters
    And Select List by comments from filters
    Then List all products by free shipping
