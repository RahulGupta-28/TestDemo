#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Search a Product on FlipCart Website

Background: 
Given User Should landed on FlipCart Website

  @tag2
  Scenario Outline: Verify Product Search functionality
    Given User is on Search Page
    When User Type any <product> in search box and select <productCategory> from search list
    Then Selected <productcategoryItem> visible in Result page

    Examples: 
      | product    | productCategory   | productcategoryItem  |
      | mobile     | phone under 2000+0| OnePlus N6x          |
      | television | 65+ inch          |  Xiaomi 189 cm       |
