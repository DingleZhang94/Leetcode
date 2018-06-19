package leetCode;

public class countPrimes {
	public static int tountPrime(int n) {
		if (n <= 2)
			return 0;
		boolean[] a = new boolean[n];
		int count = 1;
		for (int i = 3; i < n; i = i + 2) {
			if (!a[i]) {
				count++;
				for (int j = 2; j * i < n; j++) {
					a[i * j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(tountPrime(4));
	}
}
