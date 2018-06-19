package leetCode;

public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber a = new PalindromeNumber();
		System.out.println(a.isPalindrome(1112111));
	}

	public boolean isPalindrome(int x) {
		if (x >= 0 && x < 10) {
			return true;
		}
		if (x < 0) {
			return false;
		}
		String a = Integer.toString(x);
		for (int i = 0; i < a.length() - 1 - i; i++) {
			if (a.charAt(i) == a.charAt(a.length() - i - 1)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
