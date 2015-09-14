package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DivideArray {
	
	public static void main(String[] args) {
		int[][] division = divide(new int[] { 1, 0, 3, 6, 8, 19 });
		System.out.println(Arrays.toString(division[0]));
		System.out.println(Arrays.toString(division[1]));
	}

	private static int[][] divide(int[] a) {
		int totalSum = 0;
		int sorteda[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			totalSum += a[i];
			sorteda[i] = a[i];
		}
		
		int avg = totalSum / 2;
		Arrays.sort(sorteda);
		
		Set<Integer> sub = new HashSet<Integer>();
		int csum = 0;
		int k = 0;
		while (csum + sorteda[k] < avg) {
			sub.add(sorteda[k]);
			csum += sorteda[k++];
		}
		
		if (k < a.length - 1) {
			if (Math.abs(avg - csum + sorteda[k]) < Math.abs(avg - csum + sorteda[k + 1])) {
				csum += sorteda[k];
				sub.add(sorteda[k]);
			} else {
				csum += sorteda[k + 1];
				sub.add(sorteda[k + 1]);
			}
		}

		int result[][] = new int[2][];
		result[0] = new int[sub.size()];
		result[1] = new int[a.length - sub.size()];
		int s1 = 0, s2 = 0;
		while (s1 + s2 < a.length) {
			if (sub.contains(a[s1 + s2])) {
				result[0][s1] = a[s1 + s2];
				s1++;
			} else {
				result[1][s2] = a[s1 + s2];
				s2++;
			}
		}
		
		return result;
	}
}
