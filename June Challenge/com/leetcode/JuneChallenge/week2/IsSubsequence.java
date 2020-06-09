package com.leetcode.JuneChallenge.week2;

public class IsSubsequence {

	public boolean isSubsequence(String s, String t) {
		// Base Condition
		if (s.length() == 0 && t.length() != 0)
			return true;

		if (s.length() > t.length())
			return false;

		int firstPointer = 0;
		int secondPointer = 0;

		while (firstPointer < s.length() && secondPointer < t.length()) {

			if (s.charAt(firstPointer) == t.charAt(secondPointer)) {
				firstPointer++;
				secondPointer++;
			} else
				secondPointer++;
		}

		return firstPointer == s.length();
	}

	public static void main(String[] args) {

		String s = "abc", t = "ahbgdc";
		System.out.println(new IsSubsequence().isSubsequence(s, t));
	}

}
