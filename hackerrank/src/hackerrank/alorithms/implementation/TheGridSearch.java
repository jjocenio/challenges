package hackerrank.alorithms.implementation;

import java.util.Scanner;

public class TheGridSearch {

	public static void main(String[] args) { //thegridsearch_input1
		System.setIn(Thread.currentThread().getContextClassLoader().getResourceAsStream("thegridsearch_input2.txt"));
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		for (int i = 0; i < t; i++) {
			int[][] grid = readMatrix(scan);
			int[][] pattern = readMatrix(scan);

			System.out.println(hasPattern(grid, pattern) ? "YES" : "NO");
		}
	}

	private static boolean hasPattern(int[][] grid, int[][] pattern) {
		int pr = pattern.length;
		int pc = pattern[0].length;

		for (int r = 0; r <= grid.length - pr; r++) {
			for (int c = 0; c <= grid[r].length - pc; c++) {
				if (matches(grid, pattern, r, c)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean matches(int[][] grid, int[][] pattern, int r, int c) {
		int pr = pattern.length;
		int pc = pattern[0].length;

		for (int ir = 0; ir < pr; ir++) {
			for (int ic = 0; ic < pc; ic++) {
				if (grid[r + ir][c + ic] != pattern[ir][ic]) {
					return false;
				}
			}
		}

		return true;
	}

	private static int[][] readMatrix(Scanner scan) {
		int r = scan.nextInt();
		int c = scan.nextInt();

		int[][] matrix = new int[r][c];

		for (int i = 0; i < r; i++) {
			String line = scan.next();
			for (int j = 0; j < c; j++) {
				matrix[i][j] = Integer.valueOf(line.charAt(j));
			}
		}

		return matrix;
	}
}
