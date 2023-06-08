Feature: login a user in the system


  Rule: As a user I want to enter the application to interact with the page

    Background:
      Given  the user enter in the login page as a registered user

    Scenario: 01-  Successfully user login in the system
      When the user login in the system successfully
      Then the user name will be displayed


    Scenario: fail the login to the page

      When login section with empty name and password fields
      Then the user receives a message indicating that the fields are required


