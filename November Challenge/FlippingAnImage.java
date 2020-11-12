/**
 * @Author Shrinath Joshi
 * 
 *         Problem Statement:-
 *         https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3526/
 * 
 *         Time complexity:- O(n2) Space complexity :- O(n2)
 * 
 */

class FlippingAnImage {
	public int[][] flipAndInvertImage(int[][] A) {
		int column = A[0].length;

		for (int[] row : A) {
			for (int i = 0; i < (column + 1) / 2; i++) {

				if (row[i] == row[column - i - 1])
					row[i] = row[column - i - 1] ^= 1;
			}
		}

		return A;
	}
}
