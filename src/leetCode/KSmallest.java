package leetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallest {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.val < o1.val ? -1 : 1;
			}
		});
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];

		int row = 0;
		int col = 0;
		Node node = new Node(row, col, matrix[row][col]);
		queue.offer(node);
		visited[row][col] = true;

		while (k > 0) {
			node = queue.poll();
			k--;
			if (node.row < m && !visited[node.row + 1][node.col]) {
				queue.add(new Node(node.row + 1, node.col, matrix[node.row + 1][node.row]));
				visited[node.row + 1][node.col] = true;
			}

			if (node.col < n && !visited[node.row][node.col + 1]) {
				queue.add(new Node(node.row, node.col + 1, matrix[node.row][node.col + 1]));
				visited[node.row][node.col + 1] = true;
			}
		}

		return node.val;
	}

	static class Node {
		int row;
		int col;
		int val;

		public Node(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}
	}
}
