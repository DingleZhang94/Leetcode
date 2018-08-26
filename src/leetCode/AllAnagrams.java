package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AllAnagrams {
	public List<Integer> allAnagrams(String sh, String lo) {
		HashMap<Character, Integer> map = new HashMap<>();
		HashSet<Character> set = new HashSet<>();
		List<Integer> res = new ArrayList<>();
		if (sh.length() < lo.length())
			return res;

		for (int i = 0; i < lo.length(); i++) {
			char c = lo.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			set.add(c);
		}

		for (int i = 0; i < lo.length(); i++) {
			char c = sh.charAt(i);
			delete(map, set, c);
		}

		int len = sh.length() - lo.length();
		for (int i = 0; i < len; i++) {
			if (map.isEmpty()) {
				res.add(i);
			}
			add(map, set, sh.charAt(i + lo.length()));
			delete(map, set, sh.charAt(i));
		}

		return res;
	}

	private void delete(HashMap<Character, Integer> map, HashSet<Character> set, char c) {
		if (set.contains(c)) {
			int j = map.get(c) - 1;
			if (j == 0) {
				map.remove(c);
			} else {
				map.put(c, j);
			}
		}
	}

	private void add(HashMap<Character, Integer> map, HashSet<Character> set, char c) {
		if (set.contains(c)) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
	}

	public static void main(String[] args) {
		AllAnagrams a = new AllAnagrams();

		System.out.println(a.allAnagrams("", lo));
	}
}
