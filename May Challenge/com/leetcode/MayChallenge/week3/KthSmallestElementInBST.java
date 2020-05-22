package com.leetcode.MayChallenge.week3;

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

class TreeValue{
	int noOfSmallestSeen;
	int value;
	public TreeValue(int noOfSmallestSeen, int value) {
		super();
		this.noOfSmallestSeen = noOfSmallestSeen;
		this.value = value;
	}
}

public class KthSmallestElementInBST {

	public int kthSmallest(TreeNode root, int k) {
		int nums[] = new int[2];
		inorder(root, nums, k);
		return nums[1];
	}

	private void inorder(TreeNode root, int[] nums, int k) {
		if(root == null) return ;
		
		inorder(root.left, nums,k);
		if(++nums[0] == k) {
			nums[1]=root.val;
			return;
		}
		inorder(root.right, nums, k);
	}

	public static void main(String[] args) {

		//Input: root = [5,3,6,2,4,null,null,1], k = 3

		TreeNode node4 = new TreeNode(4);
		TreeNode node1 = new TreeNode(1);
		TreeNode node6 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2,node1,null);
		TreeNode node3 = new TreeNode(3,node2,node4);
		TreeNode root = new TreeNode(5,node3,node6);
		
		System.out.println(new KthSmallestElementInBST().kthSmallest(root, 3));
		
	}

}
