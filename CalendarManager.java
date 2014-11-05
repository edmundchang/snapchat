package snapchat;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalendarManager {

	static CalendarManager manager = null;

	public List<Event> events;

	public static CalendarManager getInstance() {
		if (manager != null) {
			return manager;
		} else {
			manager = new CalendarManager();
			return manager;
		}
	}

	public boolean hasConflict() {
		if (events != null) {
			// sort events
			Collections.sort(events, new Comparator<Event>() {
				@Override
				public int compare(Event a, Event b) {
					if (a.startTimeInUTC < b.startTimeInUTC) {
						return -1;
					} else if (a.startTimeInUTC > b.startTimeInUTC) {
						return 1;
					}
					return 0;
				}

			});

			System.out.println("here");

			// check adjacent events
			for (int i = 0; i <= events.size() - 2; i++) {
				System.out.println("event" + i + " endTime:"
						+ events.get(i).endTimeInUTC);
				System.out.println("event" + (i + 1) + " startTime:"
						+ events.get(i + 1).startTimeInUTC);
				if (events.get(i).endTimeInUTC > events.get(i + 1).startTimeInUTC) {
					return true;
				}
			}
		}
		return false;
	}

}
