import java.util.ArrayList;
import java.util.List;

/**
 * @author Shrinath Joshi
 * 
 *         Problem Statement :-
 *         https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * 
 *         Time complexity :- O(n)
 * 
 *         Space complexity :- O(1)
 *
 */

public class FindAllDuplicatesInAnArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();

		for (int num : nums) {
			int number = Math.abs(num);
			if (nums[number - 1] < 0)
				result.add(number);
			else
				nums[number - 1] = -nums[number - 1];
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = { 4, 3, 2, 7, 8, 2, 3, 1 };

		List<Integer> result = new FindAllDuplicatesInAnArray().findDuplicates(nums);

		for (Integer num : result)
			System.out.println(num + " ");

	}

}
