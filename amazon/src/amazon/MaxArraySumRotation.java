package amazon;

public class MaxArraySumRotation {
	
	public static void main(String[] args) {
		System.out.println(getMaxSum(new int[] { 1, 1, 1, 4 } ));
	}

	private static int getMaxSum(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = 0; j < a.length; j++) {
				sum += j * a[((i + j) % a.length)];
			}
			
			max = Math.max(max, sum);
		}
		
		return max;
	}
}
