Feature: Opening the Amazon Website checking the Products by Data Driven       
@B
Scenario: Executing the Scenario 2.
When Launch the URL.
When Search the list of "<items>".
Then Assert the Search Result of first Product containing the title as "<items>".

Examples:
       | items|
       |Watches|
       |Shoes|
       |Laptop|