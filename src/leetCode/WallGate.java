package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class WallGate {
	public int[][] wallsAndGates(int[][] rooms) {
		// Write your solution here
		int m = rooms.length;
		if (m == 0)
			return rooms;
		int n = rooms[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					BFS(rooms, i, j);
				}
			}
		}
		return rooms;
	}

	private void BFS(int[][] rooms, int i, int j) {
		int m = rooms.length;
		int n = rooms[0].length;
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> que = new LinkedList<>();
		visited[i][j] = true;
		que.add(new int[] { i, j });
		while (!que.isEmpty()) {
			int[] node = que.poll();
			int p = node[0];
			int k = node[1];
			visited[p][k] = true;
			int curlayer = rooms[p][k] + 1;
			if (k > 0 && !visited[p][k - 1] && rooms[p][k - 1] != 0 && rooms[p][k - 1] != -1) {
				rooms[p][k - 1] = Math.min(rooms[p][k - 1], curlayer);
				que.add(new int[] { p, k - 1 });
			}
			if (k < n - 1 && !visited[p][k + 1] && rooms[p][k + 1] != 0 && rooms[p][k + 1] != -1) {
				rooms[p][k + 1] = Math.min(rooms[p][k + 1], curlayer);
				que.add(new int[] { p, k + 1 });
			}
			if (p > 0 && !visited[p - 1][k] && rooms[p - 1][k] != 0 && rooms[p - 1][k] != -1) {
				rooms[p - 1][k] = Math.min(rooms[p - 1][k], curlayer);
				que.add(new int[] { p - 1, k });
			}
			if (p < m - 1 && !visited[p + 1][k] && rooms[p + 1][k] != 0 && rooms[p + 1][k] != -1) {
				rooms[p + 1][k] = Math.min(rooms[p + 1][k], curlayer);
				que.add(new int[] { p + 1, k });
			}
		}
	}
}
