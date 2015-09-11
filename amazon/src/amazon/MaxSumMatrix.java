package amazon;

public class MaxSumMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { 
			{ 1, 2, 3, 4 },
			{ 1, 2, 3, 4 },
			{ 1, 2, 3, 4 },
			{ 1, 2, 9, 4 },
		};
		
		System.out.println(findMaxSum(matrix));
	}

	private static int findMaxSum(int[][] matrix) {
		int max_row = matrix[0][0], current_max_row = matrix[0][0], max_col = matrix[0][0];
		int[] current_max_col = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				current_max_row = (j == 0 ? matrix[i][j] : Math.max(matrix[i][j], current_max_row + matrix[i][j]));
				max_row = Math.max(max_row, current_max_row);
				current_max_col[j] = (i == 0 ? matrix[i][j] : Math.max(matrix[i][j], current_max_col[j] + matrix[i][j]));
				max_col = Math.max(max_col, current_max_col[j]);
			}
		}
		
		return Math.max(max_row, max_col);
	}
}
