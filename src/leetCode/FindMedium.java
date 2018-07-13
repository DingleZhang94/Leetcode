package leetCode;

public class FindMedium {
	public double findMedian(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		// keep a.length > b.length
		if (m < n) {
			int[] temp = a;
			a = b;
			b = temp;
		}

		// avoid Integer overflow
		int k = m / 2 + n / 2 + (m % 2 + n % 2 + 1) / 2;

		// find k smallest's index
		int i = findKsmallest(a, b, k); // last index in array a;
		int j = k - i - 2; // last index in array b;
		int median = (a[i] > b[j] ? a[i] : b[j]);
		if (m % 2 + n % 2 == 1) {
			// if m + n is odd
			return median;
		} else {
			// if m + n is even
			int i1 = Integer.MAX_VALUE;
			int j1 = Integer.MAX_VALUE;
			if (i + 1 < m) {
				i1 = a[i + 1];
			}
			if (j + 1 < m) {
				j1 = b[j + 1];
			}
			return (median + (double) (i1 > j1 ? j1 : i1)) / 2;
		}
	}

	// a.length > b.length
	// return the last index of Ksmallest in array a;
	public int findKsmallest(int[] a, int[] b, int k) {
		int i = (k + 1) / 2 - 1;
		int count = k / 2;
		int m = a.length;
		int n = b.length;

		if (k > m + n) {
			// k > m + n
			return -1;
		}

		while (i >= 0 && i < m && count > 0) {
			int j = k - i - 2;
			if (j >= 0 && j < n) {
				count = count / 2;
				if (a[i] > b[j]) {
					// b[0] to b[j] is in k
					i = i - count;
				} else if (a[i] < b[j]) {
					i = i + count;
				} else {
					return i;
				}
			} else {
				return i;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 5, 6, 8 };
		int[] b = { 4, 9, 10, 11 };
		FindMedium f = new FindMedium();
		System.out.println(f.findKsmallest(a, b, 1));
	}

}
