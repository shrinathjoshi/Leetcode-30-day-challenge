// Basic implementation of Activity Selection problem (Greedy Algo)
// TC: O(nlogn)
// SC: O(n)

class Solution {
public:
    static bool comp(vector<int> a, vector<int> b) {	// Comparator for sorting vector
        if (a[0]==b[0]) return a[1]>b[1];
        return a[0]<b[0];	// activity that starts earlier and last longer is placed before so that it covers bigger range
    }
    
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), comp);
        
        int l=0, r=-1;
        int ans=intervals.size();
        for (auto i : intervals) {
            if (i[0]>=l && i[1]<=r)	 
                ans--;
            else
                l = i[0], r = i[1];
            
        }
        return ans;
    }
};
