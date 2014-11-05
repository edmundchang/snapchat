package snapchat;

import java.util.ArrayList;
import java.util.List;

public class CalendarTester {

	static CalendarManager c;
	public static void main(String[] args) {
		c = CalendarManager.getInstance();

		List<Event> eventsToTest = new ArrayList<Event>();
		eventsToTest.add(new Event(6, 9, "a", "b"));
		eventsToTest.add(new Event(0, 0, "a", "b"));
		eventsToTest.add(new Event(4, 5, "a", "b"));
		eventsToTest.add(new Event(5, 6, "a", "b"));
		
		c.events = eventsToTest;
		
		System.out.println("Testing of hasConflict() for set 1: " + c.hasConflict());
	}

}
