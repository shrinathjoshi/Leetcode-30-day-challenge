package com.leetcode.MayChallenge.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Shrinath Joshi 
 * 		Time Complexity :- O(n)
 * 		Space Complexity :- O(n)
 */


public class FloodFill {

	private boolean marked[][];
	private int image[][];
	private int row;
	private int col;

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		// return floodFillUsingBFS(image, sr, sc, newColor);
		// return floodFillUsingDFS(image, sr, sc, newColor);

		return floodFillEditorialSolution(image, sr, sc, newColor);

	}

	private int[][] floodFillEditorialSolution(int[][] image2, int sr, int sc, int newColor) {
		int color = image[sr][sc];
		if (color != newColor)
			depthFirstSearch(image, sr, sc, color, newColor);
		return image;
	}

	public void depthFirstSearch(int[][] image, int r, int c, int color, int newColor) {
		if (image[r][c] == color) {
			image[r][c] = newColor;
			if (r >= 1)
				depthFirstSearch(image, r - 1, c, color, newColor);
			if (c >= 1)
				depthFirstSearch(image, r, c - 1, color, newColor);
			if (r + 1 < image.length)
				depthFirstSearch(image, r + 1, c, color, newColor);
			if (c + 1 < image[0].length)
				depthFirstSearch(image, r, c + 1, color, newColor);
		}
	}

	private int[][] floodFillUsingDFS(int[][] image, int sr, int sc, int newColor) {
		row = image.length;
		col = image[0].length;
		this.image = image;
		marked = new boolean[row][col];
		dfs(sr, sc, newColor);
		return image;
	}

	private void dfs(int sr, int sc, int newColor) {
		int oldColor = image[sr][sc];
		image[sr][sc] = newColor;
		marked[sr][sc] = true;

		for (Edge i : getAdjacent(sr, sc, oldColor)) {
			if (!marked[i.getU()][i.getV()])
				dfs(i.getU(), i.getV(), newColor);
		}

	}

	private int[][] floodFillUsingBFS(int[][] image, int sr, int sc, int newColor) {
		row = image.length;
		col = image[0].length;

		if (!validNode(sr, sc))
			return image;

		marked = new boolean[row][col];
		this.image = image;

		bfs(marked, newColor, sr, sc, image);

		return image;
	}

	private void bfs(boolean[][] marked, int newColor, int sr, int sc, int[][] image) {

		marked[sr][sc] = true;
		int oldColor = image[sr][sc];
		image[sr][sc] = newColor;

		Queue<Edge> queue = new LinkedList<Edge>();
		queue.add(new Edge(sr, sc, oldColor));

		while (!queue.isEmpty()) {
			Edge top = queue.poll();
			for (Edge i : getAdjacent(top.getU(), top.getV(), top.getOldColor())) {
				int u = i.getU();
				int v = i.getV();
				if (!marked[u][v]) {
					image[u][v] = newColor;
					marked[u][v] = true;
					queue.add(i);
				}
			}

		}
	}

	private List<Edge> getAdjacent(int sr, int sc, int oldColor) {

		List<Edge> adj = new ArrayList<Edge>();
		if (validNode(sr - 1, sc) && image[sr - 1][sc] == oldColor && !marked[sr - 1][sc])
			adj.add(new Edge(sr - 1, sc, image[sr - 1][sc]));
		if (validNode(sr + 1, sc) && image[sr + 1][sc] == oldColor && !marked[sr + 1][sc])
			adj.add(new Edge(sr + 1, sc, image[sr + 1][sc]));
		if (validNode(sr, sc - 1) && image[sr][sc - 1] == oldColor && !marked[sr][sc - 1])
			adj.add(new Edge(sr, sc - 1, image[sr][sc - 1]));
		if (validNode(sr, sc + 1) && image[sr][sc + 1] == oldColor && !marked[sr][sc + 1])
			adj.add(new Edge(sr, sc + 1, image[sr][sc + 1]));

		return adj;
	}

	private boolean validNode(int i, int j) {
		if (i >= 0 && i < row && j >= 0 && j < col)
			return true;
		return false;
	}

	public static void main(String[] args) {

		int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int image1[][] = { { 0, 0, 0 }, { 0, 0, 0 } };

		int result[][] = new FloodFill().floodFill(image, 1, 1, 2);
		int result1[][] = new FloodFill().floodFill(image1, 0, 0, 2);

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}

		System.out.println();
		for (int i = 0; i < result1.length; i++) {
			for (int j = 0; j < result1[0].length; j++)
				System.out.print(result1[i][j] + " ");
			System.out.println();
		}
	}

}

class Edge {
	private int u;
	private int v;
	private int oldColor;

	public Edge(int u, int v, int oldColor) {
		this.u = u;
		this.v = v;
		this.oldColor = oldColor;
	}

	public int getU() {
		return u;
	}

	public void setU(int u) {
		this.u = u;
	}

	public int getV() {
		return v;
	}

	public int getOldColor() {
		return oldColor;
	}

	public void setOldColor(int oldColor) {
		this.oldColor = oldColor;
	}

	public void setV(int v) {
		this.v = v;
	}

}
