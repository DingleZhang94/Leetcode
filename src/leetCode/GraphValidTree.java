package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		// BFS method
		if (n != edges.length + 1)
			return false;
		boolean[] visited = new boolean[n];
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> builder = new ArrayList<>();
			list.add(builder);
		}
		for (int i = 0; i < edges.length; i++) {
			list.get(edges[i][0]).add(edges[i][1]);
			list.get(edges[i][1]).add(edges[i][0]);
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (visited[cur])
				return false;
			visited[cur] = true;
			for (int i : list.get(cur)) {
				if (!visited[i])
					queue.offer(i);
			}
		}

		for (boolean i : visited) {
			if (!i)
				return false;
		}
		return true;
	}

	public boolean validTree2(int n, int[][] edges) {
		// find - union method
		if (n != edges.length + 1)
			return false;
		int[] sub = new int[n];
		Arrays.fill(sub, -1);
		for (int[] edge : edges) {
			int first = edge[0];
			int second = edge[1];
			if (find(first, sub) != find(second, sub)) {
				sub[find(first, sub)] = second;
			} else {
				return false;
			}
		}
		return true;
	}

	public int find(int n, int[] sub) {
		if (sub[n] == -1)
			return n;
		n = sub[n];
		return find(n, sub);
	}

	public boolean validTree3(int n, int[][] edges) {
		if (n != edges.length + 1)
			return false;
		boolean[] visited = new boolean[n];
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			List<Integer> builder = new ArrayList<>();
			list.add(builder);
		}

		for (int[] edge : edges) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
		if (!helper(list, visited, 0, -1))
			return false;
		return true;
	}

	private boolean helper(List<List<Integer>> list, boolean[] visited, int curr, int parent) {
		if (visited[curr])
			return false;
		visited[curr] = true;
		for (int i : list.get(curr)) {
			if (i != parent && !helper(list, visited, i, curr))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 0, 1 }, { 2, 1 }, { 3, 1 }, { 4, 1 }, { 4, 5 } };
		int n = 6;
		GraphValidTree b = new GraphValidTree();
		int[] nums = { 1, 2, 3, 4, 5 };
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(b.validTree3(n, a));
	}

}
