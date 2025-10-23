Feature: Opening the Amazon Website checking the Products      
@A
Scenario: Executing the Scenario 1.
When Launch the URL.
Then Assert the Title and URL.
When Click on Today”s Deal.
Then Assert the Page Contains title as “Deals”.
When Click on the first Item of the “Today's Deals”.
Then Assert the Product Name.
When Go back to Deals Page and click on the second item.
Then Assert the Product Name.