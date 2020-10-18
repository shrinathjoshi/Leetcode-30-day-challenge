package week3.day15;

/**
 * @author Shrinath Joshi
 *
 *         Problem Statement :-
 *         https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3496/
 *
 */
public class RotateArray {
	// Time Complexity :- O(N)
	// Space Complexity :- O(1)

	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		if (k < 0)
			k = k + n;
		reverse(nums, 0, n - k - 1);
		reverse(nums, n - k, n - 1);
		reverse(nums, 0, n - 1);
	}

	private void reverse(int nums[], int start, int end) {

		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;

			start++;
			end--;
		}

	}
}
