Feature: Filter the products and add the product to the favorite and for compare
  Scenario: User able to open another category page and filter the products
    Given The Electronics category page is opened and the category item is chosen
    When User filter the products by Belt,Manufacturer,Price
    Then The filtered items are displayed on the top of the page
  Scenario: User should be to open the product page and add it the his list
    Given Product page is opened and details are displayed
    When User ticking checkboxes
    Then The chosen values are displayed on the page
