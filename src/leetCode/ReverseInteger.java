package leetCode;

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger a = new ReverseInteger();
		System.out.println(a.reverse(123));

	}

	public int reverse(int x) {
		if (x < 10 && x > -10) {
			return x;
		}
		long longr = 0;
		int[] a = new int[10];
		int sign = x > 0 ? 1 : -1;
		x = Math.abs(x);
		int i = 0;
		while (x != 0) {
			a[i] = x % 10;
			x /= 10;
			i++;
		}
		for (int j = 0; j < i; j++) {
			longr = (long) (longr + a[j] * Math.pow(10, i - j - 1));
		}
		if (longr > Integer.MAX_VALUE || longr < Integer.MIN_VALUE) {
			return 0;
		} else {
			return (int) longr * sign;
		}
	}
}
