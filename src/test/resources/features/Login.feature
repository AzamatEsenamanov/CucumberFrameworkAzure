Feature: Login

@Login
@Regression
@May
@S-31234

Scenario Outline: Login Page
  Given we are on "HomePage"
  When we enter "<login>" in the "searchBox" field
  Then we click on "submitdBtn"
  And we click on "logoImage"
  And we click on "loginTextLink"
  Given we are on "LoginPage"
  And we enter "<username>" in the "userNameBox" field
  And we enter "<lastName>" in the "lastNameBox" field
  And we enter "<password>" in the "passwordBox" field
  And we click on "loginBtn"
  And we wait for 2 seconds


Examples:
|login|username|lastName|password|
|USA  |username|lastName|password|