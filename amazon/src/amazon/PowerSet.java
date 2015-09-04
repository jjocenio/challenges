package amazon;

public class PowerSet {

	public static void main(String[] args) {
		final byte[] set = args[0].getBytes();

		final int MAX = (1 << set.length); //(2 ^ n)

		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j <= i; j++) {
				if (((i >> j) & 1) != 0) {
					System.out.print((char) set[j] + " ");
				}
			}
			
			System.out.println("");
		}
	}
}
