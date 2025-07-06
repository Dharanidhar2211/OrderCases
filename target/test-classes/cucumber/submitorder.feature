
@tag
Feature: Purchase the Order from Ecommerce WebSite
  I want to use this template for my feature file
  
  
Background:
Given Login to the Application

  @Regression
  Scenario Outline: Postive test of Submitting an Order 
    Given Login with the valid email<email> and password <password> 
    When I add the product to the cart <item>
    And Checkout the item <item> and submit the order
    Then Need to get the "Thankyou for the order." Text on the screen
    And Close the Application
    

    Examples: 
      | email  										| password 								| item  	   |
      | dharanidhar220@gmail.com 	|     Ilovecricket@123 		| ZARA COAT 3|
    	| dharanidhar2211@gmail.com 	|     Ilovecricket@123 	| ADIDAS ORIGINAL|
