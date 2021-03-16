#Author: hugh.harford@poscoconsulting.com
#Keywords Summary :
@codeSignal.removeKfromList
Feature: Add Two Huge Numbers
#Scenario: Can we handle enormous numbers correctly?
@basicScenario
Scenario Outline: Basic large number addition
   Given two inputLists for huge number addition <numberA> and <numberB>
   When a huge number addition operation is performed
   Then the additions answer is <hugeNumberAnswer>
Examples:
	| numberA             	| numberB  			| hugeNumberAnswer  			|
	| "9876, 5432, 1999"	| "1, 8001"			| "9876, 5434, 0"				|
	| "123, 4, 5"			| "100, 100, 100"	| "223, 104, 105"				|
	| "0"					| "0"				| "0"							|
	| "1234, 1234, 0"		| "0"				| "1234, 1234, 0"				|
	| "0"					| "1234, 123, 0"	| "1234, 123, 0"				|
	| "1"					| "9998, 9999, 9999, 9999, 9999, 9999" | "9999, 0, 0, 0, 0, 0" |
	| "1"					| "9999, 9999, 9999, 9999, 9999, 9999" | "1, 0, 0, 0, 0, 0, 0" |
	| "8339, 4510"			| "2309"			| "8339, 6819"					|
