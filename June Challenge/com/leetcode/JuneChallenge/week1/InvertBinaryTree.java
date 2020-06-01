package com.leetcode.JuneChallenge.week1;

/**
 * @author Shrinath Joshi
 *
 *         Time complexity :- O(n)
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
