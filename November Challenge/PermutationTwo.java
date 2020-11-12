import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shrinath Joshi
 *
 *         Problem Statement
 *         :-https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3528/
 */
public class PermutationTwo {

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		boolean used[] = new boolean[nums.length];
		getPermutation(0, new ArrayList<Integer>(), result, nums, used);
		return result;
	}

	private void getPermutation(int index, ArrayList<Integer> partialSolution, List<List<Integer>> result, int nums[],
			boolean used[]) {

		if (index > nums.length)
			return;

		if (partialSolution.size() == nums.length) {
			result.add(new ArrayList<Integer>(partialSolution));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
				continue;

			used[i] = true;
			partialSolution.add(nums[i]);
			getPermutation(i + 1, partialSolution, result, nums, used);
			used[i] = false;
			partialSolution.remove(partialSolution.size() - 1);
		}
	}
}
