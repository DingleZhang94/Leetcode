package leetCode;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int maxsum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			maxsum = Math.max(maxsum, sum);
			sum = sum < 0 ? 0 : sum;
		}
		return maxsum;
	}

	public static void main(String[] args) {
		MaximumSubarray a = new MaximumSubarray();
		int[] b = { 0, -1, 0, -4, 0, -2, 0, 0, -4 };
		System.out.println(a.maxSubArray(b));
	}

}
