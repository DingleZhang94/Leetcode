package leetCode;

public class RomanToIntegers {
	public static void main(String[] args) {
		String s = "CM";
		System.out.println("Roman: " + s);
		System.out.println("Integer: " + romanToInt(s));
	}

	public static int romanToInt(String s) {
		int result = 0;
		int I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000;
		for (int i = s.length() - 1; i >= 0; i--) {

			if (s.charAt(i) == 'I') {
				result = result + I;
			}
			if (s.charAt(i) == 'V') {
				result = result + V;
				I = -1;
			}
			if (s.charAt(i) == 'X') {
				result = result + X;
				I = -I;
				V = -V;
			}
			if (s.charAt(i) == 'L') {
				result = result + L;
				X = -X;
			}
			if (s.charAt(i) == 'C') {
				result = result + C;
				X = -X;
			}
			if (s.charAt(i) == 'D') {
				result = result + D;
				C = -C;
			}
			if (s.charAt(i) == 'M') {
				result = result + M;
				C = -C;
			}
		}
		return result;
	}
}
