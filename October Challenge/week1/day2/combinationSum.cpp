// TC: O(2^N)
// SC: O(N^2)

class Solution {
public:


    void helper(vector<vector<int>> &ans, vector<int> &v, int t, vector<int>& can, int i=0, int sum=0) {
    if (sum==t) {
        ans.push_back(v);
        return;
    }
    if (i==can.size() || sum>t)
        return;

    int x=0;
    while (sum <= t) {
        helper(ans, v, t, can, i+1, sum);
        v.push_back(can[i]);
        sum += can[i];
        x++;
    }
    while (x--) v.pop_back();
}

vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
    vector<vector<int>> ans;
    vector<int> v;
    sort(candidates.begin(), candidates.end());
    helper(ans, v, target, candidates);
    return ans;
}
};
