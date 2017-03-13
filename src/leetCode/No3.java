package leetCode;

import java.util.HashMap;

public class No3 {
	public int LongString(String s) {
		int maxlength = 0;
		int len = 0;
		int[] t = new int[127];
		int[] t1 = new int[127];
		int[] t2 = new int[127];
		int k = 0;
		int prek = 0;
		for (int i = 0; i < s.length(); i++) {
			int index = (int) s.charAt(i);
			if (t[index] <= t2[index]) {
				len++;
			} else {

				if (t1[index] > prek) {
					len = i - t1[index];
				} else {
					len = i - prek;
				}
				System.out.println("overlap");
				System.out.println("t1[prev]:" + t1[prek]);
				t2[index]++;
				if (t1[index] >= prek) {
					k = i;
					prek = t1[index];
				}
			}
			t[index]++;
			t1[index] = i;
			System.out.println("i= " + i + "  length:" + len + " char:" + s.charAt(i) + "  k:" + k);
			maxlength = (maxlength > len ? maxlength : len);
		}
		return maxlength;
	}

	public int longString2(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		No3 a = new No3();
		String s = "asdfqgqeasdfqawae";
		System.out.println(a.longString2(s));
	}
}
