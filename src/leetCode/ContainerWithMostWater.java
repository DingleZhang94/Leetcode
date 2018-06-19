package leetCode;

public class ContainerWithMostWater {
	public int maxArea1(int[] height) {
		if (height.length == 2) {
			return Math.min(height[0], height[1]);
		}
		int i = 0;
		int j = height.length - 1;
		int maxarea = Math.min(height[0], height[height.length - 1]) * (height.length - 1);
		while (i < j) {

			if (height[i] < height[j]) {
				System.out.println("i= " + i + "j= " + j);
				int temp = height[i];
				i++;
				while (height[i] < temp) {
					i++;
				}
				int area = Math.min(height[i], height[j]) * (j - i);
				maxarea = Math.max(area, maxarea);
			}
			if (height[i] > height[j]) {
				System.out.println("i= " + i + "j= " + j);
				int temp = height[j];
				j--;
				while (height[j] < temp) {
					j--;
				}
				int area = Math.min(height[i], height[j]) * (j - i);
				maxarea = Math.max(area, maxarea);
			}
			if (height[i] == height[j]) {
				System.out.println("i= " + i + "j= " + j);
				int kj = j - 1 == -1 ? j : j - 1;
				int ki = i + 1 == height.length ? i : i + 1;
				while (height[ki] < height[i] && ki <= j) {
					ki++;
				}
				if (ki == j) {
					return maxarea;
				}
				while (height[kj] < height[j] && kj >= i) {
					kj--;
				}
				System.out.println("ki=" + ki + " kj=" + kj);
				if (j - kj > ki - i) {
					i = ki;
					int area = Math.min(height[i], height[j]) * (j - i);
					maxarea = Math.max(area, maxarea);
				} else {
					j = kj;
					int area = Math.min(height[i], height[j]) * (j - i);
					maxarea = Math.max(area, maxarea);
				}
			}
		}
		return maxarea;
	}

	public static void main(String[] args) {
		ContainerWithMostWater a = new ContainerWithMostWater();
		int[] b = { 1, 2, 4, 3 };
		System.out.println(a.maxArea(b));
	}

	public int maxArea(int[] height) {
		int i = 0, j = height.length - 1;
		int maxarea = Math.min(height[i], height[j]) * (j - i);
		while (i < j) {
			if (height[i] <= height[j]) {
				i++;
			} else if (height[i] > height[j]) {
				j--;
			}
			maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
		}
		return maxarea;
	}
}
