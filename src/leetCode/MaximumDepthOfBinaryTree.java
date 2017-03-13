package leetCode;

import java.util.Stack;

public class MaximumDepthOfBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		int depth = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode searchNode = stack.peek();
			depth++;
			stack.pop();

		}
		return depth;
	}
}
