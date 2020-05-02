package com.leetcode.AprilChallenge.week4;

import java.util.HashMap;

public class SubarraySumEqualToK {

	 public static void main(String[] args) {
		int nums[]= {1,1,1};
		int k=2;
		
		System.out.println(new SubarraySumEqualToK().subarraySum(nums,k));
	}

	private int  subarraySum(int[] nums, int k) {
		
		int n = nums.length;
		HashMap<Integer,Integer> hash =  new HashMap<Integer, Integer>();
		hash.put(0,1);
		int count=0;
		int currentSum=0;
		for(int i=0;i<n;i++)
		{
			currentSum=currentSum+nums[i];
			
			if(hash.containsKey(currentSum-k))
			{
				count+=hash.get(currentSum-k);
			}
			hash.put(currentSum, hash.getOrDefault(currentSum, 0)+1);
			
		}
		
		return count;
		
	}
}
