package com.leetcode.MayChallenge.week2;

public class FindTownJudge {

	public int findJudge(int N, int[][] trust) {

		int[] trustCount = new int[N + 1];
		for (int i = 0; i < trust.length; i++) {
			trustCount[trust[i][0]]--;
			trustCount[trust[i][1]]++;

		}

		for (int i = 1; i <= N; i++) {
			if (trustCount[i] == N - 1)
				return i;
		}
		return -1;

	}

	public static void main(String[] args) {

		int trust[][] = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		int trust1[][] = { { 1, 2 }, { 2, 3 } };
		int trust2[][] = { { 1, 2 } };
		int trust3[][] = { { 1, 3 }, { 2, 3 } };
		int trust4[][] = { { 1, 3 }, { 2, 3 }, { 3, 1 } };

		System.out.println(new FindTownJudge().findJudge(2, trust2));
		System.out.println(new FindTownJudge().findJudge(3, trust3));
		System.out.println(new FindTownJudge().findJudge(3, trust4));
		System.out.println(new FindTownJudge().findJudge(3, trust1));
		System.out.println(new FindTownJudge().findJudge(4, trust));

	}
}
