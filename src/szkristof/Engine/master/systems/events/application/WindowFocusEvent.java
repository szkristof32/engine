package szkristof.Engine.master.systems.events.application;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public class WindowFocusEvent extends Event {

	public WindowFocusEvent() {
		super(EventType.WINDOW_FOCUS, EventCategory.APPLICATION);
	}

	@Override
	public String toString() {
		return "WindowFocusEvent";
	}
	
}