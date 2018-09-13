package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SpicifiedSort {
	public int[] sortSpecial(int[] A1, int[] A2) {
		// assumption: A1 and A2 are not null

		// corner case:
		if (A2.length == 0 || A1.length < 2)
			return A1;

		// Find the order list
		HashMap<Integer, Integer> orderList = new HashMap<>();
		for (int i = 0; i < A2.length; i++) {
			orderList.put(A2[i], i);
		}

		Integer[] temp = new Integer[A1.length];

		for (int i = 0; i < A1.length; i++) {
			temp[i] = A1[i];
		}

		Arrays.sort(temp, new myComparator(orderList));

		for (int i = 0; i < A1.length; i++) {

			A1[i] = temp[i];
		}
		return A1;

	}
}

class myComparator implements Comparator<Integer> {
	private HashMap<Integer, Integer> orderList;

	myComparator(HashMap<Integer, Integer> orderList) {
		this.orderList = orderList;
	}

	@Override
	public int compare(Integer i, Integer j) {
		boolean ci = orderList.containsKey(i);
		boolean cj = orderList.containsKey(j);
		if (ci && cj) {
			return orderList.get(i).compareTo(orderList.get(j));
		} else if (!ci && !cj) {
			return i.compareTo(j);
		} else {
			return ci ? -1 : 1;
		}
	}
}
