
Feature: Demoqa Checkout
		
    Scenario: Checkout
		When User click viewcart button and process checkout
		And User input form billing details
		And User checklist terms and click place order
		Then User succes to checkout
