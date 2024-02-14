Feature: User Login Function
Scenario: Valid Login
Given User is on Login Page
When User enters "tomsmith" and "SuperSecretPassword!"
Then Should display Success Msg