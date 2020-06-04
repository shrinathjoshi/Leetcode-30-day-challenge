package com.leetcode.JuneChallenge.week1;

import java.util.PriorityQueue;

/**
 * @author Shrinath Joshi
 * 
 *         Time complexity :- O(nlogn) //
 * 
 *         Space complexity :- O(n)
 *
 */
public class TwoCityScheduling {
	public int twoCitySchedCost(int[][] costs) {
		int n = costs.length;
		int totalCost = 0;
		int currentCount = 0;

		// Building a Max-Heap
		PriorityQueue<CityNode> pq = new PriorityQueue<CityNode>((a, b) -> b.profit - a.profit);

		for (int i = 0; i < n; i++)
			pq.add(new CityNode(costs[i], (costs[i][1] - costs[i][0])));

		while (currentCount < n && !pq.isEmpty()) {
			CityNode top = pq.poll();
			int costOfCity[] = top.cityCost;

			if (currentCount < n / 2)
				totalCost += costOfCity[0];
			else
				totalCost += costOfCity[1];
			currentCount++;
		}

		return totalCost;
	}

	public static void main(String[] args) {
		int costs[][] = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		System.out.println(new TwoCityScheduling().twoCitySchedCost(costs));
	}

}

class CityNode {
	public int cityCost[];
	public int profit;

	public CityNode(int cityCost[], int profit) {
		this.cityCost = cityCost;
		this.profit = profit;
	}
}
