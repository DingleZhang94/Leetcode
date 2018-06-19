package leetCode;

public class StringtoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int myAtoi(String str) {
		if (str.length() == 0) {
			return 0;
		}
		return (int) Integer.parseInt(str);
	}
}
