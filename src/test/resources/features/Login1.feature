Feature: User Login Function
Scenario: Valid Login
Given User is on Login Page
When User enters credentials
   | username | password |
   | tomsmith | SuperSecretPassword |
Then Should display Success Msg
   |You logged into a secure area! |