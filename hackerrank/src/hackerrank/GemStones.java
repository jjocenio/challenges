package hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GemStones {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        Map<Character, Integer> mapElements = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            byte[] elements = scan.nextLine().getBytes();
            Set<Character> counted = new HashSet<Character>();
            
            for (int e = 0; e < elements.length; e++) {
                Character element = (char) elements[e];
                if (!counted.contains(element)) {
                    counted.add(element);
                    Integer count = mapElements.get(element);
                    mapElements.put(element, count != null ? count + 1 : 1);
                }
            }
        }

        scan.close();

        int countGems = 0;
        for (Integer value: mapElements.values()) {
            countGems += (value == n ? 1 : 0);
        }
        
        System.out.println(countGems);
    }
}