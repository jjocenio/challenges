package amazon;

public class CakeFlavors {

	public static void main(String[] args) {
		System.out.println(maximunPleasure(new int[]{10, -2, 5, -4, 3, -5, 10}));
//		System.out.println(maximunPleasure(new int[]{-1, -5, -7, 9, 10, 8}));
//		System.out.println(maximunPleasure(new int[]{-1, -2, 1, -7}));
	}
	
	public static int maximunPleasure(int[] cakeLayers) {
		int indexMaxSum = -1;
		int maxSum = Integer.MIN_VALUE;
		int maxInverseSum = Integer.MIN_VALUE;
		
		// Sum left to right
		int sum = 0;
		for (int i = 0; i < cakeLayers.length; i++) {			
			sum += cakeLayers[i];
			
			if (sum > maxSum) {
				maxSum = sum;
				indexMaxSum = i;
			}
		}
		
		// If the maxSum reach the end, try sum on inverse order
		if (indexMaxSum == cakeLayers.length - 1) {
			indexMaxSum = 0;
		}
		
		// Sum right to left
		sum = 0;
		for (int i = cakeLayers.length - 1; i > indexMaxSum; i--) {
			sum += cakeLayers[i];
			
			if (sum > maxInverseSum) {
				maxInverseSum = sum;
			}
		}
		
		// If both are negative, eat nothing
		if (maxSum < 0 && maxInverseSum < 0) {
			return 0;
		}
		
		// If reach the end, the max is one or other
		if (indexMaxSum == 0) {
			return Math.max(maxSum, maxInverseSum);
		}
		
		// If not reach the end, check the max
		return Math.max(Math.max(maxSum, maxInverseSum), maxSum + maxInverseSum);
	}	
}
