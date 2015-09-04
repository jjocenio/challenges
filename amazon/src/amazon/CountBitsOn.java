package amazon;

public class CountBitsOn {

	public static void main(String[] args) {
		for (int n = 0; n < 10; n++) {
			System.out.println(Integer.toBinaryString(n) + " - " + countBitsOn(n));
		}
	}
	
	private static int countBitsOn(int number) {
		int count = 0;
		for (int i = 0; i < number; i++) {
			count += (((number >> i) & 1) != 0) ? 1 : 0;
		}
		
		return count;
	}
}
