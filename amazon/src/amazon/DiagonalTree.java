package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DiagonalTree {
	
	public static void main(String[] args) {
		List<List<Node>> diagonalList = new ArrayList<List<Node>>();
		diagonal(getRoot(), 0, diagonalList);
		for (List<Node> list: diagonalList) {
			for (Node node: list) {
				System.out.print(node.value + " ");
			}
			System.out.println();
		}
	}
	
	private static Node getRoot() {
		Node root = new Node('a');
		root.left = new Node('d');
		root.left.left = new Node('h');
		root.left.left.right = new Node('i');
		root.left.right = new Node('e');
		root.right = new Node('b');
		root.right.left = new Node('f');
		root.right.right = new Node('c');
		root.right.right.left = new Node('g');
		root.right.right.left.left = new Node('j');
		return root;
	}

	private static void diagonal(Node root, int level, List<List<Node>> list) {
		if (root == null) {
			return;
		}
		
		while (list.size() < level + 1) {
			list.add(new LinkedList<Node>());
		}
		
		List<Node> currentDiagonal = list.get(level);
		currentDiagonal.add(root);
		
		diagonal(root.left, level + 1, list);
		diagonal(root.right, level, list);
	}
}

class Node {
	
	char value;
	Node left;
	Node right;

	public Node(char value) {
		super();
		this.value = value;
	}
}