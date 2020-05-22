package com.leetcode.MayChallenge.week3;

public class CountSquareSubmatricesWithAllOnes {

	public int countSquares(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		int dp[][] = new int[row][column];

		for (int i = 0; i < row; i++)
			dp[i][0] = matrix[i][0];

		for (int i = 0; i < column; i++)
			dp[0][i] = matrix[0][i];

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (matrix[i][j] == 1) {
					int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
					int finalMin = Math.min(min, dp[i - 1][j - 1]);
					dp[i][j] = finalMin + 1;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				if (dp[i][j] >= 1)
					result += dp[i][j];

		return result;

	}

	public static void main(String[] args) {
		int matrix[][] = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(matrix));

		int matrix1[][] = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(matrix1));

	}

}
