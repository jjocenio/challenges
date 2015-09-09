package amazon;

public class SpiralArrayPrint {

	public static void main(String[] args) {
		int[][] array = new int[][] { 
	        { 1,    2,   3,   4 },
	        { 5,    6,   7,   8 },
	        { 9,   10,  11,  12 },
	        { 13,  14,  15,  16 }	
		};
		
		printSpiral(array);
	}
	
	private static void printSpiral(int[][] array) {
		int fr = 0, lr = array.length;
		int fc = 0, lc = array[0].length;
		
		while (fr < lr && fc < lc) {
			for (int i = fc; i < lc; i++) {
				System.out.print(array[fr][i] + " ");
			}
			fr++;
			
			for (int i = fr; i < lr; i++) {
				System.out.print(array[i][lc - 1] + " ");
			}
			lc--;
			
			if (fr < lr) {
				for (int i = lc - 1; i >= fc; i--) {
					System.out.print(array[lr - 1][i] + " ");
				}
				lr--;
			}
			
			if (fc < lc) {
				for (int i = lr - 1; i >= fr; i--) {
					System.out.print(array[i][fc] + " ");
				}
				fc++;
			}
		}
	}
}
