package leetCode;

import java.util.PriorityQueue;

public class KSmallestInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		// assume the input is correct
		int n = matrix.length, m = matrix[0].length;

		PriorityQueue<Node> min = new PriorityQueue<>();

		boolean[][] visited = new boolean[n][m];

		int count = 0;
		Node res = new Node(0, 0, matrix[0][0]);

		while (count < k) {
			res = min.poll();
			count++;

			// add next column
			if (res.col + 1 < n && !visited[res.col + 1][res.row]) {
				visited[res.col + 1][res.row] = true;
				min.add(new Node(res.col + 1, res.row, matrix[res.col + 1][res.row]));
			}

			// add next row
			if (res.row + 1 < m && !visited[res.col][res.row + 1]) {
				visited[res.col][res.row + 1] = true;
				min.add(new Node(res.col, res.row + 1, matrix[res.col][res.row + 1]));
			}

		}
		return res.val;
	}
}

class Node implements Comparable<Node> {
	int col;
	int row;
	int val;

	public Node(int col, int row, int val) {
		this.col = col;
		this.row = row;
		this.val = val;
	}

	public int compareTo(Node another) {
		return this.val < ((Node) another).val ? -1 : 1;
	}

	public boolean equals(Node another) {
		return this.col == another.col && this.row == another.row ? true : false;
	}

}
