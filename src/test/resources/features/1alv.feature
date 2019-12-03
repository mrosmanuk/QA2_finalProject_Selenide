  Feature: 1.lv product order steps
  This feature tests product order steps starting from home page and ending at checkout page

  Scenario: Opening homepage, selecting product category, selecting brand, using filter to sort by *star* highest, selecting product and adding it to cart,
  proceeding with order form, filling in user data, comparing product price and name from product page and at final check out page.

  Given I open website
  And I check for fullscreen banner, closing it if found
  And I check for slider banner, closing it if found
  And I accept cookies
  When I open mobile devices category
  And I check for fullscreen banner, closing it if found
  And I navigate to brand Xiaomi
  And I check for fullscreen banner, closing it if found
  And I sort products by *star* highest
  When I select product with highest *star* rating and proceed to product page
  And I check for fullscreen banner, closing it if found
  And I fetch and save product price and name
  And I place product to cart and navigate to cart
  And I navigate to next page
  And I navigate to next page via without registration path
  And I enter name: name, lastName: surname, email: email@email.elv, phone: +37120000000
  And I refuse to receive spam
  And I agree on terms of use
  And I select delivery method
  And I navigate to next page 2
  And I select to contact me via email
  And I navigate to next page 3
  And I fetch and save product price and name before checkout
  And I fetch user information before checkout
  Then I compare product and user information


