package com.leetcode.AugustChallenge.week1;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {

		String str = preprocessInputString(s);

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	public String preprocessInputString(String s) {
		int n = s.length();
		s = s.toLowerCase();
		String result = "";
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				result += ch;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(new ValidPalindrome().isPalindrome(s));

	}

}
