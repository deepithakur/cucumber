
Feature: login Feature for TestMeApp

 @Registration
  Scenario: User registration in TestMe Application
     Given User opens TestMeApp register page
    When enter username as "deepi14421243"
    And enter firstname as "Deepika"
    And enter lastname as "Thakur"
    And enter password as "deepi@123"
    And enter confirm password as "deepi@123"
    And select the Gender as "Female"
    And enter email address as "deepi@gmail.com"
    And enter mobile number as "9130897889"
    And enter date of birth as "12/20/2019"
    And enter the address as "Pune"
   And select the security question as "What is your Pet Name?"
   And enter the answer as "zxcvbmnm" 
   And click on Register button
   Then  Deepika is successfully registered



@Login
  Scenario Outline: TestMe Application Login scenario
    Given The user has login the TestMe Application
    When User enters "<username>" in Username field
    And User enters "<password>" in password field
   
    Then user is logged in successfully
    Examples:
      |username|password   |
      |lalitha |password123|

   
  