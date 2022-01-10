package szkristof.Engine.master.systems.events.application;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public class WindowLostFocusEvent extends Event {

	public WindowLostFocusEvent() {
		super(EventType.WINDOW_LOST_FOCUS, EventCategory.APPLICATION);
	}

	@Override
	public String toString() {
		return "WindowLostFocusEvent";
	}
	
}