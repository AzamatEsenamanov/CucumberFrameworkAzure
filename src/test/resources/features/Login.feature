Feature: Login

@Login
Scenario Outline: Login Page
#Given we are on HomePage
When we enter "<login>" in the field
#Then we clear loginBox

Examples:
|login|loginBox|
|12345|//input[@id='q']|