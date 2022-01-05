package szkristof.Engine.master.systems.events.keyboard;

import szkristof.Engine.master.systems.events.Event;

public interface KeyPressEvent {

	default void init() {
		Event.addKeyPressEvent(this);
	}
	
	public void invoke(long window, int key, int scancode, int mods, boolean repeating);
	
}