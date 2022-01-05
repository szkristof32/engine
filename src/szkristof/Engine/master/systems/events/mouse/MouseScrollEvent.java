package szkristof.Engine.master.systems.events.mouse;

import szkristof.Engine.master.systems.events.Event;

public interface MouseScrollEvent {

	default void init() {
		Event.addMouseScrollEvent(this);
	}
	
	public void invoke(long window, float scrollX, float scrollY);
	
}