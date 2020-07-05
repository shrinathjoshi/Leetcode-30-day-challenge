
/**
 * Problem Statement :-
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3381/
 * 
 * 
 * Additional Reading:-
 * https://www.techiedelight.com/brian-kernighans-algorithm-count-set-bits-integer/
 * 
 * 
 * 
 */

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int count = 0;

		int result = x ^ y;
		while (result > 0) {
			result = (result & result - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int x = 1;
		int y = 4;
		System.out.println(new HammingDistance().hammingDistance(x, y));
	}

}
