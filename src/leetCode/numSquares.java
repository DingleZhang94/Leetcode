package leetCode;

public class numSquares {
	public static int numOfSquares(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (Math.sqrt(i) - (int) Math.sqrt(i) == 0.0) {
				dp[i] = 1;
				continue;
			}
			int min = Integer.MAX_VALUE;
			int k = 1;
			for (int j = 1; j <= i / 2; j = k * k) {
				min = Math.min(min, dp[i - j] + dp[j]);
				k++;
			}
			dp[i] = min;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(numOfSquares(12));
	}
}
