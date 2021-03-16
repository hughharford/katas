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
import com.posco.codesignal.addHugeNumbers.*;

public class CanAddHugeNumbersTest {

	private String inputForLinkedList;
	private ListNode<Integer> numberAList;
	private ListNode<Integer> numberBList;
	private ListNode<Integer> calcAnswerList;

	private ListNode<Integer> answerExpectedList;


	private AddHugeNumbers add = new AddHugeNumbers();
	
	private boolean showDebug = false;

	@Given("two inputLists for huge number addition {string} and {string}")
	public void an_input_linkedlist(String numberA, String numberB) throws Throwable {
		System.out.println();
		System.out.println();
		System.out.println("numberA = " + numberA + " and numberB = " + numberB);
		
		this.numberAList = createLinkedListFromString(numberA);
		this.numberBList = createLinkedListFromString(numberB);

	}
	
	@When("a huge number addition operation is performed")
	public void check_made_to_see_if_palindrome() throws Throwable {
		// done in the comparison below 
		this.calcAnswerList = add.getAddTwoHugeNumbers(numberAList,numberBList);
		if (showDebug) System.out.print("calcAnswerList gives: ");
		display(calcAnswerList);
	}
	
	@Then("the additions answer is {string}")
	public void compare_outcome_with_expected(String additionAnswer) throws Throwable {
		this.answerExpectedList = createLinkedListFromString(additionAnswer);
		if (showDebug) System.out.print("answerExpectedList: ");
		if (showDebug) display(answerExpectedList);
	
		assertTrue("should be: (" + additionAnswer + ")"
				, CompareLists(answerExpectedList, calcAnswerList));
		
	}
	
	boolean CompareLists(ListNode<Integer> headA, ListNode<Integer> headB) {
        while (headA != null && headB != null) 
        { 
        	// System.out.println(headA.value + "," + headB.value);
            if (!headA.value.equals(headB.value)) 
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
	
	static void displayInteger(ListNode<Integer> root) 
	{ 
		String output = "";
		int len = 0;
	    while (root != null)  
	    { 
	        System.out.print(root.value); 
	        root = root.next; 
	    } 
	    System.out.println();
	} 

}
