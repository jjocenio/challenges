package amazon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 */
public class MaxTreeWidth {

	public static void main(String[] args) {
		System.out.println(maxWidth(getRoot()));
	}
	
	private static Node getRoot() {
		Node root = new Node('1');
		root.left = new Node('2');
		root.right = new Node('3');
		root.left.left = new Node('4');
		root.left.right = new Node('5');
		root.right.left = new Node('8');
		root.right.right = new Node('8');
		root.right.right.left = new Node('6');
		root.right.right.right = new Node('7');

		return root;
	}
	
	private static int maxWidth(Node root) {
		List<Integer> listWidths = new LinkedList<Integer>();
		collectWidths(root, listWidths, 0);
		return Collections.max(listWidths);
	}
	
	private static void collectWidths(Node root, List<Integer> list, int level) {
		while (list.size() < level + 1) {
			list.add(0);
		}
		
		if (root == null)
			return;
		
		Integer width = list.get(level);
		list.set(level, width + 1);
		
		collectWidths(root.left, list, level + 1);
		collectWidths(root.right, list, level + 1);
	}
}
