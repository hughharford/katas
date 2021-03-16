package com.posco.codesignal.addHugeNumbers;

import com.posco.codesignal.removeKfromList.ListNode;
import com.posco.codesignal.removeKfromList.RemoveKFromList;


public class AddHugeNumbers {

	public ListNode<Integer> getAddTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
		return addTwoHugeNumbers(a, b);
	}
	
	ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
		boolean showDetail = false;
        
		/*
		if (showDetail) {
			System.out.print("a: ");
			display(a);
			System.out.print("b: ");
			display(b);
			System.out.println();
		}
		*/

		a = reverseList(a);
		b = reverseList(b);

		/*
		if (showDetail) {
			System.out.print("a': ");
			display(a);
			System.out.print("b': ");
			display(b);
			System.out.println();
		}
		*/
		
		ListNode<Integer> tail = null;
		ListNode<Integer> root = tail; 
		
		int remainder = 0;
		int result = 0;
		
        while (a != null | b != null) 
        { 
        	if (showDetail) if (a!=null) System.out.println("a.value = " + a.value);
        	if (showDetail) if (b!=null) System.out.println("b.value = " + b.value);
        	
        	if (root == null) {
        		if (showDetail) System.out.println("adding");

        		int[] adding = checkAdditionForRemainders(getValueToAdd(a), getValueToAdd(b), remainder);
        		result = adding[0];
        		remainder = adding[1];
        		
				root = new ListNode<>(result);
				tail = root;

				if (showDetail) System.out.println("intended result: " + result
						+ " and thisR: " + remainder);
			} else {
				if (showDetail) System.out.println("adding2");
				
				int[] adding2 = checkAdditionForRemainders(getValueToAdd(a), getValueToAdd(b), remainder);
				result = adding2[0];
				remainder = adding2[1];
				tail.next = new ListNode<>(result);
				tail = tail.next;
				
				if (showDetail) System.out.println("actual input: " + result 
						+ " and thisR: " + remainder);
			}
            /* If we reach here, then a and b are not null 
               and their data is same, so move to next nodes 
               in both lists */
			if (a!=null) a = a.next;
            if (b!=null) b = b.next; 

        } 
        
        if (remainder > 0) {
			tail.next = new ListNode<>(remainder);
			tail = tail.next;
        }
        
        /*
        if (showDetail) System.out.print("root given: ");
        if (showDetail) display(root);
		*/
		return reverseList(root);
	}
	
	static int[] checkAdditionForRemainders(int a, int b, int c) {
		
		int thisRemainder = 0;
    	int thisResult = a + b + c;
    	
    	if (thisResult > 9999) {
    		thisRemainder = thisResult - 9999;
    		thisResult = thisResult - thisRemainder - 9999;
    	}
    	return new int[] {thisResult, thisRemainder};
	}
	
	static int getValueToAdd(ListNode<Integer> a) {
		int aToAdd;
		if (a != null) aToAdd = a.value;
		else aToAdd = 0;
		return aToAdd;
	}
	
	static int addUp(ListNode<Integer> a, ListNode<Integer> b) {
		
		int aToAdd, bToAdd;
		if (a != null) aToAdd = a.value;
		else aToAdd = 0;
		if (b != null) bToAdd = b.value;
		else bToAdd = 0;
		return aToAdd + bToAdd;
	}
	
	static ListNode<Integer> reverseList(ListNode<Integer> head) {
	    ListNode<Integer> previous = null;
	    ListNode<Integer> current = head;
	    ListNode<Integer> temp = null;
	    
	    while (current != null) {
	    	temp = current.next;
	        current.next = previous;
	        previous = current;
	        current = temp;
	    }
	    return previous;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
