#Author: hugh.harford@poscoconsulting.com
#Keywords Summary :
@codeSignal.removeKfromList
Feature: Is List a Palindrome
#Scenario: Can all keys be removed from the list
@basicScenario
Scenario Outline: Basic working, Example table?
   Given an input for Palindrome <palindromeInput>
   When a check is made to see if its a palindrome
   Then the output expected is <booleanOutcome>
Examples:
	| palindromeInput             | booleanOutcome  	|
	| "1,2,3,4,5"				  | "false" 	    	|
	| "1,2,3,2,1"				  | "true"	   			|
	| "1,44,4,44,1"				  | "true"	   			|
	| "99,9,2,3,2,9,99"			  | "true"	   			|
	| "1,2,1"					  | "true"	   			|
	| "1"						  | "true"	   			|
	| "1,2,4,5"					  | "false" 	    	|
	| "1,2,5"					  | "false" 	    	|
	| "5,5,1,5,5,5,5"			  | "false" 	    	|


   