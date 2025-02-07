Feature: Regression test scenarios

  @test
  Scenario:1 User enters correct credential on the login screen and logs out
    Given The user is on the login screen
    When the user enters "standard_user" in username input field 
    And the user enters "secret_sauce" in the password input field
    And the user clicks the Log in button
    And the inventory page is displayed 
    And the user clicks on the hamburger menu
    Then the user clicks on Logout link
  
  @test
  Scenario:2 User enters incorrect password on the login screen
    Given The user is on the login screen
    When the user enters "standard_user" in username input field 
    And the user enters "incorrect_Password" in the password input field
    And the user clicks the Log in button
    Then the system displays an error message
    
  @test
  Scenario:3 A locked out user cannot login
    Given The user is on the login screen
    When the user enters "locked_out_user" in username input field 
    And the user enters "secret_sauce" in the password input field
    And the user clicks the Log in button
    Then the system displays an locked out error message
 
  @test
  Scenario:4 User clicks Login without entering username and password
    Given The user is on the login screen
    And the user clicks the Log in button
    Then the system displays username required error message
     
  @test
  Scenario:5 Test to show failure case
    Given The user is on the login screen
    When the user enters "John_Sonw" in username input field 
    And the user enters "secret_sauce" in the password input field
    And the user clicks the Log in button
    Then the system displays an locked out error message
    

  @test
  Scenario:6 User wants to filter inventory by Name (Z to A)
    Given The user is on the login screen
    When the user enters "standard_user" in username input field 
    And the user enters "secret_sauce" in the password input field
    And the user clicks the Log in button
    And the inventory page is displayed
    And the user selects the filter dropdown
    Then user selects the filter option "za"
    
  @test
  Scenario:7 User wants to filter inventory by Price (high to low)
    Given The user is on the login screen
    When the user enters "standard_user" in username input field 
    And the user enters "secret_sauce" in the password input field
    And the user clicks the Log in button
    And the inventory page is displayed
    And the user selects the filter dropdown
    Then user selects the filter option "hilo"
    
    
    
    
