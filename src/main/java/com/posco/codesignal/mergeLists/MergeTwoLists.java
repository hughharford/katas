package com.posco.codesignal.mergeLists;

import com.posco.codesignal.removeKfromList.ListNode;


public class MergeTwoLists {

	public	ListNode<Integer> getMergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		return mergeTwoLinkedLists(l1, l2);
	}
	
	ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		boolean showDetail = false;
		
		ListNode<Integer> result = null;
		ListNode<Integer> tail = null;
		int lesser;

		while (l1 != null || l2 != null) {

			if (l1 != null && l2 != null) {

				if (showDetail) System.out.println("l1.value = " + l1.value + " l2.value = " + l2.value);
				if (l1.value <= l2.value) {
					lesser = l1.value;
					l1 = l1.next;
				} else {
					lesser = l2.value;
					l2 = l2.next;
				}

			} else if (l2 == null) {
				lesser = l1.value;
				l1 = l1.next;
			} else {
				lesser = l2.value;
				l2 = l2.next;
			}

			if (showDetail) System.out.println("lesser = " + lesser);
			if (result == null) {
				result = new ListNode<>(lesser);
				tail = result;
			} else {
				tail.next = new ListNode<>(lesser);
				tail = tail.next ;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
