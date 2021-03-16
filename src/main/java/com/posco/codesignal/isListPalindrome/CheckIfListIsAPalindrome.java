package com.posco.codesignal.isListPalindrome;

import com.posco.codesignal.removeKfromList.ListNode;
import com.posco.codesignal.removeKfromList.RemoveKFromList;

public class CheckIfListIsAPalindrome {

	// Singly-linked lists are already defined with this interface:
	// class ListNode<T> {
	//   ListNode(T x) {
//	     value = x;
	//   }
	//   T value;
	//   ListNode<T> next;
	// }
	//
	
	public boolean getIsListPalindrome(ListNode<Integer> l) {
		return isListPalindrome(l);
	}
	
	boolean isListPalindrome(ListNode<Integer> l) {
		
		ListNode<Integer> copiedList = manualCopyList(l);
		ListNode<Integer> reversedList = reverseList(l);

		return CompareLists(reversedList, copiedList);
	}
	
	static ListNode<Integer> manualCopyList(ListNode<Integer> l) {
		
		ListNode<Integer> current = l;
		ListNode<Integer> copiedList = null;
		ListNode<Integer> tail = null;

		while (current != null) 
		{
			if (copiedList == null) {
				copiedList = new ListNode<>(current.value);
				tail = copiedList;
			} else {
				tail.next = new ListNode<>(current.value);
				tail = tail.next;
				// tail.next = null;
			}
			current = current.next;
		}
		return copiedList;
	}
	
	static boolean CompareLists(ListNode<Integer> headA, ListNode<Integer> headB) {
        while (headA != null && headB != null) 
        { 
        	// System.out.println(headA.value + ", " + headB.value);
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
