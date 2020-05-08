package com.leetcode.MayChallenge.week2;

public class CheckIfAStraightLine {

	 public boolean checkStraightLine(int[][] coordinates) {
		 
		 if(coordinates.length ==2 ) return true;
		 
		 for(int i=2;i<coordinates.length;i++) {
			 int x1 = coordinates[i-1][0];
			 int y1 = coordinates[i-1][1];
			 int x2 = coordinates[i][0];
			 int y2 = coordinates[i][1];
			 int x3 = coordinates[i-2][0];
			 int y3 = coordinates[i-2][1];
			 		 
			 if((y2-y1)*(x3-x2)!=(y3-y2)*(x2-x1)) return false;
	
		 }
		 
		 return true;
	 }
	
	public static void main(String[] args) {
		
		int [][]coordinates = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
		int [][]coordinates1= {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		int [][]coordinates2= {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
		
		System.out.println(new CheckIfAStraightLine().checkStraightLine(coordinates));
		System.out.println(new CheckIfAStraightLine().checkStraightLine(coordinates1));
		System.out.println(new CheckIfAStraightLine().checkStraightLine(coordinates2));

	}

}
