package com.leetcode.MayChallenge.week2;

/*
 * @author Shrinath Joshi
 * 
 * 		Time complexity:- O(kn)
 * 		Space complexity :- O(1)
 * 
 */

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		return removeKdigit(num, k);
	}

	private String removeKdigit(String num, int k) {

		int n = num.length();

		if (n == k)
			return "0";

		StringBuilder sb = new StringBuilder(num);

		for (int i = 0; i < k; i++) {
			int index = 0;
			while (index < sb.length() - 1 && sb.charAt(index) <= sb.charAt(index + 1))
				index++;

			sb.delete(index, index + 1);
		}

		while (sb.length() > 1 && sb.charAt(0) == '0')
			sb.delete(0, 1);

		if (sb.length() == 0)
			return "0";

		return sb.toString();

	}


	public static void main(String[] args) {

		String num = "1432219";
		int k = 3;
		
		String num1 = "5337";
		int k1 = 2;

		System.out.println(new RemoveKDigits().removeKdigits(num, k));
		System.out.println(new RemoveKDigits().removeKdigits(num1, k1));

	}

}
