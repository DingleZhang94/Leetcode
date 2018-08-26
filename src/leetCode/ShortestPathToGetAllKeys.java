package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

class ShortestPathToGetAllKeys {

	public int shortestPathAllKeys(String[] grid) {
		// get basic dimension of the matrix;
		int n = grid.length;
		int m = grid[0].length();
		int size = m * n;
		Deque<Integer> startPoints = new ArrayDeque<>();

		// scan through the grid. find how many keys we need;
		char max = (char) 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				char temp = grid[i].charAt(j);
				// record the number of keys
				max = max > temp ? max : temp;

				if (temp >= '@' && temp <= 'Z') {
					startPoints.offer(i * m + j);
				}
			}
		}

		// no start, return -1;

		Integer minStep = null;

		while (!startPoints.isEmpty()) {
			int step = 0;
			int start = startPoints.poll();

			// indicate whaether we got the key
			boolean[] gotKeys = new boolean[(int) max - 'a' + 2];

			// determine whether we visited the matrix in each iteration
			boolean[] visited = new boolean[size];

			// queue for BST
			Deque<Integer> que = new ArrayDeque<>();

			// innit the que and visited status
			que.offer(start);
			visited[start] = true;

			// reord the lenght of each step

			// BFS from the start; if we encounter a key, redo BFS from the key.
			// until queue is empty.
			while (true) {
				if (finished(gotKeys)) {
					if (minStep == null) {
						minStep = step;
					} else {
						minStep = Math.min(minStep, step);
					}
					break;
				}
				int count = que.size();
				if (count == 0)
					break;
				step++;
				while (count > 0) {
					int cur = que.poll();
					int i = cur / m;
					int j = cur % m;
					count--;

					// top
					if (i - 1 >= 0 && !visited[(i - 1) * m + j]) {
						// if we encounter a new key, start at this key do new
						// BFS
						if (checkUnVisitedKey(gotKeys, grid, i - 1, j)) {
							// empty queue
							que = new ArrayDeque<Integer>();
							// add new key to queue
							que.offer((i - 1) * m + j);
							// clear visited status
							visited = new boolean[size];
							visited[(i - 1) * m + j] = true;
							// reset the count of current layer
							break;
						}
						put(que, count, grid, visited, gotKeys, i - 1, j);
					}

					// bottom
					if (i + 1 < n && !visited[(i + 1) * m + j]) {
						if (checkUnVisitedKey(gotKeys, grid, i + 1, j)) {
							que = new ArrayDeque<Integer>();
							que.offer((i + 1) * m + j);
							visited = new boolean[size];
							visited[(i + 1) * m + j] = true;
							break;
						}
						put(que, count, grid, visited, gotKeys, i + 1, j);
					}

					// left
					if (j - 1 >= 0 && !visited[i * m + j - 1]) {
						if (checkUnVisitedKey(gotKeys, grid, i, j - 1)) {
							que = new ArrayDeque<Integer>();
							que.offer(i * m + (j - 1));
							visited = new boolean[size];
							visited[i * m + (j - 1)] = true;
							break;
						}
						put(que, count, grid, visited, gotKeys, i, j - 1);
					}

					// right
					if (j + 1 < m && !visited[i * m + j + 1]) {
						if (checkUnVisitedKey(gotKeys, grid, i, j + 1)) {
							que = new ArrayDeque<Integer>();
							que.offer(i * m + (j + 1));
							visited = new boolean[size];
							visited[i * m + (j + 1)] = true;
							break;
						}
						put(que, count, grid, visited, gotKeys, i, j + 1);
					}
				}
			}
		}

		return minStep == null ? -1 : minStep;

	}

	// determine if we have already got the whole key
	private boolean finished(boolean[] gotKeys) {
		for (boolean gotKey : gotKeys) {
			if (!gotKey)
				return false;
		}
		return true;
	}

	// check if we got the key already
	private boolean checkUnVisitedKey(boolean[] gotKeys, String[] grid, int i, int j) {
		char cur = grid[i].charAt(j);
		if (cur <= 'z' && cur >= 'a') {
			if (gotKeys[cur - 'a']) {
				return false;
			} else {
				gotKeys[cur - 'a'] = true;
				return true;
			}
		} else if (cur == '@') {
			if (gotKeys[gotKeys.length - 1])
				return false;
			else {
				gotKeys[gotKeys.length - 1] = true;
				return true;
			}
		} else {
			return false;
		}
	}

	private void put(Deque<Integer> que, int count, String[] grid, boolean[] visited, boolean[] gotKeys, int i, int j) {
		char cur = grid[i].charAt(j);
		int m = grid[0].length();
		// if encounter the wall, we don't do anything.
		if (cur == '#')
			return;

		if (!visited[i * m + j]) {
			// if encounter an empty piont or start point, we step into that
			// point and added it to the queue.
			if ((cur == '.')) {
				que.offer(i * m + j);
				visited[i * m + j] = true;
				return;
			}

			if (cur == '@') {
				if (gotKeys[gotKeys.length - 1]) {
					que.offer(i * m + j);
					visited[i + m + j] = true;
					return;
				}
			}

			// if we encounter a lock, check if we have the key
			if (cur >= 'A' && cur <= 'Z') {
				if (gotKeys[cur - 'A']) {
					// if we got the key, add it the lock to the queue.
					que.offer(i * m + j);
					visited[i * m + j] = true;
					return;
				}
			}

			// if we encounter a key, add it to the queue, and got the key.
			if (cur >= 'a' && cur <= 'z') {
				visited[i * m + j] = true;
				que.offer(i * m + j);
				return;
			}
		}
	}

	// public int solution2(String[] grid){

	// }

	public static void main(String[] args) {
		String[] str = { "a#...A", "B#@##b", "......" };
		ShortestPathToGetAllKeys a = new ShortestPathToGetAllKeys();
		System.out.println(a.shortestPathAllKeys(str));
	}
}