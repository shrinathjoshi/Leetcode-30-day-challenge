package week2;

import java.util.ArrayList;
import java.util.List;

public class Day13_InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> result = new ArrayList<>();
		int n = intervals.length;
		int i = 0;
		while (i < n && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i++]);
		}

		while (i < n && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Integer.min(intervals[i][0], newInterval[0]);
			newInterval[1] = Integer.max(intervals[i][1], newInterval[1]);
			i++;
		}

		result.add(newInterval);

		while (i < n) {
			result.add(intervals[i++]);
		}

		return result.toArray(new int[result.size()][]);
	}
}
