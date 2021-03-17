#Author: hugh.harford@poscoconsulting.com
#Keywords Summary :
@Kata2Feature
Feature: Basic BDD Binary Chop?
   >>>> Basic BDD running
#Scenario: Can the correct index be returned?
	@basicScenario
  Scenario Outline: Basic working, Example table?
    Given the sorted integer <array>
    When the array is checked for the <target>
    Then the <index> should be returned
# int search array, target, expected answer
  Examples:
    | array                    | target   | index  |  
    | 9                        | 3        | -1     |
    | 1                        | 3        | -1     |
    | 4                        | 1        | -1     |