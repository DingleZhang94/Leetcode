package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumberInBST {

	class TreeNode {
		TreeNode left;
		TreeNode right;
		int key;

		public TreeNode(int key) {
			this.key = key;
		}

	}

	public int[] closestKValues(TreeNode root, double target, int k) {
		List<Integer> list = new ArrayList<>();
		// get sorted list;
		helper(list, root);
		int[] res = new int[Math.min(k, list.size())];
		// find closest number's index;
		int minix = findClosest(list, target);
		res[0] = list.get(minix);
		int right = 1;
		int left = 1;
		int count = 1;
		double difLeft = (double) Integer.MAX_VALUE;
		double difRight = (double) Integer.MAX_VALUE;
		while (count < res.length) {
			if (minix - left >= 0) {
				difLeft = Math.abs(target - list.get(minix - left));
			} else {
				difLeft = (double) Integer.MAX_VALUE;
			}
			if (minix + right < list.size()) {
				difRight = Math.abs(target - list.get(minix + right));
			} else {
				difRight = (double) Integer.MAX_VALUE;
			}

			if (difLeft > difRight) {
				res[count] = list.get(minix + right);
				right++;
			} else {
				res[count] = list.get(minix - left);
				left++;
			}
			count++;
		}

		// insert from head when left, insert from right when
		Arrays.sort(res);
		return res;
	}

	private void helper(List<Integer> list, TreeNode root) {
		if (root == null)
			return;
		helper(list, root.left);
		list.add(root.key);
		helper(list, root.right);
	}

	public int findClosest(List<Integer> list, double target) {
		int minix = 0;
		double mindif = Math.abs(list.get(0) - target);
		int start = 0;
		int end = list.size() - 1;
		while (start <= end) {
			int i = (start + end) / 2;
			double dif = target - (double) list.get(i);
			// update min value
			if (Math.abs(dif) < mindif) {
				mindif = Math.abs(dif);
				minix = i;
			}
			// update new range
			if (dif > 0) {
				start = i + 1;
			} else if (dif == 0) {
				return i;
			} else {
				end = i - 1;
			}
		}
		return minix;
	}

	public static void main(String[] args) {
		ClosestNumberInBST bst = new ClosestNumberInBST();
		List<Integer> list = new ArrayList<>();
		int[] array = new int[] { 1, 2, 3, 4, 5, 7, 8, 10 };
		for (int i : array) {
			list.add(i);
		}
		System.out.println(bst.findClosest(list, 4.6));
	}
}
