package com.leetcode.MayChallenge.week4;

/**
 * @author Shrinath Joshi
 * 
 *         Time complexity :- O(n*m) 
 *         Space complexity :- O(n*m)
 *
 */
public class UncrossedLines {

	public int maxUncrossedLines(int[] A, int[] B) {
		int aSize = A.length;
		int bSize = B.length;

		if (aSize == 0 || bSize == 0)
			return 0;

		int dp[][] = new int[aSize + 1][bSize + 1];

		for (int i = 1; i < aSize + 1; i++) {
			for (int j = 1; j < bSize + 1; j++) {
				if (A[i - 1] == B[j - 1])
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[aSize][bSize];
	}

	public static void main(String[] args) {
		int A[] = { 2, 5, 1, 2, 5 };
		int B[] = { 10, 5, 2, 1, 5, 2 };
		System.out.println(new UncrossedLines().maxUncrossedLines(A, B));

		int A1[] = { 1, 3, 7, 1, 7, 5 };
		int B1[] = { 1, 9, 2, 5, 1 };
		System.out.println(new UncrossedLines().maxUncrossedLines(A1, B1));

		int A2[] = { 1, 1, 2, 1, 2 };
		int B2[] = { 1, 3, 2, 3, 1 };
		System.out.println(new UncrossedLines().maxUncrossedLines(A2, B2));

	}

}
