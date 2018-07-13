package intro;

import java.util.Arrays;
import java.util.Random;

public class Test {
	public double[] generator(int x) {
		double[] a = new double[x];
		double remain = 100;
		Random random = new Random();
		for (int i = 0; i < x - 1; i++) {
			a[i] = random.nextDouble() * remain;
			remain = remain - a[i];
		}
		a[x - 1] = remain;
		return a;
	}

	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Arrays.sort(a, 7, a.length - 1);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
