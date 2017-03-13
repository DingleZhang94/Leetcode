package leetCode;

public class SpecialAdd {
	public static int specialAdd(int a, int b) {
		if (b == 0)
			return a;
		int sum, carry;
		sum = a ^ b;
		carry = (a & b) << 1;
		return specialAdd(sum, carry);
	}

	public static void main(String[] args) {
		System.out.println("The number is: " + specialAdd(12, 13));
	}
}
