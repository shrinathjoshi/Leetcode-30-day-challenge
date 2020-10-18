package week3.day17.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {
	// Time Complexity :- O(N)
	// Space Complexity :- O(N)

	public List<String> findRepeatedDnaSequences(String s) {

		Set<String> seen = new HashSet<String>();
		Set<String> result = new HashSet<String>();

		for (int i = 0; i + 9 < s.length(); i++) {
			String temp = s.substring(i, i + 10);
			if (!seen.add(temp)) {
				result.add(temp);
			}
		}

		return new ArrayList<>(result);
	}
}
