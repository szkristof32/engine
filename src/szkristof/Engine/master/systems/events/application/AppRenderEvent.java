package szkristof.Engine.master.systems.events.application;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public class AppRenderEvent extends Event {

	public AppRenderEvent() {
		super(EventType.APP_RENDER, EventCategory.APPLICATION);
	}

	@Override
	public String toString() {
		return "AppRenderEvent";
	}

}