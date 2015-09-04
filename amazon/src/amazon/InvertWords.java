package amazon;

import java.util.StringTokenizer;

public class InvertWords {

	public static void main(String[] args) {
		StringBuffer result = new StringBuffer();
		StringTokenizer tokens = new StringTokenizer(args[0]);
		while (tokens.hasMoreTokens()) {
			result.insert(0, " ").insert(0, tokens.nextToken());
		}
		
		System.out.println(result.toString());
	}
}
