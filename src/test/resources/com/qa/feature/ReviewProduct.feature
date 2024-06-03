Feature: Review the Product on the page

Background:
  Given User has already logged into the application
    | Username              | Password |
    | Tester12345@gmail.com | 12345    |

Scenario Outline: Review the product with different data set
Given User has selected product to review 
When user fills the review given from the sheetname "<SheetName>" and rowNumber <rowNumber>
And clicks on submitt button
Then user should see the message "Thank you for the Review" on the page

Examples:
|SheetName|rowNumber|
|Automation|0|
|Automation|1|
|Automation|3|
