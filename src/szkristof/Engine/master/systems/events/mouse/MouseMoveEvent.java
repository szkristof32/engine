package szkristof.Engine.master.systems.events.mouse;

import szkristof.Engine.master.systems.events.Event;

public interface MouseMoveEvent {

	default void init() {
		Event.addMouseMoveEvent(this);
	}
	
	public void invoke(long window, int x, int y);
	
}