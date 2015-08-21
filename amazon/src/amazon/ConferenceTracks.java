package amazon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * http://www.careercup.com/question?id=5195978443325440
 */
public class ConferenceTracks {

	private static final List<Talk> talks = new LinkedList<Talk>();
	private static final List<List<Talk>> tracks = new LinkedList<List<Talk>>();
	
	public static void main(String[] args) throws Exception {
		readInput();
		Collections.sort(talks, Collections.reverseOrder());

		while (!talks.isEmpty()) {
			List<Talk> track = new LinkedList<Talk>();
			track.addAll(createTrack(3 * 60));
			track.add(new Talk("Lunch", 60));
			track.addAll(createTrack(4 * 60));
			track.add(new Talk("Networking Event", 0));
			
			tracks.add(track);
		}
		
		int t = 1;
		for (List<Talk> track: tracks) {
			Calendar trackCalendar = Calendar.getInstance();
			trackCalendar.set(Calendar.HOUR_OF_DAY, 9);
			trackCalendar.set(Calendar.MINUTE, 0);
			trackCalendar.set(Calendar.SECOND, 0);
			trackCalendar.set(Calendar.MILLISECOND, 0);
			
			System.out.println("Track " + (t++));
			for (Talk talk: track) {
				System.out.printf("%1$tI:%1$tM %2$s\n", trackCalendar.getTime(), talk.toString());
				trackCalendar.add(Calendar.MINUTE, talk.getTime());
			}
			
			System.out.println();
		}
	}

	private static List<Talk> createTrack(int duration) {
		List<Talk> localTalks = new LinkedList<Talk>();
		int currentDuration = 0;
		
		while (!talks.isEmpty() && currentDuration < duration) {
			int lastPos = talks.size() - 1;
			Talk first = talks.get(0);
			Talk last = talks.get(lastPos);
			
			if (currentDuration + first.getTime() <= duration) {
				currentDuration += first.getTime();
				localTalks.add(first);
				talks.remove(0);
			} else if (currentDuration + last.getTime() <= duration) {
				currentDuration += last.getTime();
				localTalks.add(last);
				talks.remove(lastPos);
			} else {
				break;
			}
		}
		
		return localTalks;
	}

	private static void readInput() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(new File("talks.txt")));
		String line = null;
		
		Pattern pattern = Pattern.compile("([^0-9]+) ([0-9]+min|lightning)");
		while ((line = reader.readLine()) != null) {
			Matcher matcher = pattern.matcher(line);
			if (matcher.matches()) {
				String title = matcher.group(1);
				int time = Integer.valueOf(matcher.group(2).replaceAll("min", "").replaceAll("lightning", "5"));
				talks.add(new Talk(title, time));
			}
		}
		
		reader.close();
	}
} 

class Talk implements Comparable<Talk> {
	
	private String title;
	private int time;

	
	public Talk(String title, int time) {
		super();
		this.title = title;
		this.time = time;
	}

	public String getTitle() {
		return title;
	}
	
	public int getTime() {
		return time;
	}

	@Override
	public String toString() {
		String toString = title;
		if (time > 0) {
			toString += " " + (time == 5 ? "lightning" : time + "min");
		}
		
		return toString;
	}

	@Override
	public int compareTo(Talk o) {
		return this.time - o.time;
	}
}