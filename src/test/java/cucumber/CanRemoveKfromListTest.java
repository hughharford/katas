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
//import com.posco.codesignal.removeKfromList.ListNode;

public class CanRemoveKfromListTest {

	private String inputForLinkedList;
	private String forExpectedOutput;
	private ListNode<Integer> inputList;
	private ListNode<Integer> expectedList;
	private ListNode<Integer> outputList;
	private ListNode<Integer> safeUnchangedList;

	private RemoveKFromList rem = new RemoveKFromList();
	private int key;
	private boolean showDebug1 = false;
	private boolean showDebug2 = false;
	private boolean showDebug3 = false;


	@Given("an input {string}")
	public void an_input_linkedlist(String inputListAsString) throws Throwable {
		this.inputForLinkedList = inputListAsString;
		this.inputList = createLinkedListFromString(inputListAsString);
		// for safety
		this.safeUnchangedList = createLinkedListFromString(inputListAsString);
		
		if (showDebug3) {
			System.out.println("input string: " + inputListAsString);
			System.out.print("inputList: ");
			rem.outputList(inputList);
			System.out.println();
		}
	}

	@Given("a {int} to be removed")
	public void a_key_for_removal(Integer keyAsString) throws Throwable {
		this.key = keyAsString;
	}
	
	@When("the linkedlist has the key removed")
	public void the_linkedlist_has_the_key_removed() throws Throwable {
		outputList = rem.deleteNode(inputList, key);
	}
	
	@Then("the returned output should be {string}")
	public void the_returned_output_should_be(String outputExpectedListAsString) throws Throwable {
		this.expectedList = createLinkedListFromString(outputExpectedListAsString);
		
		if (!CompareLists(outputList,expectedList)) {
			System.out.print("safeUnchangedList: ");
			rem.outputList(safeUnchangedList);
			System.out.println();
			System.out.print("expectedList: ");
			rem.outputList(expectedList);
			System.out.println();
			System.out.print("outputList: ");
			rem.outputList(outputList);
			System.out.println();
			System.out.println("Compare: " + CompareLists(outputList,expectedList));
			System.out.println("\n");
		}
		assertTrue("lists not equal: (input: " + inputForLinkedList +")", CompareLists(outputList,expectedList));
	}
	

	boolean CompareLists(ListNode<Integer> headA, ListNode<Integer> headB) {
        while (headA != null && headB != null) 
        { 
        	if (showDebug3) System.out.println(headA.value + ", " + headB.value);
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


	@ParameterType("\\[([0-9, ]*)\\]")
	public List<Integer> listOfIntegers2(String integers) {
		return Arrays.stream(integers.split(", ?"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());

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
			if (showDebug3) System.out.println("ERROR FOUND");
		}
		
		if (ArrayListGiven.size() == 0) {
			if (showDebug3) System.out.println("given array's size == 0");

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
