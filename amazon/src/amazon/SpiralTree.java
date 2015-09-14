package amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpiralTree {
	
	public static void main(String[] args) {
		printSpiralTree(getRoot());
	}
	
	private static Node getRoot() {
		Node root = new Node('1');
		root.left = new Node('2');
		root.right = new Node('3');
		root.right.right = new Node('4');
		root.right.left = new Node('5');
		root.left.left = new Node('6');
		return root;
	}

	private static void printSpiralTree(Node root) {
		Map<Integer, List<Node>> traverseMap = new HashMap<Integer, List<Node>>();
		traverse(root, traverseMap, 0);
		for (int l = 0; l < traverseMap.size(); l++) {
			List<Node> nodes = traverseMap.get(l);
			for (Node node: nodes) {
				System.out.print(node.value + " ");
			}
		}
	}

	private static void traverse(Node root, Map<Integer, List<Node>> traverseMap, int level) {
		if (root == null)
			return;
		
		List<Node> levelList = traverseMap.get(level);
		if (levelList == null) {
			levelList = new LinkedList<Node>();
			traverseMap.put(level, levelList);
		}
		
		if (level % 2 == 0) levelList.add(0, root);
		else levelList.add(root);
		
		for (Node child: root.getChildren()) {
			traverse(child, traverseMap, level + 1);
		}
	}
}
