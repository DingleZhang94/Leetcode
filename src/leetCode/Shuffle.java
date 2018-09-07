package leetCode;

public class Shuffle {
	public static void shuffle(int[] array) {
		for (int i = 0; i < array.length; i++) {
			swap(array, i, i + (int) (Math.random() * (array.length - i)));
		}
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	static void print(int[] array) {
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 3, 4, 5, 5 };
		Shuffle.shuffle(a);
		Shuffle.print(a);
	}
}
