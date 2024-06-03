Feature: Verify All Products and product detail page

Background:
  Given User has already logged into the application
    | Username              | Password |
    | Tester12345@gmail.com | 12345    |

@Product
Scenario: Navigation to ALL PRODUCTS page
  Given User is on HomePage with Title 'Automation'
  When User clicks on 'Products' button
  Then Verify user is navigated to ALL PRODUCTS page successfully with "All Products"
  And The products list should be visible
    | WOMEN    |
    | MEN      |
    | KIDS     |
  And category list count should be 4
