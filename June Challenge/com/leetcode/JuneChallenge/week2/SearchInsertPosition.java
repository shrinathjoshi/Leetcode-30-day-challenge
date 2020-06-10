package com.leetcode.JuneChallenge.week2;

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		int index = 0;

		while (index < nums.length && nums[index] < target)
			index++;

		return index;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 3, 5, 7 };
		int target = 4;

		System.out.println(new SearchInsertPosition().searchInsert(nums, target));

	}

}
