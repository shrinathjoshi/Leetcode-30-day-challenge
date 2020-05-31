package com.leetcode.MayChallenge.week4;

public class CountingBits {
	public int[] countBits(int num) {
		int result[] = new int[num + 1];

		for (int i = 1; i <= num + 1; i++)
			result[i] = result[i / 2] + i % 2;

		return result;
	}

	public static void main(String[] args) {
		int[] result = new CountingBits().countBits(12);

		for (int i : result)
			System.out.print(i + " ");
	}

}
