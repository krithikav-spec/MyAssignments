Feature: Create Salesforce Account

  Scenario: Create new account with public ownership
    Given Load the URL
    Given Login to Salesforce
   	When select toggle
   	When select view All
   	When select on Accounts tab
   	When click New button
   	When enter name
   	When enter Ownership  name
   	When click save
   	Then Verify  the displayed name
   	