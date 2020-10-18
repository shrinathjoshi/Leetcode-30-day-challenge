// TC: O(logN)
// SC: O(1)

class Solution {
public:
    int bitwiseComplement(int N) {
        if (N==0)
            return 1;
        int maxVal=1;
        while (maxVal<=N) 	
            maxVal = maxVal<<1;
        
        return maxVal-1-N; // To find complement of 5(101) -> 5 is subtracted from 7(111) resulting in 2(010)
    }
};
