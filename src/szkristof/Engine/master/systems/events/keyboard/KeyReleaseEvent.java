package szkristof.Engine.master.systems.events.keyboard;

import szkristof.Engine.master.systems.events.Event;

public interface KeyReleaseEvent {

	default void init() {
		Event.addKeyReleaseEvent(this);
	}
	
	public void invoke(long window, int key, int scancode, int mods);
	
}