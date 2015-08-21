package hackerrank;

import java.util.Scanner;

public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
                
        for (int i = 0; i < t; i++) {
            System.out.println(checkPalindrome(scan.nextLine()));
        }
        
        scan.close();
    }
    
    private static int checkPalindrome(String text) {
        StringBuffer line = new StringBuffer(text);

        int posix = -1;
        for (int c = 0; c < line.length() / 2; c++) {
            int last = line.length() - c - 1;
            if (line.charAt(c) != line.charAt(last)) {
                return  (checkPalindrome(text.substring(c + 1, last + 1)) == -1 ? c : last);
            }
        }        
        
        return posix;
    }
}
