package leetCode;

public class Zigzag {
	public static void main(String[] args) {
		String s = "PPAP";
		System.out.println(convert(s, 3));
	}

	public static String convert(String s, int numRows) {
		StringBuilder sb = new StringBuilder();
		int stride = numRows * 2 - 2;
		for (int n = 0; n < numRows; n++) {
			for (int i = 0; i < s.length(); i++) {
				if (i % stride == n || i % stride == stride - n) {
					sb.append(s.charAt(i));
				}
			}
		}
		return sb.toString();
	}
}