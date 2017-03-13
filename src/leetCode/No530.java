package leetCode;

import java.util.ArrayList;

public class No530 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int minimumDifference = Integer.MAX_VALUE;
	Integer prev = null;

	public int getMinimumDifference(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		list = inorderToArray(root, list);
		int dif = getDif(list);
		return dif;
	}

	public int getDif(ArrayList<Integer> l) {
		int dif = 0;
		for (int i = 0; i < l.size() - 1; i++) {
			dif = Math.abs(l.get(i) - l.get(i + 1));
			minimumDifference = (minimumDifference <= dif ? minimumDifference : dif);
		}
		return minimumDifference;
	}

	public ArrayList<Integer> inorderToArray(TreeNode root, ArrayList<Integer> l) {
		if (root != null) {
			inorderToArray(root.left, l);
			l.add(root.val);
			inorderToArray(root.right, l);
		}
		return l;

	}

	public int getMinDif(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		getMinDif(root.left);
		if (prev != null) {
			minimumDifference = Math.min(minimumDifference, root.val - prev);
		}
		prev = root.val;
		getMinDif(root.right);
		return minimumDifference;
	}
}
