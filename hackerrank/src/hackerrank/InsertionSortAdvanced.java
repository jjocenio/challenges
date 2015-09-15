package hackerrank;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/insertion-sort
 */
public class InsertionSortAdvanced {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] ar = new int[n];
			for (int j = 0; j < n; j++) {
				ar[j] = in.nextInt();
			}
			long c = insertSort(ar);
			System.out.println(c);
		}
		
		in.close();
	}

	public static long insertSort(int[] ar) {
		long count = 0;

		for (int i = 1; i < ar.length; i++) {
			int current = ar[i];
			int j = i - 1;
			while (j >= 0 && ar[j] > current) {
				ar[j + 1] = ar[j--];
				count++;
			}
			ar[j + 1] = current;
		}

		return count;

	}
}
