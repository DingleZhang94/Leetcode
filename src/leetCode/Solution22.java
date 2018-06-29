package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution22 {

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		backtrack(list, 0, 0, "", n);
		return list;
	}

	private void backtrack(List<String> list, int numOfOpen, int numOfClose, String str, int max) {

		// if (numOfOpen == max + 1) {
		// list.add(str + ")");
		// } else {
		// str = str + "(";
		// numOfOpen++;
		// System.out.println("numOfOpen:" + numOfOpen + " numOfClose: " +
		// numOfClose);
		// System.out.println(str);
		// for (int i = Math.min(max - numOfClose - 1, numOfOpen); i >= 0; i++)
		// {
		// for (int j = i; j > 0; j--) {
		// str = str + ')';
		// }
		// backtrack(list, numOfOpen, numOfClose + i, str, max);
		// }
		// }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution22 a = new Solution22();
		List<String> bList = a.generateParenthesis(3);
		System.out.println(Arrays.toString(bList.toArray()));
	}

}
