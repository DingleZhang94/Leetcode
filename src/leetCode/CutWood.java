package leetCode;

public class CutWood {
	public int minCost(int[] cuts, int length) {
		int[] newCuts = new int[cuts.length + 2];
		newCuts[0] = 0;
		for (int i = 0; i < cuts.length; i++) {
			newCuts[i + 1] = cuts[i];
		}
		newCuts[newCuts.length - 1] = length;
		return minCost(newCuts, 0, newCuts.length - 1);
	}

	private int minCost(int[] cuts, int start, int end) {
		if (start + 1 >= end)
			return 0;
		int mid = findMid(cuts, start, end);
		System.out.println(" " + cuts[mid] + "      " + (cuts[end] - cuts[start]));
		if (mid == -1)
			return 0;
		return cuts[end] - cuts[start] + minCost(cuts, start, mid) + minCost(cuts, mid, end);
	}

	private int findMid(int[] cuts, int start, int end) {
		int target = cuts[start] + (cuts[end] - cuts[start]) / 2;
		int mid = binaryFindNearestMid(cuts, start, end, target);
		if (mid == end || mid == start)
			return -1;
		return mid;
	}

	private int binaryFindNearestMid(int[] cuts, int start, int end, int target) {
		int minDif = Integer.MAX_VALUE;
		int closest = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (cuts[mid] == target) {
				return mid;
			} else if (cuts[mid] > target) {
				if (minDif > cuts[mid] - target) {
					closest = mid;
					minDif = cuts[mid] - target;
				}
				end = mid - 1;
			} else {
				if (minDif > target - cuts[mid]) {
					closest = mid;
					minDif = target - cuts[mid];
				}
				start = mid + 1;
			}
		}
		return closest;
	}

	public static void main(String[] args) {
		CutWood c = new CutWood();
		System.out.println(" " + "cutpoint" + "  cost");
		System.out.println("total cost:" + c.minCost(new int[] { 3, 16, 19, 28, 37, 44, 47, 48, 51, 52, 62 }, 67));
	}
}
