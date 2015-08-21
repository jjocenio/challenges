package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GameOfThronesI {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
        byte[] buffer = inputString.getBytes();
        
        Set<Character> visited = new HashSet<Character>();
       
        String ans = "YES";
        
        int odds = 0;
        for (int c = 0; c < buffer.length; c++) {
            Character charC = (char) buffer[c];
            if (!visited.contains(charC)) {
                visited.add(charC);
                int count = countChar(charC, buffer, c);
                if (count % 2 == 1) {
                    odds++;
                    if (odds > 1) {
                        ans = "NO";
                        break;
                    }
                }
            }
        }
        
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        System.out.println(ans);
        myScan.close();
    }
    
    private static int countChar(char charC, byte[] buffer, int from) {
        int count = 0;
        for (int c = from; c < buffer.length; c++) {
            if (buffer[c] == charC) {
                count++;
            }
        }
        
        return count;
    }
}
