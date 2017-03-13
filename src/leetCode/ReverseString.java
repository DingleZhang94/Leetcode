package leetCode;

public class ReverseString {
	public String reverseString1(String s) {
		// very slow. my first job
		StringBuilder result = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			result.append(s.charAt(i));
		}
		return result.toString();
	}

	public String reverseString2(String s) {
		// much more concise and quicker than the first.
		return new StringBuilder(s).reverse().toString();
	}

	public String reverseString3(String s) {
		// the quickest method using char array.
		int i = 0;
		int j = s.length() - 1;
		char[] word = s.toCharArray();
		char temp = ' ';
		while (i < j) {
			temp = word[i];
			word[i] = word[j];
			word[j] = temp;
			i++;
			j--;
		}
		return new String(word);
	}
}
