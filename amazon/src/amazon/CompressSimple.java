package amazon;

public class CompressSimple {

	public static void main(String[] args) {
		String sentence = args[0];	
		int count = 0;
		
		char last = sentence.charAt(0);

		StringBuffer result = new StringBuffer();
		for (int c = 0; c < sentence.length(); c++) {
			char current = sentence.charAt(c);
			if (last == current) {
				count++;
			} else {
				result.append(last).append(count > 1 ? count : "");
				last = current;
				count = 0;
			}
		}
		
		result.append(last).append(count > 1 ? count + 1 : "");
		System.out.println(result.toString());
	}
}
