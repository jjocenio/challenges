package hackerrank;

import java.util.Scanner;

public class QuicksortInPlace {
	private static void quickSort(int[] ar) {
		quickSort(ar, 0, ar.length - 1);
	}

	private static void quickSort(int[] ar, int start, int end) {
		if (start < end) {
			int p = partition(ar, start, end);

			if (p != end) {
				printArray(ar);
			}

			quickSort(ar, start, p - 1);
			quickSort(ar, p, end);
		}
	}

	private static int partition(int[] ar, int start, int end) {
		int pivot = ar[end];
		int i = start;

		int swap = 0;
		for (int j = start; j < end; j++) {
			if (ar[j] < pivot) {
				swap = ar[j];
				ar[j] = ar[i];
				ar[i] = swap;
				i++;
			}
		}

		swap = ar[end];
		ar[end] = ar[i];
		ar[i] = swap;

		return i;
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] ar = new int[n];

		for (int i = 0; i < n; i++) {
			ar[i] = scan.nextInt();
		}

		quickSort(ar);

		scan.close();
	}
}
