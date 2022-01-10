package szkristof.Engine.master.systems.events.application;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public class WindowResizeEvent extends Event {

	private int width;
	private int height;

	public WindowResizeEvent(int width, int height) {
		super(EventType.WINDOW_RESIZE, EventCategory.APPLICATION | EventCategory.MOUSE);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "WindowResizeEvent: " + width + ", " + height;
	}

}