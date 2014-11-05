package snapchat;

public class Event {

	long startTimeInUTC;
	long endTimeInUTC;
	
	String name;
	
	String id;
	
	public Event(long startTimeInUTC, long endTimeInUTC, String name, String id) {
		this.startTimeInUTC = startTimeInUTC;
		this.endTimeInUTC = endTimeInUTC;
		this.name = name;
		this.id = id;
	}
	
}
