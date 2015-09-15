package amazon;

/*
 * http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
 */
public class NextGreaterNumber {

	public static void main(String[] args) {
		System.out.println(findNext(218765));
		System.out.println(findNext(1234));
		System.out.println(findNext(4321));
		System.out.println(findNext(534976));
	}

	private static String findNext(int number) {
		byte[] digits = String.valueOf(number).getBytes();

		int i = 0;
		for (i = digits.length - 2; i > 0; i--) {
			byte current = digits[i];
			int lowerIndex = i;
			for (int j = digits.length - 1; j > i; j--) {
				if (current < digits[j] && (lowerIndex == i || digits[j] < digits[lowerIndex])) {
					lowerIndex = j;
				}
			}
			
			if (lowerIndex > i) {
				digits[i] = digits[lowerIndex];
				digits[lowerIndex] = current;

				for (int k = i + 2; k < digits.length; k++) {
					current = digits[k];
					int j = k - 1;
					while ((j > i) && digits[j] > current) {
						digits[j + 1] = digits[j--];
					}
					
					digits[j + 1] = current;
				}
				
				return new String(digits);
			}
		}


		return "Is not possible";
	}
}
