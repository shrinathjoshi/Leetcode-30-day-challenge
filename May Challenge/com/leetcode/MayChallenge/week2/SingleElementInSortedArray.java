package com.leetcode.MayChallenge.week2;

public class SingleElementInSortedArray {

	public int singleNonDuplicate(int[] nums) {
		
	//	return singleNonDuplicateUsingXOR(nums);
		
		return singleNonDuplicateUsingTwoPointer(nums);
	}

	private int singleNonDuplicateUsingTwoPointer(int[] nums) {
		
		if(nums.length == 1) return nums[0];
		
		int low = 0 ;
		int high = nums.length-1;
		
		while(low<=high) {
			
			if(nums[low] != nums[low+1])
				return nums[low];
			if(nums[high] != nums[high-1])
				return nums[high];
			
			low=low+2;
			high=high-2;
		}
		return -1;
	}

	private int singleNonDuplicateUsingXOR(int[] nums) {
		//Time Complexity :- O(n)
		//Space Complexity :- O(1)
		
		int x =0;
		for(int i : nums)
			x=x^i;
		return x;
	}

	public static void main(String[] args) {
		int nums[] = { 1};
		int nums1[] = { 3, 3, 7, 7, 10, 11, 11 };
		

		System.out.println(new SingleElementInSortedArray().singleNonDuplicate(nums));
		System.out.println(new SingleElementInSortedArray().singleNonDuplicate(nums1));
		
	}

}
