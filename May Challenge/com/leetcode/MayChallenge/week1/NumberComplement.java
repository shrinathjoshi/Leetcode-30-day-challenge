package com.leetcode.MayChallenge.week1;

/**
 * @author Shrinath Joshi 
 * 
 * Time complexity:-
 * 			no of time while loop executes  = log(v) , 
 * 			therefore , TC = log(v) ,where v -  value of number
 */

public class NumberComplement {
	
	public int findComplement(int num) {
		int n =num;
		int bit = 1;
		while(n>0) {
			num=num^bit;
			bit=bit<<1;
			n=n>>1;
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(new NumberComplement().findComplement(12));
	}    
	
}
