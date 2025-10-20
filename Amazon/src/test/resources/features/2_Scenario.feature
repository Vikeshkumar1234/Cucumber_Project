Feature: Launch the Browser       

Scenario: Executing the Scenario 2.
Given Launching the Browser.
When Launch the URL.
When Search the list of "<items>".
Then Assert the Search Result of first Product containing the title as "<items>".
Then Close the browsers.

Examples:
       | items|
       |Watches|
       |Shoes|
       |Laptop|