package com.leetcode.MayChallenge.week1;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {

	public int majorityElement(int[] nums) {
	    //    return majorityElementUsingHashMap(nums);
		// 	  return majorityElementUsingSorting(nums);
		// 	  return majorityElementUsingDivideAndConquer(nums);
		return majorityElementUsingBoyerMooreVotingAlgorithm(nums);
		
	 }

	private int majorityElementUsingBoyerMooreVotingAlgorithm(int[] nums) {
		//Time complexity :- O(n)
		//Space complexity :- O(1)
		
		int count=0;
		Integer candiate=null;
		
		for(int i=0;i<nums.length;i++) {
			if(count == 0 ) {
				candiate = nums[i];
			}
		count+= (nums[i] ==candiate)?1:-1;
		}
		return candiate;
	}

	private int majorityElementUsingDivideAndConquer(int[] nums) {
		
		// Time complexity :- O(nlogn) 
		// Recurrance Relation T(n) = 2T(n/2)+2n
		
		//Space complexity :- O(logn) - recursive stack
		return majorityElementUsingDivideAndConquerRecusion(nums,0,nums.length-1);
	}

	private int majorityElementUsingDivideAndConquerRecusion(int[] nums, int left, int right) {
		
		if(left == right)
			return nums[left];
		
		int mid = left + (right-left)/2;
		int leftAns = majorityElementUsingDivideAndConquerRecusion(nums,left, mid);
		int rightAns = majorityElementUsingDivideAndConquerRecusion(nums,mid+1,right);
		
		if(leftAns == rightAns)
			return leftAns;
		else
		{
			int leftAnsCount = getCount(leftAns,left,right,nums);
			int rightAnsCount = getCount(rightAns,left,right,nums);
			
			return leftAnsCount>rightAnsCount?leftAns:rightAns;
		}
	
	}

	private int getCount(int ans, int left, int right, int[] nums) {
		int count=0;
		for(int i =left;i<=right;i++) {
			if(nums[i] == ans)
				count++;
		}
		return count;
	}

	private int majorityElementUsingSorting(int[] nums) {

		// Time complexity :- O(nlogn)
		// Space complexity : - O(1)
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	private int majorityElementUsingHashMap(int[] nums) {

		// Time complexity:- O(n)
		// Space complexity:- O(n)

		int n = nums.length;

		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
			if (counts.get(nums[i]) > n / 2)
				return nums[i];
		}

		return -1;
	}

	public static void main(String[] args) {
		int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(new MajorityElement().majorityElement(nums));
	}

}
