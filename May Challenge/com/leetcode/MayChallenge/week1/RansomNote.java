package com.leetcode.MayChallenge.week1;

import java.util.HashMap;

/*@author Shrinath Joshi
 * 
 * 
 * Time complexity:- O(n+m) 
 * Space complexity - O(m)
 *           n =  length of ransomNote
 *           m =  length of magazine
 */

public class RansomNote {

	public static void main(String[] args) {
		String ransomeNote = "bg";
		String magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";

		System.out.println(new RansomNote().canConstruct(ransomeNote, magazine));
		System.out.println(new RansomNote().canConstructEfficent(ransomeNote, magazine));

	}

	private boolean canConstruct(String ransomNote, String magazine) {

		// Time complexity:- O(n+m) 
		// Space complexity - O(m)
		
		HashMap<Character, Integer> magazineCache = new HashMap<Character, Integer>();

		for (char c : magazine.toCharArray()) {
			magazineCache.put(c, magazineCache.getOrDefault(c, 0) + 1);
		}

		for (char c : ransomNote.toCharArray()) {
			if (!magazineCache.containsKey(c) || magazineCache.get(c) <= 0)
				return false;
			else
				magazineCache.put(c, magazineCache.get(c) - 1);
		}

		return true;

	}
	
	private boolean canConstructEfficent(String ransomNote, String magazine) {
		
		// Time complexity:- O(n+m) 
		// Space complexity - O(1)
		
		int count[] = new int[26];
		
		for(char c : magazine.toCharArray())
			count[c - 'a']++;
		
		for(char c: ransomNote.toCharArray()) {
			if(count[--c - 'a']<0) return false;
		}
		
		return true;
	}
	
}
