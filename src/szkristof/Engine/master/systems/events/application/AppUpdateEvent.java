package szkristof.Engine.master.systems.events.application;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public class AppUpdateEvent extends Event {

	public AppUpdateEvent() {
		super(EventType.APP_UPDATE, EventCategory.APPLICATION);
	}

	@Override
	public String toString() {
		return "AppUpdateEvent";
	}

}