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
import com.posco.codesignal.mergeLists.MergeTwoLists;

public class CanMergeTwoListsTest {

	private String inputForLinkedList;
	private ListNode<Integer> list1;
	private ListNode<Integer> list2;
	private ListNode<Integer> calcAnswerList;

	private ListNode<Integer> answerExpectedList;


	private MergeTwoLists m = new MergeTwoLists();
	
	private boolean showDebug = false;

	@Given("two inputLists for non-decreasing order merge {string} and {string}")
	public void two_input_linkedlists(String stringList1, String stringList2) throws Throwable {
		System.out.println();
		System.out.println();
		System.out.println("stringList1 = " + stringList1 + " and stringList2 = " + stringList2);
		
		this.list1 = createLinkedListFromString(stringList1);
		this.list2 = createLinkedListFromString(stringList2);

	}
	
	@When("a non-decreasing order merge is performed")
	public void non_decreasing_merge_performed() throws Throwable {
		// done in the comparison below 
		this.calcAnswerList = m.getMergeTwoLinkedLists(list1,list2);
		if (showDebug) System.out.print("calcAnswerList gives: ");
		if (showDebug) display(calcAnswerList);
	}
	
	@Then("the merge result is {string}")
	public void compare_merge_outcome_with_expected(String stringMergeListAnswer) throws Throwable {
		this.answerExpectedList = createLinkedListFromString(stringMergeListAnswer);
		if (showDebug) System.out.print("answerExpectedList: ");
		if (showDebug) display(answerExpectedList);
	
		assertTrue("should be: (" + stringMergeListAnswer + ")"
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

			// listStart = new ListNode<>(0);
			// listStart.value = null;
			// return listStart;
			return null;
		} else {
	    // System.out.println(ArrayListGiven.toString());
			listStart = arrayToList(ArrayListGiven, ArrayListGiven.size());
		}
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
