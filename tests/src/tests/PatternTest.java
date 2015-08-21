package tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {
		String text = "aaabbba";
		Matcher matcher = Pattern.compile("(a)/g", Pattern.MULTILINE).matcher(text);
		System.out.println(matcher.groupCount());
	}
}
