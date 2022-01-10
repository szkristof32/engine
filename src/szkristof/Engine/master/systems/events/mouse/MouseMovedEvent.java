package szkristof.Engine.master.systems.events.mouse;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public class MouseMovedEvent extends Event {

	private float x;
	private float y;

	public MouseMovedEvent(float x, float y) {
		super(EventType.MOUSE_MOVED, EventCategory.INPUT | EventCategory.MOUSE);
		this.x = y;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	@Override
	public String toString() {
		return "MouseMovedEvent: " + x + ", " + y;
	}

}