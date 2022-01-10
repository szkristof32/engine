package szkristof.Engine.master.systems.events.application;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public class AppTickEvent extends Event {

	public AppTickEvent() {
		super(EventType.APP_TICK, EventCategory.APPLICATION);
	}

	@Override
	public String toString() {
		return "AppTickEvent";
	}

}