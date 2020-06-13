package com.leetcode.JuneChallenge.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class RandomizedSet {
	private List<Integer> list;
	private HashMap<Integer, Integer> map;
	private Random rand;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val))
			return false;

		list.add(val);
		map.put(val, list.size() - 1);
		return true;

	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val))
			return false;

		int index = map.get(val);
		int valueAtLastIndex = list.get(list.size() - 1);

		list.set(index, valueAtLastIndex);
		map.put(valueAtLastIndex, index);
		list.remove(list.size() - 1);
		map.remove(val);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {

		return list.get(rand.nextInt(list.size()));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * 
 */

public class InsertDeleteGetRandom {

	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();

		System.out.println(obj.insert(1));
		System.out.println(obj.remove(2));
		System.out.println(obj.insert(2));
		System.out.println(obj.getRandom());
		System.out.println(obj.remove(1));
		System.out.println(obj.insert(2));
		System.out.println(obj.getRandom());

	}

}
