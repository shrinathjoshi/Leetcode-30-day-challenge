package com.leetcode.MayChallenge.week4;

import java.util.HashMap;

/**
 * @author Shrinath Joshi
 * 
 *         Time complexity :- O(n) - all the elements are traversed only once
 * 
 *         Space complexity :- O(n) - additional space for storing count and
 *         		index, the maximum value for count in worst case will be n(i.e either
 *         		all 0 , or all 1)
 *
 */

public class ContigiousArray {
	public int findMaxLength(int[] nums) {
		int count = 0;
		int currentIndex = 0;
		int maxSize = 0;
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

		for (currentIndex = 0; currentIndex < nums.length; currentIndex++) {

			if (nums[currentIndex] == 1)
				count++;
			else
				count--;
			if (count == 0) {
				maxSize = currentIndex + 1;
			}
			if (hash.containsKey(count)) {
				int firstIndex = hash.get(count);
				if (maxSize < (currentIndex - firstIndex))
					maxSize = currentIndex - firstIndex;
			} else
				hash.put(count, currentIndex);

		}
		return maxSize;

	}

	public static void main(String[] args) {
		int nums[] = { 0, 1, 0 };
		System.out.println(new ContigiousArray().findMaxLength(nums));

		int nums1[] = { 0, 1 };
		System.out.println(new ContigiousArray().findMaxLength(nums1));

		int nums2[] = { 0, 1, 0, 0, 1, 1, 0, 1, 0, 1 };
		System.out.println(new ContigiousArray().findMaxLength(nums2));

	}

}
