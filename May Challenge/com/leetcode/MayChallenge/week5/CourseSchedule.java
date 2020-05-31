package com.leetcode.MayChallenge.week5;

import java.util.Stack;

/**
 * @author Shrinath Joshi
 *
 *         This question can be solved using Kahn's Algorithm
 *         https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 *
 *         Time complexity:- O(V+E) Space complexity:- O(V)
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] inDegree = new int[numCourses];
		int count = 0;

		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][0]]++;
		}

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				stack.push(i);
		}

		while (!stack.isEmpty()) {
			int curr = stack.pop();
			count++;
			for (int i = 0; i < prerequisites.length; i++) {
				if (prerequisites[i][1] == curr) {
					inDegree[prerequisites[i][0]]--;
					if (inDegree[prerequisites[i][0]] == 0)
						stack.push(prerequisites[i][0]);
				}

			}
		}
		return count == numCourses;
	}

	public static void main(String[] args) {
		int numCourses = 2, prerequisites[][] = { { 1, 0 }, { 0, 1 } };
		System.out.println(new CourseSchedule().canFinish(numCourses, prerequisites));

		int numCourses1 = 2, prerequisites1[][] = { { 1, 0 } };
		System.out.println(new CourseSchedule().canFinish(numCourses1, prerequisites1));

	}

}
