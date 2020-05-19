package com.leetcode.MayChallenge.week3;

/*
 * @author Shrinath Joshi
 * 
 * 		Time complexity :-O(n)
 * 		Space complexity :- O(1)
 * 
 * 
 */

public class MaximumSumCircularSubarray {

	public int maxSubarraySumCircular(int[] A) {

		int n = A.length;
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		int minSoFar = Integer.MAX_VALUE;
		int minEndingHere = 0;
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			maxEndingHere = maxEndingHere + A[i];
			if (maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
			if (maxEndingHere < 0)
				maxEndingHere = 0;

			totalSum += A[i];

			minEndingHere = minEndingHere + A[i];
			if (minSoFar > minEndingHere)
				minSoFar = minEndingHere;

			if (minEndingHere > 0)
				minEndingHere = 0;

		}

		if (totalSum == minSoFar)
			return maxSoFar;
		else
			return Math.max(maxSoFar, totalSum - minSoFar);
	}

	public static void main(String[] args) {
		int A[] = { 1, -2, 3, -2 };
		int B[] = { 5, -3, 5 };
		int C[] = { 3, -1, 2, -1 };
		int D[] = { 3, -2, 2, -3 };
		int E[] = { -2, -3, -1 };

		System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(A));
		System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(B));
		System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(C));
		System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(D));
		System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(E));

	}

}
