package pricelinecom;

import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Generator {

	public static void main(String[] args) throws Exception {
		System.setOut(new PrintStream(new File("input1.txt")));
		Set<Integer> numbers = new HashSet<Integer>();
		Random rand = new Random();
		while (numbers.size() < 200000) {
			numbers.add(rand.nextInt(Integer.MAX_VALUE));
		}
		
		System.out.println(numbers.size());
		for (Integer n: numbers) {
			System.out.printf("%d ", n);
		}
	}
}
