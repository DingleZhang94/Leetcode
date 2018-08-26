package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllPermutation {
	public List<String> permutations(String set) {
		List<String> result = new ArrayList<>();
		if (set == null)
			return result;
		char[] dic = set.toCharArray();
		helper(result, dic, 0);
		return result;
	}

	private void helper(List<String> result, char[] dic, int wall) {
		if (wall == dic.length) {
			result.add(new String(dic));
		}
		HashSet<Character> set = new HashSet<>();
		for (int i = wall; i < dic.length; i++) {
			if (!set.contains(dic[i])) {
				set.add(dic[i]);
				swap(dic, i, wall);
				helper(result, dic, wall + 1);
				swap(dic, i, wall);
			}
		}
	}

	private void swap(char[] dic, int i, int j) {
		char temp = dic[i];
		dic[i] = dic[j];
		dic[j] = temp;
	}

	public static void main(String[] args) {

	}

}
