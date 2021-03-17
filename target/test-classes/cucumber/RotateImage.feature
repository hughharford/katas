#Author: hugh.harford@poscoconsulting.com
#Keywords Summary :
@codeSignal.rotateImage
Feature: Rotate Image
#Scenario: Can the 2D array be rotated?
@basicScenario
Scenario: Simple test
	Given an n-by-n sorted array
		| a |
		| b |
	When the array is rotated
	Then the target should be returned
		| A |
		| B |
