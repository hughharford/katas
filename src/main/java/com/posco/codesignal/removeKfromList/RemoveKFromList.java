package com.posco.codesignal.removeKfromList;


public class RemoveKFromList {

	
	// Singly-linked lists are already defined with this interface:
	// class ListNode<T> {
	//   ListNode(T x) {
	//	     value = x;
	//   }
	//   T value;
	//   ListNode<T> next;
	// }
	//
	public ListNode<Integer> removeKFromList(ListNode<Integer> lister, int k) {
		ListNode<Integer> head = lister;
		ListNode<Integer> currentNode = head;
		while(currentNode != null) {
			if (currentNode.value == k) { 
				currentNode.next = currentNode.next;
			}
			currentNode = head.next;
		}
		return head;
	}
	
	public ListNode<Integer>  deleteNode(ListNode<Integer> head, int key) {
		ListNode<Integer>  current = head;
		ListNode<Integer>  prev = new ListNode<>(0);
		int noDeletions = 0;
		int countList = 0;
		
		while(current != null) {
			countList++;
			
			if(countList == 1 && current.value == key) { 
				head = current.next;
				noDeletions++;
				countList = 0;
			} // sorts edge case where first node matches key
			
			if (current.next != null && current.value == key) { 
				prev.next = current.next;  
				noDeletions++;
				
				// skip forward correctly (i.e. avoid rest of the while loop)
				current = current.next;
				continue;
			}   // not really deleting, just skipping in the linked list...
			
			if (current.next == null && current.value == key) { 
				prev.next = null;
				current = null;
				noDeletions++;
			} // sorts edge case where last node matches key
			
			if (current != null) {
				prev = current;
				current = current.next;
			}
			
			if(current == null && noDeletions == 0) { // key not found
				// System.out.println("Key not found to delete" );
			} 
			if (getSize(head) == 0) {
				head = new ListNode<Integer>(0);
				head.value = null;
				// System.out.println("Size got as Zero");
			}
		}
		return head;
	}
	
	public static int getSize(ListNode<Integer> listToCount) {
		int size = 0;
		while(listToCount != null) {
			size++;
			listToCount = listToCount.next;
		}
		return size;
	}
	
	public void outputList(ListNode<Integer> listToConsole) {

		while(listToConsole != null) {
			System.out.print(listToConsole.value + " ");
			listToConsole = listToConsole.next;
		}
	    System.out.println();

	}
	

	
	public static void main(String[] args) {
	
		ListNode<Integer> inputList = new ListNode<>(1000);
		ListNode<Integer> currentNode = inputList;
		int dataValue;
		
		for (int j = 0; j <= 2; j++) {
			if (j+1 != 28) dataValue = j+1;
			else dataValue = 4;
			currentNode.next = new ListNode<>(1000);
			currentNode = currentNode.next;
		}
		
		RemoveKFromList rem = new RemoveKFromList();
		// ListNode<Integer>output = rem.removeKFromList(inputList, 4);
		
		rem.outputList(inputList);
		System.out.println();
		
		// ListNode<Integer> output = 
				// rem.deleteNode(inputList, 1000);
		
		rem.outputList(inputList);
		System.out.println();

		
	}
}


