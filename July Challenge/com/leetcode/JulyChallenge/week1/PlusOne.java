package com.leetcode.JulyChallenge.week1;

/*
 * Time complexity :- O(n)
 * Space complexity :- O(1)
 * 
 * 
 */

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int n = digits.length;

		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}

		int edgeCase[] = new int[n + 1];
		edgeCase[0] = 1;
		return edgeCase;

	}

	public static void main(String[] args) {
		int digits[] = { 4, 3, 2, 1 };
		int digits1[] = { 9, 9, 9, 9 };
		int digits2[] = { 1, 2, 3, 9 };

		int result[] = new PlusOne().plusOne(digits);
		int result1[] = new PlusOne().plusOne(digits1);
		int result2[] = new PlusOne().plusOne(digits2);

		print(result);
		print(result1);
		print(result2);
		System.out.println();

	}

	private static void print(int[] result) {
		for (int i : result)
			System.out.print(i + " ");

		System.out.println();
	}

}
