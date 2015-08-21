package amazon;

/*
 * http://www.careercup.com/question?id=5121982330830848
 */
public class CuboidChocolate {

	private static final double CUBE_SIDE = 1.26; // approximately 2 cm3
	
	private static int countChocolates(int a, int b, int c) {
		int countA = (int) (a / CUBE_SIDE);
		int countB = (int) (b / CUBE_SIDE);
		int countC = (int) (c / CUBE_SIDE);
		
		return countA * countB * countC;
	}
	
	public static void main(String[] args) {
		System.out.println(countChocolates(13, 13, 13));
	}
}
