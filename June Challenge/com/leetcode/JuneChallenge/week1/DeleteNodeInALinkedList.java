package com.leetcode.JuneChallenge.week1;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

/**
 * @author Shrinath Joshi
 * 
 *         Time complexity :- O(1)
 * 
 *         Space complexity :- O(1)
 *
 */

public class DeleteNodeInALinkedList {

	public void deleteNode(ListNode node) {
		ListNode curr = node;
		ListNode temp = node;
		curr.val = curr.next.val;
		temp = curr.next;
		curr.next = curr.next.next;
		temp.next = null;
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode five = new ListNode(5);
		ListNode four = new ListNode(4);
		ListNode nine = new ListNode(9);

		one.next = five;
		five.next = four;
		four.next = nine;

	}

}
