package learning;

public class alibaba {

	/** 请完成下面这个函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/
	static int maxScore(int[] score) {
		int max;
		int n = score.length;
		int[] tempScore = new int[n];
		for (int i = 0; i < n; i++) {
			if (score[i] == 0) {
				tempScore[i] = 1;
			} else {
				tempScore[i] = score[i];
			}
		}
		max = score[0] * (score[1] == 0 ? 1 : score[1]) + score[n - 1] * (score[n - 2] == 0 ? 1 : score[n - 2]);
		for (int i = 1; i < n - 1; i++) {
			if (score[i] != 0) {
				int temp = tempScore[i - 1] * tempScore[i] * tempScore[i + 1];
				max = Math.max(max, temp);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int res;
		int a[] = { 4, 2, 3, 0, 3 };
		res = maxScore(a);
		System.out.println(String.valueOf(res));

	}
}
