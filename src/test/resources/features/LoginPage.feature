Feature: Login Page Feature

Scenario: Login Page Title
Given user is on login page
When user gets the title of the page 
Then page title should be "Login - My Store"

Scenario: Forgot Password link Display
Given user is on login page
Then Forgot your password link should be display

Scenario: Login with correct credentials
Given user is on login page
When user enters username "poojak8897@gmail.com"
And user enters password "Selenium@1"
And user clicks on login button
Then user gets the title of the page
And page title should be "My account - My Store"