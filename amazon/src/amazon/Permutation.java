package amazon;

import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		printPermutation(new int[] { 1, 2, 3, 4 }, 0);
	}

	private static void printPermutation(int[] a, int s) {
		if (s == a.length) {
			System.out.println(Arrays.toString(a));
		} else {
			for (int i = s; i < a.length; i++) {
				if (i != s) swap(a, i, s);
				printPermutation(a, s + 1);
				if (i != s) swap(a, s, i);
			}
		}
	}

	private static void swap(int[] a, int i, int s) {
		int tmp = a[i];
		a[i] = a[s];
		a[s] = tmp;
	}
}
