package leetCode;

public class MinSubArrayLen {

	public static int minSubArrayLen(int s, int[] nums) {
		int length = 0;
		int sum = 0;
		while (sum < s && length < nums.length) {
			sum += nums[length];
			length++;
		}
		if (sum < s && length == nums.length) {
			return 0;
		}
		int i = length - 1;
		while (i < nums.length) {
			System.out.println("1 i: " + i + " sum: " + sum + " length:" + length);
			while (sum - nums[i - length + 1] >= s) {
				sum = sum - nums[i - length + 1];
				length--;
			}
			System.out.println("2 i: " + i + " sum: " + sum + " length:" + length);
			sum = sum - nums[i - length + 1];
			if (i + 1 < nums.length) {
				sum = sum + nums[i + 1];
			}
			i++;
		}
		return length;
	}

	public static void main(String[] args) {
		int[] a = {};
		System.out.println(minSubArrayLen(213, a));
	}

}
