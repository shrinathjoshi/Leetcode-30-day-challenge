package com.leetcode.MayChallenge.week3;

import java.util.Arrays;

public class PermutationInString {

	public boolean checkInclusion(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length())
			return false;

		int freqCountS1[] = new int[26];
		int freqCountS2[] = new int[26];

		for (int i : s1.toCharArray()) {
			freqCountS1[i - 'a']++;
		}
		
		int n = s1.length();
		int m = s2.length();

		for (int i = 0; i <=(m - n); i++) {
			int left = i;
			int right = i + n;
			for (int j = left; j < right; j++) {
				char currentChar = s2.charAt(j);
				freqCountS2[currentChar - 'a']++;

				if (checkIfEqual(freqCountS1, freqCountS2)) {
					return true;
				}
			}
			Arrays.fill(freqCountS2,0);
		}

		return false;
	}

	private boolean checkIfEqual(int[] freqCountS1, int[] freqCountS2) {
		for (int i = 0; i < freqCountS1.length; i++) if (freqCountS1[i] != freqCountS2[i])return false;
		return true;
	}
	
	public static void main(String[] args) {

		String s1 = "ab";String s2 = "eidbaooo";
		System.out.println(new PermutationInString().checkInclusion(s1, s2));

		String s3 = "ab";
		String s4 = "eidboaoo";

		System.out.println(new PermutationInString().checkInclusion(s3, s4));

		String s5 = "adc";
		String s6 = "dcda";

		System.out.println(new PermutationInString().checkInclusion(s5, s6));

	}

}
