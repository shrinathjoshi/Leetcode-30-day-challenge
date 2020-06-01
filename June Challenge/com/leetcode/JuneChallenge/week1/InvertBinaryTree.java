package com.leetcode.JuneChallenge.week1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Shrinath Joshi
 *
 * 
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
//		return invertTreeUsingRecursion(root);
		return invertTreeUsingIteration(root);
	}

	private TreeNode invertTreeUsingIteration(TreeNode root) {

//		Time complexity :- O(n)
//		Space complexity :- O(n)

		if (root == null)
			return root;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {

			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;

			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}

		return root;
	}

	private TreeNode invertTreeUsingRecursion(TreeNode root) {

//		 Time complexity :- O(n)
//		 Space complexity :- O(h) h is the height of the tree (worst case h=n)

		// Base Case 1
		if (root == null)
			return root;
		// Base Case 2
		if (root.left == null && root.right == null)
			return root;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.right = left;
		root.left = right;

		return root;
	}

	public static void main(String[] args) {

		TreeNode one = new TreeNode(1);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		TreeNode nine = new TreeNode(9);
		TreeNode two = new TreeNode(2, one, three);
		TreeNode seven = new TreeNode(7, six, nine);

		TreeNode four = new TreeNode(4, two, seven);

		TreeNode root = new InvertBinaryTree().invertTree(four);

		inorder(root);
		System.out.println();

	}

	private static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}
}
