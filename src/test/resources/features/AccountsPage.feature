Feature: Account Page Feature

Background:
Given user is already logeed in to application
|username|password|
|poojak8897@gmail.com|Selenium@1|

@accounts
Scenario: Accounts Page Title
Given user is on accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

@accounts
Scenario: Accounts section count 
Given user is on accounts page
Then user gets acounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|My WISHLISTS|
|Home|
And account section count should be 6