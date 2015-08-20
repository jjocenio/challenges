package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountTapes {
	
	public static void main(String[] args) {
		System.out.println(countMinimunTapes(150, Arrays.asList(70, 10, 98, 60, 100, 20, 1, 90, 50, 10, 5)));
	}

	private static int countMinimunTapes(int tapeSize, List<Integer> files) {
		List<Integer> sortedFiles = new ArrayList<Integer>(files);
		Collections.sort(sortedFiles, Collections.reverseOrder());
		
		int tapes = 0;
		while (sortedFiles.size() > 1) {
			int lastPos = sortedFiles.size() - 1;
			int first = sortedFiles.get(0);
			int last = sortedFiles.get(lastPos);
			if (first + last <= tapeSize) {
				sortedFiles.remove(lastPos);
				System.out.printf("%d ", last);
			}

			System.out.printf("%d\n", first);
			sortedFiles.remove(0);
			tapes++;
		}
		
		if (!sortedFiles.isEmpty()) {
			System.out.printf("%d\n", sortedFiles.remove(0));
			tapes++;
		}
			
		return tapes;
	}
}
