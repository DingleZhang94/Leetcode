package leetCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	public boolean isMatch(String s, String p) {
		Pattern pattern = Pattern.compile(s);
		Matcher matcher = pattern.matcher(s);
		boolean result = matcher.matches();
		return result;
	}
}
