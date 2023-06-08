Feature:Register a new user in the system

  Rule: As a new user of the application I want to register an account to interact with the page


    Background:
      Given the user enter in the sing up form

    Scenario: 01-  Successfully user sing up
      When the user sing up in the system
      Then a success message is displayed


    Scenario: 02 - sing up with password does not match
      When the user sing up in the system with password does not match
      Then the system displays a password mismatch message
