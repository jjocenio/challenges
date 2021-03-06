package amazon;

import java.io.ByteArrayInputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FirstNoRepeatedWord {
	
	public static void main(String[] args) {
		Enumeration<Character> input = new Enumeration<Character>() {
			private final String text = "The dog has a red nose. The dog has one white nose.";
			private final ByteArrayInputStream stream = new ByteArrayInputStream(text.getBytes());
			
			@Override
			public boolean hasMoreElements() {
				return stream.available() > 0;
			}

			@Override
			public Character nextElement() {
				return Character.valueOf((char) stream.read());
			}
		};
		
		System.out.println(getFirstNoRepeatedWord(input));
	}

	private static String getFirstNoRepeatedWord(Enumeration<Character> input) {
		List<String> notRepeatedWords = new LinkedList<String>();
		Set<String> repeatedWords = new HashSet<String>();
		
		String word = null;
		while ((word = nextWord(input)) != null) {
			if (!repeatedWords.contains(word)) {
				if (notRepeatedWords.contains(word)) {
					notRepeatedWords.remove(word);
					repeatedWords.add(word);
				} else {
					notRepeatedWords.add(word);
				}
			}
		}
		
		return notRepeatedWords.isEmpty() ? null : notRepeatedWords.get(0);
	}
	
	private static String nextWord(Enumeration<Character> input) {
		if (!input.hasMoreElements()) {
			return null;
		}
		
		StringBuffer buffer = new StringBuffer();
		
		Character current = null;
		while (input.hasMoreElements()) {
			current = input.nextElement();
			if (Character.isLetter(current)) {
				buffer.append(current);
			} else {
				break;
			}
		}
		
		return buffer.toString().toLowerCase();
	}
}
