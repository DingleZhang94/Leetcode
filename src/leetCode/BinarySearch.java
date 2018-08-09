package leetCode;

public class BinarySearch {

	public static int search(int[] arr, int target, int start, int end) {
		int l = start;
		int r = end;
		while (l < r) {
			int m = l + (r - l) / 2;

			if (arr[m] == target) {
				if (m == 0 || arr[m - 1] != target) {
					return m;
				}
				r = m;
			} else if (arr[m] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 4, 4, 5, 7, 8, 8, 9, 11, 12 };

		System.out.println(search(a, 8, 0, a.length));

	}

}
