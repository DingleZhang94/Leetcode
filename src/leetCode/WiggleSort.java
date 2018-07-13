package leetCode;

public class WiggleSort {
	public void wiggleSort(int[] nums) {
		if (nums.length < 2)
			return;
		// quickselect the median number of the array
		int p = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
		final int n = nums.length;
		int m = 0, r = nums.length - 1;
		int lw = 1, mw = 1, rw = (1 + 2 * (nums.length - 1)) % (n | 1);
		while (m <= r) {
			if (nums[mw] > p) {
				int tmp = nums[mw];
				nums[mw] = nums[lw];
				nums[lw] = tmp;
				mw = (mw + 2) % (n | 1);
				++m;
				lw = (lw + 2) % (n | 1);
			} else if (nums[mw] < p) {
				int tmp = nums[mw];
				nums[mw] = nums[rw];
				nums[rw] = tmp;
				rw = (rw - 2 + (n | 1)) % (n | 1);
				--r;
			} else {
				mw = (mw + 2) % (n | 1);
				++m;
			}
		}
	}

	public void name(int i, double x) {

	}

	public void name(double x, int i) {

	}

	private int newIndex(int index, int n) {
		return (1 + 2 * index) % (n | 1);
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private int quickSelect(int[] nums, int start, int end, int n) {
		// partition
		System.out.println("start: " + start + " end:" + end + " n:" + n);

		int pivot = nums[start];
		int i = start;
		int j = end;
		while (i <= j) {
			while (i <= j && nums[i] <= pivot) {
				i++;
			}
			while (i <= j && nums[j] > pivot) {
				j--;
			}
			if (i < j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				for (int k : nums) {
					System.out.print(k + " ");
				}
				System.out.println();
			}
		}
		int temp = nums[j];
		nums[j] = pivot;
		nums[start] = temp;

		// Check j with n
		if (j == n) {
			return pivot;
		} else if (j > n) {
			return quickSelect(nums, start, j - 1, n);
		} else {
			return quickSelect(nums, j + 1, end, n);
		}
	}

	public static void main(String[] args) {
		WiggleSort a = new WiggleSort();
		int[] nums = { 1, 3, 2, 2, 2, 1, 1, 3, 1, 1, 2 };
		int n = nums.length;
		System.out.println(a.quickSelect(nums, 0, nums.length - 1, (nums.length - 1) / 2));
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		a.wiggleSort(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();

	}
}
