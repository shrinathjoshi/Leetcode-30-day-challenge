package com.leetcode.MayChallenge.week2;

public class ValidPerfectSquare {

	public boolean isPerfectSquare(int num) {
		//return (Math.sqrt(num)%Math.ceil(Math.sqrt(num))==0);
		
		return isPerfectSquareWithoutInbuiltFunctions(num);
		
	}
	
	private boolean isPerfectSquareWithoutInbuiltFunctions(int num) {

		if(num<=0) return false;
		if(num == 1) return true;
		
		
		double low=1;
		double high = num;
		
		while(high>=low) {
			double mid = low + Math.floor((high - low)/2);
			double value = mid*mid;
			if(value == num)
				return true;
			else if(value > num)
				high=mid-1;
			else low = mid+1;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
		System.out.println(new ValidPerfectSquare().isPerfectSquare(19));
		System.out.println(new ValidPerfectSquare().isPerfectSquare(26));
		System.out.println(new ValidPerfectSquare().isPerfectSquare(2147483647));
		
	}

}
