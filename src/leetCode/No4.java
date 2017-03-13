package leetCode;

import java.util.HashMap;

public class No4 {
	public static void main(String[] args) {
		No4 a = new No4();
		String string = "bananas";
		System.out.println(a.longestPalindromicSubstring(string));
	}

	public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		int maxleft = 0, maxright = 0;
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				if (i - map.get(s.charAt(i)) == 1) {
					left = i - 1;
					right = i;
					while (right + 1 < s.length() && s.charAt(right) == s.charAt(right + 1)) {
						right++;
					}
					i = right;
					while (left - 1 >= 0 & right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
						left--;
						right++;
					}

					if (maxright - maxleft <= right - left) {
						maxright = right;
						maxleft = left;
					}
				}
				if (i - map.get(s.charAt(i)) == 2) {
					left = i - 2;
					right = i;

					while (left - 1 >= 0 & right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
						left--;
						right++;
					}
					// i = right;
					if (maxright - maxleft <= right - left) {
						maxright = right;
						maxleft = left;
					}
				}
			}

			map.put(s.charAt(i), i);
		}

		return s.substring(maxleft, maxright + 1);
	}

	public String longestPalindromicSubstring(String s) {
		int low = 0, maxlen = 1;
		int left = 0;
		int len = 1;
		for (int i = 0; i < s.length();) {
			if (s.length() - i < maxlen / 2) {
				break;
			}
			left = i;
			System.out.println("i=" + i + " len:" + len);
			while (left + len < s.length() && s.charAt(left) == s.charAt(left + len)) {
				len++;
				System.out.println('2');
			}
			i = left + len;
			while (left - 1 >= 0 && left + len < s.length() && s.charAt(left - 1) == s.charAt(left + len)) {
				len = len + 2;
				left--;
				System.out.println('3');
			}
			System.out.println(" after len:" + len);
			if (maxlen < len) {
				maxlen = len;
				low = left;
			}
			len = 1;
		}
		System.out.println("low= " + low + " len= " + len);
		return s.substring(low, low + maxlen);
	}

	public String longestPalindrome2(String s) {
		if (s.isEmpty())
			return "";
		if (s.length() == 1)
			return s;
		int min_start = 0, max_len = 1;
		for (int i = 0; i < s.length();) {
			if (s.length() - i <= max_len / 2)
				break;
			int j = i, k = i;
			while (k < s.length() - 1 && j > 0 && s.charAt(k + 1) == s.charAt(k)) {
				++k;
			}
			i = k + 1;
			while (k < s.length() - 1 && j > 0 && s.charAt(k + 1) == s.charAt(j - 1)) {
				++k;
				--j;
			}
			int new_len = k - j + 1;
			if (new_len > max_len) {
				min_start = j;
				max_len = new_len;
			}
		}
		return s.substring(min_start, max_len);
	}

}
