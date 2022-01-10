package szkristof.Engine.master.systems.events.keyboard;

import szkristof.Engine.master.systems.events.Event;
import szkristof.Engine.master.systems.events.EventCategory;
import szkristof.Engine.master.systems.events.EventType;

public abstract class KeyEvent extends Event {

	protected int keyCode;
	
	public KeyEvent(EventType type, int keyCode) {
		super(type, EventCategory.INPUT | EventCategory.KEYBOARD);
		this.keyCode = keyCode;
	}

	public int getKeyCode() {
		return keyCode;
	}

}