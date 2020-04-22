import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIsland {
	
	
	class Node{
		public int u;
		public int v;
		
		public Node(int u, int v) {
			this.u=u;
			this.v=v;
		}
		
	}
	
	 public int numIslands(char[][] grid) {
		 	 
		 int row = grid.length;
		 if(row ==0 )return 0;
		 
		 int col = grid[0].length;
		 boolean marked[][]= new boolean[row][col];
		 Queue<Node> queue = new LinkedList<Node>();
		 int count=0;
		 
		 for(int i=0;i<row;i++)
			 for(int j=0;j<col;j++)
				 if(marked[i][j] == false && grid[i][j] == '1') {
					 BFS(i,j,queue,row,col,marked,grid);
					 count++;
				 }
		
		 
		 return count;
	 }
	 
	private void BFS(int i, int j, Queue<Node> queue, int row, int col, boolean[][] marked, char[][] grid) {
		Node node = new Node(i,j);
		queue.add(node);
		marked[i][j]=true;
		
		while(!queue.isEmpty()) {
			Node top = queue.poll();
			int topu=top.u;
			int topv=top.v;
			
			List<Node> adjacent = surround(topu,topv,row,col,grid,marked);
			for(Node adj:adjacent) {
				int u=adj.u;
				int v=adj.v;
				if(marked[u][v] == false) {
					queue.add(adj);
					marked[u][v]=true;
				}
			}	
		}
	}

	private List<Node> surround(int i, int j, int row, int col, char[][] grid, boolean[][] marked) {
		
		List<Node> result = new ArrayList<Node>();
		
		if(i-1>=0 && grid[i-1][j] =='1' && marked[i-1][j] == false) result.add(new Node(i-1,j));
		if(i+1<=row-1 && grid[i+1][j] =='1' && marked[i+1][j] == false) result.add(new Node(i+1,j));
		if(j-1>=0 && grid[i][j-1] =='1' && marked[i][j-1] == false) result.add(new Node(i,j-1));
		if(j+1<=col-1 && grid[i][j+1] =='1' && marked[i][j+1] == false) result.add(new Node(i,j+1));
		
		return result;
	}

	public static void main(String[] args) {
		
		char grid[][]= {{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};
		
		char grid1[][]= {{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}};
		
		
		System.out.println(new NumberOfIsland().numIslands(grid1));
	}	
}
