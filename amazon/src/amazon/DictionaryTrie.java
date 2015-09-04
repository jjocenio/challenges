package amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DictionaryTrie {

	private static final Trie dictionary = new Trie();

	public static void main(String[] args) {
		loadDictionary();
		Set<String> words = findValidWords(args[0], dictionary.getRoot(), "");
		
		for (String word: words) {
			System.out.println(word);
		}
	}

	private static Set<String> findValidWords(String input, TrieNode trieNode, String currentWord) {
		Set<String> words = new LinkedHashSet<String>();
		
		StringBuffer buffer = new StringBuffer(input); 
		for (TrieNode node: trieNode.getChildren()) {
			StringBuffer word = new StringBuffer(currentWord);
			int index = buffer.indexOf(String.valueOf(node.getSymbol())); 
			if (index >= 0) {
				buffer.deleteCharAt(index);
				word.append(node.getSymbol());
				if (node.isKey()) {
					words.add(word.toString());
				}

				words.addAll(findValidWords(buffer.toString(), node, word.toString()));
			}
		}
		
		return words;
	}

	private static void loadDictionary() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				Thread.currentThread().getContextClassLoader().getResourceAsStream("dictionary.txt")));
		String line = null;
		
		try {
			while ((line = reader.readLine()) != null) {
				dictionary.insert(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Trie {

	private TrieNode root = new TrieNode('\0');

	public TrieNode getRoot() {
		return root;
	}

	public boolean has(String word) {
		return root.has(word);
	}

	public void insert(String word) {
		root.insert(word);
	}
}

class TrieNode {

	private Character symbol;
	private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	private boolean key = false;

	public TrieNode(Character symbol) {
		super();
		this.symbol = symbol;
	}

	public Collection<TrieNode> getChildren() {
		return children.values();
	}

	public Character getSymbol() {
		return symbol;
	}

	public boolean has(String word) {
		String lowerWord = word.toLowerCase();
		TrieNode current = this;

		for (int c = 0; c < lowerWord.length(); c++) {
			TrieNode child = current.children.get(lowerWord.charAt(c));
			if (child == null) {
				return false;
			}

			current = child;
		}

		return current.isKey();
	}

	public void insert(String word) {
		String lowerWord = word.toLowerCase();
		TrieNode current = this;

		for (int c = 0; c < lowerWord.length(); c++) {
			TrieNode child = current.children.get(lowerWord.charAt(c));
			if (child == null) {
				child = new TrieNode(lowerWord.charAt(c));
				current.children.put(child.symbol, child);
			}

			current = child;
		}

		current.key = true;
	}

	public boolean isKey() {
		return key;
	}
}