/**
 * @author Shrinath Joshi
 * 
 *         Problem Statement
 *         https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3521/
 *
 */
public class FindSmallestDivisorGivenThreshold {
	public int smallestDivisor(int[] nums, int threshold) {
		int left = 1, right = (int) 1e6;

		while (left < right) {
			int m = (left + right) / 2;

			int sum = 0;
			for (int num : nums)
				sum += (num + m - 1) / m;

			// System.out.println("Sum "+sum+" when m "+m +" with left "+ left + " and right
			// "+right);
			if (sum <= threshold)
				right = m;
			else
				left = m + 1;
		}

		return left;
	}

}
