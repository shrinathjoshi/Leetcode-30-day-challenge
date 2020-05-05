package com.leetcode.MayChallenge.week1;

import java.util.LinkedHashMap;


/**
 * @author Shrinath Joshi
 *		Time complexity :- O(n)
 *		Space complexity :- O(n)
 */

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        
    	LinkedHashMap<Character, Integer> cache = new LinkedHashMap<Character, Integer>();
    	int n = s.length();
    	
    	for(int i=0;i<n;i++) {
    		char c = s.charAt(i);
    		cache.put(c, cache.getOrDefault(c, 0)+1);
    	}
    	
    	for(int i =0;i<n;i++) {
    		char c = s.charAt(i);
    		if(cache.get(c)==1) return i;
    	}
    	
    	return -1;
    }

	public static void main(String[] args) {
		System.out.println(new FirstUniqueCharacterInString().firstUniqChar("leetcode"));
		System.out.println(new FirstUniqueCharacterInString().firstUniqChar("loveleetcode"));

	}

}
