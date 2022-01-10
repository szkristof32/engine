package szkristof.Engine.master.systems.events.mouse;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public abstract class MouseButtonEvent extends Event {

	protected int button;
	
	public MouseButtonEvent(EventType type, int keyCode) {
		super(type, EventCategory.INPUT | EventCategory.MOUSE);
		this.button = keyCode;
	}

	public int getMouseButton() {
		return button;
	}

}