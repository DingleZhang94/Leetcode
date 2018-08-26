package leetCode;

public class ArrangeCoins {
	public static int arrangeCoins(int n) {
		return (int) ((Math.sqrt(8 * (long) n + 1) - 1) / 2);
	}

	public static void main(String[] args) {
		System.out.println(arrangeCoins(1804289383));
	}
}
