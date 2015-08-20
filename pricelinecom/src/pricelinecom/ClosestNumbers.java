package pricelinecom;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream(new File("input1.txt")));
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		System.out.println("Reading " + n + " numbers");
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}

		Arrays.sort(array);
		List<Integer> pairs = new LinkedList<Integer>();

		System.out.println("Input read");
		int minDiference = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			int diference = Math.abs(array[i] - array[i + 1]);
			if (diference <= minDiference) {
				if (diference < minDiference) {
					pairs.clear();
				}

				pairs.add(array[i]);
				pairs.add(array[i + 1]);
				minDiference = diference;
			}
		}

		for (Integer number : pairs) {
			System.out.printf("%d ", number);
		}
	}
}