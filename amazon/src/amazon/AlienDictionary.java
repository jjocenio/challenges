package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 */
public class AlienDictionary {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortAlienLetters(new String[] {"baa", "abcd", "abca", "caz", "caa"})));
		System.out.println(Arrays.toString(sortAlienLetters(new String[] {"caa", "aaa", "aab"})));
	}

	private static Character[] sortAlienLetters(String[] words) {
		Map<Character, LetterNode> letters = new HashMap<Character, LetterNode>();
		LetterNode root = null;
		
		for (int i = 0; i < words.length - 1; i++) {
			String wordA = words[i], wordB = words[i + 1];
			for (int j = 0; j < Math.min(wordA.length(), wordB.length()); j++) {
				char chA = wordA.charAt(j), chB = wordB.charAt(j);
				if (chA != chB) {
					LetterNode nodeA = letters.containsKey(chA) ? letters.get(chA) : new LetterNode(chA);
					LetterNode nodeB = letters.containsKey(chB) ? letters.get(chB) : new LetterNode(chB);
					
					if (nodeB.prev != null && nodeB.prev != nodeA) {
						nodeA.prev = nodeB.prev;
						nodeA.prev.next = nodeA; 
					}
					
					nodeA.next = nodeB;
					nodeB.prev = nodeA;
					
					if (nodeA.prev == null) {
						root = nodeA;
					}
					
					letters.put(chA, nodeA);
					letters.put(chB, nodeB);
					
					break;
				}
			}
		}
		
		Character[] sortedLetters = new Character[letters.size()];
		
		int c = 0;
		LetterNode current = root;
		while (current != null) {
			sortedLetters[c++] = current.value;
			current = current.next;
		}
		
		return sortedLetters;
	}
}

class LetterNode {

	char value;
	LetterNode prev;
	LetterNode next;

	public LetterNode(char value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return (prev != null ? String.valueOf(prev.value) : "") 
				+ " -> " + value + " -> " 
				+ (next != null ? String.valueOf(next.value) : "");
	}
}