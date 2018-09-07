package leetCode;

public class LargestRectangular {
	public int largest(int[][] matrix) {
		// corner cases
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		// variables we need
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] right = new int[n][m];
		int[][] bottom = new int[n][m];
		int maxRec = 0;

		// init the right and bottom
		for (int i = 0; i < n; i++) {
			right[i][m - 1] = matrix[i][m - 1] == 0 ? 0 : 1;
		}

		for (int i = 0; i < m; i++) {
			bottom[n - 1][i] = matrix[n - 1][i] == 0 ? 0 : 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = m - 2; j >= 0; j--) {
				right[i][j] = matrix[i][j] == 0 ? 0 : right[i][j + 1] + 1;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = n - 2; j >= 0; j--) {
				bottom[j][i] = matrix[j][i] == 0 ? 0 : bottom[j + 1][i] + 1;
			}
		}
		// calculate the maxRec for each point then keep the global maxRec
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					continue;
				}
				int height = bottom[i][j];
				int width = 1;
				int pointMax = 1;
				while (width <= right[i][j]) {
					height = Math.min(height, bottom[i][j + width - 1]);
					pointMax = Math.max(pointMax, width * height);
					width++;
				}
				maxRec = Math.max(maxRec, pointMax);
			}
		}
		return maxRec;
	}

	public static void main(String[] args) {
		LargestRectangular r = new LargestRectangular();
		int[][] matirx = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 0, 1 }, { 1, 1, 1, 1 } };
		System.out.println(r.largest(matirx));
	}
}
