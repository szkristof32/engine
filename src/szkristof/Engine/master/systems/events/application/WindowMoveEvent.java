package szkristof.Engine.master.systems.events.application;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public class WindowMoveEvent extends Event {

	private int x;
	private int y;

	public WindowMoveEvent(int x, int y) {
		super(EventType.WINDOW_MOVE, EventCategory.APPLICATION | EventCategory.MOUSE);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "WindowMoveEvent: " + x + ", " + y;
	}

}