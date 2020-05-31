package com.leetcode.MayChallenge.week5;

/**
 * @author Shrinath Joshi
 * 
 *         Time Complexity :- O(n*m)
 * 
 *         Space Complexity :- O(n*m)
 *
 */

public class EditDistance {

	// Bottom Up Approach
	public int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		int dp[][] = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++)
			dp[i][0] = i;

		for (int i = 0; i <= len2; i++)
			dp[0][i] = i;

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
			}
		}
		return dp[len1][len2];

	}

	public static void main(String[] args) {

		String word1 = "intention", word2 = "execution";
		System.out.println(new EditDistance().minDistance(word1, word2));

		String word3 = "horse", word4 = "ros";
		System.out.println(new EditDistance().minDistance(word3, word4));

		String word5 = "", word6 = "r";
		System.out.println(new EditDistance().minDistance(word5, word6));

	}

}
