#Author: hugh.harford@poscoconsulting.com
#Keywords Summary :
@Kata2Feature
Feature: Datatable Chop work?  
   >>> DATATABLE Does the binary search Chop give the right result?
#Scenario: Use the datatable approach
	@ScenarioWithData
  Scenario: Datatable, order of data
    Given an integer array
    | 1 | 2 | 3  | 4 |
    When the array is checked for the target    
    | 1 | 2 | 3 |    
    Then the index should be returned
    | 1 | 2 | 3 |