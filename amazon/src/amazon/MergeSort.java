package amazon;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 2, 9, 7, 4, 0, 3, 8, 6 };
		System.out.println(Arrays.toString(array));

		mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	private static void mergeSort(int[] array, int start, int end) {
		if (end <= start) {
			return;
		}
		
		int middle = (start + end) / 2;
		mergeSort(array, start, middle);
		mergeSort(array, middle + 1, end);
		
		int[] a = new int[middle - start + 1];		
		int[] b = new int[end - middle];		
		
		for (int i = 0; i <= middle - start; i++) {
			a[i] = array[start + i];
		}
		for (int i = 0; i <= end - middle - 1; i++) {
			b[i] = array[middle + 1 + i];
		}
		
		int i = 0;
		int j = 0;
		
		for (int k = start; k <= end; k++) {
			if (i < a.length && j < b.length) {
				if (a[i] < b[j]) {
					array[k] = a[i++];
				} else {
					array[k] = b[j++];
				}
			} else if (i < a.length) {
				array[k] = a[i++];
			} else if (j < b.length) {
				array[k] = b[j++];
			}
		}
	}
}
