package leetCode;

public class FindIntegers {
	public static int findIntegers(int num) {
		StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
		int n = sb.length();
		int[] a = new int[n];
		int[] b = new int[n];
		a[0] = b[0] = 1;
		for (int i = 1; i < n; i++) {
			a[i] = b[i - 1] + a[i - 1];
			b[i] = a[i - 1];
		}
		int result = a[n - 1] + b[n - 1];
		for (int i = 0; i < n - 1; i++) {
			if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1')
				break;
			if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') {
				result = result - b[n - i - 2];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findIntegers(3));
	}
}

/*
 * public int findIntegers(int num) { int count = 1; for (int i = 1; i <= num;
 * i++) { if (check(i)) { count++; } } return count; }
 * 
 * private static boolean check(int num) { StringBuilder sb = new
 * StringBuilder(Integer.toBinaryString(num)); for (int i = 0; i < sb.length() -
 * 1; i++) { if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') { return false;
 * } } return true; }
 * 
 * public static void main(String[] args) { FindIntegers aFindIntegers = new
 * FindIntegers(); System.out.println(aFindIntegers.findIntegers(10)); }
 */
