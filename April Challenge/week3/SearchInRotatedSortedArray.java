
public class SearchInRotatedSortedArray {

	public static void main(String[] args) {

		int nums[]= {4,5,6,7,0,1,2};
		int nums1[]= {4,5,6,7,0,1,2};
		int m[]= {1,3};
		int target=3;
		
		
		System.out.println(new SearchInRotatedSortedArray().search(nums
				,0));
		System.out.println(new SearchInRotatedSortedArray().search(nums1
				,3));
		System.out.println(new SearchInRotatedSortedArray().search(m
			,target));
	}

	private int search(int[] nums, int target) {
		
		if(nums.length == 0) return -1;
		
		int low = 0;
		int high = nums.length -1;
		
		while(low<=high) {
			int first=nums[low];
			int mid = (low + high)/2;
			int value = nums[mid];
			
			if(value == target)
				return mid;
			
			if(first<=value) {
				if(target>=first && target <=value)
					high=mid-1;
				else
					low=mid+1;
			}
			else
			{
				if(target>=value && target<=nums[high])
					low=mid+1;
				else
					high=mid-1;

			}
					}
		return -1;
	}

}
