package com.leetcode.JuneChallenge.week1;

import java.util.Arrays;

public class QueueReconstructionByHeight {

	public int[][] reconstructQueue(int[][] people) {
		int n = people.length;
		int result[][] = new int[n][2];

		for (int i = 0; i < n; i++) {
			result[i][0] = -1;
			result[i][1] = -1;
		}

		Arrays.sort(people, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);

		for (int i = 0; i < n; i++) {
			int count = people[i][1];
			for (int j = 0; j < n; j++) {
				if (count == 0 && result[j][0] == -1) {
					result[j][0] = people[i][0];
					result[j][1] = people[i][1];
					break;
				} else if (result[j][0] >= people[i][0] || result[j][0] == -1) {
					count--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {

		int people[][] = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

		int result[][] = new QueueReconstructionByHeight().reconstructQueue(people);

		for (int i = 0; i < result.length; i++) {
			System.out.print("[" + result[i][0] + "," + result[i][1] + "]");
			System.out.println(" ");
		}

//		{{5,0},{6,1},{5,2},{7,0},{4,4},{7,1}}
	}

}
