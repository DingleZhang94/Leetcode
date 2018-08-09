package leetCode;

import java.util.ArrayList;
import java.util.List;

public class KClosest {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int l = 0;
		int r = arr.length - k - 1;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (x - arr[m] <= arr[m + k] - x) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = l; i < l + k; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
