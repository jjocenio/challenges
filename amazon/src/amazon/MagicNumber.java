package amazon;

public class MagicNumber {

	public static void main(String[] args) {
		for (int n = 1; n < 10; n++) {
			System.out.println(">> " + findMagicNumber(n));
		}
	}
	
	private static int findMagicNumber(int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (((n >> i) & 1) == 1) {
				result += (int) Math.pow(5, i + 1);
			}
		}
		
		return result;
	}
}
