#Author: hugh.harford@poscoconsulting.com
#Keywords Summary :
@codeSignal.mergeLists
Feature: Merge Two Lists
#Scenario: Can we merge 2 lists in non decreasing order correctly?
@basicScenario
Scenario Outline: Merge 2 lists in non-decreasing order
   Given two inputLists for non-decreasing order merge <list1> and <list2>
   When a non-decreasing order merge is performed
   Then the merge result is <mergeListAnswer>
Examples: Pairs of Lists to Merge and intended output 
	| list1             	| list2  							| mergeListAnswer  						|
	| "1, 2, 3"						| "4, 5, 6"						| "1, 2, 3, 4, 5, 6"					|
	| "1, 1, 2, 4"				|	"0, 3, 5"						| "0, 1, 1, 2, 3, 4, 5"				|
	| "5, 10, 15, 40"			| "2, 3, 20"					| "2, 3, 5, 10, 15, 20, 40" 	|
	| "1, 1"							| "2, 4"							| "1, 1, 2, 4"								|
	| ""									| "1, 1, 2, 2, 4, 7, 7, 8" | "1, 1, 2, 2, 4, 7, 7, 8" |
	| ""									| ""									| ""													|
	| "1,1,4"							| ""									| "1, 1, 4"										|
	| "1, 1"							| "0"									| "0, 1, 1"										|
	| "0"									| "2"									| "0, 2"											|
	| "1"									| "-1000000000, 1000000000" | "-1000000000, 1, 1000000000" |
	| "-1, -1, 0, 1"			| "-1, 0, 0, 1, 1"		| "-1, -1, -1, 0, 0, 0, 1, 1, 1" |
	| "-780990573, -670826849, -404817961, 242026249, 731519938" | "-815817641, -426491047, 437929670, 520408640" | "-815817641, -780990573, -670826849, -426491047, -404817961, 242026249, 437929670, 520408640, 731519938" |