package com.leetcode.MayChallenge.week5;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
	Time complexity :- O(klogn) , n is the number of points 
	Space complexity :- O(n) , n is the number of points

*/

public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new PointComparator());
		for (int[] i : points) {
			maxHeap.add(i);
			if (maxHeap.size() > K)
				maxHeap.poll();
		}

		int result[][] = new int[K][2];
		for (int i = 0; i < K; i++) {
			int res[] = maxHeap.poll();
			result[i][0] = res[0];
			result[i][1] = res[1];
		}

		return result;
	}

	public static void main(String[] args) {
		int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } }, K = 2;
		int[][] result = new KClosestPointsToOrigin().kClosest(points, K);

		for (int i = 0; i < K; i++) {
			System.out.println("" + result[i][0] + result[i][1]);
		}
	}

}

class PointComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] p1, int[] p2) {
		return Double.compare(dist(p2), dist(p1));
	}

	private double dist(int[] p) {
		return (p[0] * p[0] + p[1] * p[1]);
	}

}
