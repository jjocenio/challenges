package amazon;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Set;

public class LastRepeatedWord {

	static interface Stream {
	    char next();
	    boolean hasNext();
	}
	
	static class StreamImpl implements Stream {
		private final ByteArrayInputStream stream;
		
		public StreamImpl(String text) {
			this.stream = new ByteArrayInputStream(text.getBytes());			
		}

		@Override
		public char next() {
			return Character.valueOf((char) stream.read());
		}

		@Override
		public boolean hasNext() {
			return stream.available() > 0;
		}
	}
	
	public static void main(String[] args) {
		String text = "The angry dog was red.";
		System.out.println(getLastRepeatedWord(new StreamImpl(text)));
	}

	private static String getLastRepeatedWord(Stream input) {
		Set<String> words = new HashSet<String>();
		
		String lastRepeated = "";
		String word = null;
		while ((word = nextWord(input)) != null) {
			if (words.contains(word)) {
				lastRepeated = word;
			}
			
			words.add(word);
		}
		
		return lastRepeated;
	}
	
	private static String nextWord(Stream input) {
		if (!input.hasNext()) {
			return null;
		}
		
		StringBuffer buffer = new StringBuffer();
		
		Character current = null;
		while (input.hasNext()) {
			current = input.next();
			if (Character.isLetter(current)) {
				buffer.append(current);
			} else {
				break;
			}
		}
		
		return buffer.toString().toLowerCase();
	}
}
