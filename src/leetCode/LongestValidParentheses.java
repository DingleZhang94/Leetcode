package leetCode;

public class LongestValidParentheses {
	public static int longestValidParentheses(String s) {

		boolean[] dp = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				int j = i - 1;
				System.out.println("test");
				while (j >= 0) {
					if (!dp[j] && s.charAt(j) == '(') {
						dp[j] = true;
						dp[i] = true;
						break;
					}
					j--;
				}
			}
			System.out.println(i);
		}
		int maxLength = 0;
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			if (dp[i]) {
				length++;
			} else {
				maxLength = Math.max(length, maxLength);
				length = 0;
			}
		}
		return Math.max(length, maxLength);
	}

	public static void main(String[] args) {
		int i = longestValidParentheses("(((()()()((())");
		System.out.println(i);
	}
}
