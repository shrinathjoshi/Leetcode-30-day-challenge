package week1.day3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {

	public int findPairs(int[] nums, int k) {

//		return findPairsUsingHashMap(nums, k);
		return findPairsUsingTwoPointer(nums, k);
	}

	private int findPairsUsingTwoPointer(int[] nums, int k) {
		// Time Complexity :- O(nlogn)
		// Space Complexity :- O(1)

		int result = 0;

		Arrays.sort(nums);
		int left = 0;
		int right = 0;

		for (left = 0, right = 0; left < nums.length; left++) {

			for (right = left + 1; right < nums.length && nums[right] - nums[left] < k; right++)
				;
			if (right < nums.length && nums[right] - nums[left] == k)
				result++;
			while (left < nums.length - 1 && nums[left] == nums[left + 1])
				left++;
		}

		return result;
	}

	public int findPairsUsingHashMap(int[] nums, int k) {

		// Time Complexity :- O(n)
		// Space Complexity :- O(n)

		int result = 0;

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);

		for (Integer num : map.keySet()) {
			if (k == 0 && map.get(num) > 2) {
				result++;
			}
			if (k > 0 && map.containsKey(num + k))
				result++;
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 }, k = 3;

		System.out.println(new KDiffPairsInArray().findPairs(nums, k));
	}

}
