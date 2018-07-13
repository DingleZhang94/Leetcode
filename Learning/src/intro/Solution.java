package intro;

import java.util.HashMap;

public class Solution {
	public int solution(int[] A) {
		// less than 3 number return 0
		if (A.length < 3) {
			return 0;
		}
		// store the number of unique number before A[i] occurs
		HashMap<Integer, Integer> difMap = new HashMap<>();
		// store the number of unique pairs before A[i] occurs
		HashMap<Integer, Integer> pairMap = new HashMap<>();

		int difCount = 0; // counter of how many unique number
		int[] pair = new int[A.length]; // how many unique pairs until i th
										// number
		int[] tripair = new int[A.length]; // how many tripairs until i th
											// number
		int[] dif = new int[A.length + 1]; // store how many unique number
											// before i th number
		// initialize
		dif[0] = 0;
		pair[0] = 0;
		pair[1] = 1;
		tripair[1] = 0;
		tripair[2] = 1;

		// loop through the array once
		for (int i = 0; i < A.length; i++) {
			System.out.println("i:" + i);

			// update pair[i] and tripair[i]
			if (i >= 2) {
				pair[i] = pair[i - 1] + difCount - (difMap.containsKey(A[i]) ? difMap.get(A[i]) : 0);
				if (i > 2) {
					tripair[i] = tripair[i - 1] + pair[i - 1] - (pairMap.containsKey(A[i]) ? pairMap.get(A[i]) : 0);

				}

			}

			// count the unique number until i-th numeber
			if (!difMap.containsKey(A[i])) {
				difCount++;
			}
			// store d[i+1] with current unique numbers
			dif[i + 1] = difCount;

			// store unique number before A[i] last appears
			difMap.put(A[i], dif[i]);
			// System.out.println("difCount: " + difCount);
			// System.out.println("pair[" + i + "] :" + pair[i]);
			// System.out.println("tripair[" + i + "] :" + tripair[i]);
			// System.out.println("pairmap[" + A[i] + "]" + pairMap.get(A[i]));
			// System.out.println("dif[" + i + "] :" + dif[i]);
			// System.out.println();
			// store unique pairs before A[i] last appears
			pairMap.put(A[i], (i > 0 ? pair[i - 1] : 0));
		}

		return tripair[A.length - 1];
	}

	public static void main(String[] args) {
		Solution aSolution = new Solution();
		int[] a = { 2, 2, 2, 2, 4, 5, 2, 1, 2, };

		System.out.println(aSolution.solution(a));
	}
}
