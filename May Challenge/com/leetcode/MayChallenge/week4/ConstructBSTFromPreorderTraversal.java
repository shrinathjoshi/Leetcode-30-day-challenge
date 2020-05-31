package com.leetcode.MayChallenge.week4;

/**
 * @author Shrinath Joshi Time complexity:- O(nlogn) Space complexity:- O(1)
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

public class ConstructBSTFromPreorderTraversal {
	private TreeNode root;

	public TreeNode bstFromPreorder(int[] preorder) {

		int n = preorder.length;
		if (n == 0)
			return null;

		for (int node : preorder)
			buildBST(node);

		return root;
	}

	private void buildBST(int node) {

		if (root == null) {
			root = new TreeNode(node);
			return;
		}
		TreeNode current = root;
		while (current != null) {
			if (current.val > node) {
				// Left Subtree
				if (current.left == null) {
					current.left = new TreeNode(node);
					return;
				} else
					current = current.left;
			} else {
				// Right Subtree
				if (current.right == null) {
					current.right = new TreeNode(node);
					return;
				} else
					current = current.right;
			}
		}
	}

	public static void main(String[] args) {
		int preorder[] = { 8, 5, 1, 7, 10, 12 };
		System.out.println(new ConstructBSTFromPreorderTraversal().bstFromPreorder(preorder));
	}

}
