Feature: Storefront login
  Scenario: Standard user logs in
    Given the login page is open
    When the user logs in as "standard_user" with password "secret_sauce"
    Then the product list is displayed

  Scenario: Locked-out user is rejected
    Given the login page is open
    When the user logs in as "locked_out_user" with password "secret_sauce"
    Then the error message contains "locked out"
