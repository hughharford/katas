#Author: hugh.harford@poscoconsulting.com
#Keywords Summary :
@codeSignal.removeKfromList
Feature: Remove K from List
#Scenario: Can all keys be removed from the list
@basicScenario
Scenario Outline: Basic working, Example table?
   Given an input <linkedlist>
   And a <key> to be removed
   When the linkedlist has the key removed
   Then the returned output should be <outputlist>
Examples:
   | linkedlist              	  | key      | outputlist  	   |
   | "1,2,3,4,5"				  | 9        | "1,2,3,4,5" 	   |
   | "5,6,7,8,9"				  | 5        | "6,7,8,9"	   |
   | "5"				  		  | 5        | ""			   |
   | "2,3,4,5,6"				  | 5        | "2,3,4,6" 	   |
   | "4,5,6,7,8"				  | 5        | "4,6,7,8" 	   |
   | "1,2,3,4,5"				  | 5        | "1,2,3,4" 	   |
   | "1,2,5,4,5"				  | 5        | "1,2,4" 	  	   |
   | "1,2,5,5"				      | 5        | "1,2" 	  	   |
   | "5,5,5,5,5,5"				  | 5		 | ""              |
   | "1,5,5"	 		  		  | 5		 | "1"             |
   | "1,5,5,5,5,5,5"	 		  | 5		 | "1"             |
   