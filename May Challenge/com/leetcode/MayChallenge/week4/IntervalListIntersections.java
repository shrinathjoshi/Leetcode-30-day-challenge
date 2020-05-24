package com.leetcode.MayChallenge.week4;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public int[][] intervalIntersection(int[][] A, int[][] B) {

		int a = 0;
		int b = 0;

		List<int[]> result = new ArrayList<int[]>();

		while (a < A.length && b < B.length) {
			int a0 = A[a][0];
			int a1 = A[a][1];

			int b0 = B[b][0];
			int b1 = B[b][1];

			if (a0 <= b1 && a1 >= b0) {
				int u = Math.max(a0, b0);
				int v = Math.min(a1, b1);
				result.add(new int[] { u, v });
			} else if (a0 >= b1 && a1 <= b0) {
				int u = Math.max(a0, b0);
				int v = Math.min(a1, b1);
				result.add(new int[] { u, v });
			}

			if (a1 < b1)
				a++;
			else
				b++;
		}

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {

		int[][] A = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
				B = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

		int result[][] = new IntervalListIntersections().intervalIntersection(A, B);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

}
