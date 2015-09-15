import java.util.LinkedList;
import java.util.Queue;


public class StackQueue {

	private Queue<Integer> queue1 = new LinkedList<Integer>();
	private Queue<Integer> queue2 = new LinkedList<Integer>();
	
	public void push(Integer value) {
		queue1.add(value);
	}
	
	public Integer pop() {
		Integer value = null;
		while (!queue1.isEmpty()) {
			value = queue1.poll();
			if (!queue1.isEmpty()) {
				queue2.add(value);
			}
		}
		
		Queue<Integer> tmpQueue = queue1;
		queue1 = queue2;
		queue2 = tmpQueue;
		return value;
	}
	
	public static void main(String[] args) {
		StackQueue sq = new StackQueue();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		sq.push(5);
		
		Integer value = null;
		while ((value = sq.pop()) != null) {
			System.out.println(value);
		}
	}
}