package leetCode;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		if (m < n) {
			return uniquePaths(n, m);
		}
		int result = 1;
		for (int i = 1; i <= n - 1; i++) {
			result = result * (m + i - 1) / i;
		}
		return (int) result;
	}

	private int factorial(int x) {
		int a = 1;
		for (int i = 2; i <= x; i++) {
			a *= i;
		}
		return a;
	}

	public static void main(String[] args) {
		UniquePaths a = new UniquePaths();
		System.out.println(a.uniquePaths(51, 9));
	}
}
