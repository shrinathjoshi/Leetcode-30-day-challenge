
class RecentCounter {
public:
    queue<int> q;
    RecentCounter() {
    }
		    
    int ping(int t) {	// For one call to ping() worst case TC: O(N) but overall complexity of program does not exceed O(N) 	
        q.push(t);
        while (!q.empty() && q.front() + 3000 < t)	// Remove all time units that are less than t-3000
            q.pop();
        
        return q.size();
    }
  
};

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter* obj = new RecentCounter();
 * int param_1 = obj->ping(t);
 */
