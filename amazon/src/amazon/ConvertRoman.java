package amazon;

public class ConvertRoman {
	
	public static void main(String[] args) throws Exception {
		System.out.println(convertToInt("I"));
		System.out.println(convertToInt("IV"));
		System.out.println(convertToInt("XX"));
		System.out.println(convertToInt("XIX"));
		System.out.println(convertToInt("LVII"));
		System.out.println(convertToInt("MCMLXXXI"));

		System.out.println(convertToRoman(1));
		System.out.println(convertToRoman(4));
		System.out.println(convertToRoman(20));
		System.out.println(convertToRoman(19));
		System.out.println(convertToRoman(57));
		System.out.println(convertToRoman(1981));
	}

	private static int convertToInt(String roman) throws Exception {
		if (roman == null || roman.trim().length() == 0) {
			throw new Exception("Invalid");
		}
		
		byte[] algarisms = roman.getBytes();
		int result = getValue(algarisms[0]);
		int last = result;
		
		for (int i = 1; i < algarisms.length; i++) {
			int current = getValue(algarisms[i]);
			result += (current <= last ? current : current - (last * 2));
			last = current;
		}
		
		return result;
	}

	private static int getValue(byte b) {
		switch (b) {
			case 'I' : return 1;
			case 'V' : return 5;
			case 'X' : return 10;
			case 'L' : return 50;
			case 'C' : return 100;
			case 'D' : return 500;
			case 'M' : return 1000;
		}
		
		return 0;
	}
	
	private static String convertToRoman(int value) throws Exception {
		if (value < 1 || value > 4999) {
			throw new Exception("Invalid");
		}
		
		StringBuffer result = new StringBuffer();
		result.append(convert(value / 1000, "M", "", "", ""))
			  .append(convert(value % 1000 / 100, "C", "CM", "D", "CD"))
			  .append(convert(value % 1000 % 100 / 10, "X", "XC", "L", "XL"))
			  .append(convert(value % 1000 % 100 % 10, "I", "IX", "V", "IV"));
		
		return result.toString();
	}

	private static Object convert(int value, String one, String nine, String five, String four) {
		StringBuffer buffer = new StringBuffer();
		int current = 0;

		if (value / 9 == 1) {
			current = 9;
			buffer.append(nine);
		} else if (value / 5 == 1) {
			current = 5;
			buffer.append(five);
		} else if (value / 4 == 1) {
			current = 4;
			buffer.append(four);
		}
		
		while (current < value) {
			current++;
			buffer.append(one);
		}
		
		return buffer.toString();
	}
}
