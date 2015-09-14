package amazon;

import java.util.Arrays;
import java.util.List;

public class Node {

	char value;
	Node left;
	Node right;

	public Node(char value) {
		super();
		this.value = value;
	}
	
	public List<Node> getChildren() {
		return Arrays.asList(left, right);
	}
}