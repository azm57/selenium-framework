Feature: Creaftsvilla Application

#Scenario: User Registration

#Given Launch Browser and navigate to application
#And Read Test Data
#When Go to registration and enter all the data and click register
#Then Verify successful registration


Scenario: Add Products To Cart and Verify

Given Launch Browser and navigate to application
And Read Test Data
When User Login to Application with valid Credentials
And User navigates to Product Category Page
And User Adds products to the cart
Then User Navigates to Cart 
And Verify the Cart Items
