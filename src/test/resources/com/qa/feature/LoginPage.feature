Feature: Login to Application

Scenario: Login User with correct email and password
Given User is on HomePage "Automation"
And Click on Login button
When Verify "Login to your account" is visible
And Enter correct "automationxxx@gmail.com" and "1234"
And Click login button
Then Verify that "Logged in as AutomationTester" is visible

Scenario: Login User with incorrect email and password
Given User is on HomePage "Automation"
And Click on Login button
When Verify "Login to your account" is visible
And Enter correct "abcd@gmail.com" and "123523513"
And Click login button
Then Verify error 'Your email or password is incorrect!' is visible

