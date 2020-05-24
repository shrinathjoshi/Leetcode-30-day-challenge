package com.leetcode.MayChallenge.week4;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Shrinath Joshi
 * 
 *         Problem statement :-
 *         https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/
 * 
 *         Time complexity :- O(nlogn) Space complexity :-O(n)
 */

public class SortCharactersByFrequency {

	public String frequencySort(String s) {

		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();

		for (char c : s.toCharArray())
			hash.put(c, hash.getOrDefault(c, 0) + 1);

		PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> hash.get(b) - hash.get(a));
		pq.addAll(hash.keySet());

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Character current = pq.remove();
			int count = hash.get(current);
			while (count-- > 0)
				sb.append(current);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "Aabb";
		String str1 = "cccaaa";

		System.out.println(new SortCharactersByFrequency().frequencySort(str));
		System.out.println(new SortCharactersByFrequency().frequencySort(str1));

	}

}
