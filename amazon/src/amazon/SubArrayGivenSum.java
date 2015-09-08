package amazon;

/*
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 */
public class SubArrayGivenSum {

	public static void main(String[] args) {
		printSubArraysWithSum(new  int[] {1, 2, 3, 4, 5}, 5);
		printSubArraysWithSum(new  int[] {1, 2, 3, 4, 5}, 9);
	}
	
	private static void printSubArraysWithSum(int[] array, int sum) {
		if (array.length == 0) {
			return;
		}
		
		int currentSum = array[0];
		int start = 0;
		
		for (int i = 1; i <= array.length; i++) {
			while (currentSum > sum && start < i - 1) {
				currentSum -= array[start];
				start++;
			}
			
			if (currentSum == sum) {
				System.out.println(start + " to " + (i - 1));
			}
			
			currentSum += (i < array.length) ? array[i] : 0;
		}
	}
}
