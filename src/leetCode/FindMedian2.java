package leetCode;

public class FindMedian2 {
	public static void main(String[] args) {
		int[] a = { 3 };
		int[] b = {};
		System.out.println(findMedian(a, b));
	}

	public static float findMedian(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		if (m > n) {
			int[] temp = a;
			a = b;
			b = temp;
			int t = m;
			m = n;
			n = t;
		}
		System.out.println("m:" + m + " n: " + n);
		if (n == 0) {
			return 0;
		}
		if (m == 0) {
			if (n % 2 == 0) {
				return (b[n / 2 - 1] + b[n / 2]) / 2.0f;
			} else {
				return b[(n + 1) / 2 - 1];
			}
		}
		int max_left = 0, min_right = 0;
		int imin = 0, imax = m, halfLenght = (m + n + 1) / 2;
		while (imin <= imax) {
			int i = (imax + imin) / 2;
			int j = halfLenght - i;

			if (i > 0 && a[i - 1] > b[j]) {
				imax = i - 1;
			} else if (i < m && b[j - 1] > a[i]) {
				imin = i + 1;
			} else {
				if (i == 0) {
					max_left = b[j - 1];
					if (j == n) {
						min_right = a[i];
					} else {
						min_right = (a[i] < b[j] ? a[i] : b[j]);
					}
				} else if (i == m) {
					min_right = b[j];
					if (j == 0) {
						max_left = a[i - 1];
					} else {
						max_left = (a[i - 1] > b[j - 1] ? a[i - 1] : b[j - 1]);
					}
				} else {
					max_left = (a[i - 1] > b[j - 1] ? a[i - 1] : b[j - 1]);
					min_right = (a[i] < b[j] ? a[i] : b[j]);
				}
				break;
			}
		}
		if ((n + m) % 2 == 0) {
			return (max_left + min_right) / 2.0f;
		} else {
			return max_left;
		}
	}
}
