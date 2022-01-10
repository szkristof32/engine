package szkristof.Engine.master.systems.events.application;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public class WindowCloseEvent extends Event {

	public WindowCloseEvent() {
		super(EventType.WINDOW_CLOSE, EventCategory.APPLICATION);
	}

	@Override
	public String toString() {
		return "WindowCloseEvent";
	}
	
}