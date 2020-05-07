package com.leetcode.MayChallenge.week1;

/**
 * 
 * @author Shrinath Joshi
 * 
 * 	Time complexity :- O(n)
 * 	Space complexity :-O(log(n)) 
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

public class CousinsInBinaryTree {

	public boolean isCousins(TreeNode root, int x, int y) {

		int xLevel = getLevelOfNode(root, x, 0);
		int yLevel = getLevelOfNode(root, y, 0);

		TreeNode xParent = getParent(root, x, new TreeNode(-1));
		TreeNode yParent = getParent(root, y, new TreeNode(-1));

		return ((xLevel == yLevel) && ((xParent != null && yParent != null) && (xParent.val != yParent.val)));
	}

	private TreeNode getParent(TreeNode root, int x, TreeNode parent) {
		if (root == null)
			return null;
		if (root.val == x)
			return parent;
		else {
			TreeNode leftParent = getParent(root.left, x, root);
			if (leftParent != null)
				return leftParent;

			TreeNode rightParent = getParent(root.right, x, root);
			if (rightParent != null)
				return rightParent;
		}
		return null;
	}

	private int getLevelOfNode(TreeNode root, int x, int level) {

		if (root == null)
			return 0;
		if (root.val == x)
			return level;
		else {
			int leftLevel = getLevelOfNode(root.left, x, level + 1);
			if (leftLevel != 0)
				return leftLevel;

			return getLevelOfNode(root.right, x, level + 1);
		}

	}

	public static void main(String[] args) {

		TreeNode node3 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4, null, null);
		TreeNode node = new TreeNode(2, null, node2);
		TreeNode node1 = new TreeNode(3, null, node3);
		TreeNode root = new TreeNode(1, node, node1);

		System.out.println(new CousinsInBinaryTree().isCousins(root, 5, 4));
	}

}
