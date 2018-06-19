package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
	public static List<String> letterCombinations(String digits) {
		List<String> oldList = new ArrayList<String>();
		List<String> newList = new ArrayList<String>();
		oldList.add("");
		for (int i = 0; i < digits.length(); i++) {
			char[] c;
			switch (digits.charAt(i)) {
			case '2':
				c = new char[] { 'a', 'b', 'c' };
				break;
			case '3':
				c = new char[] { 'd', 'e', 'f' };
				break;
			case '4':
				c = new char[] { 'g', 'h', 'i' };
				break;
			case '5':
				c = new char[] { 'j', 'k', 'l' };
				break;
			case '6':
				c = new char[] { 'm', 'n', 'o' };
				break;
			case '7':
				c = new char[] { 'p', 'q', 'r', 's' };
				break;
			case '8':
				c = new char[] { 't', 'u', 'v' };
				break;
			case '9':
				c = new char[] { 'w', 'x', 'y', 'z' };
				break;
			default:
				c = new char[] {};
				break;
			}
			for (int j = 0; j < oldList.size(); j++) {
				for (int k = 0; k < c.length; k++) {
					newList.add(oldList.get(j) + c[k]);
				}
			}
			oldList = newList;
			newList.clear();
		}
		return oldList;
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("23").toString());
	}

}
