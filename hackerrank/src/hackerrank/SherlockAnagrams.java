package hackerrank;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAnagrams {

    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream(new File("sherlockanagrams.txt")));
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        
        for (int i = 0; i < n; i++) {
            System.out.println(countAnagrams(scan.nextLine(), 0));
        }
        
        scan.close();
    }
    
    private static int countAnagrams(String text, int length) {
        if (length > text.length() - 1) {
            return 0;
        } else if (length == 0) {
            return countAnagrams(text, 1);
        }
        
        int count = 0;
        
        for (int c = 0; c <= text.length() - length; c++) {
            String sub1 = sort(text.substring(c, c + length));
            for (int c1 = c + 1; c1 <= text.length() - length; c1++) {
            	String sub2 = sort(text.substring(c1, c1 + length));
            	if (sub1.equals(sub2)) {
            		count++;
            	}
            }
        }
        
        return count + countAnagrams(text, length + 1);
    }

    private static String sort(String text) {
        byte[] letters = text.getBytes();
        Arrays.sort(letters);
        return new String(letters);
    }
}