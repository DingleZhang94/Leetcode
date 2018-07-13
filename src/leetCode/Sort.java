package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Sort {
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
		if (arr.size() == 0) {
			return arr;
		}

		return mergeSort(arr, 0, arr.size() - 1);
	}

	private static ArrayList<Integer> mergeSort(ArrayList<Integer> arr, int left, int right) {
		ArrayList<Integer> result = new ArrayList<>();
		if (left > right) {
			return result;
		}
		if (left == right) {
			result.add(arr.get(left));
			return result;
		}
		int mid = left + (right - left) / 2;
		List<Integer> subLeft = mergeSort(arr, left, mid);
		List<Integer> subRight = mergeSort(arr, mid + 1, right);
		merge(subLeft, subRight, result);
		return result;
	}

	private static void merge(List<Integer> subLeft, List<Integer> subRight, List<Integer> result) {
		int l = 0;
		int r = 0;
		while (l < subLeft.size() && r < subRight.size()) {
			if (subLeft.get(l) <= subRight.get(r)) {
				result.add(subLeft.get(l));
				l++;
			} else {
				result.add(subRight.get(r));
				r++;
			}
		}

		while (l < subLeft.size()) {
			result.add(subLeft.get(l));
			l++;
		}
		while (r < subRight.size()) {
			result.add(subRight.get(r));
			r++;
		}
	}

	public static void quicksort(int[] arrays) {
		if (arrays == null || arrays.length == 0) {
			return;
		}
		sort(arrays, 0, arrays.length - 1);
	}

	public static void sort(int[] arrays, int i, int j) {
		if (i >= j)
			return;
		int pi = partition(arrays, i, j);
		if (i < j) {
			sort(arrays, pi + 1, j);
			sort(arrays, i, pi - 1);
		}
	}

	public static int partition(int[] nums, int start, int end) {
		if (start == end)
			return start;
		int i = start + 1;
		int j = end;
		while (i <= j) {
			while (i <= j && nums[i] < nums[start]) {
				i++;
			}
			while (i <= j && nums[j] >= nums[start]) {
				j--;
			}
			if (i < j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		int temp = nums[start];
		nums[start] = nums[j];
		nums[j] = temp;
		return j;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1, 1, 12, 2, 3, 3, 1, 1, 1, 2, 2, 7, 7, 5, 4, 3, 3, 4, 2 };
		ArrayList<Integer> list = new ArrayList<>();
		// quicksort(a);
		for (int i : a) {
			list.add(i);
		}
		System.out.println(list);
		System.out.println(mergeSort(list));
	}
}
