package snapchat;

import java.util.List;

public class ChainSnap {
	List<ChainSnap> recipients;
	enum Case {
		visited, unvisited, visitedWithoutCycle
	}
	Case status;
	
	public ChainSnap(List<ChainSnap> recipients) {
		this.recipients = recipients;
		status = Case.unvisited;
	}
	
	public boolean hasCycle() {
		status = Case.visited;
		for (ChainSnap c : recipients) {
			if (c.status.equals(Case.unvisited)) {
				c.status = Case.visited;
				if (c.hasCycle()) {
					return true;
				} else {
					c.status = Case.unvisited;
				}
			} else {
				return true;
			}
		}
		
		status = Case.visitedWithoutCycle;
		
		return false;
	}
}
