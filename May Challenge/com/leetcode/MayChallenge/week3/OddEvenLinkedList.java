package com.leetcode.MayChallenge.week3;

/**
 * 
 * @author Shrinath Joshi
 *
 *		Time complexity :- O(n)
 *		Space complexity :- O(1)
 */

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {

		if (head == null)
			return null;

		if (head.next == null)
			return head;

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenStart = even;

		while (odd.next != null && odd.next.next != null && even != null) {
			odd.next = odd.next.next;
			odd = odd.next;
			even.next = even.next.next;
			even = even.next;
		}

		odd.next = evenStart;

		return head;

	}

	public static void main(String[] args) {
		// [1,2,3,4,5]
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		OddEvenLinkedList ll = new OddEvenLinkedList();

		ListNode result = ll.oddEvenList(head);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

		System.out.println();

		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(1);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(5);
		head1.next.next.next.next = new ListNode(6);
		head1.next.next.next.next.next = new ListNode(4);
		head1.next.next.next.next.next.next = new ListNode(7);

		ListNode result1 = ll.oddEvenList(head1);
		while (result1 != null) {
			System.out.print(result1.val + " ");
			result1 = result1.next;
		}

	}

}
