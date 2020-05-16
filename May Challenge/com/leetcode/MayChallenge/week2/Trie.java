package com.leetcode.MayChallenge.week2;


/**
 * @author Shrinath Joshi
 *
 *		Insert :-
 *			Time complexity:- O(m) 
 *			Space complexity:- O(m) , m is length of String
 *			
 *		Search :-
 *			Time complexity:- O(m) , m is length of String
 *			Space complexity:- O(1) 
 *
 *		Search for key prefix  :-
 *			Time complexity:- O(m) , m is length of String
 *			Space complexity:- O(1) 
 *		
 *
 */
class TrieNode{
	public TrieNode[] children;
	public boolean isEndOfWord;
	
	public TrieNode()
	{
		children=new TrieNode[26];
	}
}

public class Trie {
	private TrieNode root;
	
	public Trie() {
		root =  new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		int n = word.length();
		TrieNode curr = root;
		for(int i=0;i<n;i++)
		{
			char value = word.charAt(i);
			int index = value-'a';
			if(curr.children[index] ==  null)
			{
				curr.children[index] = new TrieNode();
			}
				curr = curr.children[index];
		}
		curr.isEndOfWord=true;
	}


	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		int n = word.length();
		TrieNode curr = root;
		for(int i=0;i<n;i++)
		{
			char value = word.charAt(i);
			int index = value-'a';
			if(curr.children[index] == null)
				return false;
			else
				curr = curr.children[index];
		}
		
		return curr.isEndOfWord && curr != null;
		
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {

		int n = prefix.length();
		TrieNode curr = root;
		for(int i=0;i<n;i++)
		{
			char value = prefix.charAt(i);
			int index = value-'a';
			if(curr.children[index] == null)
				return false;
			else
				curr = curr.children[index];
		}
		
		return curr != null;
	}

	public static void main(String[] args) {

		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
	}

}
