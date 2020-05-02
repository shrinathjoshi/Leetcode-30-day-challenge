package com.leetcode.MayChallenge.week1;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        //Binary Search
        int low =1;
        int high =n;
        while(high>=low){
            int mid = low + (high-low)/2;
            if(isBadVersion(mid)){
                high=mid-1;
            }
            else low=mid+1;
        }

        return low;
    }
}