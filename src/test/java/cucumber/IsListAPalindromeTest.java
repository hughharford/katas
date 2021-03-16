package cucumber;

import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import com.posco.codesignal.removeKfromList.ListNode;
import com.posco.codesignal.removeKfromList.RemoveKFromList;
import com.posco.codesignal.isListPalindrome.*;

public class IsListAPalindromeTest {

	private String inputForLinkedList;
	private ListNode<Integer> inputList;
	private ListNode<Integer> safetyList;


	private CheckIfListIsAPalindrome pal = new CheckIfListIsAPalindrome();
	
	private boolean showDebug = true;

	@Given("an input for Palindrome {string}")
	public void an_input_linkedlist(String inputListAsString) throws Throwable {
		this.inputForLinkedList = inputListAsString;
		this.inputList = createLinkedListFromString(inputListAsString);
		// this.safetyList = createLinkedListFromString(inputListAsString);

		
		// System.out.println("input string: " + inputListAsString);
	}
	
	@When("a check is made to see if its a palindrome")
	public void check_made_to_see_if_palindrome() throws Throwable {
		// done in the comparison below 
	}
	
	@Then("the output expected is {string}")
	public void compare_outcome_with_expected(String booleanAsString) throws Throwable {
		boolean sourcedResult = Boolean.valueOf(booleanAsString);
		
		System.out.println("intended: " + sourcedResult + ", " 
				+ inputForLinkedList);
//			    + pal.getIsListPalindrome(inputList));
	
		assertEquals("should be: (" + sourcedResult + ", " 
				+ inputForLinkedList + ")"
				, pal.getIsListPalindrome(inputList)
				, sourcedResult);
		
	}
	
	boolean CompareLists(ListNode<Integer> headA, ListNode<Integer> headB) {
        while (headA != null && headB != null) 
        { 
            if (headA.value != headB.value) 
                return false; 
  
            /* If we reach here, then a and b are not null 
               and their data is same, so move to next nodes 
               in both lists */
            headA = headA.next; 
            headB = headB.next; 
        } 
  
        // If linked lists are identical, then 'a' and 'b' must 
        // be null at this point. 
        return (headA == null && headB == null); 
	}

	
	public ListNode<Integer> createLinkedListFromString(String inputString) {
		ListNode<Integer> listStart;
		List<Integer> ArrayListGiven;
		try {
			ArrayListGiven = Arrays.stream(inputString.split(", ?"))
					.map(Integer::parseInt)
					.collect(Collectors.toList());
		} catch (Exception NumberFormatException) {
			ArrayListGiven = new ArrayList<>();
			// ArrayListGiven.add(null);
			if (showDebug) System.out.println("ERROR FOUND");
		}
		
		if (ArrayListGiven.size() == 0) {
			if (showDebug) System.out.println("given array's size == 0");

			listStart = new ListNode<>(0);
			listStart.value = null;
			return listStart;
		} 
	    // System.out.println(ArrayListGiven.toString());
	    listStart = arrayToList(ArrayListGiven, ArrayListGiven.size());
	    // display(listStart);
		return listStart;
	}
	
	static ListNode<Integer> arrayToList(List<Integer> ArrayIn, int n) 
	{ 
		ListNode<Integer> root = null; 
	    for (int i = 0; i < n; i++) {
	        root = insert(root, ArrayIn.get(i)); 
	    }

	    return root; 
	    
	} 
	
	static ListNode<Integer> insert(ListNode<Integer> root, int item) 
	{ 
		ListNode<Integer> temp = new ListNode<>(item); 
		ListNode<Integer> ptr; 
	  
	    if (root == null) 
	        root = temp; 
	    else 
	    { 
	        ptr = root; 
	        while (ptr.next != null) 
	            ptr = ptr.next; 
	        ptr.next = temp; 
	    } 
	    return root; 
	} 
	
	static void display(ListNode<Integer> root) 
	{ 
	    while (root != null)  
	    { 
	        System.out.print( root.value + " "); 
	        root = root.next; 
	    } 
	    System.out.println();
	} 

}
