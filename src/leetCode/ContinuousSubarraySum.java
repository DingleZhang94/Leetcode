package leetCode;

import java.util.HashMap;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int tempsum = k == 0 ? sum : sum % k;
			Integer l = map.get(tempsum);
			if (l != null) {
				if (i - l > 1) {
					return true;
				}
			} else {
				map.put(tempsum, i);
			}
		}
		return false;
	}

	public boolean checkSubarraySum1(int[] nums, int k) {
		k = Math.abs(k);
		if (nums.length == 1) {
			return false;
		}

		if (k == 0) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					return false;
				}
			}
			return true;
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] % k;
		}
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		sum[1] = nums[1] + sum[0];
		if (sum[1] % k == 0) {
			return true;
		}
		for (int i = 2; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
			if (sum[i] % k == 0 || sum[i - 2] == sum[i]) {
				return true;
			}
		}
		if (sum[nums.length - 1] == 0) {
			return true;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < sum.length; i++) {
			map.put(sum[i], sum[i]);
		}
		int l = sum[nums.length - 1] / k;
		for (int j = 1; j <= l; j++) {
			for (int i = 1; i < sum.length; i++) {
				if (map.containsKey(sum[i] - j * k)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContinuousSubarraySum a = new ContinuousSubarraySum();
		int[] b = { 0 };
		System.out.println(a.checkSubarraySum(b, 0));
	}

}
