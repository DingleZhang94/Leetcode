package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StroboPermutation {
	public String[] generatePalindromes(String s) {
		// preprocess
		HashMap<Character, Integer> map = new HashMap<>();
		List<String> strings = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		int odd = 0;
		for (char c : map.keySet()) {
			int f = map.get(c);
			if (f % 2 == 0) {
				map.put(c, f / 2);
			} else {
				odd++;
				if (odd == 2)
					return new String[0];
				map.put(c, (f + 1) / 2);
			}
		}
		return null;
	}

	public static void main(String[] args) {

	}

}
