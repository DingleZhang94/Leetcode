package leetCode;

public class NumArray {
	private int[] a;

	public NumArray(int[] nums) {
		if (nums.length != 0) {
			a = new int[nums.length + 1];
			a[1] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				a[i + 1] = nums[i] + a[i];
			}
		}
	}

	public int sumRange(int i, int j) {
		return a[j + 1] - a[i];
	}

}
