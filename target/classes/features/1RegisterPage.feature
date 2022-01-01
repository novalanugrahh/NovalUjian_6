Feature: Demoqa Register

	Scenario: Register
		Given User go to the Website
		When User click myaccount page button
		And User input username email password and click register
		Then User success to register