package com.leetcode.AugustChallenge.week1;

/*
https://leetcode.com/problems/detect-capital/
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False


 */
public class DetectCapital {

	// Time Complexity :- O(n)
	// Space Complexity :- O(1)
	public boolean detectCapitalUse(String word) {
		int n = word.length();
		if (n == 1)
			return true;

		if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
			for (int i = 2; i < n; i++) {
				if (Character.isLowerCase(word.charAt(i)))
					return false;
			}
		} else {
			for (int i = 1; i < n; i++) {
				if (Character.isUpperCase(word.charAt(i)))
					return false;
			}
		}
		return true;
	}

	public boolean detectCapitalUseUsingRegex(String word) {
		return word.matches("[A-Z]*|.[a-z]*");
	}
}
