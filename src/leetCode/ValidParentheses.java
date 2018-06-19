package leetCode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push(1);
			if (s.charAt(i) == '{')
				stack.push(2);
			if (s.charAt(i) == '[')
				stack.push(3);

			if (s.charAt(i) == ')') {
				if (stack.pop() != 1)
					return false;
			}
			if (s.charAt(i) == '}') {
				if (stack.pop() != 2)
					return false;
			}
			if (s.charAt(i) == ']') {
				if (stack.pop() != 3)
					return false;
			}
		}
		return true;
	}
}
