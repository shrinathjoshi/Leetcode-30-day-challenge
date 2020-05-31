package com.leetcode.MayChallenge.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Shrinath Joshi
 * 
 *         Similar to Graph Bipartite
 *
 */
public class PossibleBipartition {
	public boolean possibleBipartition(int N, int[][] dislikes) {
		HashMap<Integer, List<Integer>> adj = new HashMap<>();
		HashMap<Integer, String> color = new HashMap<Integer, String>();
		boolean visited[] = new boolean[N + 1];

		// create adj list
		for (int i = 0; i < dislikes.length; i++) {
			int u = dislikes[i][0];
			int v = dislikes[i][1];
			List<Integer> ad = null;
			if (adj.containsKey(u)) {
				ad = adj.get(u);
			} else
				ad = new ArrayList<>();
			ad.add(v);
			adj.put(u, ad);
		}

		Queue<Integer> queue = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				color.put(i, "RED");
				queue.add(i);

				while (!queue.isEmpty()) {
					int top = queue.poll();
					if (visited[top])
						continue;
					visited[top] = true;
					List<Integer> adjList = adj.get(top);
					if (adjList != null)
						for (int v : adjList) {
							if (!visited[v]) {
								if (color.get(top).equals(color.get(v)))
									return false;
								if (color.get(top) == "RED")
									color.put(v, "BLUE");
								else
									color.put(v, "RED");

								queue.add(v);
							}
						}
				}

			}
		}

		return true;
	}

	public static void main(String[] args) {

		int N = 5, dislikes[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } };
		System.out.println(new PossibleBipartition().possibleBipartition(N, dislikes));
	}

}
