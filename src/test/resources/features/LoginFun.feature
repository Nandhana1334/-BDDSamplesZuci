Scenario Outline:Valid Login
Given User is on Login Page
When User enters "<username>" and "<password>"
Then Should display Success Msg
 Examples:
   | username | password |
   | tomsmith | SuperSecretPassword! |
   | testuser1 | welcome123 |
   | testuser2 | welcome123 |  