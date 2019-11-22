Feature: Feature for TestMeApp
 @Shopping1
  Scenario: user tries to move to payment without adding any item to cart
    Given user has logged into TestMe Application
    When user searches for a product
    And user tries to proceed to payment without adding any item to cart
    Then cart icon is not displayed

  @Shopping2
  Scenario: Title of your scenario outline
   Given user has logged into TestMe Application
    When the user searches for a products
    When user adds the product to cart and clicks on cart icon
    And the user proceeds to pay with valid credentials
    Then order placed successfully
   
      
  
   