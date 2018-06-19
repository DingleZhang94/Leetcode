package leetCode;

public class Strobogrammatic3 {

	public int strobogrammaticInRange(String low, String high) {
		int count = 0;
		int[] single = { 1, 2, 2, 2, 2, 2, 2, 2, 3, 3 };
		int[] normal = { 1, 2, 2, 2, 2, 2, 3, 3, 4, 5 };
		int n = low.length();
		int m = high.length();
		int[] dp = new int[m];
		if (m > 0) {
			dp[0] = 3;
			if (m > 1) {
				dp[1] = 4;
				if (m > 2) {
					dp[2] = 12;
				}
			}
		}
		for (int i = 3; i < m; i++) {
			dp[i] = dp[i - 2] * 5;
		}
		int num1 = 0;
		for (int i = 0; i < n - 1; i++) {
			num1 += dp[i];
		}
		int num2 = 0;
		for (int i = 0; i < m - 1; i++) {
			num2 += dp[i];
		}
		System.out.println("num1:" + num1);
		System.out.println("num2:" + num2);
		System.out.println("count low:" + count(low, n));
		System.out.println("count(high, m):" + count(high, m));
		System.out.println("check(high):" + check(high));
		System.out.println("check(low)" + check(low));
		int str1 = num1 + count(low, n);
		int str2 = num2 + count(high, m);

		return (str2 + check(high)) - (str1 + check(low)) + (valid(low) ? 1 : 0);
	}

	private boolean valid(String str) {
		String rot = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case '1':
				rot = '1' + rot;
				break;
			case '6':
				rot = '9' + rot;
				break;
			case '8':
				rot = '8' + rot;
				break;
			case '9':
				rot = '6' + rot;
				break;
			case '0':
				rot = '0' + rot;
				break;
			default:
				return false;
			}
		}
		return rot.equals(str);
	}

	private int count(String str, int m) {
		int[] single = { 1, 2, 2, 2, 2, 2, 2, 2, 3, 3 };
		int[] normal = { 1, 2, 2, 2, 2, 2, 3, 3, 4, 5 };
		int c = str.charAt(0) - 48;
		int n = str.length();
		int sum = 0;

		if (n == 1) {
			return single[c];
		}
		int num = 0;
		if (n == m) { // first count no 0;
			if (n == 2) {
				return normal[c] - 1;
			}
			num = (c == 0 ? 0 : normal[c - 1] - 1);
		} else {
			if (n == 2) {
				return normal[c];
			}
			num = (c == 0 ? 0 : normal[c - 1]); // not first count 0;
		}
		sum += num * combine(n - 2);
		if (c == 0 || c == 1 || c == 6 || c == 9 || c == 8) {
			sum += count(str.substring(1, n - 1), m);
		}
		return sum;
	}

	private int combine(int k) {
		if (k == 0) {
			return 1;
		} else if (k == 1) {
			return 3;
		} else if (k == 2) {
			return 5;
		} else if (k % 2 == 0) {
			return (int) Math.pow(5, k / 2);
		} else {
			return (int) (3 * Math.pow(5, k / 2));
		}
	}

	private int check(String str) {
		int n = str.length();
		if (n == 1) {
			return 0;
		}
		if (n % 2 == 0) {
			int i = n / 2 - 1;
			int j = n / 2;
			while (i >= 0 && j < n) {
				if (str.charAt(j) - 48 < reverse(str.charAt(i))) {
					return -1;
				}
				j++;
				i--;
			}
		} else {
			int j = (n - 1) / 2 + 1;
			int i = (n - 1) / 2 - 1;
			while (i >= 0 && j < n) {
				System.out.println("j: " + j);
				System.out.println("i: " + i);
				if (str.charAt(j) - 48 < reverse(str.charAt(i))) {
					return -1;
				}
				j++;
				i--;
			}
		}

		return 0;
	}

	private int reverse(char c) {
		int a = c - 48;
		switch (a) {
		case 1:
			return 1;
		case 0:
			return 0;
		case 6:
			return 9;
		case 8:
			return 8;
		case 9:
			return 6;
		default:
			return -1;
		}
	}

	public int dp(int n) {
		int[] dp = new int[n];
		dp[0] = 3;
		dp[1] = 4;
		dp[2] = 12;
		for (int i = 3; i < n - 1; i++) {
			dp[i] = dp[i - 2] * 5;
		}
		int sum = 0;
		for (int i = 0; i < dp.length - 1; i++) {
			sum += dp[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strobogrammatic3 s1 = new Strobogrammatic3();
		System.out.println(s1.strobogrammaticInRange("50", "100"));
	}

}
