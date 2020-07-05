package com.leetcode.JuneChallenge.week1;

public class ReverseString {

	// Time complexity :- O(n)
	// space complexity :- O(1)
	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;

		while (left < right) {
			s[left] = (char) (s[left] ^ s[right]);
			s[right] = (char) (s[right] ^ s[left]);
			s[left] = (char) (s[left] ^ s[right]);
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		char s[] = { 'h', 'e', 'l', 'l', 'o' };
		char s1[] = { 'H', 'a', 'n', 'n', 'a', 'h' };

		ReverseString reverseString = new ReverseString();
		reverseString.reverseString(s);
		reverseString.reverseString(s1);

		for (char c : s) {
			System.out.print(c + " ");
		}

		System.out.println();

		for (char c : s1) {
			System.out.print(c + " ");
		}

		System.out.println();

	}

}
