package com.leetcode.MayChallenge.week3;
import java.util.Stack;

/**
 * @author Shrinath Joshi
 * 		
 * 		Time complexity :- O(n)
 * 		Space complexity :- O(n)
 *
 */



class StockNode {
	int price;
	int span;

	public StockNode(int price, int span) {
		this.price = price;
		this.span = span;
	}

}

public class StockSpanner {
	private Stack<StockNode> stack;

	public StockSpanner() {
		stack = new Stack<StockNode>();
	}

	public int next(int price) {
		int span = 1;

		while (!stack.isEmpty() && price >= stack.peek().price) {
			span += stack.peek().span;
			stack.pop();
		}

		stack.add(new StockNode(price, span));
		return span;
	}

	public static void main(String[] args) {

		StockSpanner sp = new StockSpanner();
		System.out.println(sp.next(100));
		System.out.println(sp.next(80));
		System.out.println(sp.next(60));
		System.out.println(sp.next(70));
		System.out.println(sp.next(60));
		System.out.println(sp.next(75));
		System.out.println(sp.next(85));
	}

}
